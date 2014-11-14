package src;

import java.sql.*;

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
	
	Student student;
	Feedback feedback;
	Guest guest;
	Login login;
	String username;
	String password;
	
	public BitsDatabase() {
		this.username = "root";
		this.password = "J0llYS1D";
	}
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
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
