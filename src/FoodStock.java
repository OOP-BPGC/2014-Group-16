package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Abhinav
 *
 */
public class FoodStock {

	private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet rs = null;
	 public FoodStock(){
	  try{
		  final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	  Class.forName(DRIVER_CLASS);
	  }
	  catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
	  }

	Connection connect(){
    // setup the connection with the DB.
	  final String URL = "jdbc:mysql://localhost/MessData";
	  final String USER = "root";
	  final String PASSWORD = "1234";
	  try{
	  connect= DriverManager.getConnection(URL, USER, PASSWORD);
	  }
	  catch(SQLException e){
		  System.out.println("ERROR: Unable to Connect to Database.");  
	  }
	  return connect;
	  }
	
	String[] getFeedStock() throws SQLException{
		
		//String []nul=new String[1];
		try{
		int rows;
		int i=0;
		connect=connect();
		statement=connect.createStatement();
		rs=statement.executeQuery("select count(*) from FoodStock;");
		rs.next();
		rows=rs.getInt("count(*)");
		String []foodstock=new String[(rows)];
		rs=statement.executeQuery("select FoodStock from FoodStock;");
		while(rs.next()){
		foodstock[i]=rs.getString("FoodStock");	
		i++;
		return foodstock;
		}
		connect.close();}
		catch(SQLException  e){
		      e.printStackTrace();
		}
		catch(Exception se){
			se.printStackTrace();
		}
		finally{
			try{
    			if(statement!=null)
    			connect.close();
 }	
		catch(SQLException se){
								}
 	try{
 			if(connect!=null)
 				connect.close();
 	}
 	catch(SQLException se){
 			se.printStackTrace();
 						}
		}
		return null;
	}
	
	public void updateFoodstock(String item, int amount){
		
		try{
			connect=connect();
			statement=connect.createStatement();
			statement.executeUpdate("insert into messMenu values(amount,'"+item+"');");
			connect.close();
		}
			catch(SQLException  e){
			      e.printStackTrace();
			}
			catch(Exception se){
				se.printStackTrace();
			}
			finally{
				try{
	      			if(statement!=null)
	      			connect.close();
	   }	
	  		catch(SQLException se){
	  								}
	   	try{
	   			if(connect!=null)
	   				connect.close();
	   	}
	   	catch(SQLException se){
	   			se.printStackTrace();
	   						}
			}
		
	}
	
}
