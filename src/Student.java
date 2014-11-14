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
	Mess mess;
	Accounts account;
	Feedback feedback;
	boolean authStatus;
	boolean checkinStatus;
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	public Student(String idNumber) {
		this.setIdNumber(idNumber);
		//get other details from database
		
		//STEP1: CONNECT TO DATABASE
		try{
		      //Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
		      //System.out.println("Connecting to a selected database...");
		      connection = DriverManager.getConnection(STUDENT_DB_URL, username, password);
		      //System.out.println("Connected database successfully...");
		      
		    //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      statement = connection.createStatement();

		      String sql = "SELECT name, mess FROM Students";
		      resultset = statement.executeQuery(sql);
		      
		    //STEP 5: Extract data from result set
		      while(resultset.next()){
		         //Retrieve by column name
		         this.name = resultset.getString("name");
		         this.mess.messName = resultset.getString("mess");
		      }
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	//public Student(String name, String idNumber,) {
		//this.name = name;
		//this.setIdNumber(idNumber);
	//}
	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHasEaten(boolean status, String idNumber) {
		this.hasEaten = status;
		
		//copy to database
				try{  
					//Execute Query
				      statement = connection.createStatement();
				      
				      String sql = "UPDATE Students " + "SET haseaten = " + String.valueOf(hasEaten) + " WHERE id = " + idNumber;
				      resultset = statement.executeQuery(sql);
				      
				      resultset.close();
				      statement.close();
				      connection.close();
					}catch(SQLException se){
						//Handle errors for JDBC
						se.printStackTrace();
					}catch(Exception e){
						//Handle errors for Class.forName
						e.printStackTrace();
					}finally{
						//finally block used to close resources
						try{
							if(connection!=null)
								connection.close();
						}catch(SQLException se){
							se.printStackTrace();
						}//end finally try
					}//end try   
		
	}
	
	public boolean getHasEaten(String idNumber){	
		//STEP1: CONNECT TO DATABASE
		try{
		      statement = connection.createStatement();
		      
		      String sql = "SELECT haseaten FROM Students WHERE id = " + idNumber;
		      resultset = statement.executeQuery(sql);
		      
		      while(resultset.next()){
		         //Retrieve by column name
		         this.hasEaten = resultset.getBoolean("haseaten");
		         connection.close();
		         statement.close();
		         resultset.close();
		      }
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		
		return hasEaten;
		
	}
	
	public void giveFeedback(String feedback) {
		try {
			Feedback.giveFeedback(feedback);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getMessChosen() {
		return mess.messName;
	}
	
	public void setMessChosen(String mess) {
		this.mess.messName = mess;
	}
	
	
	
	
}
