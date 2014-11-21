package src;

import java.sql.SQLException;

public class Mess {
	String messName;
	String contractorName;
	String TOTAL_CAPACITY;
	
	String[] breakfast_time;
	String[] lunch_time;
	String[] snack_time; 
	String[] dinner_time;
	
	long breakfastPrice;
	long lunchPrice;
	long snackPrice;
	long dinnerPrice;
	long daycost = breakfastPrice + lunchPrice + snackPrice + dinnerPrice;
	
	long adminPayGrade;
	long chefPayGrade;
	long workerPayGrade;
	
	Accounts account;
	MessMenu menu;
	BitsDatabase bitsdatabase;
	
	
	public Mess() {
		messName = "";
		contractorName = "";
		breakfast_time = new String[] {"0700", "0930"};
		lunch_time = new String[] {"1200", "1430"};
	    snack_time = new String[] {"1630", "1730"};
	    dinner_time = new String[] {"1930", "2130"};
	    this.account.totalBalance = 0;
	}
	
	public Mess(String mname) {
		messName = mname;
		contractorName = "";
		breakfast_time = new String[] {"0700", "0930"};
		lunch_time = new String[] {"1200", "1430"};
	    snack_time = new String[] {"1630", "1730"};
	    dinner_time = new String[] {"1930", "2130"};
	    this.account.totalBalance = 0;
	}
	
	/*
	void doMeal(String meal) {
		switch(meal) {
			case "Breakfast": {
				this.account.debit(this.breakfastPrice, this.messName);
				return;
			}
						  
			case "Lunch": {
				this.account.debit(this.lunchPrice, this.messName);
				return;
			}
		
			case "Snacks": {
				this.account.debit(this.snackPrice, this.messName);
				return;		
			}
			
			case "Dinner": {
				this.account.debit(this.dinnerPrice, this.messName);
				return;		
			}
			
			default: {
				System.out.println("Invalid argument to doMeal");
				return;
			}
		}		
	}*/
	
	boolean checkStudentLeaveStatus(String tdate, int srno){
		//Student Table
		//Has Leave Start and Leave End
		// tdate is a string of format ddMMyy
		// If current date lies between Leave Start and Leave End, Student Won't be billed
		//Update Student Checkin method
		
		int cdate = Integer.parseInt(tdate);
		int lstart = 0;
		int lend = 0;
		try{
			bitsdatabase.setupDB();
			
		      String sql1 = "SELECT lstart FROM Students WHERE srno = " + Integer.toString(srno);
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql1);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  lstart = bitsdatabase.resultset.getInt("lstart");
	    		  //got = true;
		      }
		      
		      String sql2 = "SELECT lend FROM Students WHERE srno = " + Integer.toString(srno);
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql2);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  lend = bitsdatabase.resultset.getInt("lstart");
	    		  //got = true;
		      }
		      
		      if(cdate>=lstart && cdate<=lend) {
		    	  return true;
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
		return false;
		
	}
	
	void doStudentBilling() {
		int count = 0;
		String cdate = bitsdatabase.getCurrentDate();
		try{
			bitsdatabase.setupDB();
			
		      String sql = "SELECT count(*) FROM Students";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  count = bitsdatabase.resultset.getInt("count(*)");
	    		  //got = true;
		      }
		      
		      for(int i = 0; i<=count; i++) {
		    	  if(checkStudentLeaveStatus(cdate,i)) {
		    		  continue;
		    	  }
		    	  else{
		    		  this.account.credit(this.daycost,this.messName);
		    	  }
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
	
	//On a specified date
	void doStudentBilling(String tdate) {
		int count = 0;
		try{
			bitsdatabase.setupDB();
			
		      String sql = "SELECT count(*) FROM Students";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  count = bitsdatabase.resultset.getInt("count(*)");
	    		  //got = true;
		      }
		      
		      for(int i = 0; i<=count; i++) {
		    	  if(checkStudentLeaveStatus(tdate,i)) {
		    		  continue;
		    	  }
		    	  else{
		    		  this.account.credit(this.daycost,this.messName);
		    	  }
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
}
