package src;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Siddhant
 *
 */
public class Login {
	
	Student student;
	Guest guest;
	MessAdmin messadmin;
	MessCrew messcrew;
	
	BitsDatabase bitsdatabase;
	
	String checkusr;
	String checkpass;
	
	public Login() {
		student = new Student();
		guest = new Guest();
		messadmin = new MessAdmin("");
		bitsdatabase = new BitsDatabase();
		checkusr = "";
		checkpass = "";
	}
	
	public void clearMessCrewLeave(String messName) {
		try{
			bitsdatabase.setupDB();
		      
			String tdate = bitsdatabase.getCurrentDate();
			Date todayDate  = new SimpleDateFormat("dd/MM/yy").parse(tdate);
			
		      String sql = "SELECT lstart FROM " + messName + "MessCrew WHERE lstart IS NOT NULL";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next());
			  {
		       Date todate = new SimpleDateFormat("dd/MM/yy").parse(bitsdatabase.resultset.getString("lstart"));
		       String name = bitsdatabase.resultset.getString("name");
		       
		       String sql1;
		       
		      if(todate.before(todayDate)){
		    	  sql1 = "UPDATE " + messName + "MessCrew " +
		                   "SET to = NULL,from = NULL,status = NULL WHERE name'"+name+"'";
	       		 bitsdatabase.statement.executeUpdate(sql1);
		    	  
		      }
			  }
		       
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
		 return;
}
	
	boolean doStudentLogin(String idNumber, String password) {

		try{
			this.checkusr = idNumber;
			this.checkpass = password;			
			boolean flag1 = false;
			bitsdatabase.setupDB();
		      
		      String sqlu = "SELECT idno FROM Students WHERE IDNO = '" + idNumber + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlu);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    	  	this.student.idNumber = bitsdatabase.resultset.getString("idno");
		    		  flag1 = true;
		      }
		      
