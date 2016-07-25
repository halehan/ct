angular.module('appKitChartjsDemo', [
	'appKitCommon',
	'appKit',
	'chart.js'
	]).controller('AppKitChartjsDemo', function($scope) {
		'use strict';
		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100);
		};

		Chart.defaults.global.colours = ['#75c181','#38cbcb','#f77b6b','#f8a13f','#ea5395','#8a40a7','#f2b542'];

		$scope.chart1labels = ['January','February','March','April','May','June','July'];
		$scope.chart1series = ['My First dataset', 'My Second dataset'];
		$scope.chart1data = [
			[randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()],
			[randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
		];

		$scope.chart2labels = ["January","February","March","April","May","June","July"];
		$scope.chart2data = [
			[randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()],
			[randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
		];

		$scope.chart3labels = ['Team A','Team B','Team C','Team D','Team E'];
		$scope.chart3data = [250, 100, 100, 40, 120];
		$scope.chart3colors = ['#44d0d0', '#5EEAEA', '#77FFFF', '#91FFFF', '#AAFFFF'];

		$scope.chart4labels = ['Team A','Team B','Team C','Team D','Team E'];
		$scope.chart4data = [250, 100, 100, 40, 120];
		$scope.chart4colors = ['#75C181', '#8FDB9B', '#A8F4B4', '#C2FFCE', '#DBFFE7'];

		$scope.chart5labels = ['Set A','Set B','Set C','Set D'];
		$scope.chart5data = [300, 50, 100, 40];
		$scope.chart5colors = ['#58BBEE', '#72D5FF', '#8BEEFF', '#A5FFFF'];

		$scope.chart6labels = ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"]
		$scope.chart6data = [[65,59,90,81,56,55,40], [28,48,40,19,96,27,100]];
	});
