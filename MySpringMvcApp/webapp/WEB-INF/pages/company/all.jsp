<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All companies</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>Name:</th>
				<th>Street:</th>
				<th>Street Number:</th>
				<th>City</th>
			</tr>
			<c:forEach items="${companies}" var="company">


				<tr>
					<td>${company.name }</td>
					<td>${company.address }</td>
					<td>${company.number }</td>
					<td>${company.cityDto.name}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>