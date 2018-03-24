<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create License</title>
</head>
<body>
	<div class="form">
			<form:form method="POST" action="/createLicense" modelAttribute="license">
			
				<form:label path="Person">Person:
    			<form:errors path="Person" class="error"/>
   				<form:select path="Person">
   				<c:forEach items="${persons}" var="person">
   					<option value="${person.id}">${person.firstName}&nbsp; ${person.lastName}</option>
				</c:forEach>
   				</form:select>
   				</form:label>
				
   				
   				<form:label path="state" >State:
    			<form:errors path="state" class="error"/>
   				<form:input path="state"/></form:label>
   				
   				<form:label path="expiration_date" >Expiration Date:
    			<form:errors path="expiration_date" class="error"/>
   				<form:input type="date" path="expiration_date"/></form:label>
   				
   				
   				<input type="submit" value="Create"/>
   				
			</form:form>
		</div>
</body>
</html>