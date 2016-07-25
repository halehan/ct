

angular.module('ct').factory('Skinny', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/patient/list/all/:type', { type: '@type' });
});

angular.module('ct').factory('Trials', function($resource) {
return $resource('http://localhost:8080/CT-Web/study/list/read/');
});

angular.module('ct').factory('Post', function($resource) {
return $resource('http://localhost:8080/CT-Web/patient/list/:type', { type: '@type' });
});

