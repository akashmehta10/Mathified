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
<script src="resources/js/delimit.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" ng-app="delimit-app" ng-controller="myCtrl">
	<form name="myForm">
		<div class="operationHeader">
			Delimit/Tokenize List
		</div>
		<div class="input">Input (line, space or comma separated)*:
		<div class="container">
		<div>
		<textarea name="list_textarea" class="textareaInput textarea" rows="25" cols="45" ng-model="input_list" ng-trim="false"  type="text" required></textarea>
		<div class="centerInputOutputDiv">
		<div>
					  <input class="delimitterInput" type="text" ng-model="delimitter_input" required maxlength="2"/>
		</div>
		<div>
					  <input class="buttonSubmit" type="button" value="Delmit" ng-click="loadResults()"/>
		</div>
<div class="result">{{results}}</div>
		</div>
	    <textarea name="output_list_textarea" class="textareaOutput textarea" rows="25" cols="45" ng-model="output_list" ng-trim="false"  type="text" disabled></textarea>
		</div>
		</div>
		</div>
		<div>
		</div>
		
	</form>
	</div>
</body>
</html>