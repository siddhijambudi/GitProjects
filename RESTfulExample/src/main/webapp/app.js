(function() {
	var app = angular.module('store', []);
	
	app.controller('StoreController', function() {
		this.products = gems;
	});
	
	var gems = [

	{
		name : 'siddhi',
		price : 400,
		desc : 'abc',
		canPurchase : true,
		soldOut : false,
		images : [ {
			full : 'java1.jpg',
			thumb : 'logo.jpg'
		}, {
			full : 'nice1.jpg',
			thumb : 'singerNeedles.jpg'
		} ]
	},

	{
		name : 'nirali',
		price : 600,
		desc : 'def',
		canPurchase : true,
		soldOut : false
	}

	];
})();

