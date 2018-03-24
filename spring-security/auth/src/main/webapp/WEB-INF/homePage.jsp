<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome<c:out value="${currentUser.first_name}">!</c:out></h1>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <div>
    	<h3>First Name: &nbsp; ${currentUser.first_name}</h3>
    	<h3>Last Name: &nbsp; ${currentUser.last_name}</h3>
    	<h3>Email: &nbsp; ${currentUser.username}</h3>
    	<h3>Sign up date: &nbsp; ${currentUser.createdAt}</h3>
    </div>
</body>
</html>