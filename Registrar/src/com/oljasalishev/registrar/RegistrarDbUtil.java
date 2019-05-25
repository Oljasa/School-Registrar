package com.oljasalishev.registrar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataAccess.Queries;

public class RegistrarDbUtil {
	
	public static List<Student> getRegistrarList() throws ClassNotFoundException, SQLException{
		
		String url = "jdbc:mysql://localhost:3306/schoolregistrar?useSSL=false";
		String userName = "Oljas";
		String password = "";
		
		ArrayList<Student> student = new ArrayList<>(); 
		
		//load the mysql driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url,userName,password);
		
		//create a statement
		
		Statement stmt = con.createStatement();
		
		//execute the statement and loop over the result set
		
		ResultSet rs = stmt.executeQuery(Queries.GET_ALLSTUDENTS);
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			//LocalDate dOB = LocalDate.parse(rs.getString(4));
			char gender = rs.getString(4).charAt(0);
			int telephone = rs.getInt(5);
			String email = rs.getString(6);
			
			Student s = new Student(id, firstName, lastName, gender, telephone, email);
			student.add(s);
		}
		return student;
	
	}
	public static void insertStudent(int ID, String firstName, String lastName, String Gender, int telephone, String email) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/schoolregistrar?useSSL=false";
		String userName = "Oljas";
		String password = "";
		
		//load the mysql driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url,userName,password);
		
		//create a statement
		
		PreparedStatement stmt = con.prepareStatement(Queries.INSERT_STUDENT);
		
		//execute the statement and loop over the result set
		stmt.setInt(1, ID);
		stmt.setString(2, firstName);
		stmt.setString(3, lastName);
		stmt.setString(4, Gender);
		stmt.setInt(5, telephone);
		stmt.setString(6, email);
		
		
		stmt.executeUpdate();
		
	}
	
}
