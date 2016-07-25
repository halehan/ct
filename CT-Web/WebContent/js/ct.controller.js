
angular.module('ctApp').controller('mainController',  function($scope, $route, $routeParams, Trials, Post) {
	
	Trials.get(function(data) {
	    $scope.trials = data;
	  });  
	
	Post.get({ type: 'pending' }, function(data) {
	    $scope.holder = data;
	  });  
	
	 $scope.$route = $route;
     $scope.$routeParams = $routeParams;
     $scope.fuck = 'fck';
     var vm = this;
     var message = 'MAINCONTROLLER Halehan iConsulting Group, Inc.';
     
     
     $scope.name = "mainController";
     $scope.params = $routeParams;
     
     console.log($scope.$route);
     console.log($scope.$routeParams);


});

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


angular.module('ctApp').controller('studyController', function($scope, $route,  $routeParams) {
	
	 $scope.$route = $route;
     $scope.params = $routeParams;
     $scope.fuck = 'fck';
     
     $scope.name = "studyController";
     $scope.params = $routeParams;
     
     console.log($scope.$route);
     console.log($scope.$routeParams);
     
     $scope.id = '1';


});

angular.module('ctApp').controller('newStudyController', function($scope, $route) {
	
	

    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

angular.module('ctApp').controller('suck', function($scope) {

    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

angular.module('ctApp').controller('AboutController', AboutController);

function AboutController($scope, $route, $routeParams) { 
	
	var vm = this;
    vm.message = 'Halehan iConsulting Group, Inc.';
    vm.message2 = '20 years of Enterprise Consulting.'
    	vm.id=$routeParams;
    vm.sendMessage = function() { };
}


/*

angular.module('ctApp').controller('AboutController', function($scope) {

    // create a message to display in our view
    $scope.message = 'Halehan iConsulting Group, Inc.';
});
*/


angular.module('ctApp').controller("studyTrials", function($scope, Trials) {
	Trials.get(function(data) {
	    $scope.holder = data;
	  });  
});

angular.module('ctApp').controller("getPatientListPending", function($scope, Post) {
	  Post.get({ type: 'pending' }, function(data) {
	    $scope.holder = data;
	  });  
	  
	  $scope.UpdateTask = function () {
	     	 
	     	 var ua        = navigator.userAgent.toLowerCase(),
	          isIE      = ua.indexOf('msie') !== -1,
	          version   = parseInt(ua.substr(4, 2), 10);

	      // Internet Explorer 8 and lower
	      if (isIE && version < 9) {
	          var link = document.createElement('a');
	          link.href = url;
	          document.body.appendChild(link);
	          link.click();
	      }

	      // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	      else { 
	          window.location.href = "updatetask-ang.html?id=" +  this.item.patientTaskId + '&patientId=' +  this.item.patientId;  
	      }
	     	 
	    	 
	  }
	  
	  $scope.UpdatePatient = function  () {
	    	var ua        = navigator.userAgent.toLowerCase(),
	        isIE      = ua.indexOf('msie') !== -1,
	        version   = parseInt(ua.substr(4, 2), 10);

	    // Internet Explorer 8 and lower
	    if (isIE && version < 9) {
	        var link = document.createElement('a');
	        link.href = url;
	        document.body.appendChild(link);
	        link.click();
	    }

	    // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	    else { 
	        window.location.href = "updatepatient-ang.html?id=" + this.item.patientId; 
	    }
	}
});

angular.module('ctApp').controller("getPatientListNew", function($scope, Post) {
	  Post.get({ type: 'NEW' }, function(data) {
	    $scope.holder = data;
	  });
	  
	  $scope.UpdateTask = function () {
     	 
     	 var ua        = navigator.userAgent.toLowerCase(),
          isIE      = ua.indexOf('msie') !== -1,
          version   = parseInt(ua.substr(4, 2), 10);

      // Internet Explorer 8 and lower
      if (isIE && version < 9) {
          var link = document.createElement('a');
          link.href = url;
          document.body.appendChild(link);
          link.click();
      }

      // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
      else { 
          window.location.href = "updatetask-ang.html?id=" +  this.item.patientTaskId + '&patientId=' +  this.item.patientId;  
      }
     	 
    	 
  }
	  
	  $scope.UpdatePatient = function  () {
	    	var ua        = navigator.userAgent.toLowerCase(),
	        isIE      = ua.indexOf('msie') !== -1,
	        version   = parseInt(ua.substr(4, 2), 10);

	    // Internet Explorer 8 and lower
	    if (isIE && version < 9) {
	        var link = document.createElement('a');
	        link.href = url;
	        document.body.appendChild(link);
	        link.click();
	    }

	    // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	    else { 
	        window.location.href = "updatepatient-ang.html?id=" + this.item.patientId; 
	    }
	}
	  
});


angular.module('ctApp').controller("getPatientListEnrolled", function($scope, Skinny) {
	  Skinny.get({ type: 'enrolled' }, function(data) {
	    $scope.holder = data;
	  });
	  
	  $scope.UpdateTask = function () {
	     	 
	     	 var ua        = navigator.userAgent.toLowerCase(),
	          isIE      = ua.indexOf('msie') !== -1,
	          version   = parseInt(ua.substr(4, 2), 10);

	      // Internet Explorer 8 and lower
	      if (isIE && version < 9) {
	          var link = document.createElement('a');
	          link.href = url;
	          document.body.appendChild(link);
	          link.click();
	      }

	      // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	      else { 
	          window.location.href = "updatetask-ang.html?id=" +  this.item.patientTaskId + '&patientId=' +  this.item.patientId;  
	      }
	     	 
	    	 
	  }
	  
	  $scope.UpdatePatient = function  () {
	    	var ua        = navigator.userAgent.toLowerCase(),
	        isIE      = ua.indexOf('msie') !== -1,
	        version   = parseInt(ua.substr(4, 2), 10);

	    // Internet Explorer 8 and lower
	    if (isIE && version < 9) {
	        var link = document.createElement('a');
	        link.href = url;
	        document.body.appendChild(link);
	        link.click();
	    }

	    // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	    else { 
	        window.location.href = "updatepatient-ang.html?id=" + this.item.patientId; 
	    }
	}
});

