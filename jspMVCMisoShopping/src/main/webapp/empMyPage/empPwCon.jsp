<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type = "text/javascript" >
	$(function () {
		$("#frm").submit(function () {
			if($("#frm").val() != $("#newPwCon").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				 $("#newPw").val();
				 $("#newPwCon").val();
				 $("#newPw").focus();
				 
			}
		})
	})
</script>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/' />">홈</a></li>
		<li><a href="empMyPage.my">내정보 보기</a></li>
		<li><a href="empUpdate.my">내정보 수정</a></li>
		<li><a href = "userPwModify.my">비밀번호변경</a></li>
		<li><a href = "empDrop.my">회원탈퇴</a></li>
	</ul>
<form action="empPwModify.my" method = "post">
비밀번호 확인 : <input type = "password" name = "empPw" required = "required" />
			<div>${errPw }</div>
			<input type = "submit" value = "확인" />
</form>
</body>
</html>