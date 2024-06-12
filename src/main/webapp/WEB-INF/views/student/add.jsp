<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보 입력</h1>
	
	<form action="/student/add" method="post">
		<div>
			<label for="num">번호</label>
			<!-- setter의 이름과 동일하게 맞춰준다. -->
			
			<input type="text" id = "num" name= "num" value ="">
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" id = "name" name = "name">
		</div>
		
		<div>
			<label for="avg">평균</label>
			<input type="text" id = "avg" name= "avg">
		</div>
		
		<div>
			<label></label>
			<input type="radio" name = "ch" value = "girl">
			<input type="radio" name = "ch" value = "boy">
		</div>
		
		
		<div>
			<select name="mobile">
				<option value = "kt">KT</option>
				<option value = "sk">SKT</option>
				<option value = "LG">LG</option>
			</select>
		
		</div>
		
		<div>
			<input type="checkbox" name= "check" value = "v1">
			<input type="checkbox" name= "check" value = "v2">
			<input type="checkbox" name= "check" value = "v3">
		</div>
		
		<div>
			<input type= "submit" value="등록">
			<button type = "submit">작성</button>	
		</div>
		
		<div>
			<textarea rows="" cols="" name="contents"></textarea>
		</div>
		
	
	</form>
</body>
</html>