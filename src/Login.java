package src;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Login {
	boolean loginStatus;
	Student student;
	Guest guest;
	
	String username;
	String password;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/Students";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/Guests";
	
	void studentLogin(String idNumber, String password) {
		
	}
	
	boolean doStudentCheckIn (String idNumber) {
		
		//set this.student to an object corresponding to idNumber in student database
		//Database - Sr.No, ID, Name, Mess, HasEaten
	this.student.idNumber = idNumber;
	try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      //System.out.println("Connecting to a selected database...");
	      this.student.connection = DriverManager.getConnection(STUDENT_DB_URL, username, password);
	      //System.out.println("Connected database successfully...");
		}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
		}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
		}finally{
	      //finally block used to close resources
	      try{
	         if(this.student.connection!=null)
	            this.student.connection.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
		}//end try
	 
		
		//Get HasEaten for student
		this.student.getHasEaten();
		
		if (student.hasEaten == true) {
			student.checkinStatus = false;
			return false;
		}
		else {
			student.checkinStatus = true;
			this.student.setHasEaten(true);
			return true;
		}			
	}
	
	boolean doGuestCheckIn(String name) {
		this.guest.name = name;
		
		return true;
	}
	
	
}
