<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/header.css" />
<link rel="stylesheet" type="text/css" href="resources/css/body.css" />
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Ubuntu">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body">
	<div class="operationHeader">What can you do?</div>
	<div class="operation">
	<a href=":blank">Basic Operations</a> - Sum/Average/Multiply/Sort/Count on List of Numbers
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>[3,2,5]
	<br/><br/>
	<span class="ioexample">Output: </span>Sum = 10, Multiplication = 30, Sort = [2,3,5], Count = 3
	</div>
	</div>
	</div>
	<hr>
	<div class="operation">
	<a href=":blank">Table Data</a> - Group by on Column(s)
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input:</span>
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
	<a href=":blank">Compare 2 Lists</a> - Find Common/Uncommon Elements in 2 Lists
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>List1: [3,2,5] List2: [3,1,5]
	<br/><br/>
	<span class="ioexample">Output: </span>List1 AND List2 = [3,5], Only in List1 = [2], Only in List2 = [1], List1 OR List2 = [3,2,5,1]
	</div>
	</div>
	</div>
	<hr>
	<div class="operation">
	<a href=":blank">Delimit/Tokenize List</a> - Choose your own Tokenizer
	<div class="example">
	<span class="ioexample">Example:</span>
	<div class="ioDiv">
	<span class="ioexample">Input: </span>[4 6 5]
	<br/><br/>
	<span class="ioexample">Output: </span>[4,6,5] OR [4|6|5] OR [4:6:5] OR Anything You Want!
	</div>
	</div>
	</div>
	</div>
</body>
</html>