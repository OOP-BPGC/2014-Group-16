package src;

import java.sql.SQLException;

/**
 * 
 * @author Siddhant, Varun
 *
 */
public final class Feedback {  
	
	BitsDatabase bitsdatabase;
	
	public Feedback() {
	bitsdatabase = new BitsDatabase();
	}
	
	void addGuestFeedback(String name, String comments) {
		try{
			bitsdatabase.setupFeedbackDB();
			
			String sql = "INSERT INTO GuestFeedback VALUES (" + name + ", " + comments + ")";
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
		}
	}
	
	void addStudentFeedback(String name, String comments) {
		try{
			bitsdatabase.setupFeedbackDB();
			
			String sql = "INSERT INTO StudentFeedback VALUES (" + name + ", " + comments + ")";
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
		}
	}
	
}
