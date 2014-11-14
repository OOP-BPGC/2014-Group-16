package src;

import java.sql.*;

/**
 * 
 * @author Varun
 *
 */

public class BitsDatabase {
	public int TOTAL_STUDENTS;
	private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet rs = null;
	 public BitsDatabase(){
	  try{
		  final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	  Class.forName(DRIVER_CLASS);
	  }
	  catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
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
	// list of Students
}
