<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Product</title>
<style>
	input, textarea{
	display:block;
	}
</style>
</head>
<body>
<h1>New Product</h1>
	<form:form method="POST" action="/newProduct" modelAttribute="product">
		<form:label path="name" >Name:
		<form:errors path="name" class="error"/>
		<form:input path="name"/></form:label>
		
		<form:label path="description" >Description:
		<form:errors path="description" class="error"/>
		<form:textarea path="description"/></form:label>
		
		<form:label path="price" >Price:
		<form:errors path="price" class="error"/>
		<form:input path="price"/></form:label>
		
		
		<input type="submit" value="Create">
	</form:form>
	
	<h2><a href="/category">Create A Category</a></h2>
</body>
</html>