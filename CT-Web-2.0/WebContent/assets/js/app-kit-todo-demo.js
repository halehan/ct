angular.module('appKitTodoDemo',[
	'appKitCommon',
	'appKit',
	'jqueryTodo'
]).controller('AppKitTodoDemo', function($scope) {
	'use strict';
	$scope.items = [{
            title: "task 1",
            done:   true
        }, {
            title: "task 2",
            done:   true
        }, {
            title: "task 3",
            done:   true
        }, {
            title: "task 4"
        }, {
            title: "task 5"
        }, {
            title: "task 6"
        }
    ];
});
