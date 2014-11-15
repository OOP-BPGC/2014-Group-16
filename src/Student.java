package src;

import java.sql.*;
/**
 * 
 * @author Siddhant
 *
 */
public class Student {

	String name;
	String password;
	String idNumber;
	final String username = idNumber;
	
	boolean hasEaten;
	
	Mess mess;
	Accounts account;
	Feedback feedback;
	BitsDatabase bitsdatabase;
	
	boolean authStatus;
	boolean checkinStatus;
	
	
	public Student() {
		this.name = "";
		this.idNumber = "";
		this.hasEaten = false;
		this.authStatus = false;
		this.checkinStatus = false;
		mess = new Mess();
		bitsdatabase = new BitsDatabase();
	}
	
	public String getIdNumber(String name) {
		boolean got = false;
		try{
			bitsdatabase.setupStudentDB();
		      
		      String sql = "SELECT idno FROM Students WHERE name = '" + name + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  this.idNumber = bitsdatabase.resultset.getString("idno");
	    		  got = true;
		      }
	      		
		      if(got == false) {
	      			System.out.println("Unable to get ID. Student Name not found.");
	      			bitsdatabase.shutdownDB();
	      			return "";
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
		      
		return this.idNumber;
	}
	
	public String getName(String idNumber) {
		boolean got = false;
		try{
			bitsdatabase.setupStudentDB();
		      
		      String sql = "SELECT name FROM Students WHERE IDNO = '" + idNumber + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  this.name = bitsdatabase.resultset.getString("name");
	    		  got = true;
		      }
	      		
		      if(got == false) {
	      			System.out.println("Unable to get name. Student ID not found.");
	      			bitsdatabase.shutdownDB();
	      			return "";
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
		      
		return this.name;
	}
	
	public String getMessChosen(String idNumber) {
		boolean got = false;
		try{
			bitsdatabase.setupStudentDB();
		      
		      String sql = "SELECT mess FROM Students WHERE IDNO = '" + idNumber + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  this.mess.messName = bitsdatabase.resultset.getString("mess");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Unable to get Mess. Student ID not found.");
		      			bitsdatabase.shutdownDB();
		      			return "";
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
		
		return this.mess.messName;		
	}
	
	public boolean getHasEaten(String idNumber){	
		boolean got = false;
		try{  
			  bitsdatabase.setupStudentDB();
		      String sql = "SELECT haseaten FROM Students WHERE IDNO = '" + idNumber + "'";
		      this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  this.hasEaten = bitsdatabase.resultset.getBoolean("haseaten");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Failed. Student ID not found.");
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
		
		return this.hasEaten;		
	}
	
	public String getPassword(String idNumber) {
		boolean got = false;
		try{
			bitsdatabase.setupStudentDB();
		      
		      String sql = "SELECT password FROM Students WHERE IDNO = '" + idNumber + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  password = bitsdatabase.resultset.getString("password");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Unable to get password. Student ID not found.");
		      			bitsdatabase.shutdownDB();
		      			return "";
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
		return password;
	}
	
	//==========
	//Set Methods
	//==========
	public void setPassword(String pswd, String idNumber) {
		this.password = pswd;
		
		//copy to database
		try{  
			//Execute Query
			bitsdatabase.setupStudentDB();
		      
		      String sql = "UPDATE Students " + "SET password = '" + pswd + "'" + " WHERE id = '" + idNumber + "'";
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
			}//end try   
		
	}
	
	public void setHasEaten(boolean status, String idNumber) {
		this.hasEaten = status;
		
		//copy to database
				try{  
					//Execute Query
					bitsdatabase.setupStudentDB();
				      
				      String sql = "UPDATE Students " + "SET haseaten = '" + String.valueOf(status) + "'" + " WHERE id = '" + idNumber + "'";
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
					}//end try   
		
	}	
	
	public void giveFeedback(String comments, boolean anonymous) {
		
		if(anonymous==true)
			feedback.addStudentFeedback("",comments);
		else
			feedback.addStudentFeedback(this.name,comments);
	}	
	
	
	
}
