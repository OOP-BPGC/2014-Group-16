package project;

import java.sql.*;

/**
 * 
 * @author Siddhant
 *
 */
public class Guest {
	
	String name;
	boolean checkinStatus;
	
	Feedback feedback;
	BitsDatabase bitsdatabase;
	
	public Guest() {
		this.name = "";
		feedback = new Feedback();
		bitsdatabase = new BitsDatabase();
	}
	
	public void getMessInfo(String messName) {		
		
		
	}
	
	public void setName(String name) {
		this.name = name;
		
		//copy to database
		/*try{  
			//Execute Query
			bitsdatabase.setupGuestDB();
		      
			String sql = "INSERT INTO Guests (name) VALUES '" + name + "';";
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
			}//end try   */		
	}
	
	
	public void giveFeedback(String comments) {		
			Feedback.addGuestFeedback(name, comments);			
		} 

}
