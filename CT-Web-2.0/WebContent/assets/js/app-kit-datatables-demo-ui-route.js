angular.module('ct').config(function($stateProvider, $urlRouterProvider) {

	
	$stateProvider
    .state('beatles', {
        abstract: true,
        url: '/beatles',
        templateUrl: 'beattles.html'
    })
    .state('beatles.list', {
        url: '/list',
        // loaded into ui-view of parent's template
        templateUrl: 'list.html',
        controller: 'listController'
    })
    .state('beatles.detail', {
        url: '/:id',
        // loaded into ui-view of parent's template
        templateUrl: 'detail.html',
        controller: 'listController'
    })

});


