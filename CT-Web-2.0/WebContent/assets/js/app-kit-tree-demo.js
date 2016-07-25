angular.module('appKitTreeDemo',[
	'appKitCommon',
	'appKit',
	'ngJsTree'
	]).controller('AppKitTreeDemo', function($scope) {
		'use strict';

		$scope.tree1Config = {
			'core' : {
				'check_callback' : true
			},
			'plugins' : [ 'types', 'dnd' ],
			'types' : {
				'default' : {
					'icon' : 'fa fa-folder'
				},
				'image' : {
					'icon' : 'fa fa-file-image-o'
				},
				'unkown' : {
					'icon' : 'fa fa-file-o'
				},
				'text' : {
					'icon' : 'fa fa-file-text-o'
				},
				'pdf' : {
					'icon' : 'fa fa-file-pdf-o'
				},
				'word' : {
					'icon' : 'fa fa-file-word-o'
				},
				'ppt' : {
					'icon' : 'fa fa-file-powerpoint-o'
				},
				'excel' : {
					'icon' : 'fa fa-file-excel-o'
				},
				'video' : {
					'icon' : 'fa fa-file-video-o'
				},
				'audio' : {
					'icon' : 'fa fa-file-audio-o'
				},
				'code' : {
					'icon' : 'fa fa-file-code-o'
				},
				'screenshot' : {
					'icon' : 'fa fa-file-picture-o'
				},
				'css' : {
					'icon' : 'fa fa-file-code-o'
				},
				'zip' : {
					'icon' : 'fa fa-file-zip-o'
				}

			}
		};

		$scope.tree2Config = {
			'core' : {
				'check_callback' : true
			},
			'plugins' : [ 'types', 'dnd' ],
			"types" : {
				"file" : {
					"icon" : "glyphicon glyphicon-file",
					"valid_children" : []
				}
			}
		};

		$scope.tree1Data = [{
				id: 'ux-design-resources',
				text: 'UX Design Resources',
				type: '',
				parent: '#',
				state: { opened: true}
			},
			{
				id: 'inspirations',
				text: 'Inspirations',
				parent: 'ux-design-resources',
				state: { opened: true}
			},
			{
				id: 'deck-1-ppt',
				text: 'Deck-1.ppt',
				type: 'ppt',
				parent: 'inspirations'
			},
			{
				id: 'research-doc',
				text: 'Research.doc',
				type: 'word',
				parent: 'inspirations'
			},
			{
				id: 'screenshot-jpeg',
				text: 'Screenshot.jpeg',
				type: 'image',
				parent: 'inspirations'
			},
			{
				id: 'icons',
				text: 'Icons',
				parent: 'ux-design-resources',
				state: { opened: true}
			},
			{
				id: 'compass-svg',
				text: 'compass.svg',
				type: 'image',
				parent: 'icons'
			},
			{
				id: 'config-svg',
				text: 'config.svg',
				type: 'image',
				parent: 'icons'
			},
			{
				id: 'users-svg',
				text: 'users.svg',
				type: 'image',
				parent: 'icons'
			},
			{
				id: 'psds',
				text: 'PSDs',
				parent: 'ux-design-resources',
				state: { opened: true}
			},
			{
				id: 'dashboard-1-psd',
				text: 'dashboard-1.psd',
				type: 'unknown',
				parent: 'psds'
			},
			{
				id: 'dashboard-2-psd',
				text: 'dashboard-2.psd',
				type: 'unknown',
				parent: 'psds'
			},
			{
				id: 'wireframes',
				text: 'Wireframes',
				parent: 'ux-design-resources',
				state: { opened: true}
			},
			{
				id: 'mock-1-bmml',
				text: 'mock-1.bmml',
				type: 'unknown',
				parent: 'wireframes'
			},
			{
				id: 'mock-2-bmml',
				text: 'mock-2.bmml',
				type: 'unknown',
				parent: 'wireframes'
			},
			{
				id: 'screenshots',
				text: 'Screenshots',
				parent: 'ux-design-resources'
			},
			{
				id: 'deprecated',
				text: '_deprecated',
				parent: 'ux-design-resources'
			},
			{
				id: 'old-design-mock-v1-png',
				text: 'old-design-mock-v1.png',
				type: 'image',
				parent: 'deprecated'
			},
			{
				id: 'old-design-mock-v2-png',
				text: 'old-design-mock-v2.png',
				type: 'image',
				parent: 'deprecated'
			},
			{
				id: 'old-design-mock-v3-png',
				text: 'old-design-mock-v3.png',
				type: 'image',
				parent: 'deprecated'
			},
			{
				id: 'development-resources',
				text: 'Development Resources',
				parent: '#',
				state: { opened: true}
			},
			{
				id: 'html',
				text: 'html',
				parent: 'development-resources',
				state: { opened: true}
			},
			{
				id: 'index-html',
				text: 'index.html',
				type: 'code',
				parent: 'html'
			},
			{
				id: 'demo-html',
				text: 'demo.html',
				type: 'code',
				parent: 'html'
			},
			{
				id: 'help-html',
				text: 'help.html',
				type: 'code',
				parent: 'html'
			},
			{
				id: 'js',
				text: 'js',
				parent: 'development-resources',
				state: { opened: true}
			},
			{
				id: 'app-js',
				text: 'app.js',
				type: 'code',
				parent: 'js'
			},
			{
				id: 'vendors-js',
				text: 'vendors.js',
				type: 'code',
				parent: 'js'
			},
			{
				id: 'css',
				text: 'css',
				parent: 'development-resources',
				state: { opened: true}
			},
			{
				id: 'style-css',
				text: 'style.css',
				type: 'code',
				parent: 'css'
			},
			{
				id: 'responsive-css',
				text: 'responsive.css',
				type: 'code',
				parent: 'css'
			}
		];

		$scope.tree2Data = angular.copy($scope.tree1Data);
		$scope.tree2Data.forEach(function(item) {
			if(item.type) {
				item.type = 'file';
			}
		});
	});
