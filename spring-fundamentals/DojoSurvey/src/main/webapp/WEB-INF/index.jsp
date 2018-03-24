<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Greetings</title>
</head>
<body>
    <!--<h1>Hello <c:out value="${param.first_name}"/>&nbsp; <c:out value="${param.last_name}"/></h1> -->
    <div class="container">
        <form action="/submit" method="post">
            <label for="name">Your Name:<input type="text" name="name"></label>
            <label for="location">Dojo Location:<select name="location" id="location">
                <option value="san_jose">San Jose</option>
                <option value="Seattle">Seattle</option>
                <option value="chicago">chicago</option>
                <option value="la">los Angeles</option>
            </select></label>
            <label for="language">Favorite langauge:<select name="language" id="langauge">
                <option value="python">python</option>
                <option value="node">node js</option>
                <option value="java">Java</option>
            </select></label>
            <label for="comment"><textarea name="comment" id="comment" cols="30" rows="5"></textarea></label>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>