<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fortran Dashboard</title>
</head>
<body>
	<div>
		<h1>Fortran!</h1>
		<ul>
			<li><a href="/m/38/0553/0733">Set up</a></li>
			<li><a href="/m/38/0483/0345">Forms</a></li>
			<li><a href="/m/38/0553/0342">Cards</a></li>
			<li><a href="/m/26/0553/0348">Advanced</a></li>
			<li><a href="/m/26/0483/2342">Binary</a></li>
		</ul>
	</div>
	<div>
		<textarea col="30" row="5"><c:out value="${cat}"></c:out></textarea>
	</div>
</body>
</html>