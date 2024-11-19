<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userForm.jsp</title>
<script src = "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script src = "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type = "text/javascript" src = "js/daumAddressScript.js"></script>
<script type = "text/javascript">
$(function() {
	$("#frm").submit(function() {
		if($("#memberPw").val() != $("#memberPwCon").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다.");
			$("#memberPw").val("");
			$("#memberPwCon").val("");
			$("#memberPw").focus;
			return false;
		}
	});
	$("#userId").bind("click", function() {
		$("#userId").val("");
		window.open("idCheck.nhn", "아이디 검색", "width=400", "height = 200", "left =130", "top = 150");
	});
});
</script>
</head>
<body>
회원가입 페이지입니다.<br />
<form action= "userRegist.nhn" id="frm" method="post">
	<table border=1 align = "center">
		<tr><th>*아이디</th>
			<td><input type="text" name="userId" id = "userId"/>아이디 중복확인</td></tr>
		<tr><th>*비밀번호</th>
			<td><input type="password" name="userPw" id = "memberPw"/></td></tr>
		<tr><th>*비밀번호확인</th>
			<td><input type="password" name="userPwCon" id = "memberPwCon"/></td></tr>
		<tr><th>회원 기본정보</th></tr>
		<tr><th>*회원 이름</th>
			<td><input type="text" name="userName"/></td></tr>
		<tr><th>*회원 연락처1</th>
			<td><input type="tel" name="userPhone1"/></td></tr>
		<tr><th>회원 연락처2</th>
			<td><input type="tel" name="userPhone2"/></td></tr>
		<tr><th>*회원 주소</th>
			<td><input type="text" name="userAddr" id = "sample4_roadAddress" readonly /><button type = "button" onclick = "execDaumPostcode();">우편번호확인</button></td></tr>
		<tr><th>회원 우편번호</th>
			<td><input type="text" name="userPost" id = "sample4_postcode" readonly /></td></tr>	
		<tr><th>*회원 이메일</th>
			<td><input type="email" name="userEmail"/></td></tr>
		<tr><th>*회원생년월일</th>
			<td><input type="date" name="userBirth"/></td></tr>	
		<tr><th>*성별</th>
			<td><input type = "radio" name = "gender" value = "M" />남자
		    <input type = "radio" name = "gender" value = "F" />여자</td><br />
		<tr><th colspan="2">
			<input type="submit" value="회원 가입">
			<input type="reset" value="회원 가입 취소">
			</th></tr>	
	</table>
</form>
</body>
</html>