angular.module('ctApp').controller("getPatientListExpired", function($scope, Post) {
	  Post.get({ type: 'EXPIRED' }, function(data) {
	    $scope.holder = data;
	  });
	  
	  $scope.UpdateTask = function () {
	        	 
	        	 var ua        = navigator.userAgent.toLowerCase(),
	             isIE      = ua.indexOf('msie') !== -1,
	             version   = parseInt(ua.substr(4, 2), 10);

	         // Internet Explorer 8 and lower
	         if (isIE && version < 9) {
	             var link = document.createElement('a');
	             link.href = url;
	             document.body.appendChild(link);
	             link.click();
	         }

	         // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	         else { 
	             window.location.href = "updatetask-ang.html?id=" +  this.item.patientTaskId + '&patientId=' +  this.item.patientId;  
	         }
	        	 
	       	 
	     }
	  
	  $scope.UpdatePatient = function  () {
	    	var ua        = navigator.userAgent.toLowerCase(),
	        isIE      = ua.indexOf('msie') !== -1,
	        version   = parseInt(ua.substr(4, 2), 10);

	    // Internet Explorer 8 and lower
	    if (isIE && version < 9) {
	        var link = document.createElement('a');
	        link.href = url;
	        document.body.appendChild(link);
	        link.click();
	    }

	    // All other browsers can use the standard window.location.href (they don't lose HTTP_REFERER like IE8 & lower does)
	    else { 
	        window.location.href = "updatepatient-ang.html?id=" + this.item.patientId; 
	    }
	}
	
});
