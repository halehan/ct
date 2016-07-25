angular.module('myApp').factory('Entry', function($resource) {
  return $resource('/api/entries/:id'); // Note the full endpoint address
});


angular.module('upe.services', ['ngResource']).
factory('Profileslst', function($resource){
	return $resource('http://localhost:8080/CT-Web/api/patient', {}, 
			{ query: {method:'GET', params:{profileid:'profilelist'}, isArray:true} }); 
	});


angular.module('jsonService', ['ngResource'])
.factory('JsonService', function($resource) {
  return $resource('http://localhost:8080/CT-Web/api/patient');
});