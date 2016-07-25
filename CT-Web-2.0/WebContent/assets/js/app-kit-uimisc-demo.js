angular.module('appKitUimiscDemo',[
	'appKitCommon',
	'appKit'
]).controller('AppKitUimiscDemo', function($scope,  $uibModal) {
	'use strict';
	this.totalItems = $scope.totalItems = 50;
	this.currentPage = $scope.currentPage = 3;
	this.tooltipText = $scope.tooltipText = 'Tooltip Text';
	this.popoverText = $scope.popoverText = 'Popover Text';
	this.progress = $scope.progress = 55;

	$scope.saved = false;

	$scope.open = function() {
		$scope.saved = false;
		var modalInstance = $uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'myModalContent.html',
		});

		modalInstance.result.then(function(result) {
			$scope.saved = true;
		});

	};
});
