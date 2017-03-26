<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/header.css" />
<link rel="stylesheet" type="text/css" href="resources/css/body.css" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Ubuntu">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/compare.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" ng-app="compare-app" ng-controller="myCtrl">
		<form name="myForm">
			<div class="operationHeader">Compare 2 Lists</div>
			<div class="input">
				Input (line, space or comma separated)*:
				<div class="container">
					<div>
						<textarea name="list1_textarea" class="textareaInput textarea"
							rows="25" cols="45" ng-model="input_list1" ng-trim="false"
							type="text" required></textarea>
						<textarea name="list2_textarea" class="textareaOutput textarea"
							rows="25" cols="45" ng-model="input_list2" ng-trim="false"
							type="text" required></textarea>
					</div>
				</div>
					
			</div>
			<div>
					<input class="buttonSubmit" type="button" value="Compare" ng-click="loadResults()"/>
			</div>
			
		<div class="result">{{results}}</div>
		<div class="result">{{commonElements}}</div>
		</form>
	</div>
</body>
</html>