angular.module('ctApp').factory('PatientService', function($resource) {
	  return $resource('/CT-Web/patient/update/:patientId', { patientId: '@patientId' });
	});

angular.module('ctApp').factory('fuckFactory', function($resource) {
	  return $resource('/CT-Web/patient/task/find/report/:patientId', { patientId: '@patientId' });
	});


angular.module('ctApp').factory('TaskListViewModel', function($resource) {
	  return $resource('/CT-Web/patient/task/find/:id', { id: '@id' });
	});

angular.module('ctApp').factory('Post', function($resource) {
	  return $resource('/CT-Web/patient/list/:type', { type: '@type' });
	});

angular.module('ctApp').factory('Skinny', function($resource) {
	  return $resource('/CT-Web/patient/list/all/:type', { type: '@type' });
	});

angular.module('ctApp').factory('Trials', function($resource) {
	  return $resource('/CT-Web/study/list/read/');
	});