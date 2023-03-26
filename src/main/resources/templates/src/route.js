var productApp = angular.module("productApp", ["ngRoute"]);

productApp.config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider
        .otherwise({
            templateUrl: "./page/home.html",
        })
        .when("/home", {
            templateUrl: "./page/home.html"
        })
        .when("/user/add", {
            templateUrl: "./page/add.html"
        })
        .when("/user/edit", {
            templateUrl: "./page/update.html"
        })
        .when("/user/edit/:id", {
            templateUrl: "./page/update.html"
        })
        .when("/user/detail/:id", {
            templateUrl: "./page/detail.html"
        })
})
productApp.controller("productCtrl", productCtrl)