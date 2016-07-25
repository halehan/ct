angular.module('appKitMapsDemo', [
	'appKitCommon',
	'appKit',
	'vectorMap',
	'ngMap'
]).controller('AppKitMapsDemo', function($scope, $http) {
	'use strict';
	$http({
		method: 'GET',
		url: 'assets/data/visitor-data.json'
	}).success(function(result){
		$scope.series = {
			regions: [{
				values: result,
				scale: ["#8ACCCC", "#40babd"],
				normalizeFunction: 'polynomial'
			}]
		};
		$scope.options = {
			backgroundColor: "none",
			regionStyle: {
				initial: {
					"fill": '#F2F2F2',
					"fill-opacity": 1,
					"stroke": 'none',
					"stroke-width": 0,
					"stroke-opacity": 1
				},
				hover: {
					"fill-opacity": 0.8,
					"cursor": 'pointer'
				},
			},
			onRegionLabelShow: function(e, el, code) {
				el.html('<strong>' + el.html() + '<br/>Visitors:<br/>' + numeral(result[code]).format('(0[,][000])') + '</strong>');
			}
		};
	});
});
