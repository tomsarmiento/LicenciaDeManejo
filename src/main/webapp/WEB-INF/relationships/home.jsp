<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div style="margin:50px;">
		<a href="/persons/new">New Person</a> 
		<a href="/licenses/new">New License</a>
		<form action="/persons" method="get" style="margin-top:30px;">
			<label for="id">Search profile by Id</label> 
			<input type="number" min="1" step="1" name="id"/> 
			<input type="submit" value="Search"/>
			<p><c:out value="${error}"/></p>
		</form>
	</div>
</body>
</html>