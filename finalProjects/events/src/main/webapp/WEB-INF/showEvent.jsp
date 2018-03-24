<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${event.name}</title>
</head>
<body>
	<div class="event">
		<h1>${event.name }</h1>
		<h3>Host: &nbsp; ${event.host}</h3>
		<h3>Date: &nbsp; <fmt:formatDate type = "date" value = "${event.time}" /></h3>
		<h3>Location: &nbsp; ${event.location}, ${event.state}</h3>
		<h3>People who are attending this event: &nbsp; ${attending.size()}</h3>
		
		<table>
			<tr><th>Name</th><th>Location</th></tr>
			<c:forEach items="${attending}" var="user">
				<tr>
					<td>${user.first_name} &nbsp; ${user.last_name}</td>
					<td>${user.location} &nbsp; ${user.state}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="wall">
		<h1>Message Wall</h1>
		<textarea rows="4" cols="30" readonly>
			<c:forEach items="${event.comments}" var="comment">
				${comment.getUser().first_name} &nbsp; Says &nbsp; ${comment.comment}
				----------------------------
			</c:forEach>
		</textarea>
		Add Comment:
		<form:form method="POST" action="/newComment/${event.id}/${currentUser.id}" modelAttribute="com">
			<p>
	            <form:errors path="comment"/>
	            <form:textarea path="comment"/>
	        </p>
	        
	        <input type="submit" value="submit"/>
	        
		</form:form>
	</div>
</body>
</html>