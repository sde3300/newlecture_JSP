<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
pageContext.setAttribute("aa", "hello");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result")%> 입니다.
	${result} <br >
	
	${names[0]} <br >
	${notice.title} <br >
	
	${aa}
	
	${result} <!-- hello 출력 -->
	${requestScope.result} <!-- 짝수 출력 -->
	
</body>
</html>