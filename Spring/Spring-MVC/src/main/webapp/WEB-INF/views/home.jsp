<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring MVC@
</h1>

	<ul>	
		<li><a href="<c:url value="/hello"/>">/hello</a></li>
		<li><a href="bye">/bye</a></li> <!-- 현재 위치가 절대 경로 이므로 경로 설정을 따로 할 필요 x -->
		
		<!-- mvc/login/login -->
		<li><a href="<c:url value="/login/login"/>">/login/login(Get)</a></li>
	
	</ul>
	
	
	
</body>
</html>
