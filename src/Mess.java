package src;

public class Mess {
	String messName;
	String contractorName;
	String TOTAL_CAPACITY;
	
	String[] breakfast_time;
	String[] lunch_time;
	String[] snack_time; 
	String[] dinner_time;
	
	Bills price;
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
	}
	
	void setTimings() {
		
	}
}
