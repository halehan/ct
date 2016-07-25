angular.module('appKitFlotDemo', [
	'appKitCommon',
	'appKit',
	'angular-flot'
	]).controller('AppKitFlotDemo', function($scope, $timeout) {
		'use strict';

		// A custom label formatter
		function labelFormatter(label, series) {
			return "<div style='font-size:11px; text-align:center; padding:2px; color:white;'>" + label + "<br/>" + Math.round(series.percent) + "%</div>";
		}

		$scope.chart1data = [[[1, 85], [2, 125], [3, 175], [4, 220], [5, 175], [5, 175], [7, 175], [8, 190], [9, 195], [10, 200]]];
		$scope.chart1options = {
			series: {
				lines: {
					show: true,
					lineWidth: 2,
					fill: true,
					fillColor: {
						colors: [{
							opacity: 0.3
						}, {
							opacity: 0.3
						}]
					}
				}
			},
			shadowSize: 0,
			xaxis: {
				color:'#f3f3f3'
			},
			yaxis:{
				color: '#f3f3f3'
			},
			colors: ["#40babd"],
			grid: {
				borderWidth: 0,
				hoverable: true, /* You need to set flot option hoverable to true if you want flot.tooltip plugin to work.*/
				clickable: true
			},
			legend: {
				show: false
			},
			/* Flot tooltip plugin required */
			tooltip: true,
			tooltipOpts: {
				content: "x: %x, y: %y"
			}
		};

		$scope.chart2data = [{
			label: 'data1',
			data: [[1, 85], [2, 125], [3, 175], [4, 220], [5, 175], [6, 175], [7, 175], [8, 190], [9, 195], [10, 200]]
		}, {
			label: 'data2',
			data: [[1, 65], [2, 115], [3, 185], [4, 230], [5, 195], [5, 165], [7, 155], [8, 230], [9, 220], [10, 210]]
		}
		];

		$scope.chart2options = {
			series: {
				lines: {
					show: true,
					lineWidth: 2,
				}
			},
			shadowSize: 0,
			xaxis: {
				color:'#f3f3f3',
			},
			yaxis:{
				color: '#f3f3f3',
			},
			colors: ["#40babd", "#75c181"],
			grid: {
				borderWidth: 0,
				hoverable: true, /* You need to set flot option hoverable to true if you want flot.tooltip plugin to work.*/
				clickable: true
			},
			legend: {
				show: true
			},
			/* Flot tooltip plugin required */
			tooltip: true,
			tooltipOpts: {
				content: "x: %x, y: %y"
			}
		};

		$scope.chart3data = [[[1, 100], [2, 200], [3, 150], [4, 400], [5, 650], [6, 350], [7, 700], [8, 600], [9, 500], [10, 450]]];
		$scope.chart3options = {
			series: {
				bars: {
					show: true,
					barWidth: 0.7,
					fill: true,
					fillColor: {
						colors: [{
							opacity: 0.8
						}, {
							opacity: 0.8
						}]
					}

				}
			},
			xaxis: {
				color:'#f3f3f3',
			},
			yaxis:{
				color: '#f3f3f3',
			},
			colors: ["#40babd"],
			grid: {
				borderWidth: 0,
				hoverable: true, /* You need to set flot option hoverable to true if you want flot.tooltip plugin to work.*/
				clickable: true
			},
			legend: {
				show: false
			},
			/* Flot tooltip plugin required */
			tooltip: true,
			tooltipOpts: {
				content: "x: %x, y: %y"
			}
		};

		$scope.chart4data = [[[1, 100], [2, 200], [3, 150], [4, 400], [5, 250], [6, 350], [7, 300], [8, 400], [9, 100], [10, 250]]];
		$scope.chart4options = {
			series: {
				bars: {
					show: true,
					align: 'center',
					horizontal: true,
					barWidth: 0.5,
					lineWidth: 15,
					fill: true,
					fillColor: {
						colors: [{
							opacity: 0.8
						}, {
							opacity: 0.8
						}]
					}

				}
			},
			xaxis: {
				color:'#f3f3f3',
			},
			yaxis:{
				color: '#f3f3f3',
			},
			colors: ["#40babd", "#75c181"],
			grid: {
				borderWidth: 0,
				hoverable: true, /* You need to set flot option hoverable to true if you want flot.tooltip plugin to work.*/
				clickable: true
			},
			legend: {
				show: false
			},
			/* Flot tooltip plugin required */
			tooltip: true,
			tooltipOpts: {
				content: "x: %x, y: %y"
			}
		};

		$scope.chart5data = [
		{label: "Team A", data: 60, color: "#40babd"},
		{label: "Team B", data: 15, color: "#75c181"},
		{label: "Team C", data: 25, color: "#58bbee"}
		];

		$scope.chart5options = {
			series: {
				pie: {
					show: true,
					highlight: {
						opacity: 0.2
					},
					radius:1,
					label: {
						show: true,
						radius: 2/3,
						formatter: labelFormatter,
						threshold: 0.1
					}
				}
			},
			grid: {
				hoverable: true /* You need to set flot option hoverable to true if you want flot.tooltip plugin to work.*/
			},
			legend: {
				show: true
			},
			/* Flot tooltip plugin required */
			tooltip: true,
			tooltipOpts: {
				content: "%s: %p.0%",
				shifts: {
					x: 20,
					y: 0
				}
			}
		};

		$scope.chart6data = [
		{label: "Series 1", data: 20, color: "#40babd"},
		{label: "Series 2", data: 15, color: "#75c181"},
		{label: "Series 3", data: 25, color: "#F5D44B"},
		{label: "Series 4", data: 10, color: "#656C79"},
		{label: "Series 5", data: 10, color: "#8A40A7"},
		{label: "Series 6", data: 20, color: "#58bbee"}
		];

		$scope.chart6options = {
			series: {
				pie: {
					show: true,
					innerRadius: 0.5,
					highlight: {
						opacity: 0.2
					}
				}
			},
			grid: {
				hoverable: true /* You need to set flot option hoverable to true if you want flot.tooltip plugin to work.*/
			},
			legend: {
				show: true
			},
			/* Flot tooltip plugin required */
			tooltip: true,
			tooltipOpts: {
				content: "%s: %p.0%",
				shifts: {
					x: 20,
					y: 0
				}
			}
		};

		$scope.chart7options = {
			series: {
				lines: {
					show: true,
					lineWidth: 1.2,
					fill: true,
					fillColor: {
						colors: [{
							opacity: 0.3
						}, {
							opacity: 0.3
						}]
					}
				}
			},
			colors: ["#75c181"],
			xaxis: {
				color:'#f3f3f3',
				mode: "time",
				tickSize: [2, "second"],
				tickFormatter: function (v) {
					var date = new Date(v);

					if (date.getSeconds() % 20 === 0) {
						var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
						var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
						var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

						return hours + ":" + minutes + ":" + seconds;
					} else {
						return "";
					}
				},
				axisLabel: "Time",
				axisLabelUseCanvas: true,
				axisLabelFontSizePixels: 12,
				axisLabelPadding: 10
			},
			yaxis: {
				color:'#f3f3f3',
				min: 0,
				max: 100,
				tickSize: 5,
				tickFormatter: function (v) {
					if (v % 10 === 0) {
						return v + "%";
					} else {
						return "";
					}
				},
				axisLabel: "CPU loading",
				axisLabelUseCanvas: true,
				axisLabelFontSizePixels: 12,
				axisLabelPadding: 6
			},
			grid: {
				borderWidth: 0,
				hoverable: true,
				clickable: true
			},
			legend: {
				labelBoxBorderColor: "#fff"
			}
		};

		var data = [];
		var totalPoints = 50;
		var updateInterval = 1000;
		var now = new Date().getTime();

		$scope.chart7data = [
		{
			label: "CPU",
			data: []
		}
		];

		function generateData() {
			data.shift();

			while (data.length < totalPoints) {
				data.push([
					now += updateInterval,
					Math.random() * 100
					]);
			}

			$scope.chart7data = [{
				label: "CPU",
				data: data
			}];
			$timeout(generateData, updateInterval);
		}

		generateData();

		$scope.chart8options = {
			xaxis: {
				mode: "time",
				color:'#f3f3f3'
			},
			yaxis:{
				color: '#f3f3f3'
			},
			grid:{
				borderWidth: 0
			},
			colors: ["#58bbee", "#75c181"],
		};

		$scope.chart8data = [{
			label: "data1",
			data: [
			[1354586000000, 153], [1364587000000, 658], [1374588000000, 198],
			[1384589000000, 663], [1394590000000, 801], [1404591000000, 1080],
			[1414592000000, 353], [1424593000000, 749], [1434594000000, 523],
			[1444595000000, 258], [1454596000000, 688], [1464597000000, 364]
			],
			bars: {
				show: true,
				barWidth: 30 * 60 * 60 * 1000 * 80,
				fill: true,
				fillColor: {
					colors: [{
						opacity: 0.6
					}, {
						opacity: 0.6
					}]
				}
			}
		},{
			label: "data2",
			data: [
			[1354586000000, 53], [1364587000000, 65], [1374588000000, 98],
			[1384589000000, 83], [1394590000000, 980], [1404591000000, 808],
			[1414592000000, 720], [1424593000000, 674], [1434594000000, 23],
			[1444595000000, 79], [1454596000000, 88], [1464597000000, 36]
			],
			lines: {
				show: true
			},
			points:{
				show:true
			}
		}];
	});
