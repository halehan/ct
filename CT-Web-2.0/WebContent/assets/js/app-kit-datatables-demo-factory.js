angular.module('ct').factory('patientListx', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/patient/list/site/:id', { name: '@_id' }, { 
	  });
	})
	
angular.module('ct').factory('patientTask', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/patient/task/find/:id', { name: '@_id' }, { 
	  });
	})

angular.module('ct').factory('patientTaskList', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/patient/task/find/report/:id', { name: '@_id' }, { 
	  });
	})
	
angular.module('ct').factory('equipList', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/equipment/site/:id', { name: '@_id' }, { 
	  });
	})

angular.module('ct').factory('maintService', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/equipment/:id', { name: '@_id' }, {
		    update: {method: 'PUT'   },
		    remove: {method: 'DELETE', params: {id: '@id'} }   
		  });
	});

angular.module('ct').factory('userService', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/user/:id', { id: '@_id' }, {
	    update: {method: 'PUT'   },
	    remove: {method: 'DELETE', params: {id: '@id'} }   
	  });
	});

angular.module('ct').factory('userSiteService', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/user/site/:id', { id: '@_id' }, { 
	  });
	});

angular.module('ct').factory('codeService', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/codes/:name', { name: '@_name' }, { 
	  });
	});

angular.module('ct').factory('practiceStudyCounts', function($resource) {
	return $resource('http://localhost:8080/CT-Web/practice/list/chart/:id/:status', { type: '@id', type: '@status' });
});   

angular.module('ct').factory('PatientList', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/patient/list/all/:type', { type: '@type' });
});

angular.module('ct').factory('Post', function($resource) {
return $resource('http://localhost:8080/CT-Web/patient/list/:type', { type: '@type' });
});

angular.module('ct').factory('Trials', function($resource) {
	return $resource('http://localhost:8080/CT-Web/study/list/read/');
	});

angular.module('ct').factory('PieChartCT', function($resource) {
	return $resource('http://localhost:8080/CT-Web/patient/chartOne/list/');
	});

angular.module('ct').factory('siteDeviationCounts', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/site/deviationcounts/:id', { type: '@id' });
});

angular.module('ct').factory('siteStaffDeviationCounts', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/site/deviationusercounts/:id', { type: '@id' });
});

angular.module('ct').factory('siteDocCounts', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/site/doccounts/:id', { type: '@id' });
});

angular.module('ct').factory('siteStudyCounts', function($resource) {
	return $resource('http://localhost:8080/CT-Web/site/list/study/chart/:id/:status', { type: '@id', type: '@status' });
});

angular.module('ct').factory('studyChart', function($resource) {
	return $resource('http://localhost:8080/CT-Web/study/list/chart/all/');
	});

/* angular.module('ct').factory('practiceList', function($resource) {
	return $resource('http://localhost:8080/CT-Web/practice/list/');
	});  */

angular.module('ct').factory('practice', function($resource) {
	return $resource('http://localhost:8080/CT-Web/practice/list/:id', { type: '@id' });
});

angular.module('ct').factory('site', function($resource) {
	return $resource('http://localhost:8080/CT-Web/site/list/:id', { type: '@id' });
});

angular.module('ct').factory('siteUser', function($resource) {
	return $resource('http://localhost:8080/CT-Web/study/site/user/:id', { type: '@id' });
});