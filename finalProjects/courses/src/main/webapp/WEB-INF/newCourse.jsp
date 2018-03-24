<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Courses</title>
</head>
<body>
	<div>
		<h1>Create a new course</h1>
		<form:form method="POST" action="/createCourse/${currentUser.id}" modelAttribute="course">
		    
	    	<p>
	            <form:label path="name">Name:</form:label>
	            <form:errors path="name" />
	            <form:input path="name"/>
	        </p>
	        
	        <p>
	            <form:label path="instructor">Instructor:</form:label>
	            <form:errors path="instructor" />
	            <form:input path="instructor"/>
	        </p>
	        
	        <p>
	            <form:label path="classSize">Limit:</form:label>
	            <form:errors path="classSize" />
	            <form:input path="classSize"/>
	        </p>
	        
	        <input type="submit" value="Create"/>
	        
	   	</form:form>
	</div>
</body>
</html>