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
	<form name="myForm">
		<div class="operationHeader">
			Basic Operations
		</div>
		<div class="input">Input Numbers (line, space or comma separated):
		<div>
		<textarea name="number_list_textarea" class="textarea" rows="25" cols="45" ng-model="number_list" ng-trim="false"  type="text" required></textarea>
		</div>
		</div>
		<div>
		<input class="buttonSubmit" type="button" value="Calculate" ng-click="loadResults()"/>
		</div>
		<div class="result">{{results}}</div>
	</form>
	</div>
	<script>
	var app = angular.module('basic-operations-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.loadResults= function() {
			if($scope.myForm.$valid == true) {
				$http.get("/OnlineMathTool/basic/results?numberList="+$scope.number_list.replace(/\r?\n?\s/g, ',')).then(function(response) {
					if(response.data.success == true) {
						$scope.results = "Result: " + response.data.resultData;
					}   
					else {
						$scope.results = "Error: Invalid input!"
					}
					}).error(function(){
			               //handle error
		            })
			}
			else {
				$scope.results = "Error: Input is required!"
			}
		};
	});
</script>
</body>
</html>