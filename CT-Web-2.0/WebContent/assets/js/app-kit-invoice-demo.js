angular.module('appKitInvoiceDemo',[
	'appKitCommon',
	'appKit'
]).controller('AppKitInvoiceDemo', function($scope, $window) {
	'use strict';

	$scope.print = function() {
		$window.print();
	};

});
