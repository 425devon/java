<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Song</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<a href="/dash">Dashboard</a>
		<h1>Title &nbsp; <c:out value="${song.title}"></c:out> </h1>
		<h1>Artist &nbsp; <c:out value="${song.artist}"></c:out> </h1>
		<h1>Rating (1-10) &nbsp; <c:out value="${song.rating}"></c:out></h1>
		<a href="/delete/${song.id}">Delete</a>
	</div>
</body>
</html>