package com.oljasalishev.registrar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// redirect to view
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-student.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		int telephone =	Integer.parseInt(request.getParameter("telephone"));
		String email = request.getParameter("email");
		
	
		
		try {
			RegistrarDbUtil.insertStudent(id, firstName, lastName, gender, telephone, email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter writer = response.getWriter();
		
		String htmlResponse = "<html>";
		htmlResponse += "<h2> you inserted values:" + firstName + lastName + gender + telephone + email + "</h2>";
		
		writer.println(htmlResponse);
		
	}
	
}
