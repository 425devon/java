<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Add Song</title>
</head>
<body>
	<div class="container">
		<a href="/">Dashboard</a>
		<div class="form">
			<form:form method="POST" action="/create" modelAttribute="song">
			
				<form:label path="title">Title:
    			<form:errors path="title" class="error"/>
   				<form:input path="title"/></form:label>
   				
   				<form:label path="artist" >Artist:
    			<form:errors path="artist" class="error"/>
   				<form:input path="artist"/></form:label>
   				
   				<form:label path="rating">Rating:
    			<form:errors path="rating" class="error"/>
   				<form:select path="rating">
   					<option value="1">1</option>
   					<option value="2">2</option>
   					<option value="3">3</option>
   					<option value="4">4</option>
   					<option value="5">5</option>
   					<option value="6">6</option>
   					<option value="7">7</option>
   					<option value="8">8</option>
   					<option value="9">9</option>
   					<option value="10">10</option>
   				</form:select>
   				</form:label>
   				
   				<input type="submit" value="Add Song"/>
   				
			</form:form>
		</div>
	</div>
</body>
</html>