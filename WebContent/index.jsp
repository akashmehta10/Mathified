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
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body">
	<div class="operationHeader">What can you do with <i>MATHIFIED?</i></div>
	<div class="operation">
	<a href="basic">1. Get Statistics on List of Numbers</a> - Count/Sum/Average/Variance/Standard Deviation on List of Numbers
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>3,2,5
	<br/><br/>
	<span class="ioexample">Output: </span>Count =3, Sum = 10, Average = 3.33, Standard Deviation = 1.247, Variance = 1.55
	</div>
	</div>
	</div>
	<hr>
	<div class="operation">
	<a href=":blank">2. Operations on Tabular Data</a> - Group by on column, Group by on column and then sum/count other columns
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>Group by Occupation and count Names
	<table>
	<tr>
	<th>#</th>
	<th>Name</th>
	<th>Occupation</th>
	</tr>
	<tr>
	<td>1</td>
	<td>John</td>
	<td>Engineer</td>
	</tr>
	<tr>
	<td>2</td>
	<td>Sam</td>
	<td>Doctor</td>
	</tr>
	<tr>
	<td>3</td>
	<td>Mike</td>
	<td>Engineer</td>
	</tr>
	</table>
	<br/><br/>
	<span class="ioexample">Output:</span>
	<table>
	<tr>
	<th>Occupation</th>
	<th>Occupation Count</th>
	</tr>
	<tr>
	<td>Engineer</td>
	<td>2</td>
	</tr>
	<tr>
	<td>Doctor</td>
	<td>1</td>
	</tr>
	</table>
	</div>
	</div>
	</div>
	<hr>
	<div class="operation">
	<a href="compare">3. Compare 2 Lists</a> - Find Common/Uncommon Elements in 2 Lists
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>List1: 3,2,5 and List2: 3,1,5
	<br/><br/>
	<span class="ioexample">Output: </span>List1 AND List2 = [3,5], Only in List1 = [2], Only in List2 = [1], List1 OR List2 = [3,2,5,1]
	</div>
	</div>
	</div>
	<hr>
	<div class="operation">
	<a href="delimit">4. Delimit/Tokenize List</a> - Choose your own Tokenizer
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>4 6 5
	<br/><br/>
	<span class="ioexample">Output: </span>[4,6,5] OR [4|6|5] OR [4:6:5] OR Anything You Want!
	</div>
	</div>
	</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>