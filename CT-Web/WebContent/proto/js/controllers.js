/*var app = angular.module("CT-Web", []);

app.controller("PostsCtrl", function($scope, $http) {
  $http.get('http://localhost:8080/CT-Web/api/patient/show/6').
    success(function(data, status, headers, config) {
      $scope.patients = data;
    }).
    error(function(data, status, headers, config) {
     alert('Hosed');
    });
});
*/

angular.module('myApp.controllers', []).
  controller('MyCtrl1', ['$scope', 'AngularIssues', function($scope, AngularIssues) {
    // Instantiate an object to store your scope data in (Best Practices)
    $scope.data = {};
   
    AngularIssues.query(function(response) {
      // Assign the response INSIDE the callback
      $scope.data.issues = response;
    });
  }])
  .controller('MyCtrl2', [function() {
  }]);
