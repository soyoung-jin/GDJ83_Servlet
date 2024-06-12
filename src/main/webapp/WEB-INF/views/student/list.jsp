<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/NewFile.css" rel="stylesheet">
</head>
<body>
	<h1>학생 목록</h1>
	<div>
		<img alt="" src="/resources/images/3.jpg">
	</div>
	
	
	<table class="tbl" border = "1">
		<thead>
			<tr>
				<th>NUM</th>
				<th>SUM</th>
				<th>AVG</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${requestScope.list}" var ="student">
				<tr>
					<td>번호 : ${pageScope.student.num} </td>
					<td>이름 : ${pageScope.student.name}</td>
					<td>평균 : ${pageScope.student.avg}</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>