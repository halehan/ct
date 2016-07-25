  

 angular.module('ct',[
               'appKitCommon',
               'appKit',
               'ngResource',
               'ngRoute',
               'ngTable',
               'datatables']).controller('AppKitDataTablesDemo', function($scope,  Skinny, Trials, Post, DTOptionsBuilder) {
	'use strict';
	
	$scope.datatableOptions = DTOptionsBuilder.newOptions().withPaginationType('full_numbers').withDisplayLength(4);
	
	Skinny.get({ type: 'enrolled' }, function(data) {
		
		$scope.patients = data;
		console.log(data);
		
	  });
	
	Trials.get(function(data) {
	    $scope.trials = data;
	    console.log(data);
	  });
	
	Post.get({ type: 'pending' }, function(data) {
	    $scope.pendingPatients = data;
	    console.log(data);
	  });  
	
	 Post.get({ type: 'NEW' }, function(data) {
		    $scope.newPatients = data;
		  });
	 
	 Post.get({ type: 'EXPIRED' }, function(data) {
		    $scope.expiredPatients = data;
		  });

                	  
     });
	
 