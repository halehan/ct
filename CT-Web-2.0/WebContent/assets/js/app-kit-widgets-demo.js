angular.module('appKitWidgetsDemo',[
	'appKitCommon',
	'appKit',
	'ng-peity',
	'ng-sparkline'
]).controller('AppKitWidgetsDemo', function($scope) {
	'use strict';

	$scope.sparkline1options = {
		defaultPixelsPerValue: 10,
		width: "100%",
		height: 30,
		lineColor: '#fff',
		fillColor: false,
		spotColor: 'rgba(256, 256, 256, 0.5)',
		minSpotColor: 'rgba(256, 256, 256, 0.5)',
		maxSpotColor: 'rgba(256, 256, 256, 0.5)',
		spotRadius: 3,
		highlightSpotColor: 'rgba(256, 256, 256, 0.8)',
		highlightLineColor: 'rgba(256, 256, 256, 0.8)',
		lineWidth: 2
	};

	$scope.sparkline2options =  {
		width: "100%",
		height: 30,
		barColor: '#fff',
		negBarColor: '#fff',
		zeroColor: '#fff',
		barWidth: 5,
		barSpacing: 2
	};

});
