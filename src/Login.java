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
	
	boolean doStudentCheckIn (String idNumber,String messName) {
		
		//set this.student to an object corresponding to idNumber in student database
		//Database - Sr.No, ID, Name, Mess, HasEaten
		this.student.idNumber = idNumber;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.student.connection = DriverManager.getConnection(STUDENT_DB_URL, username, password);
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
				try{
					if(this.student.connection!=null)
						this.student.connection.close();
				}catch(SQLException se){
					se.printStackTrace();
				}//end finally try
			}//end try
	 
		
			//Get HasEaten for student
			this.student.getHasEaten(idNumber);
			this.student.getMessChosen(idNumber);
		
			if (student.hasEaten == true && student.mess.messName == messName) {
				student.checkinStatus = false;
				return false;
			}
			else {
				student.checkinStatus = true;
				this.student.setHasEaten(true,idNumber);
				return true;
		}			
	}
	
	boolean doGuestCheckIn(String name) {
		this.guest.name = name;
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      this.guest.connection = DriverManager.getConnection(GUEST_DB_URL, username, password);
			}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
			}catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
			}finally{
				try{
		         if(this.guest.connection!=null)
		            this.guest.connection.close();
				}catch(SQLException se){
		         se.printStackTrace();
				}//end finally try
			}//end try
		
		
		return true;
	}
	
	
}
