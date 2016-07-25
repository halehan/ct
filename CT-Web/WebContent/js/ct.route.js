angular.module('ctApp').config(function($routeProvider) {
    
        // route for the home page
    $routeProvider.when('/', {
            templateUrl : 'frags/dashboard-frag.html',
            controller  : 'suck'
        })

        // route for the about page
        $routeProvider.when('/about', {
            templateUrl : 'frags/about.html',
            controller  : 'AboutController'
        })
        
        $routeProvider.when('/aboutParm/:paramID', {
            templateUrl : 'frags/ab.html',
            controller  : 'zeroFuck'
        })
        
        $routeProvider.when('/newstudy', {
            templateUrl : 'frags/newstudy-frag.html',
            controller  : 'newStudyController'
        })

        // route for the contact page
        $routeProvider.when('/studypatients/:paramID', {
            templateUrl : 'studyPatients-ang.html',
            controller  : 'studyController'
        });
    
  // $locationProvider.html5Mode(true);
});