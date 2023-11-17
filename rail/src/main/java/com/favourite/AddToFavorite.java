package com.favourite;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import java.sql.Connection; 
import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;


/**
 * Servlet implementation class AddToFavorite
 */
@WebServlet("/AddToFavorite")
public class AddToFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavorite() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemId = request.getParameter("itemId");
		try {


			Class.forName("com.mysql.jdbc.Driver"); 
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "Shubhangi@1234");
			String sql = "INSERT INTO favorites (id, Name, Address, Landmark, Trainschedule, pname, status) " +

			"SELECT id, Name, Address, Landmark, Trainschedule, pname, status " + "FROM adminhome WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql); statement.setString(1, itemId);
			int rowsAffected = statement.executeUpdate();


			statement.close(); connection.close();



			response.sendRedirect("UserHome.jsp");

		} catch (ClassNotFoundException | SQLException e) { e.printStackTrace();

		}

	}
}

