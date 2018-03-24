<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Button Clicker</title>
</head>
<body>
	<div class="container">
		<form action="" method="get">
			<input type="submit" name="ClickMe!">
			<h1>Clickity clickity clack!</h1>
			<h1><c:out value="${sessionScope.counter}"/></h1>
		</form>
	</div>
</body>
</html>