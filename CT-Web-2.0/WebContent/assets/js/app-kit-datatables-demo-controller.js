angular.module('ct')
.controller('patientTask', function($scope, $route, $rootScope, $routeParams, $log, site, patientTaskList, patientTask, patientListx) {
	
	$scope.name = "patientTask";
    $scope.params = $routeParams;
    
    patientListx.get({ id: $scope.params.siteId }, function(data) {
		$scope.patientList = data.patient;
		$log.debug($scope.patientList);
	  });
    
$scope.getTasks = function(patientId) {
    	
    	$scope.formUpdate=false;
    	$scope.disableAll = false;
    	
    	patientTaskList.get({ id: patientId }, function(data) {
    		    $scope.patientTaskList = data.patientTaskList;
    			$log.debug('getTasks' + patientId);	
    	  }); 
    		
      };
      
      $scope.getTask = function(patientTaskId) {
      	
      	$scope.formUpdate=false;
      	$scope.disableAll = false;
      	
      	patientTask.get({ id: patientTaskId }, function(data) {
      		    $scope.patientTask = data.patientTask;
      			$log.debug('getTasks' + patientTaskId);	
      	  }); 
      		
        };
   
 /*   patientTaskList.get({ id: $scope.params.patientId }, function(data) {
		$scope.patientTaskList = data.patientTaskList;
		$log.debug(data);
	  }); */
    
   /* patientTask.get({ id: $scope.params.patientTaskId }, function(data) {
		$scope.patientTask = data.site;
	  }); */
    
});


angular.module('ct')
.controller('equipment', function($scope, $route, $rootScope, $routeParams, $log, site, codeService, maintService, equipList) {
	
	$scope.name = "equipment";
    $scope.params = $routeParams;
    $scope.formUpdate=true;
    
    site.get({ id: $rootScope.globalSite }, function(data) {
		$scope.site = data.site;
	  }); 
    
    equipList.get({ id: $rootScope.globalSite }, function(data) {
			$scope.equipmentList = data.siteEquipment;
			$scope.disableAll = true;
		  }); 
    
    codeService.get({ name: 'EquipmentType' }, function(data) {
		$scope.codeEquipmentType = data.codetables;
		$log.debug($scope.codeEquipmentType.codeTableName);
	  });  
    
    $scope.editEquipment = function(site_equipmentId) {
    	
    	$scope.formUpdate=false;
    	$scope.disableAll = false;
    	
    	maintService.get({ id: site_equipmentId }, function(data) {
    		    $scope.currentEquipment = data.siteEquipment;
    			$log.debug('editEqupment ' + $scope.currentEquipment);	
    	  }); 
    		
      };
      
    $scope.remove = function(site_equipmentId) {
	    	
      	var remove = maintService.remove({ id: site_equipmentId }, function() {
      		
      		equipList.get({ id: $rootScope.globalSite }, function(data) {
      			$scope.equipmentList = data.siteEquipment;
      		  }); 
  		
      	});
      	
      	remove.$promise.then(function successCallback(response) {
  			$.alert('Equipment Successfully Removed', {autoClose: true, closeTime: 2000, type: 'success', minTop: 10});
  	    }, function errorCallback(error) {
  	    		$.alert('Equipment Error Removing', {autoClose: true, closeTime: 2000, type: 'danger', minTop: 10});	
  	    }); 	
      	
      }
    
    $scope.save = function(currentEquipment) {
    	
    	maintService.get({ id: currentEquipment.site_equipmentId }, function(equip) {
		
			equip.siteEquipment.type  = $scope.currentEquipment.type;
			equip.siteEquipment.manufacturer  = $scope.currentEquipment.manufacturer;
			equip.siteEquipment.name  = $scope.currentEquipment.name;
			equip.siteEquipment.serialNumber  = $scope.currentEquipment.serialNumber;
			equip.siteEquipment.location  = $scope.currentEquipment.location;
		
			equip.$update(function() {
			
				equipList.get({ id: $rootScope.globalSite }, function(data) {
					$scope.equipmentList = data.siteEquipment;
					$scope.disableAll = true;
				  });  
			
		});
			
			equip.$promise.then(function successCallback(response) {
				$.alert('Staff Successfully Updated', {autoClose: true, closeTime: 2000, type: 'success', minTop: 10});
				console.log('success');
		    }, function errorCallback(error) {
		    		$.alert('Staff Error Updating', {autoClose: true, closeTime: 2000, type: 'danger', minTop: 10});
		    		console.log('error');
		           
		    });
       }); 				
};

});
    

