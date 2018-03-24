<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Courses</title>
</head>
<body>
	<div>
		<h1>${course.name}</h1>
		<h3>Instructor: &nbsp; ${course.instructor}</h3>
		<h3>Sign Ups: &nbsp; ${course.users.size()}</h3>
    	
		<table>
			<tr><th>Name</th><th>Sign Up Date</th><th>Action</th></tr>
			<c:forEach items="${course.users}" var="user">
				<tr>
					<td>${user.name}</td>
					<td><fmt:formatDate type = "date" value = "${user.createdAt}" /></td>
					<td>
						<c:if test="${currentUser.id == user.id}">
       						<td><a href="/remove/${course.id}/${currentUser.id}">Remove</a></td>
       					</c:if>
					</td>
				<tr>
			</c:forEach>
		</table>
		<a href="/dash">Home</a>
		<a href="/edit/${course.id}">Edit</a>
		<a href="/delete/${course.id}">Delete</a>
	</div>
</body>
</html>