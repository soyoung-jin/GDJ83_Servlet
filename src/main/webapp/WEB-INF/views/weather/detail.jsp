<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오늘 날씨 정보</h1>
	
		<h3>${requestScope.weather.city}</h3>
		<h3>${requestScope.weather.gion}</h3>
		<h3>${requestScope.weather.status}</h3>
		<h3>${requestScope.weather.humidity}</h3>

</body>
</html>