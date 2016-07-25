angular.module('appKitTicketsDemo',[
	'appKitCommon',
	'appKit',
	'angular-chosen'
]).controller('AppKitTicketsDemo', function($scope, $uibModal) {
	'use strict';

	$scope.newTicketModal = function() {
		$uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'modalNewTicket.html',
		});
	};
});
