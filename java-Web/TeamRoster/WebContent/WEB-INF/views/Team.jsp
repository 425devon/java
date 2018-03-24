<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team</title>
</head>
<body>
	<div class="container">
		<!-- Super fun jstl to set team name -->
			<c:forEach var="entry" items="${sessionScope.teams}">
				<c:if test="${entry.key == requestScope.id }">
					<c:set var="cur_teamName" scope="session" value="${entry.value}" />
					<c:set var="cur_id" scope="session" value="${requestScope.id}" />
				</c:if>
			</c:forEach>
		<h1><c:out value="${cur_teamName }"></c:out></h1>
		<h1><a href="/TeamRoster/CreatePlayer?id=${cur_id}">New <c:out value="${cur_teamName }"></c:out></a></h1>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</tr>
		
		<c:forEach var="entry" items="${sessionScope.players}">
			<c:if test="${entry.team_id == cur_id }">
				<tr>
					<td><c:out value="${entry.first_name}"></c:out></td>
					<td><c:out value="${entry.last_name}"></c:out></td>
					<td><c:out value="${entry.age}"></c:out></td>
					<td><a href="/TeamRoster/DeletePlayer?id=${entry.getId()}">Delete</a></td>
				</tr>
			</c:if>
		</c:forEach>
		</table>
	</div>
</body>
</html>