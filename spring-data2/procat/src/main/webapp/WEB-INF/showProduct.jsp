<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Page</title>
</head>
<body>
	<div class="categories">
		<h3>Categories:</h3>
		<h1>${product.name}</h1>
		<ul>
			<c:forEach items="${prodCat}" var="pro">
			 <li>${pro.name}</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<form method="POST" action="/addCat/${product.id}">
	
			<label for="category">Add Category:
			<select name="category">
				<c:forEach items="${cats}" var="cat">
					<option value="${cat.id}">${cat.name}</option>
				</c:forEach>
			</select>
			</label>
			
			<input type="submit" value="add" />
		
		</form>
	</div> 
</body>
</html>