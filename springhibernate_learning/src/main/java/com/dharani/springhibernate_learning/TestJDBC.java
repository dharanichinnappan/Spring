package com.dharani.springhibernate_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost/hb_student_tracker";
		String jdbcUserName="hbstudent";
		String jdbcPassword="hbstudent";
		Connection connection=null;
		try {
			System.out.println("trying for connecion ");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
			System.out.println("success");
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
