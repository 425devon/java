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
	<h1>${course.name}</h1>
	<c:if test="${logoutMessage != null}">
        	<c:out value="${logoutMessage}"></c:out>
    </c:if>
	<form method="POST" action="/editCourse/${course.id}">
   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   		<p>
            <label for="name">Name:</label>
            <input name="name" value="${course.name}">
        </p>
        <p>
            <label for="instructor">Instructor:</label>
            <input name="instructor" value="${course.instructor}">
        </p>
        <p>
            <label for="classSize">Limit:</label>
            <input name="classSize" value="${course.classSize}">
        </p>
        
        <input type="submit" value="Update"/>
	 </form>
	 <a href="/dash">Home</a>
</body>
</html>