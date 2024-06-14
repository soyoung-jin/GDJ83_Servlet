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
	<h1>날씨 정보 리스트</h1>
	
	<table  class="tbl">
		<thead>
				<th>NUM</th>
				<th>CITY</th>
				<th>GION</th>
				<th>STATUS</th>
				<th>HUMIDITY</th>
				
			
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="wdto">
				<tr>
					<td>${pageScope.wdto.num}</td>
					<td><a href="./detail?num=${pageScope.wdto.num}">${pageScope.wdto.city}</a></td>
					<td>${pageScope.wdto.gion}</td>
					<td>${pageScope.wdto.status}</td>
					<td>${pageScope.wdto.humidity}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	
	
	</table>
	
	
	<div>
		<a href="./add">날씨 등록</a>
	</div>

	
</body>
</html>