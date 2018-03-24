<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Dash</title>
</head>
<body>
	<div class="container">
		<form id="logoutForm" method="POST" action="/logo">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
        
        <h1>Welcome&nbsp;<c:out value="${currentUser.first_name}">!</c:out></h1>
        <table>
        	<tr> <th>Name</th> <th>Email</th> <th>Action</th> </tr>
        	<c:forEach items="${allUsers}" var="user">
        		<tr>
        			<td>${user.first_name} &nbsp; ${user.last_name}</td>
        			<td>${user.username}</td>
        			<th>
        				<c:if test="${user.roleId() == 1}">
        					<td><a href="/admin/delete/${user.id}">Delete</a>&nbsp;<a href="/admin/mkAdmin/${user.id}">Make Admin</a> </td>
        				</c:if>
        				
        				<c:if test="${user.roleId() == 2}">
        					<td>admin</td>
        				</c:if>
        				
        			</th>
        		</tr>
        	</c:forEach>
        </table>
    </form>
	</div>
</body>
</html>