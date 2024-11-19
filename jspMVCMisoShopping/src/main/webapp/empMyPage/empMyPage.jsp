<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeMyPage.jsp</title>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/' />">홈</a></li>
		<li><a href="empMyPage.my">내정보 보기</a></li>
		<li><a href="empUpdate.my">내정보 수정</a></li>
		<li><a href = "empUserPwModify.my">비밀번호변경</a></li>
		<li><a href = "empDrop.my">회원탈퇴</a></li>
	</ul>
이름 : ${dto.empName }<br />
아이디 : ${dto.empId }<br />
주소 : ${dto.empAddr }<br />
상세주소 : ${dto.empAddrDetail }<br />
우편번호 : ${dto.empPost }<br />
연락처 : ${dto.empPhone }<br />
주민등록번호 : ${dto.empJumin }<br />
입사일 : ${dto.empHireDate }<br />
이메일 : ${dto.empEmail }<br />
</body>
</html>