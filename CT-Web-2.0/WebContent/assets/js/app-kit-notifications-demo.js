angular.module('appKitNotificationsDemo',[
	'appKitCommon',
	'appKit',
	'notify'
]).controller('AppKitNotificationsDemo', function($scope, $sce) {
	'use strict';

	$scope.close = function(arrName, index) {
		if(['basic', 'alternative'].indexOf(arrName) > -1) {
			$scope[arrName].splice(index, 1);
			$scope.$broadcast('layout');
		}
	};

	$scope.add = function(arrName) {
		if(['basic', 'alternative'].indexOf(arrName) > -1) {
			$scope[arrName].push({message: $sce.trustAsHtml('Another alert!')});
			$scope.$broadcast('layout');
		}
	};

	$scope.basic = [
		{
			'message': $sce.trustAsHtml('<strong>Howdy!</strong> This is a generic alert message.')
		}, {
			'message': $sce.trustAsHtml('<strong>Well done!</strong> You successfully read this important alert message.'),
			'type': 'success'
		}, {
			'message': $sce.trustAsHtml('<strong>Heads up!</strong> This alert needs your attention, but it\'s not super important.'),
			'type': 'info'
		}, {
			'message': $sce.trustAsHtml('<strong>Warning!</strong> Better check yourself, you\'re not looking too good.'),
			'type': 'warning'
		}, {
			'message': $sce.trustAsHtml('<strong>Oh snap!</strong> Change a few things up and try submitting again.'),
			'type': 'danger'
		}
	];

	$scope.alternative = angular.copy($scope.basic);
});
