<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
	<div class="container">
		<div="reg">
	    <h1>Register!</h1>
	    <c:if test="${logoutMessage != null}">
        	<c:out value="${logoutMessage}"></c:out>
    	</c:if>
		    <p><form:errors path="user.*"/></p>
		    
		    <form:form method="POST" action="/registration" modelAttribute="user">
		        <p>
		            <form:label path="first_name">First Name:</form:label>
		            <form:input path="first_name"/>
		        </p>
		        
		        <p>
		            <form:label path="last_name">Last Name:</form:label>
		            <form:input path="last_name"/>
		        </p>
		        
		        <p>
		            <form:label path="username">Email:</form:label>
		            <form:input path="username"/>
		        </p>
		        
		        <p>
		            <form:label path="location">Location:</form:label>
		            <form:input path="location"/>
		        </p>
		        
		        <p>
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
		        </p>
		        
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password path="password"/>
		        </p>
		        <p>
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation"/>
		        </p>
		        <input type="submit" value="Register!"/>
		    </form:form>
	    </div>
	    <div class="log">
	    	<c:if test="${logoutMessage != null}">
        		<c:out value="${logoutMessage}"></c:out>
    		</c:if>
    <h1>Login</h1>
	    <c:if test="${errorMessage != null}">
	        <c:out value="${errorMessage}"></c:out>
	    </c:if>
		    <form method="POST" action="/login">
		        <p>
		            <label for="username">Username:</label>
		            <input type="text" id="log_username" name="username"/>
		        </p>
		        <p>
		            <label for="password">Password:</label>
		            <input type="password" id="log_password" name="password"/>
		        </p>
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input type="submit" value="Login!"/>
		    </form>
	    </div>
    </div>
</body>
</html>