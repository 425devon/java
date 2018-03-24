<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Great Number Game!</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to the Great Number Game!</h1>
		<h3>I am thinking of a number between 1 and 100 <br>Take a guess!</h3>
		<form action="/NumberGame/ShowNumber" method="post">
			<input type="text" name="guess">
			<input type="submit" name="Submit">
		</form>
		<c:if test="${sessionScope.guess == sessionScope.answer }">
			<div id="correct" style="height:200px;width:200px;background-color:green;color:white">Correct!!!</div>
      	</c:if>
      	
      	<c:if test="${sessionScope.guess > sessionScope.answer }">
			<div id="high" style="height:200px;width:200px;background-color:red;color:white">Too High!</div>
      	</c:if>
      	
      	<c:if test="${sessionScope.guess < sessionScope.answer }">
			<div id="correct" style="height:200px;width:200px;background-color:orange;color:white">Too low!</div>
      	</c:if>
		
	</div>
</body>
</html>