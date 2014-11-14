package src;

import java.sql.*;

/**
 * 
 * @author Siddhant
 *
 */
public class Guest implements MessCustomer{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/Guests";
	
	String name;
	Feedback feedback;
		
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	public Guest() {
		this.name = "";
	}
	
	public void getMessInfo(String messName) {		
		
	}
	
	public void giveFeedback(String feedback) {		
		try {
			Feedback.giveFeedback(feedback);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void shutdowndb() {
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

}
