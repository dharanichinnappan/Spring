package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils{
	
	private static String jdbcUrl="jdbc:mysql://localhost/usermanagement";
	private static String jdbcUserName="root";
	private static String jdbcPassword="dhuruv";
	
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
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
		return connection;
	}
	
	  public static void main(String[] args) { 
		  //JDBCUtils u=new JDBCUtils();
	  JDBCUtils.getConnection(); }
	 
	
}