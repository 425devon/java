<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dojoOverflow</title>
</head>
<body>
	<h1>Dojo Overflow</h1>
	<h2>Questions Dashboard</h2>
	<table>
		<tr><th>Question</th><th>Tags</th></tr>
		<c:forEach items="${questions}" var="q">
			<tr>
				<td><a href="${q.id}">${q.question}</a></td>
				<td>
				<c:forEach items="${q.tags}" var="t">
				${t.subject}&nbsp;
				</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h2><a href="/newQuestion">New Question</a></h2>
</body>
</html>