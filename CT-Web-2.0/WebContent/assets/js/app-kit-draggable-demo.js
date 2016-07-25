angular.module('appKitDraggableDemo',[
	'appKitCommon',
	'appKit',
	'ui.sortable'
	]).controller('AppKitDraggableDemo', function($scope) {
		'use strict';
		var data = [
		[{
			'title': 'Foo Bar 1',
			'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.'
		}, {
			'title': 'Foo Bar 2',
			'description': 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit'
		}], [{
			'title': 'Lorem Ipsum',
			'description': 'Laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
		}, {
			'title': 'Lorem Ipsum Dolor',
			'description': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident'
		}]
		];

		$scope.column1 = data[0];
		$scope.column2 = data[1];
		$scope.sortableOptions = {
			connectWith: '.draggable-column',
			handle: '.module-heading',
			cancel: '.portlet-toggle',
			placeholder: 'module module-placeholder',
			forcePlaceholderSize: true
		};

	});
