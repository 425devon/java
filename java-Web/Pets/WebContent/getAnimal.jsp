<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pets!</title>
	<style>
		*{
			margin: 0 auto;
		}
	
		.cat, .dog{
			width: 15%;
			height: 100px;
			display: inline-block;
			margin-top: 2em;
			
		}
		form{
			border: 1px solid black;
			padding: 1em;
			margin-left: 2em;
		}
		input{
			display: block;
			margin: 1em;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="dog">
		<h2>Make A Dog!</h2>
			<form method="post" action="/Pets/ShowDog">
				<label for="name">Name:<input name="name" type="text"></label>
				<label for="breed">Breed:<input name="breed" type="text"></label>
				<label for="weight">Weight:<input name="weight" type="text"></label>
				<input type="submit" name="submit">
			</form>
		</div>
		<div class="cat">
		<h2>Make A Cat!</h2>
			<form method="post" action="/Pets/ShowCat">
				<label for="name">Name:<input name="name" type="text"></label>
				<label for="breed">Breed:<input name="breed" type="text"></label>
				<label for="weight">Weight:<input name="weight" type="text"></label>
				<input type="submit" name="submit">
			</form>
		</div>
	</div>
</body>
</html>