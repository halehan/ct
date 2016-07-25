angular.module('appKitNestableDemo',[
	'appKitCommon',
	'appKit',
	'ui.sortable'
	]).controller('AppKitNestableDemo', function($scope) {
		'use strict';

		$scope.list = [{
				"title": "First"
			}, {
				"title": "Second",
				"items": [
					{
						"title": "Second Alpha"
					}, {
						"title": "Second Bravo"
					}, {
						"title": "Second Charlie"
					}
				]
			}, {
				"title": "Third"
			}
		];

		$scope.sortableOptions = {
			'nested': true,
			'connectWith': '.nestable',
			'item': 'li'
		};
	});
