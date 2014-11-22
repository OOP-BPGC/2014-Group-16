package project;

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
	double Dues;
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
	public Student(String id){
		this.idNumber = id;
		this.name = "";
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
		      
		      String sql = "SELECT idno FROM student WHERE name = '" + name + "'";
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
	public double getDues(String idNumber){	 
		 		boolean got = false; 
				try{   
					  bitsdatabase.setupDB(); 
				      String sql = "SELECT dues FROM Student WHERE ID = '" + idNumber + "'"; 
				      this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql); 
				       
				      while(bitsdatabase.resultset.next()){ 
				    		  //Retrieve by column name 
			    		  this.account.totalBalance = bitsdatabase.resultset.getDouble("dues"); 
				    		  got = true; 
				      } 
				      		if(got == false) { 
				      			System.out.println("Failed. Student ID not found."); 
				      			bitsdatabase.shutdownDB(); 
				      			return 0; 
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
					  		 
					 		return this.account.totalBalance;		 
					 	} 
	public String getIdNumber(int srno) {
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT id FROM Student WHERE srno = '" + srno + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  this.idNumber = bitsdatabase.resultset.getString("id");
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
		      
		      String sql = "SELECT name FROM Student WHERE ID = '" + idNumber + "'";
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
		      
		      String sql = "SELECT mess FROM student WHERE ID = '" + idNumber + "'";
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
		      String sql = "SELECT haseaten FROM student WHERE ID = '" + idNumber + "'";
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
		      
		      String sql = "SELECT password FROM student WHERE ID = '" + idNumber + "'";
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
		      
		      String sql = "UPDATE student " + "SET password = '" + pswd + "'" + " WHERE id = '" + idNumber + "'";
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
				      
				      String sql = "UPDATE student " + "SET haseaten = " + status + "" + " WHERE id = '" + idNumber + "'";
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
	
	public void Feedback(String comments, boolean anonymous) throws SQLException {
	if(anonymous)
	Feedback.addStudentFeedback(comments,null);	
	else
	Feedback.addStudentFeedback(comments,this.getName(idNumber));
	
	}
	
}
