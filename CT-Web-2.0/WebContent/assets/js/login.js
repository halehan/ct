var myServices = angular.module('ct', ['ngResource']);

// myServices.factory('Auth', function($resource) {
//	  return $resource('http://localhost:8080/CT-Web/auth/:userId/:password', { type: '@userId', type: '@password' });
// });

//myServices.factory('Auth', function ($resource) {
//    return $resource('http://localhost:8080/CT-Web/auth/:userId/:password',{user: "@user", password: '@password'});
//});

myServices.factory('Auth', function($resource) {
	return $resource('http://localhost:8080/CT-Web/auth/:userId/:password', {type: '@userId', type: '@password' });
});

/*
myServices .factory('Auth',  function($resource){    
    return $resource('http://localhost:8080/CT-Web/auth/:userId/:password', {type: '@userId', type: '@password' }, {
      login: {method:'POST', params: { userId: 'user1', password: 'abc123' }, isArray:false}
    });
  }
);
*/

myServices.controller('AuthCtrl', function($scope, $location, $log, $window, Auth) {
	
	
	$scope.authenticated = '';
	$scope.val = '';
	$scope.u = 'a';
	$scope.p = 'p';
	
	if ($scope.userId != null){
		$scope.u = $scope.userId; }
	
	if ($scope.password != null){
		$scope.p  = $scope.password; }
	
	
	$scope.login = function()
	   {
		
		Auth.get({ userId: $scope.u,  password: $scope.p}, function(data) {
			$scope.val = data;
			console.log($scope.val);
		  }); 
		
		if ($scope.val.result == 'SUCCESS'){
			
			 var url = "http://" + $window.location.host + "/CT-Web-2.0/index-ct.html?practiceId=1";
		      $log.log(url);
		      $window.location.href = url;
			
		}
	      
	   };
	
	 
	
	
	  console.log('just called authctrl');
    /*  $scope.login = function() {
      console.log('Login');
      var val = Auth.login();
      $log.log(val);
      
    };  */
});


