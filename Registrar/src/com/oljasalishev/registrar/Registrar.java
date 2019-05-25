package com.oljasalishev.registrar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrar
 */
@WebServlet("/RegistrarList")
public class Registrar extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get data from database(model)
		try {
			List<Student> studentList = RegistrarDbUtil.getRegistrarList();
			request.setAttribute("studentList", studentList);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// redirect to view
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-registrar.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
