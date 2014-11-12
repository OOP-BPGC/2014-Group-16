package src;

public class Guest implements MessCustomer{
	String name;
	Feedback feedback;
	
	public Guest(String name) {
		this.name = name;
	}

	
	public String getName() {
		
		return this.name;
	}
	
	public void getMessInfo() {		
		
	}
	
	public void giveFeedback(String feedback) {		

	}

	public void setName(String name) {
		this.name = name;
	}

}
