<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome &nbsp;<c:out value="${currentUser.first_name}">!</c:out></h1>
    
    <form id="logoutForm" method="POST" action="/logo">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <div>
    <h3>Here are some of the events in your state:</h3>
    	<table class="eventState">
    		<tr> <th>Name</th> <th>Date</th> <th>Location</th> <th>Host</th> <th>Action/Status</th></tr>
    		<c:forEach items="${eventsByState}" var="event">
    			<tr>
    				<td><a href="/event/${event.id}">${event.name}</a></td>
    				<td><fmt:formatDate type = "date" value = "${event.time}" /></td>
    				<td>${event.location}</td>
    				<td>${event.host}</td>
    				
    				<c:if test="${currentUser.first_name == event.host}">
       					<td><a href="/event/edit/${event.id}/${currentUser.id}">Edit</a>&nbsp;<a href="/event/delete/${event.id}/${currentUser.id}">Delete</a> </td>
       				</c:if>
       				
       				<c:if test="${currentUser.first_name != event.host && event.getUsers().contains(currentUser) == false}">
       					<td><a href="/event/join/${event.id}/${currentUser.id}">Join</a></td>
       				</c:if>
       				
       				<c:if test="${currentUser.first_name != event.host && event.getUsers().contains(currentUser) == true}">
       					<td>Joining &nbsp; <a href="/event/cancel/${event.id}/${currentUser.id}">Cancel</a></td>
       				</c:if>
    			
    			</tr>
    		</c:forEach>
    	</table>
    </div>
    <div>
    <h3>Here are some of the events in other states:</h3>
    	<table class="allEvents">
    		<tr> <th>Name</th> <th>Date</th> <th>Location</th> <th>Host</th> <th>Action/Status</th></tr>
    		<c:forEach items="${otherEvents}" var="event">
    			<tr>
    				<td><a href="/event/${event.id}">${event.name}</a></td>
    				<td><fmt:formatDate type = "date" value = "${event.time}" /></td>
    				<td>${event.location}</td>
    				<td>${event.host}</td>
    				
    				<c:if test="${currentUser.first_name == event.host}">
       					<td><a href="/event/edit/${event.id}/${currentUser.id}">Edit</a>&nbsp;<a href="/event/delete/${event.id}/${currentUser.id}">Delete</a> </td>
       				</c:if>
       				
       				<c:if test="${currentUser.first_name != event.host && event.getUsers().contains(currentUser) == false}">
       					<td><a href="/event/join/${event.id}/${currentUser.id}">Join</a></td>
       				</c:if>
       				
       				<c:if test="${currentUser.first_name != event.host && event.getUsers().contains(currentUser) == true}">
       					<td>Joining &nbsp; <a href="/event/cancel/${event.id}/${currentUser.id}">Cancel</a></td>
       				</c:if>
    			
    			</tr>
    		</c:forEach>
    	</table>
    </div>
    <div class="newEvent">
    	<h1>Create an Event</h1>

    	<form:form method="POST" action="/newEvent/${currentUser.id}" modelAttribute="event">
    		
    		<p>
	            <form:label path="name">Name:</form:label>
	            <form:errors path="name"/>
	            <form:input path="name"/>
	        </p>
	        
	        <p>
	            <form:label path="time">date:</form:label>
	            <form:errors path="time"/>
	            <form:input type="date" path="time"/>
	        </p>
	        
	        <p>
	            <form:label path="location">Location:</form:label>
	            <form:errors path="location"/>
	            <form:input path="location"/>
	        </p>
	        
	        <p>	
	        	<form:errors path="state"/>
	            <form:select path="state">
	            		<option value="AL">AL</option>
						<option value="AK">AK</option>
						<option value="AR">AR</option>	
						<option value="AZ">AZ</option>
						<option value="CA">CA</option>
						<option value="CO">CO</option>
						<option value="CT">CT</option>
						<option value="DC">DC</option>
						<option value="DE">DE</option>
						<option value="FL">FL</option>
						<option value="GA">GA</option>
						<option value="HI">HI</option>
						<option value="IA">IA</option>	
						<option value="ID">ID</option>
						<option value="IL">IL</option>
						<option value="IN">IN</option>
						<option value="KS">KS</option>
						<option value="KY">KY</option>
						<option value="LA">LA</option>
						<option value="MA">MA</option>
						<option value="MD">MD</option>
						<option value="ME">ME</option>
						<option value="MI">MI</option>
						<option value="MN">MN</option>
						<option value="MO">MO</option>	
						<option value="MS">MS</option>
						<option value="MT">MT</option>
						<option value="NC">NC</option>	
						<option value="NE">NE</option>
						<option value="NH">NH</option>
						<option value="NJ">NJ</option>
						<option value="NM">NM</option>			
						<option value="NV">NV</option>
						<option value="NY">NY</option>
						<option value="ND">ND</option>
						<option value="OH">OH</option>
						<option value="OK">OK</option>
						<option value="OR">OR</option>
						<option value="PA">PA</option>
						<option value="RI">RI</option>
						<option value="SC">SC</option>
						<option value="SD">SD</option>
						<option value="TN">TN</option>
						<option value="TX">TX</option>
						<option value="UT">UT</option>
						<option value="VT">VT</option>
						<option value="VA">VA</option>
						<option value="WA">WA</option>
						<option value="WI">WI</option>	
						<option value="WV">WV</option>
						<option value="WY">WY</option>
					</form:select>
					
					<form:hidden path = "host" value = "${currentUser.first_name}" />
		        </p>
	        
	        <input type="submit" value="Create Event!"/>
	        
    	</form:form>
    </div>
</body>
</html>