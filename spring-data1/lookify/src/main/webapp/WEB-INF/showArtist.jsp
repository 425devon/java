<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<form action="/search" method="post">
			<input type="text" name="artist">
			<input type="submit" value="New Search">
		</form>
		<a href="/dash">Dashboard</a>
		<div>
			<table>
				<tr>
					<th>artist</th>
					<th>Name</th>
					<th>Rating</th>
					<th>actions</th>
				</tr>
				<c:forEach items="${artist}" var="song">
					<tr>
						<td><a href="/showSong/${song.id}"><c:out value="${song.artist}"/></a></td>
						<td><c:out value="${song.title}"></c:out></td>
						<td><c:out value="${song.rating}"></c:out></td>
						<td><a href="/delete/${song.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>