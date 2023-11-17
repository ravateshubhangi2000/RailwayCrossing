<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*"%>


<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Favorite Crossing</title>

</head>

<body>

	<h2>Favorite Crossing</h2>

	<a href="UserHome.jsp">Home</a>
	<br>

	<a href="search.jsp">Search Crossing</a>
	<br>
	<br>

	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/db4" user="root"
		password="Shubhangi@1234" />



	<sql:query dataSource="${snapshot}" var="favorites" SELECT * FROM Favorites; > 
	

</sql:query>



	<c:if test="${not empty favorites.rows}">
		<table border="1" width="100%">
			<tr>

				<th>Sr.No</th>

				<th>Name</th>

				<th>Address</th>

				<th>Landmark</th>

				<th>Time Schedule</th>

				<th>Person In-Charge</th>

				<th>Status</th>

			</tr>

			<c:forEach var="favorite" items="${favorites.rows}">
				<tr>

					<td><c:out value="${favorite.id}" /></td>

					<td><c:out value="${favorite.Name}" /></td>

					<td><c:out value="${favorite.Address}" /></td>

					<td><c:out value="${favorite.Landmark}" /></td>

					<td><c:out value="${favorite.Trainschedule}" /></td>

					<td><c:out value="${favorite.pname}" /></td>

					<td><c:out value="${favorite.status}" /></td>

				</tr>

			</c:forEach>

		</table>

	</c:if>

	<c:if test="${empty favorites.rows}">

		<p>No favorite crossings.</p>

	</c:if>

</body>

</html>

