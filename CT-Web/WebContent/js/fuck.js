var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'frags/home.html',
    controller  : 'HomeController'
  })

  .when('/blog', {
    templateUrl : 'frags/blog.html',
    controller  : 'BlogController'
  })

  .when('/about', {
    templateUrl : 'frags/about.html',
    controller  : 'AboutController'
  })

  .otherwise({redirectTo: '/'});
});

app.controller('HomeController', function($scope) {
	  $scope.message = 'Hello from HomeController';
	});

	app.controller('BlogController', function($scope) {
	  $scope.message = 'Hello from BlogController';
	});

	app.controller('AboutController', function($scope) {
	  $scope.message = 'Hello from AboutController';
	});