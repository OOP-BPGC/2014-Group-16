package src;

import java.sql.SQLException;


/**
 * 
 * @author Siddhant
 *
 */
public class MessAdmin {
	
	BitsDatabase bitsdatabase;
	Student student;
	Mess mess;

	 public MessAdmin(String mname) {
		 bitsdatabase = new BitsDatabase();
		 student = new Student();
		 mess = new Mess(mname);
	 }

	 //============================
	 //Student
	 //============================
	 
	 public String getStudentPassword(String idNumber) {
			boolean got = false;
			String password = "";
			try{
				bitsdatabase.setupDB();
			      
			      String sql = "SELECT password FROM Students WHERE IDNO = '" + idNumber + "'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
			    		  //Retrieve by column name
			    		  password = bitsdatabase.resultset.getString("password");
			    		  got = true;
			      }
			      		if(got == false) {
			      			System.out.println("Unable to get password. Student ID not found.");
			      			bitsdatabase.shutdownDB();
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
				   bitsdatabase.shutdownDB();
			   }//end try
			return password;
		}
	 
	//============================
		 //Set methods for Student
		 //============================
	 
	 
		public void setIdNumber(String name, String idNumber) {
			this.student.idNumber = idNumber;
			
			//copy to database
			try{  
				//Execute Query
				bitsdatabase.setupDB();
			      
			      String sql = "UPDATE Students " + "SET idno = '" + idNumber + "'" + " WHERE name = '" + name + "'";
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

		public void setName(String name, String idNumber) {
			this.student.name = name;
			
			//copy to database
					try{  
						//Execute Query
						bitsdatabase.setupDB();
					      
					      String sql = "UPDATE Students " + "SET name = '" + name + "'" + " WHERE id = '" + idNumber + "'";
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
	
	
	//============================
	//Set methods for MessMenu
	//============================
	void setBreakfast(String day, String messName, String[] meal) {
		
		 try{  
			    if (meal.length != 6)
					throw new Exception(); //make custom
				//Execute Query
			    bitsdatabase.setupDB();
			      
			      String sql = "UPDATE " + messName + "MessMenu SET  mctype = " + meal[0] + ", mc = " + meal[1] + ", side = " + meal[2] + ", salad = " + meal[3] + ", beverage = " + meal[4] + ", sweet = " + meal[5] + " " + " WHERE meal = 'Breakfast" + day + "'";
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
	
	void setLunch(String day, String messName, String[] meal)  {
		 
		 try{  
			    if (meal.length != 6)
					throw new Exception(); //make custom
				//Execute Query
			    bitsdatabase.setupDB();
			      
			      String sql = "UPDATE " + messName + "MessMenu SET  mctype = " + meal[0] + ", mc = " + meal[1] + ", side = " + meal[2] + ", salad = " + meal[3] + ", beverage = " + meal[4] + ", sweet = " + meal[5] + " " + " WHERE meal = 'Lunch" + day + "'";
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
	 
	 void setDinner(String day, String messName, String[] meal)  {
		 
		 try{  
			    if (meal.length != 6)
					throw new Exception(); //make custom
				//Execute Query
			    	bitsdatabase.setupDB();
			      
			      String sql = "UPDATE " + messName + "MessMenu SET  mctype = " + meal[0] + ", mc = " + meal[1] + ", side = " + meal[2] + ", salad = " + meal[3] + ", beverage = " + meal[4] + ", sweet = " + meal[5] + " " + " WHERE meal = 'Dinner" + day + "'";
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
	 
	 void setMealItem(String day, String meal, String messName, String type, String item) {
		 try{  
			 bitsdatabase.setupDB();
			 
			 String sql = "UPDATE " + messName + "MessMenu SET " + type + "= " + item + "WHERE meal = " + "'" + meal + day + "'";
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
	 
	 //=========================
	 //Mess
	 //=========================
	 
	 double getAccountBalance(String mname){
		 double balance = 0;
		 boolean got = false;
			try{  
				  bitsdatabase.setupDB();
			      String sql = "SELECT acbal FROM MessInfo WHERE mname = '" + mname + "'";
			      this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
			    		  //Retrieve by column name
			    		  this.mess.account.totalBalance = bitsdatabase.resultset.getDouble("acbal");
			    		  balance = this.mess.account.totalBalance;
			    		  got = true;
			      }
			      		if(got == false) {
			      			System.out.println("Failed. Mess Name not found.");
			      			bitsdatabase.shutdownDB();
			      			return 0;
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
			   }//end try
			
			return balance;		
		}
	 
	 
	 public void setMessName(String mname) {
			
			//copy to database
					try{  
						//Execute Query
						bitsdatabase.setupDB();
					      
					      String sql = "UPDATE MessInfo " + "SET mname = '" + mname + "'" + " WHERE mname = '" + this.mess.messName + "'";
					      bitsdatabase.statement.executeUpdate(sql);
					      
					      this.mess.messName = mname;
					      
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
	 
	 public void setMessContractorName(String cname) {
			
			//copy to database
					try{  
						//Execute Query
						bitsdatabase.setupDB();
					      
					      String sql = "UPDATE MessInfo " + "SET cname = '" + cname + "'" + " WHERE mname = '" + this.mess.messName + "'";
					      bitsdatabase.statement.executeUpdate(sql);
					      
					      this.mess.contractorName = cname;
					      
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
	
	 public void setAccountBalance(double amount) {
			this.mess.account.totalBalance = amount;
			
			//copy to database
					try{  
						//Execute Query
						bitsdatabase.setupDB();
					      
					      String sql = "UPDATE MessInfo " + "SET acbal = '" + amount + "'" + " WHERE mname = '" + this.mess.messName + "'";
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
	 
	 void setMessTimings(String bstart, String bend, String lstart, String lend, String sstart, String send, String dstart, String dend) {
			this.mess.breakfast_time = new String[] {bstart, bend};
			this.mess.lunch_time = new String[] {lstart, lend};
			this.mess.snack_time = new String[] {sstart, send};
			this.mess.dinner_time = new String[] {dstart, dend};
		}
	 
	 void setMessRates(long bfast, long lunch, long snacks, long dinner) {
		 this.mess.breakfastPrice = bfast;
		 this.mess.lunchPrice = lunch;
		 this.mess.snackPrice = snacks;
		 this.mess.dinnerPrice = dinner;
	 }
	 
	 
	 //=========================
	 // Student Feedback
	 //=========================
		
	 String[] getStudentFeedback() throws SQLException{
			int rows = 0;
			int i=0;
			boolean flag = false;

			try {
				bitsdatabase.setupDB();
				String sql = "SELECT srno FROM StudentFeedback";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
				while(bitsdatabase.resultset.next()){
			   		  //Retrieve by column name
			   		  rows = bitsdatabase.resultset.getInt("srno");
			   		  flag = true;
				}
				
				if (rows<=0) {
					System.out.println("No feedback available.");
					bitsdatabase.shutdownDB();
					return null;
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
			}//end try
			
			String [] comments =new String[(rows)];
			flag = false;
			
			try{
				String sql1 = "SELECT comments FROM StudentFeedback WHERE srno = 1";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql1);
				;
				while(bitsdatabase.resultset.next()){
					comments[i]=bitsdatabase.resultset.getString("Feedback");	
					i++;
					flag = true;
				}
				
				if(flag == false) {
	      			System.out.println("Failed. Could not get Feedback.");
	      			bitsdatabase.shutdownDB();
	      			return null;
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
			}//end try
			return comments;
		}
		
		String getStudentFeedback(int srno) {
			String comments = "";
			try {
				int ctot=0;
				boolean flag = false;
				bitsdatabase.setupDB();
				String sql = "SELECT srno FROM StudentFeedback";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
				
				while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  ctot = bitsdatabase.resultset.getInt("srno");
		    		  //got = true;
				}
				
				if(srno<=ctot) {
					sql = "SELECT comments FROM StudentFeedback WHERE srno = '" + srno + "'";
					this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
					
					while(bitsdatabase.resultset.next()){
			    		  //Retrieve by column name
			    		  comments = bitsdatabase.resultset.getString("comments");
			    		  flag = true;
					}
					
					if(flag == false) {
		      			System.out.println("Failed to get Feedback"); //throw custom exception
		      			bitsdatabase.shutdownDB();
		      			return "";
		      		}					
					}
					else{
						System.out.println("Error. The Student Feedback Database has fewer than " + srno + "entries");
						//throw new ArrayIndexOutOfBoundsException();
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
					bitsdatabase.shutdownDB();
				}//end try
			return comments;
		}
		
		void clearStudentFeedback() throws SQLException{
			try {
				bitsdatabase.setupDB();
				String sql = "TRUNCATE table StudentFeedback";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);	
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
		
		 //=========================
		 // Guest Feedback
		 //=========================
		
		String[] getGuestFeedback() throws SQLException{
			int rows = 0;
			int i=0;
			boolean flag = false;

			try {
				bitsdatabase.setupDB();
				String sql = "SELECT srno FROM GuestFeedback";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
				while(bitsdatabase.resultset.next()){
			   		  //Retrieve by column name
			   		  rows = bitsdatabase.resultset.getInt("srno");
			   		  flag = true;
				}
				
				if (rows<=0) {
					System.out.println("No feedback available.");
					bitsdatabase.shutdownDB();
					return null;
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
			}//end try
			
			String [] comments =new String[(rows)];
			flag = false;
			
			try{
				String sql1 = "SELECT comments FROM GuestFeedback WHERE srno = 1";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql1);
				;
				while(bitsdatabase.resultset.next()){
					comments[i]=bitsdatabase.resultset.getString("Feedback");	
					i++;
					flag = true;
				}
				
				if(flag == false) {
	      			System.out.println("Failed. Could not get Feedback.");
	      			bitsdatabase.shutdownDB();
	      			return null;
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
			}//end try
			return comments;
		}
		
		String getGuestFeedback(int srno) {
			String comments = "";
			try {
				int ctot=0;
				boolean flag = false;
				bitsdatabase.setupDB();
				String sql = "SELECT srno FROM GuestFeedback";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
				
				while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  ctot = bitsdatabase.resultset.getInt("srno");
		    		  //got = true;
				}
				
				if(srno<=ctot) {
					sql = "SELECT comments FROM GuestFeedback WHERE srno = '" + srno + "'";
					this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);
					
					while(bitsdatabase.resultset.next()){
			    		  //Retrieve by column name
			    		  comments = bitsdatabase.resultset.getString("comments");
			    		  flag = true;
					}
					
					if(flag == false) {
		      			System.out.println("Failed to get Feedback"); //throw custom exception
		      			bitsdatabase.shutdownDB();
		      			return "";
		      		}					
					}
					else{
						System.out.println("Error. The Student Feedback Database has fewer than " + srno + "entries");
						//throw new ArrayIndexOutOfBoundsException();
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
					bitsdatabase.shutdownDB();
				}//end try
			return comments;
		}
		
		void clearGuestFeedback() throws SQLException{
			try {
				bitsdatabase.setupDB();
				String sql = "TRUNCATE table GuestFeedback";
				this.bitsdatabase.resultset = this.bitsdatabase.statement.executeQuery(sql);	
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
		
		/*
		//=======================
		//FoodStock
		//=======================
		
		void setLotPrice(String item) {
			
		}
		*/
}
