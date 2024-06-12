<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 한명 정보</h1>
	 
	<!-- EL (Expression language)이게 요즘식 표현임 데이터 출력 전용 -->
	<!-- $(스코프영역명.속성명} -->
	<!-- getter의 이름을 써서 꺼내온다. getter의 이름 : get을 빼고 소문자로 바꾼 것 -->
	<h3>${requestScope.student.name}</h3>
	<h3>${requestScope.student.num}</h3>
	<h3>${requestScope.student.avg}</h3>
</body>
</html>