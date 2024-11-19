<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findIdOk.jsp</title>
</head>
<body>
아이디를 찾았습니다!<br />
크기 : ${fn:length(dto.memberId) } <br />
substring : ${fn:substring(dto.memberId, 0, 2)}<br />
나머지 글자 크기는 : ${fn:length(dto.memberId) - 1}<br />	
아이디 : ${dto.memberId } <br />

<c:if test="${!empty dto.memberId }">
당신의 아이디는 ${fn:substring(dto.memberId, 0, 1)}
<c:forEach begin = "1" end = "${fn:length(dto.memberId) - 1}" step = "1">
.
</c:forEach>
</c:if>

<c:if test="${empty dto.memberId }">
	입력하신 정보가 정확하지 않습니다.
</c:if>

</body>
</html>