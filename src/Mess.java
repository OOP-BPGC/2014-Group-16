package src;

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
	}
}
