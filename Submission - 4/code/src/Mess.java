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
	
	double adminPay;
	double messcrewPay;
	
	Accounts account;
	MessMenu menu;
	Student student;
	MessCrew messcrew;
	MessAdmin messadmin;
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
	
	void setStudentDues(String idno, double dues) {
		this.student.dues = dues;
		
		try{  
			//Execute Query
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE Students " + "SET dues = '" + dues + "'" + " WHERE id = '" + idno + "'";
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
	
	void addStudentDues(String idno, double dues) {
		double cdues = this.student.getDues(idno);
		cdues += dues;
		setStudentDues(idno, cdues);
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
		    		  addStudentDues(this.student.getIdNumber(i),this.daycost);
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
		    		  addStudentDues(this.student.getIdNumber(i),this.daycost);
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
	
	//
	//MessCrew
	//
	
	boolean checkMessCrewLeaveStatus(String tdate, int srno, String messName){
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
			
		      String sql1 = "SELECT lstart FROM " + messName + "MessCrew WHERE srno = " + Integer.toString(srno);
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql1);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  lstart = bitsdatabase.resultset.getInt("lstart");
	    		  //got = true;
		      }
		      
		      String sql2 = "SELECT lend FROM " + messName + "MessCrew WHERE srno = " + Integer.toString(srno);
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
	
	void setMessCrewBalance(String uname, double acbal) {
		this.messcrew.account.totalBalance = acbal;
		
		try{  
			//Execute Query
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE " + this.messName + "MessCrew SET acbal = '" + acbal + "'" + " WHERE uname = '" + uname + "'";
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
	
	void addMessCrewPay(String uname, double pay) {
		double cbal = this.messcrew.getAccountBalance(uname);
		cbal += pay;
		setMessCrewBalance(uname, cbal);
	}
	
	void doMessCrewPayment() {
		int count = 0;
		String cdate = bitsdatabase.getCurrentDate();
		try{
			bitsdatabase.setupDB();
			
		      String sql = "SELECT count(*) FROM " + this.messName + "MessCrew";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  count = bitsdatabase.resultset.getInt("count(*)");
	    		  //got = true;
		      }
		      
		      for(int i = 0; i<=count; i++) {
		    	  if(checkMessCrewLeaveStatus(cdate,i,this.messName)) {
		    		  continue;
		    	  }
		    	  else{
		    		  this.account.debit(this.messcrewPay,this.messName);
		    		  addMessCrewPay(this.messcrew.getUsername(i),(double) this.daycost);
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
	
	void doMessCrewPayment(String tdate) {
		int count = 0;
		try{
			bitsdatabase.setupDB();
			
		      String sql = "SELECT count(*) FROM " + this.messName + "MessCrew";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  count = bitsdatabase.resultset.getInt("count(*)");
	    		  //got = true;
		      }
		      
		      for(int i = 0; i<=count; i++) {
		    	  if(checkMessCrewLeaveStatus(tdate,i,this.messName)) {
		    		  continue;
		    	  }
		    	  else{
		    		  this.account.debit(this.messcrewPay,this.messName);
		    		  addMessCrewPay(this.messcrew.getUsername(i),(double) this.daycost);
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
	
	//
	//MessAdmin
	//
	
	boolean checkMessAdminLeaveStatus(String tdate, int srno, String messName){
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
			
		      String sql1 = "SELECT lstart FROM " + messName + "MessAdmin WHERE srno = " + Integer.toString(srno);
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql1);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  lstart = bitsdatabase.resultset.getInt("lstart");
	    		  //got = true;
		      }
		      
		      String sql2 = "SELECT lend FROM " + messName + "MessAdmin WHERE srno = " + Integer.toString(srno);
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
	
	void setMessAdminBalance(String uname, double acbal) {
		this.messadmin.account.totalBalance = acbal;
		
		try{  
			//Execute Query
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE " + this.messName + "MessAdmin SET acbal = '" + acbal + "'" + " WHERE uname = '" + uname + "'";
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
	
	void addMessAdminPay(String uname, double pay) {
		double cbal = this.messadmin.getAccountBalance(uname);
		cbal += pay;
		setMessAdminBalance(uname, cbal);
	}
	
	void doMessAdminPayment() {
		int count = 0;
		String cdate = bitsdatabase.getCurrentDate();
		try{
			bitsdatabase.setupDB();
			
		      String sql = "SELECT count(*) FROM " + this.messName + "MessAdmin";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  count = bitsdatabase.resultset.getInt("count(*)");
	    		  //got = true;
		      }
		      
		      for(int i = 0; i<=count; i++) {
		    	  if(checkMessAdminLeaveStatus(cdate,i,this.messName)) {
		    		  continue;
		    	  }
		    	  else{
		    		  this.account.debit(this.adminPay,this.messName);
		    		  addMessAdminPay(this.messadmin.getUsername(i),(double) this.daycost);
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
	
	void doMessAdminPayment(String tdate) {
		int count = 0;
		try{
			bitsdatabase.setupDB();
			
		      String sql = "SELECT count(*) FROM " + this.messName + "MessAdmin";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  count = bitsdatabase.resultset.getInt("count(*)");
	    		  //got = true;
		      }
		      
		      for(int i = 0; i<=count; i++) {
		    	  if(checkMessAdminLeaveStatus(tdate,i,this.messName)) {
		    		  continue;
		    	  }
		    	  else{
		    		  this.account.debit(this.adminPay,this.messName);
		    		  addMessCrewPay(this.messadmin.getUsername(i),(double) this.daycost);
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
