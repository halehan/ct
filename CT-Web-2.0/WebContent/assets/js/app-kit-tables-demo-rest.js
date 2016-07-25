var app = angular.module('appKitTablesDemo',[
                                            	'appKitCommon',
                                               	'appKit',
                                               	'ngTable',
                                               	'ngResource'
                                               ]);


app.factory('Skinny', function($resource) {
	  return $resource('http://localhost:8080/CT-Web/patient/list/all/:type', { type: '@type' });
});

app.factory('Trials', function($resource) {
return $resource('http://localhost:8080/CT-Web/study/list/read/');
});

app.factory('Post', function($resource) {
return $resource('http://localhost:8080/CT-Web/patient/list/:type', { type: '@type' });
});  

app.controller('AppKitTablesDemo', function($scope, Skinny, NgTableParams) {
	 'use strict';
	 
	 
Skinny.get({ type: 'enrolled' }, function(enrolledData) {
		
	// $scope.enrolled = enrolledData.patient;
	 $scope.$groupss = 'ff';
	
	  });

    var enrolled = 'fuk';
    $scope.suck = enrolled;
	
	var data = [
			{
				'id': 1,
				'firstname': 'Mark',
				'lastname': 'Otto',
				'username': '@mdo',
				'color': 'green'
			},
			{
				'id': 2,
				'firstname': 'Jacob',
				'lastname': 'Thornton',
				'username': '@fat',
				'color': 'blue'
			},
			{
				'id': 3,
				'firstname': 'Larry',
				'lastname': 'the Bird',
				'username': '@twitter',
				'color': 'blue'
			},
			{
				'id': 4,
				'firstname': 'Foobar',
				'lastname': 'Ipsum',
				'username': '@foobaripsum',
				'color': 'green'
			},
			{
				'id': 5,
				'firstname': 'Darth',
				'lastname': 'Vader',
				'username': '@imyourfatherluke',
				'color': 'red'
			},
			{
				'id': 6,
				'firstname': 'Yoda',
				'lastname': 'the Green',
				'username': '@yodathegreen',
				'color': 'green'
			}
	];  
	
	

	$scope.table1Params = new NgTableParams({
		'count': 10
	}, {
		'dataset': data,
		'counts': null
	});

	$scope.table2Params = new NgTableParams({
		'count': 5
	}, {
		'dataset': data,
		'counts': null
	});

	$scope.table3Params = new NgTableParams({
		'count': 10
	}, {
		'dataset': data,
		'counts': null
	});

	$scope.table4Params = new NgTableParams({
		'count': 10,
		'group': 'color'
	}, {
		'dataset': data,
		'counts': null
	});

	$scope.table5Params = new NgTableParams({
		'count': 10
	}, {
		'dataset': data,
		'counts': null
	});

	$scope.table6Params = new NgTableParams({
		'count': 10
	}, {
		'dataset': data,
		'counts': null
	});
	
	$scope.table7Params = new NgTableParams({
		'count': 10
	}, {
		'dataset': data,
		'counts': null
	});
});
