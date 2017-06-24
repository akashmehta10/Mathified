<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/header.css" />
<link rel="stylesheet" type="text/css" href="resources/css/body.css" />
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Ubuntu">
<link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
<link rel="apple-touch-icon" sizes="180x180" href="resources/images/favicons_mathified/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicons_mathified/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicons_mathified/favicon-16x16.png">
<link rel="manifest" href="resources/images/favicons_mathified/manifest.json">
<meta name="theme-color" content="#5f5f5f">
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
		<textarea name="list_textarea" class="textarea" rows="25" cols="45" ng-model="input_list" ng-trim="false"  type="text" required></textarea>
		<div class="centerInputOutputDiv">
		<div>
		<input list="hosting-plan" id="inputDataList" maxlength="8" ng-model="delimitter_input" required>
 
<datalist id="hosting-plan">
    <option value=","/>
    <option value="|"/>
    <option value=";"/>
    <option value=":"/>
    <option value="Space"/>
    <option value="New Line"/>
</datalist>
		</div>
		<div>
					  <input class="buttonSubmit buttonWidth" type="button" value="Delmit" ng-click="loadResults()"/>
		</div>
<div class="result">{{results}}</div>
		</div>
	    <textarea name="output_list_textarea" class="textareaOutput textarea" rows="25" cols="45" ng-model="output_list" ng-trim="false"  type="text" ng-readonly="true"></textarea>
		</div>
		</div>
		</div>
		<div>
		</div>
	</form>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>