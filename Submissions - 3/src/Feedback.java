package src;

import java.sql.SQLException;

/**
 * 
 * @author Varun
 *
 */
public final class Feedback {  
	static int total=0;
	static String []studentFeedback;
	static String feedback;
	static BitsDatabase db=new BitsDatabase();

	
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
	
	static void giveFeedback(String Feedback) throws SQLException{
		//invoked by student to give Feedback
		db.addFeedback(Feedback);
		
	}
	static void clearFeedback() throws SQLException{
		//clear the feedback array, after MessAdmin views it;
		db.clearFeedback();
		for(int i=0;i<total;i++){
		studentFeedback[i]=null;	
		}
	}
}
