var myServices = angular.module('ct', ['ngResource']);

myServices.factory('Auth',  function($resource){    
    return $resource('http://localhost:8080/CT-Web/security/authenticate', 
    {
    	
    });
  }
);

myServices.factory('equipList', function($resource, $rootScope) {
	  return $resource($rootScope.baseUrl + '/equipment/site/:id', { name: '@_id' }, { 
		  headers: { 'auth-token': 'C3PO R2D2' }
	  });
	})
	
    myServices.factory('User', function($resource, token) {
        var User = $resource('http://localhost:8080/CT-Web/security/findSomething', { }, {
            query: {
                method: 'GET',
                isArray: true,
                headers: { 'token': token }
            }
        });
        return User
    });
	


myServices.factory('PieChartCT', function($resource, $rootScope) {
	return $resource($rootScope.baseUrl + '/patient/chartOne/list/');
	});

myServices.controller('AuthCtrl', function($scope, $location, $log, $window, $http, Auth) {
	
	$scope.authenticated = '';
	$scope.val = '';
	$scope.u = 'a';
	$scope.p = 'p';
	
	if ($scope.userId != null){
		$scope.u = $scope.username; }
	
	if ($scope.password != null){
		$scope.p  = $scope.password; }
	
	
	$scope.login = function()
	   {
		
		$http.defaults.headers.get = { 'token' : 'value' };
		
/*		Auth.$login({ username: $scope.u,  password: $scope.p}, function(data) {
			$scope.val = data;
			console.log($scope.val);
		  }); 
		*/
		if ($scope.val.result == 'SUCCESS'){
			
			 var url = "http://" + $window.location.host + "/CT-Web-2.0/index-ct.html?practiceId=1";
		      $log.log(url);
		      $window.location.href = url;
			
		}
	      
	   };
	
	
	  console.log('just called authctrl');
    
});


