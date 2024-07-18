<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>JSTL 입력</title>
</head>
<body>
	<c:set var="to" value="10"/>
	<c:set var="arr" value="10,20,30,40,50,60,70"/>
	<c:forEach var="i" begin="1" end="${to}">
		${i}
	</c:forEach>
	<c:if test="${not empty arr}">
		<c:forEach var="elem" items="${arr}" varStatus="status">
			${status.count}.arr[${status.index}]=${elem}<br> 
		</c:forEach>
	</c:if>
	<c:if test="${param.msg != null}">
		msg=${param.msg}
		msg=<c:out value="${msg}"/>;
	</c:if>
	<c:set var="age" value="${param.age}"/>
	<br>
	<c:choose>
		<c:when test="${age >= 19}">성인입니다.</c:when>
		<c:when test="${0 <= age && age <19}">성인이 아닙니다.</c:when>
		<c:otherwise>값이 유효하지 않습니다.</c:otherwise>
	</c:choose>
</body>
</html>
