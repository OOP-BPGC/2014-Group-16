package src;

public class Student implements MessCustomer{

	private String name;
	private String idNumber;
	boolean hasEaten;
	Mess mess;
	Accounts account;
	Feedback feedback;
	boolean authStatus;
	boolean checkinStatus;
	
	public Student(String idNumber) {
		this.setIdNumber(idNumber);
		//get other details from database
	}
	
	public Student(String name, String idNumber) {
		this.name = name;
		this.setIdNumber(idNumber);
	}
	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHasEaten(boolean status) {
		this.hasEaten = status;
	}
	
	public boolean getHasEaten() {	
		return hasEaten;
	}
	
	public void giveFeedback(String feedback) {
		//save in database
	}
	
	public String getMessChosen() {
		return mess.messName;
	}
	
	public void setMessChosen(String mess) {
		this.mess.messName = mess;
	}
	
	
	
	
}
