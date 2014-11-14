package src;

import java.sql.*;

public class Student implements MessCustomer{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String STUDENT_DB_URL = "jdbc:mysql://localhost/Students";

	String name;
	static String password;
	String idNumber;
	final String username = idNumber;
	boolean hasEaten;
	Mess mess = new Mess();
	Accounts account;
	Feedback feedback;
	boolean authStatus;
	boolean checkinStatus;
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	public Student() {
		this.name = "";
		this.idNumber = "";
		this.hasEaten = false;
	}
	
	public String getIdNumber(String name) {
		boolean got = false;
		try{
		      statement = connection.createStatement();
		      
		      String sql = "SELECT idno FROM Students WHERE name = '" + name + "'";
		      resultset = statement.executeQuery(sql);
		      
		      while(resultset.next()){
	    		  //Retrieve by column name
	    		  this.idNumber = resultset.getString("idno");
	    		  got = true;
		      }
	      		
		      if(got == false) {
	      			System.out.println("Failed. Student Name not found.");
	    		  	shutdowndb();
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
		    	  shutdowndb();
		   }
		      
		return this.idNumber;
	}
	
	public String getName(String idNumber) {
		boolean got = false;
		try{
		      statement = connection.createStatement();
		      
		      String sql = "SELECT name FROM Students WHERE IDNO = '" + idNumber + "'";
		      resultset = statement.executeQuery(sql);
		      
		      while(resultset.next()){
	    		  //Retrieve by column name
	    		  this.name = resultset.getString("name");
	    		  got = true;
		      }
	      		
		      if(got == false) {
	      			System.out.println("Failed. Student ID not found.");
	    		  	shutdowndb();
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
		    	  shutdowndb();
		   }
		      
		return this.name;
	}
	
	public boolean getHasEaten(String idNumber){	
		boolean got = false;
		try{
		      statement = connection.createStatement();
		      
		      String sql = "SELECT haseaten FROM Students WHERE IDNO = '" + idNumber + "'";
		      resultset = statement.executeQuery(sql);
		      
		      while(resultset.next()){
		    		  //Retrieve by column name
		    		  this.hasEaten = resultset.getBoolean("haseaten");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Failed. Student ID not found.");
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
		
		return this.hasEaten;		
	}
	
	public String getMessChosen(String idNumber) {
		boolean got = false;
		try{
		      statement = connection.createStatement();
		      
		      String sql = "SELECT mess FROM Students WHERE IDNO = '" + idNumber + "'";
		      resultset = statement.executeQuery(sql);
		      
		      while(resultset.next()){
		    		  //Retrieve by column name
		    		  this.mess.messName = resultset.getString("mess");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Failed. Student ID not found.");
		    		  	shutdowndb();
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
		    	  shutdowndb();
		   }//end try
		
		return this.mess.messName;		
	}
	
	public void setHasEaten(boolean status, String idNumber) {
		this.hasEaten = status;
		
		//copy to database
				try{  
					//Execute Query
				      statement = connection.createStatement();
				      
				      String sql = "UPDATE Students " + "SET haseaten = '" + String.valueOf(hasEaten) + "'" + " WHERE id = '" + idNumber + "'";
				      statement.executeUpdate(sql);
				      
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
		
	}
	
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
		
		//copy to database
		try{  
			//Execute Query
		      statement = connection.createStatement();
		      
		      String sql = "UPDATE Students " + "SET idno = '" + idNumber + "'" + " WHERE id = '" + idNumber + "'";
		      statement.executeUpdate(sql);
		      
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
	}

	public void setName(String name, String idNumber) {
		this.name = name;
		
		//copy to database
				try{  
					//Execute Query
				      statement = connection.createStatement();
				      
				      String sql = "UPDATE Students " + "SET name = '" + name + "'" + " WHERE id = '" + idNumber + "'";
				      statement.executeUpdate(sql);
				      
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
		
	}
	
	public void setMessChosen(String mess) {
		this.mess.messName = mess;
		
		//copy to database
				try{  
					//Execute Query
				      statement = connection.createStatement();
				      
				      String sql = "UPDATE Students " + "SET mess = '" + mess + "'" + " WHERE id = '" + idNumber + "'";
				      statement.executeUpdate(sql);
				      
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
	}	
	
	public void giveFeedback(String feedback) {
		try {
			Feedback.giveFeedback(feedback);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void shutdowndb() {
		try{
			if(connection!=null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	
}
