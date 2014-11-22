package project;

import java.sql.SQLException;

public class MessCrew {
	
	BitsDatabase bitsdatabase;
	Mess mess;
	Accounts account;
	
	String name;
	String password;
	static String uName;
	String jobtitle;
	String shifts;
	final String username = uName;
	
	boolean authStatus;
	boolean leaveStatus;
	
	public MessCrew() {
		this.name = "";
		this.uName = ""; //username
		this.authStatus = false;
		this.leaveStatus = false;
		mess = new Mess();
		bitsdatabase = new BitsDatabase();
	}
	void setUsername(String user){
	this.uName=user;	
	}
	public String getUsername(int srno) {
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT uname FROM " + this.mess.messName + "MessCrew WHERE srno = '" + srno + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  this.uName = bitsdatabase.resultset.getString("uname");
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
		      
		return this.uName;
	}
	
	public String getName(String uname) {
		boolean got = false;
		String cname = "";
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT name FROM " +Driver.cusermess+ "MessCrew WHERE uname = '" + uname + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      while(bitsdatabase.resultset.next()){
		    	  
	    		  //Retrieve by column name
	    		  this.name = bitsdatabase.resultset.getString("name");
	    		  got = true;
		      }
		      
		      if(got == false) {
	      			System.out.println("Failed. Username not found.");
	      			bitsdatabase.shutdownDB();
	      			return cname;
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
		 return cname;
	}
	
	public String getMessName(String uname) {
		boolean got = false;
		String cname = "";
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT mess FROM " + this.mess.messName + "MessCrew WHERE uname = '" + uname + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      while(bitsdatabase.resultset.next()){
		    	  
	    		  //Retrieve by column name
	    		  this.mess.messName = bitsdatabase.resultset.getString("mess");
	    		  got = true;
		      }
		      
		      if(got == false) {
	      			System.out.println("Failed. Username not found.");
	      			bitsdatabase.shutdownDB();
	      			return cname;
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
		 return cname;
	}
	
	public String getJobTitle(String uname) {
		boolean got = false;
		String cname = "";
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT job FROM " + Driver.cusermess + "MessCrew WHERE uname = '" + uname + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      while(bitsdatabase.resultset.next()){
		    	  
	    		  //Retrieve by column name
	    		  this.jobtitle = bitsdatabase.resultset.getString("job");
	    		  got = true;
		      }
		      
		      if(got == false) {
	      			System.out.println("Failed. Username not found.");
	      			bitsdatabase.shutdownDB();
	      			return cname;
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
		 return cname;
	}
	
	
	
	public String getShifts(String uname) {
		boolean got = false;
		String cname = "";
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT shifts FROM " +Driver.cusermess + "MessCrew WHERE uname = '" + uname + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      while(bitsdatabase.resultset.next()){
		    	  
	    		  //Retrieve by column name
	    		  this.shifts = bitsdatabase.resultset.getString("shifts");
	    		  got = true;
		      }
		      
		      if(got == false) {
	      			System.out.println("Failed. Username not found.");
	      			bitsdatabase.shutdownDB();
	      			return cname;
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
		 return cname;
	}
	
	public float getAccountBalance(String uname){	
		boolean got = false;
		try{  
			  bitsdatabase.setupDB();
		      String sql = "SELECT acbal FROM "+Driver.cusermess+ "MessCrew WHERE uname = '" + uname + "'";
		      this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
		      
		      
		    	  bitsdatabase.resultset.next();
		    	  //Retrieve by column name
		    		  return bitsdatabase.resultset.getFloat("acbal");
		    		 // got = true;
		      
		      		/*if(got == false) {
		      			System.out.println("Failed. Username not found.");
		      			bitsdatabase.shutdownDB();
		      			return 0;
		      		}*/
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
		return 0.0f;
		//return this.account.totalBalance;		
	}
	
	public long getFoodLots(String item) {
		boolean got = false;
		long l = 0;
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT stock FROM "+Driver.cusermess+ "FoodStock WHERE name = '" + item + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()){
	    		  //Retrieve by column name
	    		  l = bitsdatabase.resultset.getLong("stock");
	    		  got = true;
		      }
	      		
		      if(got == false) {
	      			System.out.println("Unable to get stock. Illegal Parameters.");
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
		
	//
	//Set Methods
	//
	
	void setFoodLots(String item, int lots) {
		try{  
			//Execute Query
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE " + Driver.cusermess + "FoodStock SET stock = '" + String.valueOf(lots) + "'" + " WHERE name = '" + item + "'";
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
	
	public void setPassword(String pswd, String uName) { //Student must have logged in to change password
		if(this.authStatus == false) {
			System.out.println("You must login first.");
			return;
		}
		
		this.password = pswd;
		
		//copy to database
		try{  
			//Execute Query
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE " +Driver.cusermess+ "MessCrew SET password = '" + pswd + "'" + " WHERE id = '" + uName + "'";
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
	
	//
	//Leave
	//
	
	public boolean getLeaveStatus(String uName) {
		boolean got = false;
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "SELECT lstatus FROM " +Driver.cusermess+ "MessCrew WHERE uname='" + uName + "'";
		      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
		      
		      while(bitsdatabase.resultset.next()) {
		    	  this.leaveStatus = bitsdatabase.resultset.getBoolean("status");
		    	  got = true;
		      }
		      
		      if(got == false) {
	      			System.out.println("Unable to get Leave Status. UserName not found.");
	      			bitsdatabase.shutdownDB();
	      			return this.leaveStatus;
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
		 return this.leaveStatus;
	}
	
	public void applyLeave(String lstart, String lend) {
		try{
			bitsdatabase.setupDB();
		      
		      String sql = "UPDATE " +Driver.cusermess+ "MessCrew SET lstart='" + lstart + "', lend='" + lend + "' WHERE uname='" + Driver.cusername + "'";
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
		   }
	}
	
	
}
