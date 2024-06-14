<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/NewFile.css" rel="stylesheet">
</head>
<body>
	<h1>날씨 정보 입력</h1>
	
	<form action="./add" method="post">
		<div>
			<label>도시명</label>
			<input type="text" name= "city">
		</div>
	
		<div>
			<label>기온</label>
			<input type="text" name= "gion">
		</div>
		<div>
			<label>습도</label>
			<input type="text" name= "humidity">
		</div>
		<div>
			<label>상태</label>
			<input type="text" name= "status">
		</div>
		
		<div>
			<label>날짜</label>
			<input type="date" name= "da">
		</div>
		
		<input type="submit" value="등록">
		<button type="submit">등록</button>
	
	
	
	</form>
</body>
</html>