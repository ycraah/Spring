<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입 입력값</title>
</head>
<body>
	<p>id = ${param.id}</p>
	<p>pwd = ${param.pwd}</p>
	<p>name = ${param.name}</p>
	<p>email = ${param.email}</p>
	<p>birth = ${param.birth}</p>
	<p>sns[0] = ${paramValues.sns[0]}</p>
	<p>sns[1] = ${paramValues.sns[1]}</p>
	<p>sns[2] = ${paramValues.sns[2]}</p>
</body>
</html>
