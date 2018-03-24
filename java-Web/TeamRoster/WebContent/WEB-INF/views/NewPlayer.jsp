<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${cur_teamName }" />: New Player</title>
</head>
<body>
	<div class="container">
	 <h1>Add a new player to team <c:out value="${cur_teamName }" /></h1>
	 <form action="/TeamRoster/CreatePlayer" method="post">
	 	<label for="first_name">First Name:<input type="text" name="first_name"></label>
	 	<label for="last_name">Last Name:<input type="text" name="last_name"></label>
	 	<label for="age">Age: <input type="range" name="age" min="10" max="100" id="myRange"><span id="val"></span></label> 
	 	<input type="submit" name="Add"> 
	 </form>
	
	</div>
	<script>
		var slider = document.getElementById("myRange");
		var output = document.getElementById("val");
		output.innerHTML = slider.value;
		
		slider.oninput = function() {
		  output.innerHTML = this.value;
		}
 	</script>
</body>
</html>