app.controller('staffUpdate', function($scope, $routeParams, $rootScope, $log, site, userService, userSiteService) { 
	'use strict';

    $scope.params = $routeParams;
    $scope.formUpdate=true;
    
    userSiteService.get({ id: $rootScope.globalSite }, function(data) {
		$scope.staffList = data.user;
		$scope.disableAll = true;
	  });  
    
    site.get({ id: $rootScope.globalSite }, function(data) {
		$scope.site = data.site;

	  });  
	
    $scope.name = "staffUpdate";

    $scope.save = function(userObject) {
    	
    		userService.get({ id: userObject.userId }, function(updateUser) {
			
    			updateUser.user.fname  = $scope.currentUser.fname;
    			updateUser.user.lname  = $scope.currentUser.lname;
    			updateUser.user.login  = $scope.currentUser.login;
    			updateUser.user.phone  = $scope.currentUser.phone;
    			updateUser.user.email  = $scope.currentUser.email;
			
    			updateUser.$update(function() {
				
    			userSiteService.get({ id: $rootScope.globalSite }, function(data) {
    	    			$scope.staffList = data.user;
    	    			$scope.disableAll = true;
    	    		  });  
				
			});
    			
			updateUser.$promise.then(function successCallback(response) {
					$.alert('Staff Successfully Updated', {autoClose: true, closeTime: 2000, type: 'success', minTop: 10});
					console.log('success');
			    }, function errorCallback(error) {
			    		$.alert('Staff Error Updating', {autoClose: true, closeTime: 2000, type: 'danger', minTop: 10});
			    		console.log('error');
			           
			    });
	       }); 				
    };
    
    $scope.create = function(userObject) {
    	
			updateUser.user.fname  = $scope.currentUser.fname;
			updateUser.user.lname  = $scope.currentUser.lname;
			updateUser.user.login  = $scope.currentUser.login;
			updateUser.user.phone  = $scope.currentUser.phone;
			updateUser.user.email  = $scope.currentUser.email;
		
			updateUser.$update(function() {
			
				userSiteService.get({ id: $rootScope.globalSite }, function(data) {
	    			$scope.staffList = data.user;
	    			$scope.disableAll = true;
	    		  });  
			
		});
			
		updateUser.$promise.then(function successCallback(response) {
				$.alert('Staff Successfully Updated', {autoClose: true, closeTime: 2000, type: 'success', minTop: 10});
				console.log('success');
		    }, function errorCallback(error) {
		    		$.alert('Staff Error Updating', {autoClose: true, closeTime: 2000, type: 'danger', minTop: 10});
		    		console.log('error');
		           
		    });
      			
    	$scope.formUpdate=true;
    	
    };
    
    $scope.remove = function(userId) {
    	    	
    	var remove = userService.remove({ id: userId }, function() {
    		
    		userSiteService.get({ id: $rootScope.globalSite }, function(data) {
    			$scope.staffList = data.user;
    			$scope.disableAll = true;
    		  });   
    		
    	});
    	
    	remove.$promise.then(function successCallback(response) {
			$.alert('Staff Successfully Removed', {autoClose: true, closeTime: 2000, type: 'success', minTop: 10});
	    }, function errorCallback(error) {
	    		$.alert('Staff Error Removing', {autoClose: true, closeTime: 2000, type: 'danger', minTop: 10});	
	    }); 	
    	
    }
    
    $scope.editpatient = function(userId, edit) {
    	
    	$log.debug(edit);
    	$log.debug($scope.disableAll);
    	$scope.formUpdate=false;
    	$scope.disableAll = false;
    	
    		var user = userService.get({ id: userId }, function() {
    			$scope.currentUser = user.user;
    	  }); 
    	
      };

});

