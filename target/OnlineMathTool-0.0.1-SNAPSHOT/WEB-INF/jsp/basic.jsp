<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/header.css" />
<link rel="stylesheet" type="text/css" href="resources/css/body.css" />
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Ubuntu">
<script src="resources/js/angular.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" ng-app="basic-operations-app" ng-controller="myCtrl">
		<div class="operationHeader">
			Basic Operations
		</div>
		<div class="input">Input Numbers (line, space or comma separated):
		<div>
		<textarea class="textarea" rows="25" cols="45" ng-model="number_list"></textarea>
		</div>
		</div>
		<div>
		<input class="buttonSubmit" type="button" value="Calculate" ng-click="loadResults()"/>
		</div>
		<h1>{{number_list}}</h1>
		<h1>{{myWelcome}}</h1>
	</div>
	<script>
	var app = angular.module('basic-operations-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.loadResults= function() {
			$http.get("/OnlineMathTool/basicresults").then(function(response) {
				   $scope.myWelcome = response.data;
				}).error(function(){
		               //handle error
	            })
		};
	});
</script>
</body>
</html>