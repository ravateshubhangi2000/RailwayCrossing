<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.io.*,java.util.*,java.sql.*" %>

<%@ page import="javax.servlet.http.*,javax.servlet.*" %>


<%

String id = request.getParameter("id");


// Check if ID is provided

if (id != null && !id.isEmpty()) {

try {

// Database connection details

String url = "jdbc:mysql://localhost:3306/db4"; String user = "root";

String password = "Shubhangi1234";
// Create database connection

Connection conn = DriverManager.getConnection(url, user, password);


// Prepare and execute the delete statement

String sql = "DELETE FROM adminhome WHERE id = ?";

PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1, id);

pstmt.executeUpdate();


pstmt.close(); conn.close();

response.sendRedirect("delete.jsp?success=true"); } catch (SQLException e) { e.printStackTrace();
response.sendRedirect("delete.jsp?error=true"); }

} else {
response.sendRedirect("delete.jsp?error=true");

}

%>

