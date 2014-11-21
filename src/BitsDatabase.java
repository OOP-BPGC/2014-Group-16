package src;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		 String cdate = sdf.format(new Date());
		 
		 return cdate;
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

	public void shutdownDB() {
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
}
