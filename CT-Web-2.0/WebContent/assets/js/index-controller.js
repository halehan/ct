angular.module('ct',[
	'appKitCommon',
	'appKit',
	'ng-peity',
	'ng-sparkline',
	'ngResource',
	'ngRoute'
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
	
	$scope.name='AppKitWidgetsDemo';
	console.log($scope.name);

});

angular.module('appKitProjectsDemo',[
                                 	'appKitCommon',
                                 	'appKit',
                                 	'angular-chosen'
                                 ]).controller('AppKitProjectsDemo', function($scope, $uibModal) {
                                 	'use strict';

                                 	$scope.newProjectModal = function() {
                                 		$uibModal.open({
                                 			animation: $scope.animationsEnabled,
                                 			templateUrl: 'modalNewProject.html',
                                 		});
                                 	};

                                 	$scope.addMemberModal = function() {
                                 		$uibModal.open({
                                 			animation: $scope.animationsEnabled,
                                 			templateUrl: 'modalAddMember.html',
                                 		});
                                 	};
                                 });

angular.module('ct',[
                 	'appKitCommon',
                 	'appKit',
                 	'angular-chosen',
                 	'bootstrapWysiwyg',
                 	'bootstrapSwitch',
                 	'icheck',
                 	'jqueryTodo',
                 	'ng-peity',
                	'ng-sparkline',
                	'ngResource',
                	'ngRoute'
                 ]).controller('AppKitUserProfileDemo', function($scope) {
                 	'use strict';

                 	$scope.view = 'grid';
                 	$scope.jobrole = ['ux-designer', 'ui-designer'];
                 	$scope.country = 'uk';
                 	$scope.reminders = [
                 		{
                 			title: "Create UX deck for Nike",
                 		},

                 		{
                 			title: "Send email to Julie",
                 			done:   true
                 		},

                 		{
                 			title: "Prepare meetup presentation"
                 		},

                 		{
                 			title: "Wireframes for Project Lorem Ipsum"
                 		},
                 		{
                 			title: "Research apps for sports",
                 			done:   true
                 		},
                 		{
                 			title: "Research iWatch apps"
                 		},
                 		{
                 			title: "Design UI for Lorem Android app"
                 		}
                 	];
                 });

angular.module('ct',[
                  	'appKitCommon',
                  	'appKit',
                  	'angular-chosen',
                  	'bootstrapWysiwyg',
                  	'bootstrapSwitch',
                  	'icheck',
                  	'jqueryTodo',
                  	'ng-peity',
                 	'ng-sparkline',
                 	'ngResource',
                 	'ngRoute'
                  ]).controller('banner', function($scope) {
                  	
                   $scope.practice='RSI';
                   console.log($scope.practice);
                  	
                  });



