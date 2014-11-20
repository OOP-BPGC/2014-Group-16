package src;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Siddhant, Varun
 *
 */

public class BitsDatabase {
	
	public final int TOTAL_STUDENTS = 1000;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost/MessManagement";
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/Students";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/Guests";
	static final String FEEDBACK_DB_URL = "jdbc:mysql://localhost/Feedback";
	static final String AMESS_DB_URL = "jdbc:mysql://localhost/AMess";
	static final String CMESS_DB_URL = "jdbc:mysql://localhost/CMess";
	
	String username = "root";
	String password = "J0llYS1D";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	public BitsDatabase() {
		connection = null;
		statement = null;
		resultset = null;
	}
	
	String getCurrentDay() {
		 SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		 String cday = sdf.format(new Date());
		 
		 switch(cday) {
		 case "Mon": return "MONDAY";
		 case "Tue": return "TUESDAY";
		 case "Wed": return "WEDNESDAY";
		 case "Thu": return "THURSDAY";
		 case "Fri": return "FRIDAY";
		 case "Sat": return "SATURDAY";
		 case "Sun": return "SUNDAY";
		 default: System.out.println("There was a problem in getting the Current Day.");
		 		  return "";
		 }
	 }
	 
	 String getCurrentTime() {
		 SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		 String ctime = sdf.format(new Date());
		 return ctime;
	 }
	 
	 public void setupDB() {
			try{
				Class.forName("com.mysql.jdbc.Driver");
				this.connection = DriverManager.getConnection(DB_URL, username, password);
				this.statement = this.connection.createStatement();
				}catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				}catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}finally{
				}//end try
		} 
	
	public void setupStudentDB() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(STUDENT_DB_URL, username, password);
			this.statement = this.connection.createStatement();
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
			}//end try
	}
	
	public void setupGuestDB() {
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      this.connection = DriverManager.getConnection(GUEST_DB_URL, username, password);
		      this.statement = this.connection.createStatement();
			}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
			}catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
			}finally{
			}//end try
	}
	
	public void setupMessDB(String messName) {
		switch(messName){
		case "A": {
			try{
			      Class.forName("com.mysql.jdbc.Driver");
			      this.connection = DriverManager.getConnection(AMESS_DB_URL, username, password);
			      this.statement = this.connection.createStatement();
				}catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
				}catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
				}finally{
				}
			break;
		}
		
		case "C": {
			try{
			      Class.forName("com.mysql.jdbc.Driver");
			      this.connection = DriverManager.getConnection(CMESS_DB_URL, username, password);
			      this.statement = this.connection.createStatement();
				}catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
				}catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
				}finally{
				}//end try
			break;
		}
		
		default: 
			System.out.println("Invalid Mess.");
		}
	}
	
	public void setupFeedbackDB() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(FEEDBACK_DB_URL, username, password);
			this.statement = this.connection.createStatement();
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
			}//end try
	}
	
	public void shutdownDB() {
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
}
