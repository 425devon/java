<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Java Gold!</title>
</head>
<body>
	<div class="container">
	<a href="/logout">Reset</a>
        <div class="gold">
            <h2>Your Gold:&nbsp; <c:out value="${sessionScope.gold}" /> </h2>

        </div>
            <div class="box" id="b1">
                <h2>Farm</h2>
                <h4>(earn 10-20 golds)</h4>
                <form action="/farm" method="post">
                    <input class="sub" type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="box" id="b2">
                <h2>Cave</h2>
                <h4>(earns 5-10 golds)</h4>
                <form action="/cave" method="post">
                    <input class="sub" type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="box" id="b3">
                <h2>House</h2>
                <h4>(earns 2-5 golds)</h4>
                <form action="/house" method="post">
                    <input class="sub" type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="box" id="b4">
                <h2>Casino</h2>
                <h4>(earns/takes 0-50 golds)</h4>
                <form action="/casino" method="post">
                    <input class="sub" type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="log">
                <h3 style="text-align: left; margin-left: 2em">Activities:</h3>
                <form action="/log">
                    <input type="hidden" name="activity" value="log" />
                    <textarea rows="4" cols="50">
                        <c:out value="${sessionScope.alog}" />
                    </textarea>
                </form>
            </div>
    </div>
</body>
</html>