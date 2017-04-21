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
<link rel="stylesheet" media="screen" href="resources/css/handsontable.full.min.css">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/handsontable.full.min.js"></script>
<script src="resources/js/ngHandsontable.js"></script>
<script src="resources/js/dataFactory.js"></script>
<script src="resources/js/grid.js"></script>
</head>
<body data-ng-app="app">
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body" data-ng-controller="MainCtrl as ctrl">
	<form name="myForm">
		<div class="operationHeader">
			Process Grid Data
		</div>
		<div class="input">Input Grid Data*:
		<div>
		</div>

<hot-table
    settings="ctrl.settings"
    row-headers="ctrl.rowHeaders"
    min-spare-rows="ctrl.minSpareRows"
    datarows="ctrl.db.items"
    height="300"
    width="700">
      <hot-column data="column1" title="'Column1'"></hot-column>
      <hot-column data="column2" title="'Column2'"></hot-column>
      <hot-column data="column3" title="'Column3'"></hot-column>
      <hot-column data="column4" title="'Column4'"></hot-column>
      <hot-column data="column5" title="'Column5'"></hot-column>
      <hot-column data="column6" title="'Column6'"></hot-column>
      <hot-column data="column7" title="'Column7'"></hot-column>
      <hot-column data="column8" title="'Column8'"></hot-column>
      <hot-column data="column9" title="'Column9'"></hot-column>
      <hot-column data="column10" title="'Column10'"></hot-column>
  </hot-table>
		</div>
		<div>
		<input class="buttonSubmit" type="button" value="Calculate" ng-click="ctrl.loadResults()"/>
		</div>
	</form>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>