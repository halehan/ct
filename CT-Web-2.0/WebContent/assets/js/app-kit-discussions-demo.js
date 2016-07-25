angular.module('appKitDiscussionsDemo',[
	'appKitCommon',
	'appKit'
]).controller('AppKitDiscussionsDemo', function($scope, $uibModal) {
	'use strict';

	$scope.fullscreen = false;

	$scope.open = function() {
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'discussionsModalContent.html'
		});
	};
});
