<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String temp = request.getParameter("cnt");	// temp에 값을 받음

int cnt= 100;							// 기본값은 100
if(temp != null && !temp.equals(""))	// temp가 null이 아니고 tmep값이 ("")이 아니면 (빈문자열이오면 인트형으로 못바꾸기 때문) cnt를 temp로 바꿈
	cnt = Integer.parseInt(temp);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% for(int i=0; i<cnt; i++) {%>
	안녕 servlet!!<br/><%}%>
	
</body>
</html>