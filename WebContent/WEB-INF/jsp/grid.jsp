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
<link rel="stylesheet" media="screen"
	href="resources/css/handsontable.full.min.css">
<link rel="apple-touch-icon" sizes="180x180" href="resources/images/favicons_mathified/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicons_mathified/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicons_mathified/favicon-16x16.png">
<link rel="manifest" href="resources/images/favicons_mathified/manifest.json">
<meta name="theme-color" content="#5f5f5f">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/handsontable.full.min.js"></script>
<script src="resources/js/ngHandsontable.js"></script>
<script src="resources/js/dataFactory.js"></script>
<script src="resources/js/grid.js"></script>
<title>Group By Data, Tabular Data, Excel Data, Grid Data - Mathified</title>
<meta name="description" content="Perform Group by on tabular data, excel data, grid data. ">
<meta name="keywords" content="Group By,Tabular Data,Excel Data,Grid Data,Group By Tabular Data,Group By Excel Data,Group By Grid Data,Process Tabular Data,Process Excel Data,Process Grid Data,Group By Column,Group By Column Tabular Data,Group By Column Excel Data,Group By Column Grid Data,Group By Count,Group By Count Tabular Data,Group By Count Excel Data,Group By Count Grid Data,Group By Sum,Group By Sum Tabular Data,Group By Sum Excel Data,Group By Sum Grid Data">
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-101594780-1', 'auto');
  ga('send', 'pageview');
</script>
</head>
<body data-ng-app="app">
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" data-ng-controller="MainCtrl as ctrl">
		<form name="myForm">
			<div class="operationHeader">Process Grid Data</div>
			<div class="input">
				Input Grid Data*:
				<div></div>

				<hot-table settings="ctrl.settings" row-headers="ctrl.rowHeaders"
					min-spare-rows="ctrl.minSpareRows" datarows="ctrl.db.items"
					on-after-selection="ctrl.onAfterSelection" height="300" width="900">
				<hot-column data="column1" title="'Column1'"></hot-column> <hot-column
					data="column2" title="'Column2'"></hot-column> <hot-column
					data="column3" title="'Column3'"></hot-column> <hot-column
					data="column4" title="'Column4'"></hot-column> <hot-column
					data="column5" title="'Column5'"></hot-column> <hot-column
					data="column6" title="'Column6'"></hot-column> <hot-column
					data="column7" title="'Column7'"></hot-column> <hot-column
					data="column8" title="'Column8'"></hot-column> <hot-column
					data="column9" title="'Column9'"></hot-column> <hot-column
					data="column10" title="'Column10'"></hot-column> </hot-table>
			</div>
			<div class="groupByColumn floatLeft marginRight">
				Grouping on: <span class="groupByColumnValue">Column{{
					selectedColumn + 1}}</span>
			</div>
			<div class="groupByColumn">
				Summing on Column:
				<select ng-model="groupBySumColumn">
				<option value="N/A">N/A</option>
				<option value="0">1</option>
				<option value="1">2</option>
				<option value="2">3</option>
				<option value="3">4</option>
				<option value="4">5</option>
				<option value="5">6</option>
				<option value="6">7</option>
				<option value="7">8</option>
				<option value="8">9</option>
				<option value="9">10</option>
				</select>
			</div>
			<div class='btnGroupBy'>
				<input class="buttonSubmit" type="button" value="Group By"
					ng-click="ctrl.loadResults()" />
			</div>
		</form>
		<div class="groupByResultText" ng-show="groupByResultTextShow">Result: {{ inputErrorFromServer }}</div>
		<div class="groupByResult" ng-show="groupByResultShow">
			<div class="tableGroupResult">
				<table class="groupByResultTable">
					<tr>
						<th>Column{{ selectedColumnFromServer }}</th>
						<th>{{ groupByOperationFromServer }} </th>
					</tr>
					<tr ng-repeat="result in groupByResult">
						<td>{{ result.key }}</td>
						<td>{{ result.value }}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>