app.controller('practiceDashboard', function($scope, $log, practice, site, practiceStudyCounts, siteStudyCounts, siteDocCounts, siteDeviationCounts, PieChartCT, studyChart,  $rootScope, $route,  $routeParams) { 
	$scope.params = $routeParams;
	
	 practice.get({ id: $rootScope.practiceId }, function(data) {
			$scope.sites = data.practice.sites;
			$scope.practice = data.practice;
			console.log($scope.sites)
		  });  
	
	practiceStudyCounts.get({ id: $scope.params.practiceId, status: 'candidate' }, function(data) {
		$scope.candidates = data.sitecounts;	
		
		$.each($scope.candidates, function(i,jsonData){ $scope.candidateCount += jsonData.count; $scope.candidateStudies += 1;});
		
		siteStudy($scope.candidates, 'studyName', 'PieChartStudy', 'practiceCandidate', 'Patient Candidates');
	 
		$log.debug('candidate Counts ' + $scope.candidateCount);
    }); 
	
	practiceStudyCounts.get({ id: $scope.params.practiceId, status: 'enrolled' }, function(data) {
		$scope.enrolled = data.sitecounts;	
		
		$.each($scope.enrolled, function(i,jsonData){ $scope.candidateCount += jsonData.count; $scope.candidateStudies += 1;});
		
		siteStudy($scope.enrolled, 'studyName', 'PieChartStudy', 'practiceEnrolled', 'Patient Candidates');
	 
		$log.debug('candidate Counts ' + $scope.candidateCount);
    }); 
	
	practiceStudyCounts.get({ id: $scope.params.practiceId, status: 'failed' }, function(data) {
		$scope.failed = data.sitecounts;	
		
		$.each($scope.failed, function(i,jsonData){ $scope.candidateCount += jsonData.count; $scope.candidateStudies += 1;});
		
		siteStudy($scope.failed, 'studyName', 'PieChartStudy', 'practiceFailed', 'Patient Candidates');
	 
		$log.debug('candidate Counts ' + $scope.candidateCount);
    }); 
	
});

app.controller('siteDashboard', function($scope, $log, site, siteStudyCounts, siteDocCounts, siteDeviationCounts, siteStaffDeviationCounts, PieChartCT, studyChart,  $rootScope, $route,  $routeParams) { 
	
	$scope.name = "siteDashboard";
	$scope.params = $routeParams;
	$scope.enrolledCount = 0;
	$scope.enrolledStudies = 0;
	$scope.candidateCount = 0;
	$scope.candidateStudies = 0;
	
	$log.log($scope.params.siteId);
	$rootScope.globalSite = $scope.params.siteId;
	    
	    site.get({ id: $scope.params.siteId }, function(data) {
			$scope.site = data.site;
			$scope.site.equipmentList = data.site.siteEquipmentVoList;
			
		  });
	    
	    siteDeviationCounts.get({ id: $rootScope.globalSite }, function(data) {
			$scope.deviationCounts = data.deviation;	
			
			siteStudy($scope.deviationCounts, 'studyName', 'PieChartStudy', 'deviationCount', 'Study Deviation Count');
			
	      });
	    
	    siteStaffDeviationCounts.get({ id: $rootScope.globalSite }, function(data) {
			$scope.deviationStaffCounts = data.deviation;	
			
			siteStudy($scope.deviationStaffCounts, 'studyName', 'PieChartStudy', 'deviationStudyCount', 'Staff Deviation Count');
			
	      });
	    
	    siteDocCounts.get({ id: $rootScope.globalSite }, function(data) {
			$scope.docs = data.doccounts;	
			
			siteStudy($scope.docs, 'docName', 'PieChartStudy', 'docCounts', 'Physician Enrollment');
			
	      });
	    
	    siteStudyCounts.get({ id: $rootScope.globalSite, status: 'candidate' }, function(data) {
			$scope.candidates = data.sitecounts;	
			
			$.each($scope.candidates, function(i,jsonData){ $scope.candidateCount += jsonData.count; $scope.candidateStudies += 1;});
			
			siteStudy($scope.candidates, 'studyName', 'PieChartStudy', 'siteCandidate', 'Patient Candidates');
		 
			$log.debug('candidate Counts ' + $scope.candidateCount);
	    }); 
	   
	    siteStudyCounts.get({ id: $scope.params.siteId, status: 'enrolled' }, function(data) {
				$scope.enrolled = data.sitecounts;	
				$log.debug('enrolled');
				
				$.each($scope.enrolled, function(i,jsonData){ $scope.enrolledCount += jsonData.count; $scope.enrolledStudies += 1;});
				
				siteStudy($scope.enrolled, 'studyName',"PieChartStudy", 'siteEnrolled', 'Patients Enrolled');
				
				$log.debug('$scope Enrolled Counts ' + $scope.enrolledCount);
			
		  }); 
	    
	    siteStudyCounts.get({ id: $scope.params.siteId, status: 'failed' }, function(data) {
			$scope.failed = data.sitecounts;	
			$log.debug('enrolled');
			
			$.each($scope.failed, function(i,jsonData){ $scope.enrolledCount += jsonData.count; $scope.enrolledStudies += 1;});
			
			siteStudy($scope.failed, 'studyName',"PieChartStudy", 'siteFailed', 'Patients Failed');
			
			$log.debug('$scope Failed Counts ' + $scope.enrolledCount);
		
	  }); 
	    
	    $scope.sitemetrics = [
		                      {
		                    	  'menuName': 'Site Recruitment',
		                    	  'href': '#site-recruitment'
		                      },
		                      {
		                    	  'menuName': 'Site Billing Reconciliation',
		                    	  'href': '#invoices'
		                      },
		                      {
		                    	  'menuName': 'Site Report Card',
		                    	  'href': '#charts'
		                      },
		                      {
		                    	  'menuName': 'Site Staff Metrics',
		                    	  'href': '#charts'
		                      },
		                      
		                      ]
	 
});
	


