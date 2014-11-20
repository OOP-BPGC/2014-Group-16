package src;

import java.sql.SQLException;

public class Accounts {
	double totalBalance;
	
	BitsDatabase bitsdatabase;
	
	// Array of credits
	// Array of debits
	
	void credit(double amount, String messName) {
		// add element to credits
		// update total balance
		
		double balance = 0;
		boolean got = false;
		try{  
			  bitsdatabase.setupDB();
			  
		      String sql1 = "SELECT acbal FROM MessInfo WHERE mname = '" + messName + "'";
		      this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql1);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  balance = bitsdatabase.resultset.getDouble("acbal");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Credit Failed.");
		      			bitsdatabase.shutdownDB();
		      		}
		      		
		      	balance += amount;
		      	
		      	String sql2 = "UPDATE MessInfo " + "SET acbal = '" + balance + "'" + " WHERE mname = '" + messName + "'";
			      bitsdatabase.statement.executeUpdate(sql2);
		      		
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
	
	void debit(double amount, String messName) {
		// add element to credits
		// update total balance
		
		double balance = 0;
		boolean got = false;
		try{  
			  bitsdatabase.setupDB();
			  
		      String sql1 = "SELECT acbal FROM MessInfo WHERE messName = '" + messName + "'";
		      this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql1);
		      
		      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  balance = bitsdatabase.resultset.getDouble("acbal");
		    		  got = true;
		      }
		      		if(got == false) {
		      			System.out.println("Credit Failed.");
		      			bitsdatabase.shutdownDB();
		      		}
		      		
		      	balance -= amount;
		      	
		      	String sql2 = "UPDATE MessInfo " + "SET acbal = '" + balance + "'" + " WHERE messName = '" + messName + "'";
			      bitsdatabase.statement.executeUpdate(sql2);
		      		
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
