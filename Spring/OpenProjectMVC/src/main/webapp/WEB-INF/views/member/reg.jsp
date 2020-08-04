<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">


</head>

<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<h3>
		
		${member}

		<c:if test="${memberCnt gt 0}">
			<div>
				회원가입 완료
			</div>
		</c:if>
		
		<c:if test="${not (memberCnt gt 0)}">
			회원가입 실패
		</c:if>
		
		
		
		</h3>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>


</body>
</html>




