package project;


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
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/messdata";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/messdata";
	static final String FEEDBACK_DB_URL = "jdbc:mysql://localhost/messdata";
	static final String AMESS_DB_URL = "jdbc:mysql://localhost/messdata";
	static final String CMESS_DB_URL = "jdbc:mysql://localhost/messdata";
	static final String DB_URL = "jdbc:mysql://localhost/messdata";
	String username = "root";
	String password = "1234";
	
	Connection connection = null;
	Connection connect;
	Statement statement = null;
	ResultSet resultset = null;
	ResultSet rs;
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
	
	Connection connect(){
	      // setup the connection with the DB.
		  final String URL = "jdbc:mysql://localhost/MessData";
		  final String USER = "root";
		  final String PASSWORD = "1234";
		  try{
		  connect= DriverManager.getConnection(URL, USER, PASSWORD);
		  }
		  catch(SQLException e){
			  System.out.println("ERROR: Unable to Connect to Database.");  
		  }
		  return connect;
		  }
		
		
	
	public void shutdownDB() {
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	
	

	
	void addFeedback(String Feedback) throws SQLException{
		connect=connect();
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
	
	long getBalance(String messname) throws Exception{
		connect=connect();
		statement=connect.createStatement();
		rs=statement.executeQuery("select * from Accounts;");
		while(rs.next()){
		if(rs.getString("Mess").equals(messname)){
			return rs.getLong("Balance");
		}
		}
		connect.close();
		throw new Exception("Specified Mess Does not exist");
	}
	
	void changeBalance(long newbal,String mess) throws SQLException{
		connect=connect();
		statement=connect.createStatement();
		statement.executeUpdate("update Accounts set Balance="+newbal+" where Mess='"+mess+"';");
		connect.close();
	}
	String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		 String cdate = sdf.format(new Date());
		 
		 return cdate;
	}
	
	
	
}


