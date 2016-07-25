angular.module('appKitProjectsDemo',[
	'appKitCommon',
	'appKit',
	'angular-chosen'
]).controller('AppKitProjectsDemo', function($scope, $uibModal) {
	'use strict';

	$scope.newProjectModal = function() {
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'modalNewProject.html',
		});
	};

	$scope.addMemberModal = function() {
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'modalAddMember.html',
		});
	};
});
