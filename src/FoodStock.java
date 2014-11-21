package src;

public class FoodStock {
	BitsDatabase bitsdatabase;
	/*
	long getCurrentLots(String item, String mname) {
			boolean got = false;
			long l = 0;
			try{
				bitsdatabase.setupDB();
			      
			      String sql = "SELECT lots FROM " + mname + "FoodStocks WHERE name = '" + item + "'";
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
		*/
	}
