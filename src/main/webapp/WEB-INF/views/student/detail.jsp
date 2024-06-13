<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>학생 한명 정보</h1>
	 
	<!-- EL (Expression language)이게 요즘식 표현임 데이터 출력 전용 -->
	<!-- $(스코프영역명.속성명} -->
	<!-- getter의 이름을 써서 꺼내온다. getter의 이름 : get을 빼고 소문자로 바꾼 것 -->
	
	
	<table border="1" class="tbl">
		<thead>
			<th>NUM</th>
			<th>NAME</th>
			<th>KOR</th>
			<th>ENG</th>
			<th>MATH</th>
			<th>TOTAL</th>
			<th>AVG</th>

		</thead>
		<tbody>
			<c:forEach items="${reqeustScope.student}" var="student">
			<tr>
				<td>${requestScope.student.num}</td>
				<td>${requestScope.student.name}</td>
				<td>${requestScope.student.kor}</td>
				<td>${requestScope.student.eng}</td>
				<td>${requestScope.student.math}</td>
				<td>${requestScope.student.total}</td>
				<td>${requestScope.student.avg}</td>
				
			</tr>
			</c:forEach>
		</tbody>
	
	
	</table>
	
</body>
</html>