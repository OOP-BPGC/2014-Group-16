package src;


import java.sql.*;

/**
 * 
 * @author Abhinav
 *
 */
//Database Structure
//breakfast - Continental/Indian(main course), milk/egg (side), tea/coffee (beverage)
	// lunch - (salad), veg/non-veg (main course type), (main course), (rice), roti/naan (bread), (beverage), (sweet)
	// snack - (main course), (beverage)
	// dinner - (salad), veg/non-veg (main course type), (main course), (rice), roti/naan (bread), (beverage), (sweet)

public class MessMenu {
	public int TOTAL_STUDENTS;
	private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet rs = null;
	 public MessMenu(){
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
	
	
	
	void setMenu(int day, int meal, String newMenu) throws SQLException{
		try{
		connect=connect();
		statement=connect.createStatement();
		statement.executeUpdate("insert into messMenu values(day, meal,'"+newMenu+"');");
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
	
	
	
	String getMenu(int day, int meal) throws Exception{
		 String menu=null;
		try{
		connect=connect();
		statement=connect.createStatement();
		rs=statement.executeQuery("select count(*) from messMenu;");
		
		 String sql = "SELECT Day, Meal, Menu FROM messMenu";
	      ResultSet rs = statement.executeQuery(sql);
	      while(rs.next()){
	          int d = rs.getInt("Day");
	          int m = rs.getInt("meal");
	          	if (d==day && m==meal){
	          menu = rs.getString("menu");
	          System.out.print("today's menu: " + menu);
	          }  	
	          	rs.close();
	       }}
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
		return menu;}
	
}
	
	
	

