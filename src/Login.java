package src;

import java.sql.SQLException;

/**
 * 
 * @author Siddhant
 *
 */
public class Login {
	
	Student student;
	Guest guest;
	MessAdmin messadmin;
	
	BitsDatabase bitsdatabase;
	
	String checkusr;
	String checkpass;
	
	public Login() {
		student = new Student();
		guest = new Guest();
		messadmin = new MessAdmin();
		bitsdatabase = new BitsDatabase("root","J0llYS1D");
		checkusr = "";
		checkpass = "";
	}
	
	boolean doStudentLogin(String idNumber, String password) {
		this.checkusr = idNumber;
		this.checkpass = password;
		
		boolean match = false;
		try{
			bitsdatabase.setupStudentDB();
		      
		      String sqlu = "SELECT idno FROM Students WHERE IDNO = '" + idNumber + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlu);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    	  	this.student.idNumber = bitsdatabase.resultset.getString("idno");
		    		  match = true;
		      }
		      
		      //Check user
		      if(match == true && this.student.idNumber.equalsIgnoreCase(checkusr)) {
		    	  System.out.println("Student Username Matched.");
		    	  try{
		    		  bitsdatabase.setupStudentDB();
				      
				      String sqlp = "SELECT password FROM Students WHERE IDNO = '" + idNumber + "'";
				      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sqlp);
				      
				      while(bitsdatabase.resultset.next()){
				    		  //Retrieve by column name
				    	  	this.student.password = bitsdatabase.resultset.getString("password");
				    		  match = true;
				      }
				      if(match == true && this.student.password.equals(checkpass)) {
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
			bitsdatabase.setupStudentDB(); 
			this.student.hasEaten = this.student.getHasEaten(idNumber);			
			
			bitsdatabase.setupStudentDB();
			this.student.mess.messName = this.student.getMessChosen(idNumber);
			
			if(!this.student.mess.messName.equals(messName) || this.student.hasEaten == true) {
				student.checkinStatus = false;
				System.out.println("Checkin Failed.");
				return false;
			}
			else {
				student.checkinStatus = true;
				System.out.println("Checkin Successful.");
				bitsdatabase.setupStudentDB();				
				this.student.setHasEaten(true,idNumber);
				return true;
			}			
	}
	
	boolean doGuestCheckIn(String name) {
		this.guest.name = name;	
		try{
			bitsdatabase.setupGuestDB();
			
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