angular.module('ct').controller('AppKitInvoicesDemo', function($scope) {
	'use strict';

	$scope.invoicesData = [
        {x: '2015-06-01', a:4200, b:1000, c:1200 },
        {x: '2015-06-03', a:5400, b:800, c:600 },
        {x: '2015-06-08', a:3100, b:1100, c:1200 },
        {x: '2015-06-11', a:2500, b:800, c:1200 },
        {x: '2015-06-12', a:4200, b:1400, c:5670 },
        {x: '2015-06-13', a:5600, b:1250, c:4200 },
        {x: '2015-06-16', a:5200, b:1320, c:3760 },
        {x: '2015-06-18', a:5700, b:1578, c:3669 },
        {x: '2015-06-20', a:6250, b:924, c:3550 },
        {x: '2015-06-23', a:6100, b:866, c:3980 },
        {x: '2015-06-30', a:6340, b:790, c:3800 }
	];

	$scope.dateFormatter = function (x) {
		return moment(x).format('DD MMM YYYY');
	};
});

angular.module('ct')
.controller('crack', function($scope, $route, $rootScope, $routeParams,  site) {
	
	$scope.name = "crack";
    $scope.params = $routeParams;
	
    console.log($scope.params);
    console.log($scope.params.siteId);
    $rootScope.globalSite = $scope.params.siteId;
    
    site.get({ id: $rootScope.globalSite }, function(data) {
		$scope.site = data.site;
		$scope.site.equipmentList = data.site.siteEquipmentVoList;
		console.log($scope.site);
		console.log($scope.site.abbreviatedName);
	  });  
    
});

angular.module('ct')
.controller('staff', function($scope, $route, $rootScope, $routeParams,  site) {
	
	$scope.name = "staff";
    $scope.params = $routeParams;

    site.get({ id: $rootScope.globalSite }, function(data) {
		$scope.site = data.site;
		$scope.staffList = data.site.userVoList;
	  });  
    
});

angular.module('ct')
.controller('site-recruitment', function($scope, $route,  $rootScope, $routeParams,    site) {
	
	$scope.name = "site-recruitment";
    $scope.params = $routeParams;
	
    console.log($scope.params);
    console.log($scope.params.siteId);
  
});


