angular.module('appKitSortableDemo',[
	'appKitCommon',
	'appKit',
	'ui.sortable'
	]).controller('AppKitSortableDemo', function($scope) {
		'use strict';

		$scope.list = [
			{
				title: 'Lorem Ipsum'
			},
			{
				title: 'Dolot Amet',
				type: 'info'
			},
			{
				title: 'Hakuna Matata',
				type: 'success'
			},
			{
				title: 'Ipsum Dolot',
				type: 'danger'
			},
			{
				title: 'Aenean vulputate eleifend tellus',
				type: 'warning'
			},
			{
				title: 'Quisque rutrum',
				type: 'highlight'
			}
		];

		$scope.sortableOptions = {
			'nested': false
		};

	});
