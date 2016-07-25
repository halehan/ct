angular.module('appKitFormValidationDemo',[
	'appKitCommon',
	'appKit'
]).controller('AppKitFormValidationDemo', function($scope) {
	'use strict';

	$scope.hobbyOptions = ['skiing','runing','eating','sleeping','reading','coding'];
	$scope.hobbies = {};

	$scope.noneOrAtLeastSelected = function(object, minCount) {
		var count = 0;
		minCount = minCount || 1;

		count = object && Object.keys(object).filter(function(key) {
			return !!object[key];
		}).length;

		return !(count === 0 || count >= minCount);
	};
});
