angular.module('appKitMembersDemo', [
	'appKitCommon',
	'appKit'
]).controller('AppKitMembersDemo', function($scope, $uibModal) {
	'use strict';

	$scope.newMemberModal = function() {
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'newMemberModal.html',
		});
	};
});
