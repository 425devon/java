<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Languages</title>
</head>
<body>
	<div class="container">
		<div class="table">
			<table>
				<tr><th>Name</th><th>Creator</th><th>Version</th><th>Action:</th></tr>
				<c:forEach items="${languages}" var="language" varStatus="count">
					<tr>
						<td><a href="/${count.index}"><c:out value="${language.name}"></c:out></a></td>
						<td><c:out value="${language.creator}"></c:out></td>
						<td><c:out value="${language.version}"></c:out></td>
						<td><a href="/delete/${count.index}">Delete</a><a href="/edit/${count.index}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="form">
			<form:form method="POST" action="/new" modelAttribute="language">
			
				<form:label path="name">Name:
    			<form:errors path="name" class="error"/>
   				<form:input path="name"/></form:label>
   				
   				<form:label path="creator" >Creator:
    			<form:errors path="creator" class="error"/>
   				<form:input path="creator"/></form:label>
   				
   				<form:label path="version">Version:
    			<form:errors path="version" class="error"/>
   				<form:input path="version"/></form:label>
   				
   				<input type="submit" value="Submit"/>
   				
			</form:form>
		</div>
	</div>
</body>
</html>