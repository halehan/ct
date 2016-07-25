angular.module('appKitCarouselsDemo', [
	'appKitCommon',
	'appKit',
	'owlCarousel',
	'angular-flexslider'
]).controller('AppKitCarouselsDemo', function($scope) {
	'use strict';

	$scope.carouselOne = [
		{
			"image": "assets/images/carousels/slide-1.jpg",
			"title": "Carousel Caption One"
		}, {
			"image": "assets/images/carousels/slide-2.jpg",
			"title": "Carousel Caption Two"
		}, {
			"image": "assets/images/carousels/slide-3.jpg",
			"title": "Carousel Caption Three"
		}
	];

	$scope.carouselTwo = [
		'assets/images/carousels/slide-4.jpg',
		'assets/images/carousels/slide-5.jpg',
		'assets/images/carousels/slide-6.jpg'
	];

	$scope.carouselThree = [
		'assets/images/carousels/slide-sm-1.jpg',
		'assets/images/carousels/slide-sm-2.jpg',
		'assets/images/carousels/slide-sm-3.jpg',
		'assets/images/carousels/slide-sm-4.jpg',
		'assets/images/carousels/slide-sm-5.jpg',
		'assets/images/carousels/slide-sm-6.jpg',
		'assets/images/carousels/slide-sm-7.jpg',
		'assets/images/carousels/slide-sm-8.jpg'
	];
});
