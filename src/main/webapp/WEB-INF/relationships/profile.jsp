<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<div style="margin: 50px;">
		<a href="/">Home</a>
		<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
		<table>
			<tr>
				<td>License Number</td>
				<td><c:out value="${license.number}"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><c:out value="${license.state}"/></td>
			</tr>
			<tr>
				<td>Expiration Date</td>
				<td><c:out value="${license.expirationDate}"/></td>
			</tr>
		</table>
	</div>
</body>
</html>