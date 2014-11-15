package src;

import java.sql.SQLException;


/**
 * 
 * @author Siddhant
 *
 */
public class MessAdmin implements MessEmployee{
	
	BitsDatabase bitsdatabase;
	Student student;
	Mess mess;

	 public MessAdmin() {
		 bitsdatabase = new BitsDatabase();
		 student = new Student();
		 mess = new Mess();
	 }
	 
	 //============================
	 //Set methods for Student
	 //============================
		public void setIdNumber(String name, String idNumber) {
			this.student.idNumber = idNumber;
			
			//copy to database
			try{  
				//Execute Query
				bitsdatabase.setupStudentDB();
			      
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
						bitsdatabase.setupStudentDB();
					      
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
		
		public void setMessChosen(String mess) {
			this.student.mess.messName = mess;
			
			//copy to database
					try{  
						//Execute Query
						bitsdatabase.setupStudentDB();
					      
					      String sql = "UPDATE Students " + "SET mess = '" + mess + "'" + " WHERE id = '" + student.idNumber + "'";
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
			    bitsdatabase.setupMessDB(messName);
			      
			      String sql = "UPDATE MessMenu" + day + " SET  mctype = " + meal[0] + ", mc = " + meal[1] + ", side = " + meal[2] + ", salad = " + meal[3] + ", beverage = " + meal[4] + ", sweet = " + meal[5] + " " + " WHERE meal = 'Breakfast'";
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
			    bitsdatabase.setupMessDB(messName);
			      
			      String sql = "UPDATE MessMenu" + day + " SET  mctype = " + meal[0] + ", mc = " + meal[1] + ", side = " + meal[2] + ", salad = " + meal[3] + ", beverage = " + meal[4] + ", sweet = " + meal[5] + " " + " WHERE meal = 'Lunch'";
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
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "UPDATE MessMenu" + day + " SET  mctype = " + meal[0] + ", mc = " + meal[1] + ", side = " + meal[2] + ", salad = " + meal[3] + ", beverage = " + meal[4] + ", sweet = " + meal[5] + " " + " WHERE meal = 'Dinner'";
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
	 
	 void setMealItem(String day, String meal, String messName, String type, String set) {
		 try{  
			 bitsdatabase.setupMessDB(messName);
			 
			 String sql = "UPDATE MessMenu" + day + " SET " + type + "= " + set + "WHERE meal = " + "'" + meal + "'";
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
	 //Set for Mess
	 //=========================
	 
	 void setMessTimings(String bstart, String bend, String lstart, String lend, String sstart, String send, String dstart, String dend) {
			mess.breakfast_time = new String[] {bstart, bend};
			mess.lunch_time = new String[] {lstart, lend};
			mess.snack_time = new String[] {sstart, send};
			mess.dinner_time = new String[] {dstart, dend};
		}
		

}
