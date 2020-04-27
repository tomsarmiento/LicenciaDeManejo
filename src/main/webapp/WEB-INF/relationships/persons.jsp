<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div style="margin: 50px;">
		<a href="/">Home</a>
		<h1>New Person</h1>
		<form:form action="/persons/new" method="post"
			modelAttribute="person">
			<p>
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" />
				<form:errors path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" />
				<form:errors path="lastName" />
			</p>
			<input type="submit" value="Create" />
		</form:form>
	</div>
</body>
</html>