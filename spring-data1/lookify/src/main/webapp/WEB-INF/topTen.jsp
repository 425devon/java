<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top Ten Songs</title>
</head>
<body>
<a href="/dash">Dashboard</a>
	<div>
		<h3>Top Ten Songs</h3>
		
		<ol>
		<c:forEach items="${songs}" var="song">
			<li>${song.rating} &nbsp; <a href="/showSong/${song.id}">${song.title}</a>&nbsp; ${song.artist} </li>
		</c:forEach>
		</ol>
	</div>
</body>
</html>