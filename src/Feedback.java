package src;

import java.sql.SQLException;

/**
 * 
 * @author Varun
 *
 */
public final class Feedback {  
	//static int total=0;
	//static String []studentFeedback;
	//static String feedback;
	
	BitsDatabase bitsdatabase = new BitsDatabase("root","J0llYS1D");

	/*
	static String getFeedback(int i) throws Exception{
		//called by MessAdmin to view a particular Feedback; For GUI purposes
		feedback=db.getFeedback(i);
		return feedback;	
	}
	
	static String[] getFeedback() throws SQLException{
		//called by MessAdmin to view all the unread Feedback; For GUI purposes
		studentFeedback=db.getFeedback();
		return studentFeedback;	
	}
	
	
	
	*/
	
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
	
	/*
	static void clearFeedback() throws SQLException{
		//clear the feedback array, after MessAdmin views it;
		db.clearFeedback();
		for(int i=0;i<total;i++){
		studentFeedback[i]=null;	
		}
	}*/
}
