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
	
	public int TOTAL_STUDENTS;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/Students";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/Guests";
	static final String FEEDBACK_DB_URL = "jdbc:mysql://localhost/Feedback";
	static final String AMESS_DB_URL = "jdbc:mysql://localhost/AMess";
	static final String CMESS_DB_URL = "jdbc:mysql://localhost/CMess";
	
	String username;
	String password;
	
	public BitsDatabase(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
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
	
	
	
/*
	
	void addFeedback(String Feedback) throws SQLException{
		connection=connection();
		statement=connect.createStatement();
		statement.executeUpdate("insert into Feedback values('"+Feedback+"');");
		connect.close();
	}
	
	void clearFeedback() throws SQLException{
		connect=connect();
		statement=connect.createStatement();
		statement.executeUpdate("delete from Feedback;");
		connect.close();	
	}
	
	String[] getFeedback() throws SQLException{
		int rows;
		int i=0;
		connect=connect();
		statement=connect.createStatement();
		rs=statement.executeQuery("select count(*) from Feedback;");
		rs.next();
		rows=rs.getInt("count(*)");
		String []feedback=new String[(rows)];
		rs=statement.executeQuery("select Feedback from Feedback;");
		while(rs.next()){
		feedback[i]=rs.getString("Feedback");	
		i++;
		}
		connect.close();
		return feedback;
	}
	
	String getFeedback(int i) throws Exception{
		connect=connect();
		statement=connect.createStatement();
		rs=statement.executeQuery("select count(*) from Feedback;");
		rs.next();
		int tot=rs.getInt("count(*)");
		rs=statement.executeQuery("select Feedback from Feedback;");
		if(i<tot){
			rs.absolute(i-1);
			String feed=rs.getString("Feedback");
			return feed;			
		}
		else
			throw new ArrayIndexOutOfBoundsException();	
	}
	// list of Students */
}
