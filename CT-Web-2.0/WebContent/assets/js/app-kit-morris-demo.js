angular.module('appKitMorrisDemo', [
	'appKitCommon',
	'appKit',
	'angular.morris-chart'
	]).controller('AppKitMorrisDemo', function($scope) {
		'use strict';

		$scope.chart1data = [
			{x: '2010', y: 23450, z: 15670},
			{x: '2012', y: 31324, z: 32345},
			{x: '2013', y: 22356, z: 21234},
			{x: '2014', y: 25434, z: 23567},
			{x: '2015', y: 32566, z: 16784}
		];

		$scope.chart2data = [
			{x: '2011', y: 23450, z: 15670},
			{x: '2012', y: 31324, z: 32345},
			{x: '2013', y: 22356, z: 21234},
			{x: '2014', y: 25434, z: 23567},
			{x: '2015', y: 32566, z: 16784}
		];

		$scope.chart3data= [
			{device: 'iPhone', geekbench: 136},
			{device: 'iPhone 4G', geekbench: 142},
			{device: 'iPhone 4GS', geekbench: 236},
			{device: 'iPhone 5G', geekbench: 342},
			{device: 'iPhone 5GS', geekbench: 475},
			{device: 'iPhone 6', geekbench: 680},
			{device: 'iPhone 6 Plus', geekbench: 755}
		];

		$scope.chart4data = [
			{x: '2011', y: 23450, z: 15670},
			{x: '2012', y: 31324, z: 32345},
			{x: '2013', y: 22356, z: 21234},
			{x: '2014', y: 25434, z: 23567},
			{x: '2015', y: 32566, z: 16784}
		];

		$scope.chart5data = [
			{x: '2011 Q1', y: 3, z: 2, a: 3},
			{x: '2011 Q2', y: 2, z: 3, a: 1},
			{x: '2011 Q3', y: 0, z: 2, a: 4},
			{x: '2011 Q4', y: 2, z: 4, a: 3}
		];

		$scope.chart6data = [
			{value: 70, label: 'US'},
			{value: 15, label: 'UK'},
			{value: 10, label: 'China'},
			{value: 5, label: 'Germany'}
		];

		$scope.chart6formatter = function (x) { return x + "%"};

	});
