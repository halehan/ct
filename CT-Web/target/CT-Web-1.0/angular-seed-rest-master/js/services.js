'use strict';

/*
   angular.module('myApp.services', ['ngResource'])
  .factory('AngularIssues', function($resource){
    return $resource('https://api.github.com/repos/angular/angular.js/issues/:number',
      {number: '@number'},
      {getIssue: {method: 'GET', params: {number: 0}}}
    )
  })
  .value('version', '0.1');  */

angular.module('myApp.services', ['ngResource']).
factory('AngularIssues', function($resource) {
	$http.get('http://localhost:8080/CT-Web/api/patient').success(function(data){
		  $scope.test = data;
		});
	});
   
 /*
   angular.module('myApp.services', ['ngResource'])
   .factory('AngularIssues', function($resource){
     return $resource('http://localhost:8080/CT-Web/api/patient/:number',
       {number: '@number'},
       {getIssue: {method: 'GET', params: {number: 0}}}
     )
   })
   .value('version', '0.1');  */
   

/*
angular.module('myApp.services', ['ngResource'])
.factory('AngularIssues', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/api/patient/list');
	});
*/
/*
angular.module('myApp.services', ['ngResource'])
.factory('AngularIssues', function($resource){
  return $resource('http://localhost:8080/CT-Web/api/patient/list/:number',
    {number: '@number'},
    {getIssue: {method: 'GET', params: {number: 0}}}
  )
})  
.value('version', '0.1');  */


/*
{ 'get':    {method:'GET'},
  'save':   {method:'POST'},
  'query':  {method:'GET', isArray:true},
  'remove': {method:'DELETE'},
  'delete': {method:'DELETE'} };
*/