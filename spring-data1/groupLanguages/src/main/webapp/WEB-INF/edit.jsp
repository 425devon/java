<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title><c:out value="${language.name}"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<a href="/delete/${index}">Delete</a>
	<a href="/">Dashboard</a>
	<div class="form">
			<form:form method="POST" action="/update/${index}" modelAttribute="language">
			
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
</body>
</html>