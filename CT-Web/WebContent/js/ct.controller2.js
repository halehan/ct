


angular.module('ctApp').controller('loginController', function($scope, $route,  $routeParams) {
	
	 $scope.$route = $route;
    $scope.params = $routeParams;
    $scope.fuck = 'fck';
    $scope.fullName = 'Sherika Tallman';
    $scope.position = 'Spider';
    $scope.site = 'Pensacola';
    
    $scope.name = "loginController";
    $scope.params = $routeParams;
    
    console.log($scope.$route);
    console.log($scope.$routeParams);
    
    $scope.id = '1';


});




