<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form method="POST" action="/newNinja" modelAttribute="ninja">
	
		<form:label path="Dojo">Dojo:
		<form:errors path="Dojo" class="error"/>
		<form:select path="Dojo">
			<c:forEach items="${dojos}" var="dojo">
				<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
		</form:select>
		</form:label>
   				
		<form:label path="firstName" >First Name:
		<form:errors path="firstName" class="error"/>
		<form:input path="firstName"/></form:label>
		
		<form:label path="lastName" >Last Name:
		<form:errors path="lastName" class="error"/>
		<form:input path="lastName"/></form:label>
		
		<form:label path="age" >Age:
		<form:errors path="age" class="error"/>
		<form:input path="age"/></form:label>
		
		<input type="submit" value="Create">
	</form:form>
</body>
</html>