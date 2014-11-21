package src;

import java.sql.SQLException;

public class MessCrew {
	
	BitsDatabase bitsdatabase;
	Mess mess;
	
	long getFoodLots(String item) {
		boolean got = false;
		long l = 0;
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT lots FROM " + this.mess.messName + "FoodStocks WHERE name = '" + item + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  l = bitsdatabase.resultset.getLong("lots");
	    		  got = true;
		      }
	      		
		      if(got == false) {
	      			System.out.println("Unable to get lots. Illegal Parameters.");
	      			bitsdatabase.shutdownDB();
	      			return l;
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
		      
		return l;
	}
	
	void setFoodLots(String item, long lots) {
		try{  
			//Execute Query
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE " + this.mess.messName + "FoodStocks SET lots = '" + String.valueOf(lots) + "'" + " WHERE name = '" + item + "'";
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
}
