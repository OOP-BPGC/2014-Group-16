package src;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Login {
	boolean loginStatus;
	Student student = new Student();
	Guest guest;
	
	String username = "root";
	String password = "J0llYS1D";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/Students";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/Guests";
	
	void studentLogin(String idNumber, String password) {
		
	}
	
	boolean doStudentCheckIn (String idNumber,String messName) {
		
		//set this.student to an object corresponding to idNumber in student database
		//Database - Sr.No, ID, Name, Mess, HasEaten, Password
			this.student.idNumber = idNumber;
			setupstudentdb(); 
			this.student.hasEaten = this.student.getHasEaten(idNumber);			
			
			setupstudentdb();
			this.student.mess.messName = this.student.getMessChosen(idNumber);
			
			if(!this.student.mess.messName.equals(messName) || this.student.hasEaten == true) {
				student.checkinStatus = false;
				return false;
			}
			else {
				student.checkinStatus = true;				
				setupstudentdb();				
				this.student.setHasEaten(true,idNumber);
				return true;
			}			
	}
	
	boolean doGuestCheckIn(String name) {
		this.guest.name = name;	
		setupguestdb();
		return true;
	}
	
	public void setupstudentdb() {
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
			}//end try
	}
	
	public void setupguestdb() {
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
			}//end try
	}
	
	public static void main(String[] args) {
		Login l = new Login();
		
		System.out.println("Check in " + l.doStudentCheckIn("2012A3PS208G", "A"));
		System.out.println("");
		System.out.println("Check in " + l.doStudentCheckIn("2012A3PS200G", "A"));
	}
}
