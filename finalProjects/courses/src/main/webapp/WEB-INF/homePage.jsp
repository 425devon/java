<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome, &nbsp;<c:out value="${currentUser.name}"></c:out></h1>
    
    <form id="logoutForm" method="POST" action="/logo">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <div>
    	<h3>Courses</h3>
    	<table>
    		<tr><th>Course</th><th>Instructor</th><th>Signups</th><th>Action</th></tr>
    		
    		<c:forEach items="${allCourses}" var="course">
    			<tr>
    				<td><a href="/course/${course.id}/${currentUser.id}">${course.name}</a></td>
    				<td>${course.instructor}</td>
    				<td>${course.users.size()} / ${course.classSize}</td>
    				<td>
    					<c:if test="${course.users.size() == course.classSize}">
       						<td>full</td>
       					</c:if>
       					
       					<c:if test="${course.users.size() < course.classSize && course.users.contains(currentUser) == false}">
       						<td><a href="/join/${course.id}/${currentUser.id}">add</a></td>
       					</c:if>
       					
       					<c:if test="${course.users.contains(currentUser) == true}">
       						<td>Already Added</td>
       					</c:if>
       					
    				</td>
    			</tr>
    		</c:forEach>
    	</table>
    </div>
    <a href="/addCourse/${currentUser.id}">Add a course</a>
</body>
</html>