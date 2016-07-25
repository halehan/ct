angular
	.module('appKit', ['ngAnimate', 'ui.bootstrap', 'rt.debounce'])
	.animation('.slide', function() {
		'use strict';

		return {
			enter: function(element, doneFn) {
				$(element).slideUp(0);
				$(element).slideDown(500, doneFn);
			},
			leave: function(element, doneFn) {
				$(element).slideUp(500, doneFn);
			}
		};
});

angular.module('appKit').filter('capitalize', function() {
	'use strict';
	return function(input, all) {
		var reg = (all) ? /([^\W_]+[^\s-]*) */g : /([^\W_]+[^\s-]*)/;
		return (!!input) ? input.replace(reg, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();}) : '';
	};
});

angular.module('appKit').directive('appKitFocusOn', function($timeout, $parse) {
	'use strict';

	return {
		link: function(scope, element, attrs) {
			var model = $parse(attrs.appKitFocusOn);
			scope.$watch(model, function(value) {
				if(value === true) {
					$timeout(function() {
						element[0].focus();
					});
				}
			});
			element.bind('blur', function() {
				scope.$apply(model.assign(scope, false));
			});
		}
	};
});

angular.module('appKit').directive('appKitLoader', function() {
	'use strict';
	return {
		restrict: "AE",
		replace: true,
		templateUrl: 'assets/tpl/app-kit-loader.html',
		scope: {
			variant: '@',
		},
		link: function(scope) {
			scope.variant = scope.variant || 1;
		}
	};
});

angular.module('appKit').directive('appKitMasonry', function($timeout, $animate, debounce) {
	'use strict';

	function onAnimationComplete(element, phase) {
		if(phase === 'close') {
			/*jshint validthis:true */
			this.layout();
		}
	}

	return {
		restrict: 'A',
		controller: function($element) {
			this.promise = null;
			this.layout = function() {
				if(this.promise) {
					$timeout.cancel(this.promise);
				}
				this.promise = $timeout(function() {
					$element.masonry('reloadItems');
					$element.masonry('layout');
					this.promise = null;
				}.bind(this), 100);
			};
			this.closeModule = function(elementToRemove) {
				$element.masonry('remove', elementToRemove);
				$element.masonry('layout');
			};
		},
		link: function(scope, element, attrs, controller) {
			var selector = attrs.itemSelector || '.masonry-item',
				MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver,
				observer;

			controller.selector = selector;

			$(element).masonry({
				itemSelector: selector
			});

			if(MutationObserver) {
				observer = new MutationObserver(function(mutations) {
					mutations.forEach(debounce(100, controller.layout.bind(controller)));
				});

				$timeout(function() {
					observer.observe(element[0], {
						attributes: true,
						childList: true,
						characterData: true,
						subtree: true
					});
				});
			}

			scope.$on('layout', controller.layout.bind(controller));
		}
	};
});

angular.module('appKit').directive('appKitMenu', function() {
	'use strict';
	return {
		restrict: 'AE',
		link: function(scope, element) {
			$(element).metisMenu();
		}
	};
});

angular.module('appKit').directive('appKitModule', function() {
	'use strict';
	return {
		restrict: "AE",
		transclude: {
			'more': '?moreMenu',
			'body': 'paneBody',
			'footer': '?paneFooter'
		},
		replace: true,
		require: '?^^appKitMasonry',
		templateUrl: 'assets/tpl/app-kit-module.html',
		scope: {
			wrapperClass: '@',
			moduleClass: '@',
			contentClass: '@',
			title:'@',
			meta: '@',
			controls: "=?",
			collapsed: '@'
		},
		link: function(scope, element, attrs, appKitMasonry, transclude) {
			if(typeof scope.controls === 'undefined') {
				scope.controls = !!appKitMasonry;
			}

			if(typeof scope.collapsed === 'undefined') {
				scope.collapsed = false;
			}

			scope.showFooter = transclude.isSlotFilled('footer');
			scope.showMore = transclude.isSlotFilled('more');

			if(typeof scope.wrapperClass === 'undefined') {
				if(scope.title || scope.meta) {
					scope.wrapperClass = 'module-headings';
				} else {
					scope.wrapperClass = 'module-headings';
				}
			}

			if(appKitMasonry) {
				appKitMasonry.layout();
			}

			scope.closeModule = function(ev) {
				if(appKitMasonry) {
					appKitMasonry.closeModule($(ev.target).closest(appKitMasonry.selector));
				} else {
					$(element).remove();
				}
			};

			scope.collapseModule = function(ev) {
				scope.collapsed = !scope.collapsed;
			};
		}
	};
});

angular.module('appKit').directive('appKitResponsive', function($window) {
	'use strict';
	return {
		restrict: 'AE',
		link: function(scope, element) {
			$window = angular.element($window);

			function adaptToScreenSize() {
				scope.compact = $window.width() <= 1200;
				scope.mobile = $window.width() <= 768;
			}
			scope.navOpen = false;

			$window.bind('resize', function() {
				scope.$apply(adaptToScreenSize);
			});

			$window.bind('load', function() {
				$(element).removeClass('preload');
			});

			adaptToScreenSize();
		}
	};
});

angular.module('appKit').config(function($provide) {
	'use strict';

	$provide.decorator('uibTabsetDirective', function($delegate) {
		$delegate[0].templateUrl = "assets/tpl/uib-tabset-app-kit.html";
		$delegate[0].$$isolateBindings.tabsetClass = {
			attrName: 'tabsetClass',
			mode: '@'
		};
		return $delegate;
	});

	$provide.decorator('uibTabDirective', function($delegate) {
		$delegate[0].templateUrl = "assets/tpl/uib-tab-app-kit.html";
		$delegate[0].$$isolateBindings.tabIconClass = {
			attrName: 'tabIconClass',
			mode: '@'
		};
		return $delegate;
	});

	$provide.decorator('uibAlertDirective', function($delegate) {
		$delegate[0].templateUrl = "assets/tpl/uib-alert-app-kit.html";

		return $delegate;
	});
});
