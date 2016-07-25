angular.module('ct',[
                 	'appKitCommon',
                	'appKit',
                	'ng-peity',
                	'ng-sparkline',
                	'ngResource',
                	'ngRoute']).config(function($routeProvider) {

	$routeProvider.when('/', {
	    templateUrl : 'widgets-frag.html',
	    controller  : 'AppKitWidgetsDemo'
	})

	$routeProvider.when('/widgets', {
	    templateUrl : 'widgets-frag.html',
	    controller  : 'AppKitWidgetsDemo'
	})
	
	$routeProvider.when('/fuck', {
	    templateUrl : 'fuck.html',
	    controller  : 'fuck'
	})

	$routeProvider.when('/tickets', {
	    templateUrl : 'tickets-frag.html',
	    controller  : 'AppKitDataTablesDemo'
	})

	$routeProvider.when('/dt', {
	    templateUrl : 'tables-datatables-frag.html',
	    controller  : 'AppKitDataTablesDemo'
	})

	$routeProvider.when('/projects', {
	    templateUrl : 'projects-frag.html',
	    controller  : 'AppKitDataTablesDemo'
	})

	$routeProvider.when('/forms', {
	    templateUrl : 'forms-validation-frag.html',
	    controller  : 'AppKitDataTablesDemo'
	})

	$routeProvider.when('/profile', {
	    templateUrl : 'user-profile-frag.html',
	    controller  : 'AppKitDataTablesDemo'
	})

	});