		      //Check user
		      if(flag1 == true && this.student.idNumber.equalsIgnoreCase(checkusr)) {
		    	  System.out.println("Student Username Matched.");
		    	  try{
		    		  boolean flag2 = false;
		    		  bitsdatabase.setupDB();
				      
				      String sqlp = "SELECT password FROM Students WHERE IDNO = '" + idNumber + "'";
				      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlp);
				      
				      while(bitsdatabase.resultset.next()){
				    		  //Retrieve by column name
				    	  	this.student.password = bitsdatabase.resultset.getString("password");
				    		  flag2 = true;
				      }
				      if(flag2 == true && this.student.password.equals(checkpass)) {
				    	  System.out.println("Password Matched. Logged In.");
				    	  this.student.authStatus = true;
				    	  bitsdatabase.shutdownDB();
				    	  return true;
				      }
				      else {
				    	  System.out.println("Login Failed. Incorrect password.");
				    	  this.student.authStatus = false;
				    	  bitsdatabase.shutdownDB();
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
	      			bitsdatabase.shutdownDB();
	      		   }
		      }
		      else{
		    	  System.out.println("Login Failed. Student ID not found.");
		    	  this.student.authStatus = false;
		    	  bitsdatabase.shutdownDB();
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
			   bitsdatabase.shutdownDB();
		   }//end try
		return false;
		
	}
	
	boolean doStudentCheckIn (String idNumber,String messName) {
		
		//set this.student to an object corresponding to idNumber in student database
		//Database - Sr.No, ID, Name, Mess, HasEaten, Password
			this.student.idNumber = idNumber;
			bitsdatabase.setupDB(); 
			this.student.hasEaten = this.student.getHasEaten(idNumber);			
			
			bitsdatabase.setupDB();
			this.student.mess.messName = this.student.getMessChosen(idNumber);
			
			if(!this.student.mess.messName.equals(messName) || this.student.hasEaten == true) {
				student.checkinStatus = false;
				System.out.println("Checkin Failed.");
				return false;
			}
			else {
				student.checkinStatus = true;
				System.out.println("Checkin Successful.");
				bitsdatabase.setupDB();				
				this.student.setHasEaten(true,idNumber);
				return true;
			}			
	}
	
	boolean doGuestCheckIn(String name) {
		this.guest.name = name;	
		try{
			bitsdatabase.setupDB();
			
			String sql = "INSERT INTO Guests VALUES (" + name + ")";
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
		guest.checkinStatus = true;
		return true;
	}
	
	//
	// MessCrew
	//
	
	boolean doMessCrewLogin(String uname, String password, String messName) {

		try{
			this.checkusr = uname;
			this.checkpass = password;			
			boolean flag1 = false;
			bitsdatabase.setupDB();
		      
		      String sqlu = "SELECT uname FROM " + messName + "MessCrew WHERE uname = '" + uname + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlu);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    	  	this.messcrew.uName = bitsdatabase.resultset.getString("uname");
		    		  flag1 = true;
		      }
		      
		      //Check user
		      if(flag1 == true && this.messcrew.uName.equalsIgnoreCase(checkusr)) {
		    	  System.out.println("Mess Crew Username Matched.");
		    	  try{
		    		  boolean flag2 = false;
		    		  bitsdatabase.setupDB();
				      
				      String sqlp = "SELECT password FROM " + messName + "MessCrew WHERE uname = '" + uname + "'";
				      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlp);
				      
				      while(bitsdatabase.resultset.next()){
				    		  //Retrieve by column name
				    	  	this.messcrew.password = bitsdatabase.resultset.getString("password");
				    		  flag2 = true;
				      }
				      if(flag2 == true && this.messcrew.password.equals(checkpass)) {
				    	  System.out.println("Password Matched. Logged In.");
				    	  this.messcrew.authStatus = true;
				    	  bitsdatabase.shutdownDB();
				    	  return true;
				      }
				      else {
				    	  System.out.println("Login Failed. Incorrect password.");
				    	  this.messcrew.authStatus = false;
				    	  bitsdatabase.shutdownDB();
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
	      			bitsdatabase.shutdownDB();
	      		   }
		      }
		      else{
		    	  System.out.println("Login Failed. Username not found.");
		    	  this.messcrew.authStatus = false;
		    	  bitsdatabase.shutdownDB();
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
			   bitsdatabase.shutdownDB();
		   }//end try
		return false;
		
	}
	
	boolean doMessAdminLogin(String uname, String password, String messName) {

		try{
			this.checkusr = uname;
			this.checkpass = password;			
			boolean flag1 = false;
			bitsdatabase.setupDB();
		      
		      String sqlu = "SELECT uname FROM " + messName + "MessAdmin WHERE uname = '" + uname + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlu);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    	  	this.messadmin.uName = bitsdatabase.resultset.getString("uname");
		    		  flag1 = true;
		      }
		      
		      //Check user
		      if(flag1 == true && this.messadmin.uName.equalsIgnoreCase(checkusr)) {
		    	  System.out.println("Admin Username Matched.");
		    	  try{
		    		  boolean flag2 = false;
		    		  bitsdatabase.setupDB();
				      
				      String sqlp = "SELECT password FROM " + messName + "MessAdmin WHERE uname = '" + uname + "'";
				      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlp);
				      
				      while(bitsdatabase.resultset.next()){
				    		  //Retrieve by column name
				    	  	this.messadmin.password = bitsdatabase.resultset.getString("password");
				    		  flag2 = true;
				      }
				      if(flag2 == true && this.messadmin.password.equals(checkpass)) {
				    	  System.out.println("Password Matched. Logged In.");
				    	  this.messadmin.authStatus = true;
				    	  bitsdatabase.shutdownDB();
				    	  return true;
				      }
				      else {
				    	  System.out.println("Login Failed. Incorrect password.");
				    	  this.messadmin.authStatus = false;
				    	  bitsdatabase.shutdownDB();
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
	      			bitsdatabase.shutdownDB();
	      		   }
		      }
		      else{
		    	  System.out.println("Login Failed. Username not found.");
		    	  this.messadmin.authStatus = false;
		    	  bitsdatabase.shutdownDB();
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
			   bitsdatabase.shutdownDB();
		   }//end try
		return false;
		
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
