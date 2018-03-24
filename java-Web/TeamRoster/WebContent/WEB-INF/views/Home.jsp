<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roster</title>
</head>
<body>
	<div class="container">
		<h1>Prototype Roster</h1>
		<a href="/TeamRoster/CreateTeam">New Team</a>
		
		<table>
			<tr>
				<th>Team</th>
				<th>Players</th>
				<th>Action</th>
			</tr>
			<!-- For each statement here -->
			<c:forEach var="entry" items="${sessionScope.teams}">
			<tr>
				<td><c:out value="${entry.value}" /></td>
				<td>
					<c:forEach items="${sessionScope.players}" var="person">
						<c:if test="${person.team_id == entry.key}">
							+=1
						</c:if>
					</c:forEach>
				</td>
				<td><a href="/TeamRoster/ShowTeam?id=${entry.key}">Details</a>&nbsp;&nbsp;<a href="/TeamRoster/DeleteTeam?id=${entry.key}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>