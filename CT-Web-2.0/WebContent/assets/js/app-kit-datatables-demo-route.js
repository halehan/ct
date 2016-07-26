angular.module('ct').config(function($routeProvider) {

	$routeProvider.when('/patientTask', {
	    templateUrl : 'frag/patient-task.html',
	    controller  : 'patientTask'
	})
	
	$routeProvider.when('/sitedash', {
	    templateUrl : 'frag/site-dashboard.html',
	    controller  : 'siteDashboard'
	})
	
	$routeProvider.when('/siteStaffUpdate', {
	    templateUrl : 'frag/patient-update.html',
	    controller  : 'staffUpdate'
	})
	
	$routeProvider.when('/login', {
	    templateUrl : 'login.html',
	    controller  : 'login',
	    disableCache: true
	})
	
	$routeProvider.when('/', {
	    templateUrl : 'frag/practice-dashboard.html',
	    controller  : 'practiceDashboard'
	})

	$routeProvider.when('/widgets', {
	    templateUrl : 'widgets-frag.html',
	    controller  : 'AppKitDataTablesDemo'
	})
	
	$routeProvider.when('/charts', {
	    templateUrl : 'frag/google-charts.html',
	    controller  : 'AppKitDataTablesDemo'
	})
	
	$routeProvider.when('/invoices', {
	    templateUrl : 'frag/invoices.html',
	    controller  : 'AppKitInvoicesDemo'
	})
	
	$routeProvider.when('/equipment', {
	    templateUrl : 'frag/site-equipment.html',
	    controller  : 'dashboard'
	})
	
	$routeProvider.when('/staff', {
	    templateUrl : 'frag/site-staff.html',
	    controller  : 'dashboard'
	})
	
	$routeProvider.when('/site-recruitment', {
	    templateUrl : 'frag/site-recruitment.html',
	    controller  : 'AppKitDataTablesDemo',
	    disableCache: true
	})
	
	
	$routeProvider.when('/charts2', {
	    templateUrl : 'frag/google-charts.html',
	    controller  : 'dashboard',
	    disableCache: true
	})
	
	$routeProvider.when('/help', {
	    templateUrl : 'frag/help.html',
	    controller  : 'AppKitDataTablesDemo'
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
	
/*	$routeProvider.when('/charts/:practiceId', {
        templateUrl : 'frag/google-charts.html',
        controller  : 'AppKitDataTablesDemo'
    });
	*/

	});