app.controller('AppKitWidgetsDemo', function($scope,  $routeParams) { 
	'use strict';
	
    $scope.name = "AppKitWidgetsDemo";
    $scope.params = $routeParams;
    
    console.log($scope.params);
    console.log($scope.params.practiceId);

});


angular.module('ct')
.controller('dashboard', function($scope, $route, $log, $routeParams, $rootScope, practice) {
	
		 $scope.practice = 'RSI';
	     $scope.params = $routeParams;
	     
	     $log.debug('practiceId = ' + $rootScope.practiceId);
	   
	     $scope.name = "dashboard";
	    
		 console.log($scope.params);
		 console.log($scope.params.practiceId);
		 $rootScope.practiceId = $scope.params.practiceId;
		 
	/*	 if ($scope.params.practiceId == null || $scope.params.practiceId == undefined){
			 $rootScope.practiceId = 1;
		 }
		 */
		 
		 practice.get({ id: $rootScope.practiceId }, function(data) {
			$scope.sites = data.practice.sites;
			console.log($scope.sites)
		  });  
		
		$scope.sitemetrics = [
		                      {
		                    	  'menuName': 'Site Recruitment',
		                    	  'href': '#site-recruitment'
		                      },
		                      {
		                    	  'menuName': 'Site Billing Reconciliation',
		                    	  'href': '#invoices'
		                      },
		                      {
		                    	  'menuName': 'Site Report Card',
		                    	  'href': '#charts'
		                      },
		                      {
		                    	  'menuName': 'Site Staff Metrics',
		                    	  'href': '#charts'
		                      },
		                      
		                      ]
		
});


angular.module('ct')
.controller('practices', function($scope, practice) {
	
	$scope.loggeduser = 'Sheri Tallman';
	$scope.loggedrole = 'CTA';
	$scope.practice = 'Retina Specialty Institute';
	
	practice.get(function(data) {
		$scope.practices = data;
		
		
	  });
	
		console.log($scope.practices);
		
});


angular.module('ct')
.controller('branding', function($scope) {
	
		$scope.practice = 'Retina Specialty Institute';
		
		console.log($scope.practice);
		
});

angular.module('ct')
.controller('notifications', function($scope) {
	
		$scope.name = 'Buster';
		$scope.action = 'Wanted to see if you wanted to go fishing.';
	
});


angular.module('ct')
.controller('AppKitDataTablesDemo', function($scope, PatientList, Trials, Post, DTOptionsBuilder) {
	'use strict';
	$scope.datatableOptions = DTOptionsBuilder.newOptions().withPaginationType('full_numbers').withDisplayLength(10);
	
    Skinny.get({ type: 'enrolled' }, function(data) {
		
		$scope.patients = data;
		console.log(data);
		$scope.practice = 'RSI';
		
	  });
	
	Trials.get(function(data) {
	    $scope.trials = data;
	    console.log(data);
	  });
	
	Post.get({ type: 'pending' }, function(data) {
	    $scope.pendingPatients = data;
	    console.log('pending patients' + data);
	  });  
	
	 Post.get({ type: 'NEW' }, function(data) {
		    $scope.newPatients = data;
		  });
	 
	 Post.get({ type: 'EXPIRED' }, function(data) {
		    $scope.expiredPatients = data;
		  });
	

});


function siteStudy(data, name, ChartType, elementId, title)
{
var c=ChartType;
var jsonData=data;


google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var dataObject = new google.visualization.DataTable();


dataObject.addColumn('string', name);
dataObject.addColumn('number', 'count');


$.each(jsonData, function(i,jsonData)
{
	
	var dataCount=jsonData.count;
	var studyName=jsonData.name;
	
	dataObject.addRows([[studyName, dataCount]]);

});

var options = {
title : title,
is3D: true,
colorAxis: {colors: ['#54C492', '#cc0000']},
datalessRegionColor: '#dedede',
defaultColor: '#dedede'
};

var chart;

chart = new google.visualization.PieChart(document.getElementById(elementId));
chart.draw(dataObject, options);

}
}
