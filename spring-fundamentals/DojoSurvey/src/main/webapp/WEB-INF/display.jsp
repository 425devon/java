<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h3>Submitted Info</h3>
        <table>
            <tr><td>Name:</td><td><c:out value="${param.name}"/></td></tr>
            <tr><td>Dojo Location:</td><td><c:out value="${param.location}"/></td></tr>
            <tr><td>Favorite Language:</td><td><c:out value="${param.language}"/></td></tr>
            <tr><td>Comment:</td><td><c:out value="${param.comment}"/></td></tr>
        </table>
        <a href="/">Go Back</a>
    </div>
</body>
</html>