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
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/feedback.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" ng-app="feedback-app" ng-controller="myCtrl">
	<form name="myForm">
		<div class="operationHeader">
			Leave Feedback
		</div>
		<div class="feedbackSection">Name*:<input class="feedbackInput" type="text" ng-model="name" maxlength="20" required/>
		</div>
		<div class="feedbackSection">Email*:<input class="feedbackInput" type="email" ng-model="email" maxlength="40" required/>
		</div>
		<div class="feedbackSection">Feedback*:
		</div>
		<textarea name="feedback_textarea" class="textarea textareaFeedback" rows="15" cols="25" ng-model="feedback" ng-trim="false" type="text" maxlength="350" required></textarea>
		<div>
		<input class="buttonSubmit" type="button" value="Submit" ng-disabled="buttonDisabled" ng-click="submitFeedback()"/>
		</div>
		<div class="result">{{results}}</div>
	</form>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>