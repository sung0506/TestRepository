<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
		<li><a href="<c:url value='/' />">홈</a></li>
		<li><a href="empMyPage.my">내정보 보기</a></li>
		<li><a href="empUpdate.my">내정보 수정</a></li>
		<li><a href = "userPwModify.my">비밀번호변경</a></li>
		<li><a href = "empDrop.my">회원탈퇴</a></li>
	</ul>
<form action="empPwPro.my" method = "post" id = "frm">
현재비밀번호 : <input type = "password" name = "oldPw" id = "oldPw" required = "required" /><br />
새 비밀번호 : <input type = "password" name = "newPw" id = "newPw" required = "required" /><br />
새 비밀번호 확인 : <input type = "password" name = "newPwCon" id = "newPwCon" required = "required" /><br />
<input type = "submit" value = "비밀번호 변경" />
</form>
</body>
</html>