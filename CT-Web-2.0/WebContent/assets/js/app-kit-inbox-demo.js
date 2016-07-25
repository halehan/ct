angular.module('appKitInboxDemo',[
	'appKitCommon',
	'appKit',
	'icheck',
	'bootstrapWysiwyg'
]).controller('AppKitInboxDemo', function($scope, $uibModal) {
	'use strict';

	$scope.fullscreen = false;

	$scope.open = function() {
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'inboxModalContent.html',
			windowTemplateUrl: 'assets/tpl/uib-modal-window.html'
		});
	};
});
