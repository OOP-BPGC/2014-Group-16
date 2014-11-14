package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Siddhant
 *
 */
public class Login {
	boolean loginStatus;
	Student student = new Student();
	Guest guest;
	
	String username = "root";
	String password = "12345";
	
	String checkusr = "";
	String checkpass = "";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/Students";
	static final String GUEST_DB_URL = "jdbc:mysql://localhost/Guests";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	boolean doStudentLogin(String idNumber, String password) {
		this.checkusr = idNumber;
		this.checkpass = password;
		
		boolean match = false;
		try{
			  setupdb();
		      statement = connection.createStatement();
		      
		      String sqlu = "SELECT idno FROM Students WHERE IDNO = '" + idNumber + "'";
		      resultset = statement.executeQuery(sqlu);
		      
		      while(resultset.next()){
		    		  //Retrieve by column name
		    	  	this.student.idNumber = resultset.getString("idno");
		    		  match = true;
		      }
		      
		      //Check user
		      if(match == true && this.student.idNumber.equalsIgnoreCase(checkusr)) {
		    	  System.out.println("Student Username Found.");
		    	  try{
				      statement = connection.createStatement();
				      
				      String sqlp = "SELECT password FROM Students WHERE IDNO = '" + idNumber + "'";
				      resultset = statement.executeQuery(sqlp);
				      
				      while(resultset.next()){
				    		  //Retrieve by column name
				    	  	this.student.password = resultset.getString("password");
				    		  match = true;
				      }
				      if(match == true && this.student.password.equals(checkpass)) {
				    	  System.out.println("Password Matched. Loggin In.");
				    	  shutdowndb();
				    	  return true;
				      }
				      else {
				    	  System.out.println("Login Failed. Incorrect password.");
				      	  shutdowndb();
				      	  return false;
				      }
	      		}catch(SQLException se){
	  		      //Handle errors for JDBC
	  		      se.printStackTrace();
	      		 }catch(Exception e){
	  		      //Handle errors for Class.forName
	  		      e.printStackTrace();
	      		  }finally{
	  		      //finally block used to close resources
	  		    	  shutdowndb();
	      		   }
		      }
		      else{
		    	  System.out.println("Login Failed. Student ID not found.");
	    		  	shutdowndb();
	      			return false;
		      }
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		    	  shutdowndb();
		   }//end try
		return false;
		
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
				System.out.println("Checkin Failed.");
				return false;
			}
			else {
				student.checkinStatus = true;
				System.out.println("Checkin Successful.");
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
	
	public void setupdb() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(STUDENT_DB_URL, username, password);
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
			}//end try
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
	
	public void shutdowndb() {
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Login l = new Login();
		
		l.doStudentCheckIn("2012A3PS208G", "A");
		System.out.println("");
		l.doStudentCheckIn("2012A3PS200G", "A");
		System.out.println("");
		l.doStudentLogin("2012A3PS200G","12345");
		System.out.println("");
		l.doStudentLogin("2012A3PS208G","12345");
		System.out.println("");
		l.doStudentLogin("2012A3PS200G","12346");
	}
}
