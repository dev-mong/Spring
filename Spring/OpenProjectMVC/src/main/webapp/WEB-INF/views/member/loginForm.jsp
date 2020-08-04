<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">로그인</h1>
		<hr>

		<form  method="post">
			<table>
				<tr>
					<td>아이디 (이메일)</td>
					<td><input type="text" name="uid" value="${cookie.uid.value}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"></td>
					<td><input type="checkbox" name="check" value="${cookie.uid !=null ? 'checked' : '' }" >아이디 기억하기</td>
				</tr>
			</table>

			
		</form>

	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>