<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>Weather Detail</h1>
	
	
	
	<h3>${requestScope.dto.city}</h3>
	<h3>${requestScope.dto.gion}</h3>
	<h3>${requestScope.dto.status}</h3>
	<h3>${requestScope.dto.humidity}</h3>
	
	<form id = "frm" action="./delete" method="post">
		<input id = "num" type="hidden" name="num" value="${requestScope.dto.num}" >
	</form>
	

	
	
	<button type = "button" id="btn1">DELETE</button>
	<button type = "button" id="up">UPDATE</button>
	
	<script>
		const frm = document.getElementById("frm");
		const btn1 = document.getElementById("btn1");
		const up = document.getElementById("up");
		
		btn1.addEventListener("click", function(){
			frm.submit();
			
		})
		
		up.addEventListener("click", function(){
			frm.setAttribute("method","get");
			frm.method = "get";
			frm.setAttribute("action","./update");
			
			frm.submit();
			//method 형식 get으로 바꾸고 싶음
			//frm의 속성을 get 하거나 set 하거나 또는 frm의 method 속성에 값을 넣거나 가져옴
		})
	</script>
	

</body>
</html>