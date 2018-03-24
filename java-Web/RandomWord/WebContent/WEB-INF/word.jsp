<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Random Word Generator</title>
</head>
<body>
	<div class="container">
		<h3>You have generated a word <c:out value="${sessionScope.counter}" /> times</h3>
		<h1><c:out value="${sessionScope.word}" /></h1>
		<form action="/RandomWord/ShowWords" method="get">
			<input type="submit" name="Generate">
		</form>
		<h3>The last time you generated a was:</h3>
		<h1><c:out value="${sessionScope.date}" /></h1>
	</div>
</body>
</html>