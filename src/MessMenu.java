package src;


import java.sql.*;

/**
 * 
 * @author Siddhant
 * Acknowledgements - Abhinav
 *
 */
//Database Structure
//One Database per mess
//Multiple MessMenuxxxxxx Tables for each day in that database where xxxxxx is a day like Monday
//breakfast - Continental/Indian(main course), milk/egg (side), tea/coffee (beverage)
	// lunch - (salad), veg/non-veg (main course type), (main course), rice/roti/naan (side), (beverage), (sweet)
	// snack - (main course), (beverage)
	// dinner - (salad), veg/non-veg (main course type), (main course), (rice,roti/naan (side), (beverage), (sweet)

public class MessMenu {
	
	BitsDatabase bitsdatabase = new BitsDatabase();
	Mess mess = new Mess();
	 
	 String[] getBreakfast(String day, String messName) {
		 day.toUpperCase();
		 String[] meal = new String [6];
		 boolean got = false;
		 
		 try{
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "SELECT mctype, mc, side, salad, beverage, sweet FROM MessMenu" + day + " WHERE meal = 'Breakfast'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  meal[0] = bitsdatabase.resultset.getString("mctype");
		    		  meal[1] = bitsdatabase.resultset.getString("mc");
		    		  meal[2] = bitsdatabase.resultset.getString("side");
		    		  meal[3] = bitsdatabase.resultset.getString("salad");
		    		  meal[4] = bitsdatabase.resultset.getString("beverage");
		    		  meal[5] = bitsdatabase.resultset.getString("sweet");
		    		  got = true;
		    		  //System.out.println("Breakfast " + meal[0] + " " + meal[1] + " " + meal[2] + " " + meal[3] + " " + meal [4] + " " + meal[5]);
			      }
		      		
			      if(got == false) {
		      			System.out.println("Failed to get Breakfast of " + day + " for Mess " + messName);
		      			bitsdatabase.shutdownDB();
		      			return meal;
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
		return meal;
	 }
	 
	 String[] getLunch(String day, String messName) {
		 day.toUpperCase();
		 String[] meal = new String [6];
		 boolean got = false;
		 
		 try{
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "SELECT mctype, mc, side, salad, beverage, sweet FROM MessMenu" + day + " WHERE meal = 'Lunch'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  meal[0] = bitsdatabase.resultset.getString("mctype");
		    		  meal[1] = bitsdatabase.resultset.getString("mc");
		    		  meal[2] = bitsdatabase.resultset.getString("side");
		    		  meal[3] = bitsdatabase.resultset.getString("salad");
		    		  meal[4] = bitsdatabase.resultset.getString("beverage");
		    		  meal[5] = bitsdatabase.resultset.getString("sweet");
		    		  got = true;
			      }
		      		
			      if(got == false) {
		      			System.out.println("Failed to get Lunch of " + day + " for Mess " + messName);
		      			bitsdatabase.shutdownDB();
		      			return meal;
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
		return meal;
	 }
	 
	 String[] getSnacks(String day, String messName) {
		 day.toUpperCase();
		 String[] meal = new String [6];
		 boolean got = false;
		 
		 try{
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "SELECT mctype, mc, side, salad, beverage, sweet FROM MessMenu" + day + " WHERE meal = 'Snacks'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  meal[0] = bitsdatabase.resultset.getString("mctype");
		    		  meal[1] = bitsdatabase.resultset.getString("mc");
		    		  meal[2] = bitsdatabase.resultset.getString("side");
		    		  meal[3] = bitsdatabase.resultset.getString("salad");
		    		  meal[4] = bitsdatabase.resultset.getString("beverage");
		    		  meal[5] = bitsdatabase.resultset.getString("sweet");
		    		  got = true;
			      }
		      		
			      if(got == false) {
		      			System.out.println("Failed to get Snacks of " + day + " for Mess " + messName);
		      			bitsdatabase.shutdownDB();
		      			return meal;
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
		return meal;
	 }
	 
	 String[] getDinner(String day, String messName) {
		 String[] meal = new String [6];
		 day.toUpperCase();
		 boolean got = false;
		 
		 try{
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "SELECT mctype, mc, side, salad, beverage, sweet FROM MessMenu" + day + " WHERE meal = 'Dinner'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  meal[0] = bitsdatabase.resultset.getString("mctype");
		    		  meal[1] = bitsdatabase.resultset.getString("mc");
		    		  meal[2] = bitsdatabase.resultset.getString("side");
		    		  meal[3] = bitsdatabase.resultset.getString("salad");
		    		  meal[4] = bitsdatabase.resultset.getString("beverage");
		    		  meal[5] = bitsdatabase.resultset.getString("sweet");
		    		  got = true;
			      }
		      		
			      if(got == false) {
		      			System.out.println("Failed to get Dinner of " + day + " for Mess " + messName);
		      			bitsdatabase.shutdownDB();
		      			return meal;
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
		return meal;
	 }
	 
	 String getMealItem(String day, String meal, String messName, String type) {
		 String mealitem = "";
		 boolean got = false;
		 
		 try{
				bitsdatabase.setupMessDB(messName);
				String sql = "SELECT " + type + " FROM MessMenu" + day + " WHERE meal = '" + meal + "'";
			    bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			    
			    while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  mealitem = bitsdatabase.resultset.getString(type);
		    		  got = true;
			      }
			    
			    if(got == false) {
	      			System.out.println("Failed to get " + meal + " of " + day + " for Mess " + messName); //throw custom exception here
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
		   }
		 return mealitem;
	 }
	 
	 String[] getCurrentMeal(String messName) {
		 String[] meal = new String [6];
		 boolean got = false;
		 
		 String cmeal;
		 String cday = bitsdatabase.getCurrentDay();
		 String ctime = bitsdatabase.getCurrentTime();
		 int i = Integer.parseInt(ctime);
		 
		 if(i>=Integer.parseInt(this.mess.breakfast_time[0]) && i<=Integer.parseInt(this.mess.breakfast_time[1])) 
			 cmeal = "Breakfast";
		 else if (i>=Integer.parseInt(this.mess.lunch_time[0]) && i<=Integer.parseInt(this.mess.lunch_time[1]))
			 cmeal = "Lunch";
		 else if (i>=Integer.parseInt(this.mess.snack_time[0]) && i<=Integer.parseInt(this.mess.snack_time[1]))
			 cmeal = "Snacks";
		 else if (i>=Integer.parseInt(this.mess.dinner_time[0]) && i<=Integer.parseInt(this.mess.dinner_time[1]))
			 cmeal = "Dinner";
		 else{
			 cmeal = "";
		 	 System.out.println("Mess is closed at this time.");
		 	 return meal;
		 }
		 
		 try{
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "SELECT mctype, mc, side, salad, beverage, sweet FROM MessMenu" + cday + " WHERE meal = " + "'" + cmeal + "'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  meal[0] = bitsdatabase.resultset.getString("mctype");
		    		  meal[1] = bitsdatabase.resultset.getString("mc");
		    		  meal[2] = bitsdatabase.resultset.getString("side");
		    		  meal[3] = bitsdatabase.resultset.getString("salad");
		    		  meal[4] = bitsdatabase.resultset.getString("beverage");
		    		  meal[5] = bitsdatabase.resultset.getString("sweet");
		    		  got = true;
		    		  System.out.println(cmeal + " " + meal[0] + " " + meal[1] + " " + meal[2] + " " + meal[3] + " " + meal [4] + " " + meal[5]); 
			      }
		      		
			      if(got == false) {
		      			System.out.println("Failed to get Dinner of " + cday + " for Mess " + messName);
		      			bitsdatabase.shutdownDB();
		      			return meal;
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
		return meal;
			 
	 }
	 
	 String[] getNextMeal(String messName) {
		 String[] meal = new String [6];
		 boolean got = false;
		 
		 String cmeal;
		 String cday = bitsdatabase.getCurrentDay();
		 String ctime = bitsdatabase.getCurrentTime();
		 int i = Integer.parseInt(ctime);
		 
		 if (i>=Integer.parseInt(this.mess.breakfast_time[0]) && i<Integer.parseInt(this.mess.lunch_time[0]))
			 cmeal = "Lunch";
		 else if (i>=Integer.parseInt(this.mess.lunch_time[0]) && i<Integer.parseInt(this.mess.snack_time[0]))
			 cmeal = "Snacks";
		 else if (i>=Integer.parseInt(this.mess.snack_time[0]) && i<Integer.parseInt(this.mess.dinner_time[0]))
			 cmeal = "Dinner";
		 else
			 cmeal = "Breakfast";
		 
		 try{
				bitsdatabase.setupMessDB(messName);
			      
			      String sql = "SELECT mctype, mc, side, salad, beverage, sweet FROM MessMenu" + cday + " WHERE meal = " + "'" + cmeal + "'";
			      bitsdatabase.resultset = bitsdatabase.statement.executeQuery(sql);
			      
			      while(bitsdatabase.resultset.next()){
		    		  //Retrieve by column name
		    		  meal[0] = bitsdatabase.resultset.getString("mctype");
		    		  meal[1] = bitsdatabase.resultset.getString("mc");
		    		  meal[2] = bitsdatabase.resultset.getString("side");
		    		  meal[3] = bitsdatabase.resultset.getString("salad");
		    		  meal[4] = bitsdatabase.resultset.getString("beverage");
		    		  meal[5] = bitsdatabase.resultset.getString("sweet");
		    		  got = true;
		    		  System.out.println(cmeal + " " + meal[0] + " " + meal[1] + " " + meal[2] + " " + meal[3] + " " + meal [4] + " " + meal[5]); 
			      }
		      		
			      if(got == false) {
		      			System.out.println(cmeal + " details of " + cday + " for Mess " + messName + " do not exist in it's database");
		      			bitsdatabase.shutdownDB();
		      			return meal;
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
		return meal;
	 }
	 
	 public static void main(String args[]) {
		 MessMenu m = new MessMenu();
		 //m.getCurrentMeal("A");
		 m.getNextMeal("A");
	 }
}
	
	
	

