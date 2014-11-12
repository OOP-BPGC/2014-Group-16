package src;

public class CheckIn {
	Student student;
	Guest guest;

	boolean doStudentCheckIn (String idNumber) {
		
		//set this.student to an object corresponding to idNumber in student database
	
		if (student.hasEaten == true) {
			student.checkinStatus = false;
			return false;
		}
		else {
			student.checkinStatus = true;
			student.hasEaten = true;
			return true;
		}			
	}
	
	boolean doGuestCheckIn (String guestName) {
		this.guest = new Guest(guestName);
		//update database
		return true;
		
	}
		
}
