<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <link rel="stylesheet" href="resources/main.css" type="text/css" /> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	*{
    margin: 0 auto;
    font-family: sans-serif;
	}
	.calculator{
	}
	.results{
	
	}
	.container{
	    width: 100%;
	}
	form{
	    border: 1px solid black;
	    border-radius: 1em;
	    width: 20%;
	    text-align:center;
	    padding: 1%;
	}
	input{
	display: inline-block;
	padding: 10px;
	}
	#perfrom{
	display: block;
	width: 25%;
	}
	
</style>
<title>CalculatorII</title>
</head>
<body>
    <div class="container">
        <div class="calculator">
            <form action="/Calculator2/Logic" method="post">
                <input type="text" name="perform" id="perform" value="" placeholder ="">
                <input type="button" value="7" class="number">
                <input type="button" value="8" class="number">
                <input type="button" value="9" class="number">
                <input type="button" value="/" class="number"><br>
                <input type="button" value="4" class="number">
                <input type="button" value="5" class="number">
                <input type="button" value="6" class="number">
                <input type="button" value="x" class="number"><br>
                <input type="button" value="1" class="number">
                <input type="button" value="2" class="number">
                <input type="button" value="3" class="number">
                <input type="button" value="-" class="number"><br>
                <input type="button" value="0" class="number">
                <input type="submit" value="=">
                <input type="button" value="+" class="number">
            </form>
            <script>
            	var str = ""
            	$(".number").click(function(){
            		console.log("click" + this.value);
            		str += this.value;
            		console.log(str);
            		$("#perform").attr("placeholder",str);
            		$("#perform").val(str);
            	})
            </script>
        </div>
        <div class="results">
        	<h1>Previous Results:</h1>
        	<ol>
        	<c:forEach var="entry" items="${sessionScope.results}">
				<li><c:out value="${entry}" /></li>
        	</c:forEach>
        	</ol>
        </div>
    </div>
</body>
</html>