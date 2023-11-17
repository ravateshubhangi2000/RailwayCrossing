package com.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "Shubhangi@1234");

			String uname = request.getParameter("uname");
			String pass = request.getParameter("password");

			// Corrected SQL query to check both username and password
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE uname=? AND password=?");
			ps.setString(1, uname);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Set user information in session if needed
				request.getSession().setAttribute("username", uname);

				RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
				rd.forward(request, response);
			} else {
				out.println("<font color=red size=4>Login Failed!!!<br>");
				out.println("<font color=red size=2>Invalid user name or password<br>");
				out.println("<a href=login.jsp>Try Again</a>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}