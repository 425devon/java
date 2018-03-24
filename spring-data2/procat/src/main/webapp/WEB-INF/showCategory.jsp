<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Page</title>
</head>
<body>
<div class="categories">
		<h1>${cat.name}</h1>
		<ul>
			<c:forEach items="${products}" var="pro">
			 <li>${pro.name}</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<form method="POST" action="/addPro/${cat.id}">
	
			<label for="product">Add Product:
			<select name="product">
				<c:forEach items="${allProducts}" var="prod">
					<option value="${prod.id}">${prod.name}</option>
				</c:forEach>
			</select>
			</label>
			
			<input type="submit" value="add" />
		
		</form>
	</div> 
</body>
</html>