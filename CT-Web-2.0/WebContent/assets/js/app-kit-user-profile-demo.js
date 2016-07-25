angular.module('ct',[
	'appKitCommon',
	'appKit',
	'angular-chosen',
	'bootstrapWysiwyg',
	'bootstrapSwitch',
	'icheck',
	'jqueryTodo'
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
