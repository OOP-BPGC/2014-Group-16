package src;

import java.sql.*;

/**
 * 
 * @author Siddhant
 *
 */
public class Guest implements MessCustomer{
	
	String name;
	Feedback feedback;
	BitsDatabase bitsdatabase = new BitsDatabase("root","J0llYS1D");
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	public Guest() {
		this.name = "";
	}
	
	public void getMessInfo(String messName) {		
		
	}
	
	public void setName(String name) {
		this.name = name;
		
		//copy to database
		try{  
			//Execute Query
			bitsdatabase.setupGuestDB();
		      
			String sql = "INSERT INTO Guests (name) VALUES '" + name + "'";
		      bitsdatabase.statement.executeUpdate(sql);
		      
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
				//finally block used to close resources
				bitsdatabase.shutdownDB();
			}//end try   

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
