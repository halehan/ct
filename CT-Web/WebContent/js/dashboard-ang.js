angular.module('ctApp',['ngResource', 'ngRoute']);

/* app.config(function($locationProvider) {
    $locationProvider.html5Mode({
      enabled: true,
      requireBase: false
    });
}); */


angular.module('ctApp').config(function($routeProvider) {
    
        // route for the home page
    $routeProvider.when('/', {
            templateUrl : 'frags/dashboard-frag.html',
            controller  : 'suck'
        })

        // route for the about page
        $routeProvider.when('/about', {
            templateUrl : 'frags/about.html',
            controller  : 'AboutController'
        })
        
        $routeProvider.when('/newstudy', {
            templateUrl : 'frags/newstudy-frag.html',
            controller  : 'newStudyController'
        })

        // route for the contact page
        $routeProvider.when('/studypatients/:param', {
            templateUrl : 'frags/studypatients-ang.html',
            controller  : 'studyController'
        });
    
  // $locationProvider.html5Mode(true);
});


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

ajax_data('GET','patient/chartOne/list', function(data)
		{

		chartProgress(data,"PieChartCT");


		});

angular.module('ctApp').controller('studyController', function($scope, $routeParams) {

	$scope.id = $routeParams.id;
	console.log(id);
});

angular.module('ctApp').controller('newStudyController', function($scope) {

    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

angular.module('ctApp').controller('suck', function($scope) {

    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

angular.module('ctApp').controller('AboutController', AboutController);

function AboutController() { 
	
	var vm = this;
    vm.message = 'Halehan iConsulting Group, Inc.';
    vm.message2 = '20 years of Enterprise Consulting.'
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

   
//GET and DELETE Ajax
function ajax_data(type, url, success)
{
$.ajax({
type:type,
url:url,
dataType:"json",
restful:true,
cache:false,
timeout:20000,
async:true,
beforeSend :function(data) { },
success:function(data){
success.call(this, data);
},
error:function(data){
alert("Error In Connecting");
}
});
}

function studyAll(data,ChartType)
{
var c=ChartType;
var jsonData=data;

google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var dataCandidate = new google.visualization.DataTable();
var dataEnrolled = new google.visualization.DataTable();

dataCandidate.addColumn('string', 'studyName');
dataCandidate.addColumn('number', 'count');

dataEnrolled.addColumn('string', 'studyName');
dataEnrolled.addColumn('number', 'count');

$.each(jsonData.chart, function(i,jsonData)
{
	var candidateCount=jsonData.candidateCount;
	var enrolledCount=jsonData.enrolledCount;
	
	
	var studyName=jsonData.studyName;
		console.log('name ' + studyName);
		console.log('value ' + candidateCount);

dataCandidate.addRows([ [studyName, candidateCount]]);
dataEnrolled.addRows([ [studyName, enrolledCount]]);
});

var optionsCandidates = {
title : "Patient Candidates",
colorAxis: {colors: ['#54C492', '#cc0000']},
datalessRegionColor: '#dedede',
defaultColor: '#dedede'
};

var optionsEnrolled = {
title : "Patients Enrolled",
colorAxis: {colors: ['#54C492', '#cc0000']},
datalessRegionColor: '#dedede',
defaultColor: '#dedede'
};

var chart;
var chartCandidate;
var chartEnrolled

chartCandidate = new google.visualization.PieChart(document.getElementById('piechart_ctStudyCand'));
chartEnrolled = new google.visualization.PieChart(document.getElementById('piechart_ctStudyEnrolled'));

chartCandidate.draw(dataCandidate, optionsCandidates);
chartEnrolled.draw(dataEnrolled, optionsEnrolled);
}
}

function chartProgress(data,ChartType)
{
var c=ChartType;
var jsonData=data;
google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var data = new google.visualization.DataTable();
data.addColumn('string', 'Status');
data.addColumn('number', 'Count');
$.each(jsonData.chart, function(i,jsonData)
{
var value=jsonData.count;
var name=jsonData.status;
console.log('value ' + value);
console.log('name ' + name);
data.addRows([ [name, value]]);
});


var options = {
		title : "Patient Candidate Progress",
        is3D: false,
        colors: ['red', 'green']
      };



var chart;
chart = new google.visualization.PieChart(document.getElementById('piechart_ct'));

chart.draw(data, options);
}
}



function parseLocation(location) {
	
	var regex = /[?&]([^=#]+)=([^&#]*)/g,
	location,
	params = {},
	match;
	while(match = regex.exec(location)) {
	params[match[1]] = match[2];
	}
	
	console.log(params);
    
    return params;
}

   
