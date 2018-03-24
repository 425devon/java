<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question Profile</title>
</head>
<body>
	<h1>${question.question}</h1>
	<ul>
		<c:forEach items="${question.tags}" var="t">
			<li>${t.subject}</li>
		</c:forEach>
	</ul>
	<table>
		<tr><th>Answers</th></tr>
		<c:forEach items="${question.answers}" var="a">
			<tr>
				<td>${a.resp}</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Add your answer:</h1>
	<form:form method="POST" action="/createAnswer/${question.id}" modelAttribute="answer">
		<form:label path="resp" >Answer:
		<form:errors path="resp" class="error"/>
		<form:textarea path="resp"/></form:label>
		
		<input type="submit" value="Answer it!"/>
	</form:form>
</body>
</html>