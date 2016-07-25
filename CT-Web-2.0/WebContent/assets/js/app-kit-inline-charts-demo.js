angular.module('appKitInlineChartsDemo', [
	'appKitCommon',
	'appKit',
	'ng-peity',
	'ng-sparkline',
	'easypiechart'
	]).controller('AppKitInlineChartsDemo', function($scope, $timeout) {
		'use strict';

		$.fn.peity.defaults.pie = {
			delimiter: null,
			fill: ["#40babd", "#f5f5f5", "#92d1d2"],
			height: null,
			radius: 16,
			width: null
		};

		$.fn.peity.defaults.donut = {
			delimiter: null,
			fill: ["#40babd", "#f5f5f5", "#92d1d2"],
			height: null,
			innerRadius: null,
			radius: 16,
			width: null
		};

		$.fn.peity.defaults.line = {
			delimiter: ",",
			fill: "#92d1d2",
			height: 32,
			max: null,
			min: 0,
			stroke: "#40babd",
			strokeWidth: 1,
			width: 64
		};

		$.fn.peity.defaults.bar = {
			delimiter: ",",
			fill: ["#40babd"],
			height: 32,
			max: null,
			min: 0,
			padding: 0.1,
			width: 64
		};

		$scope.livechartdata = [5,3,9,6,5,9,7,3,5,2,5,3,9,6,5,9,7,3,5,2,5,2,4,9,3,6,1,5,6,3];

		function generateData() {
			$scope.livechartdata.shift();
			$scope.livechartdata.push(
				Math.round(Math.random() * 10)
			);
			$timeout(generateData, 1000);
		}

		generateData();


		$scope.easypiechartoptions = {
			barColor:'#40babd',
            lineWidth : 5,
            onStep: function(from, to, percent) {
				$(this.el).find('span').text(Math.round(percent));
			}
		};

		$scope.sparkline1options = {
            type: 'line',
            defaultPixelsPerValue: 6,
            width: 200,
            height: 80,
            lineColor: '#40babd',
            fillColor: '#74d2d3',
            spotColor: '#75c181',
            minSpotColor: '#75c181',
            maxSpotColor: '#75c181',
            spotRadius: 3,
            highlightSpotColor: '#F8A13F',
            highlightLineColor: '#6f7581',
            lineWidth: 2
        };

        $scope.sparkline2options = {
            type: 'bar',
            width: 200,
            height: 100,
            barColor: '#40babd',
            negBarColor: '#40babd',
            zeroColor: '#40babd',
            barWidth: 15,
            barSpacing: 5
        };

        $scope.sparkline3options = {
            type: 'pie',
            width: 200,
            height: 100,
            sliceColors: ['#6f7581', '#75c181', '#f77b6b', '#F8A13F', '#58bbee'],
            offset: 30,
            borderWidth: 0
        };

        $scope.sparkline4options = {
            type: 'tristate',
            width: 200,
            height: 100,
            posBarColor: '#40babd',
            negBarColor: '#939bab',
            zeroBarColor: '#40babd',
            barWidth: 15,
            barSpacing: 5
        };
	});
