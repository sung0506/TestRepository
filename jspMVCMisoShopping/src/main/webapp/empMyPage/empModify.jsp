<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empModify.jsp</title>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/' />">홈</a></li>
		<li><a href="empMyPage.my">내정보 보기</a></li>
		<li><a href="empUpdate.my">내정보 수정</a></li>
		<li><a href = "empPwModify.my">비밀번호변경</a></li>
		<li><a href = "empDrop.my">회원탈퇴</a></li>
	</ul>
<form action="empModify.my" method="post" name="frm">
이름 : <input type="text" name="empName" value="${dto.empName }"/><br />
*아이디 : <input type="text" name="empId" value="${dto.empId }" readonly="readonly"/><br />
현재 비밀번호 : <input type="password" name="empPw" />
			<span>${errPw}</span><br />
주소 : <input type="text" name="empAddr" value="${dto.empAddr }" /><br />
상세주소 : <input type="text" name="empAddrDetail" value="${dto.empAddrDetail }"/><br />
우편번호 : <input type="text" name="empPost" value="${dto.empPost }"/><br />
연락처 : <input type="tel" name="empPhone" value="${dto.empPhone }"/><br />
*입사일 : <input type="date" name="empHireDate" value="${dto.empHireDate }"  readonly="readonly"/><br />
주민등록번호 : <input type="text" name="empJumin" value="${dto.empJumin }"/><br />
이메일 : <input type="email" name="empEmail" value="${dto.empEmail }"/><br />
<input type="submit" value="회원수정 완료" /> 
</form>
</body>
</html>