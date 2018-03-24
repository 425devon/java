<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckerMania!</title>
<style>
	.black{
		display:inline-block;
		height: 25px;
		width: 25px;
		background-color: blue;
		border: 1px solid black;
	}
	.red{
		display:inline-block;
		height: 25px;
		width: 25px;
		background-color: red;
		border: 1px solid black;
	}

</style>
</head>
<body>
	<%
	int height = 5;
		if(request.getParameter("height") != null){
			height = Integer.parseInt(request.getParameter("height"));
		};
		
	int width = 5;
		if(request.getParameter("width") != null){
			height = Integer.parseInt(request.getParameter("width"));
		};
		
	int count = 0;
		
	String color;
		
	%>
	

	<h1>Checker Board Height: <%= height %> Width: <%= width %></h1>
	
	<% for(int index = 0; index < height; index++) { %>
		<br>
  		<% for(int index2 = 0; index2 < width; index2++) { %>
  			
  			<% if(count % 2 == 0){ %>
				<% color = "black"; %>
			<% }else{ %>
				<% color = "red"; %>
			<% } %>
  			
        	<div class=<%= color %>></div>
        	<% count++; %>
    	<% } %>
        	
    <% } %>
 
</body>
</html>