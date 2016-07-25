angular.module('appKitButtonsDemo', [
	'appKitCommon',
	'appKit'
]).controller('AppKitButtonsDemo', function($scope) {
	'use strict';

	$scope.singleModel = 'On';
	$scope.radioModel = 'Middle';
	$scope.checkModel = {
		left: false,
		middle: true,
		right: false
	};
});
