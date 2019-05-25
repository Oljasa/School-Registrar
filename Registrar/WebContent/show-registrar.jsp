<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentList</title>
</head>
<body>
	<h2 align="center"> Student List</h2>
	<table border = "1" cellpadding="10%" align="center">
			<tr>
				<th> ID </th>
				<th> First </th>
				<th> Last </th>
				
				<th> Gender </th>
				<th> Telephone </th>
				<th> Email </th>
			</tr>
			<c:forEach var="items" items = "${studentList}"> 
				<tr> 	
					<td>${items.id}</td>
					<td>${items.firstName}</td>
					<td>${items.lastName}</td>

					<td>${items.gender}</td>
					<td>${items.telephone}</td>
					<td>${items.email}</td>
					
				</tr>
			</c:forEach>
		
	</table>
</body>
</html>