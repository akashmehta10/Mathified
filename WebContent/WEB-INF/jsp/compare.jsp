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
<link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
<link rel="apple-touch-icon" sizes="180x180" href="resources/images/favicons_mathified/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicons_mathified/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicons_mathified/favicon-16x16.png">
<link rel="manifest" href="resources/images/favicons_mathified/manifest.json">
<meta name="theme-color" content="#5f5f5f">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/compare.js"></script>
<title>Compare Lists - Find Common and Uncommon Data - Mathified</title>
<meta name="description" content="Compare lists or text to find common data, uncommon data">
<meta name="keywords" content="Compare,Compare Lists,Compare Data,Compare Texts,Common Data,Uncommon Data,Missing Data,Common Elements,Uncommon Elements,Common Text,Uncommon Text">
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-101594780-1', 'auto');
  ga('send', 'pageview');
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" ng-app="compare-app" ng-controller="myCtrl">
		<form name="myForm">
			<div class="operationHeader">Compare 2 Lists</div>
			<div class="input">
				<div class="textareaInput">Input 1 (line, space or comma
					separated)*:</div>
				<div class="textareaOutput">Input 2 (line, space or comma
					separated)*:</div>
				<div class="container">
					<div>
						<textarea name="list1_textarea" class="textarea" rows="25"
							cols="45" ng-model="input_list1" ng-trim="false" type="text"
							required></textarea>
						<textarea name="list2_textarea" class="textareaOutput textarea"
							rows="25" cols="45" ng-model="input_list2" ng-trim="false"
							type="text" required></textarea>
					</div>
				</div>
			</div>
			<div>
				<input class="buttonSubmit" type="button" value="Compare"
					ng-click="loadResults()" />
			</div>
			<div class="result">{{results}}</div>
			<div class="container">
				<div>
					<textarea class="textarea" rows="25" cols="45"
						ng-model="commonElements" ng-trim="false" type="text"
						ng-show="commonElementsShow" ng-readonly="true"></textarea>
					<textarea class="textareaOutput textarea" rows="25" cols="45"
						ng-model="list1Only" ng-trim="false" type="text"
						ng-show="list1OnlyShow" ng-readonly="true"></textarea>
				</div>
			</div>
			<div class="container">
				<div>
					<textarea class="textarea" rows="25" cols="45" ng-model="list2Only"
						ng-trim="false" type="text" ng-show="list2OnlyShow"
						ng-readonly="true"></textarea>
					<textarea class="textareaOutput textarea" rows="25" cols="45"
						ng-model="list1OrList2" ng-trim="false" type="text"
						ng-show="list1OrList2Show" ng-readonly="true"></textarea>
				</div>
			</div>
	</div>
	</form>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>