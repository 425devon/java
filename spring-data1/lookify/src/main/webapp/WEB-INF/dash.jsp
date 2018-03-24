<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Lookify!</title>
</head>
<body>
	<div class="container">
		<div class="head">
			<ul>
				<li><a href="/new">Add New</a></li>
				<li><a href="/top">Top Songs</a></li>
			</ul>
			<form action="/search" method="post">
			<c:out value="${error}" />
				<input type="text" name="artist">
				<input type="submit" value="Search Artists">
			</form>
		</div>
		<div class="table">
			<table>
				<tr>
					<th>artist</th>
					<th>Name</th>
					<th>Rating</th>
					<th>actions</th>
				</tr>
				<c:forEach items="${songs}" var="song">
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