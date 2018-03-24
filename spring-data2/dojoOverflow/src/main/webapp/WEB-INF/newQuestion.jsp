<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<form:form method="POST" action="/createQuestion" modelAttribute="newQ">
		<form:label path="question" >Question:
		<form:errors path="question" class="error"/>
		<form:textarea path="question"/></form:label>
		
		<label for="tag">Tags:
		<input type="text" name="tag"/></label>
		
		<input type="submit" value="Ask..."/>
	</form:form>
</body>
</html>