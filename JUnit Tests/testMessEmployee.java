
import junit.framework.*;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class testMessEmployee extends TestCase{
	
	private MessEmployee employee;
	private MessCustomer newstudent;
	private MessEmployee newemployee;
	private BitsDatabase data;
	public void setUp() throws Exception {
		employee = createNiceMock(MessEmployee.class);
		newstudent = createNiceMock(MessCustomer.class);
		data = createNiceMock(BitsDatabase.class);
		newemployee = createNiceMock(MessEmployee.class);
		}
	
	public void testDoEmployeeAuth(){
		
		expect(employee.DoEmployeeAuth("username", "truepwd")).andReturn(true);
		expect(employee.DoEmployeeAuth("username", "falsepwd")).andReturn(false);
		replay(employee);
		
		assertEquals(true, employee.DoEmployeeAuth("username", "truepwd"));
		assertEquals(false, employee.DoEmployeeAuth("username", "falsepwd"));
		verify(employee);
		
	}
	
	public void testsetMenu(){
	
		employee.setMenu(3, 3, "new_menu");
		
		expect(employee.getMenu(3, 3)).andReturn("Wednesday Dinner Menu:-");
		replay(employee);
		
		assertEquals("Wednesday Dinner Menu:-",employee.getMenu(3, 3));
		verify(employee);
		
	}
	
	public void testGetMenu(){
		
		expect(employee.getMenu(7, 1)).andReturn("Sunday Breakfast Menu:-");
		expect(employee.getMenu(2, 2)).andReturn("Tuesday Lunch Menu:-");
		expect(employee.getMenu(4, 3)).andReturn("Thursday Dinner Menu:-");
		replay(employee);
		
		assertEquals("Sunday Breakfast Menu:-",employee.getMenu(7, 1));
		assertEquals("Tuesday Lunch Menu:-",employee.getMenu(2, 2));
		assertEquals("Thursday Dinner Menu:-",employee.getMenu(4, 3));
		verify(employee);
		
		}
	
	public void testgetShift(){
		
		expect(employee.getShift(employee)).andReturn("mwf morning");
		replay(employee);
		
		assertEquals("mwf morning", employee.getShift(employee));
		verify(employee);
		
	}
	
	public void testsetShift(){
		
		employee.setShift(employee, "mwf morning");
		
		expect(employee.getShift(employee)).andReturn("mwf morning");
		replay(employee);
		
		assertEquals("mwf morning", employee.getShift(employee));
		verify(employee);
		
	}
	
	public void testgetStudentList(){
		
		expect(employee.getStudentList()).andReturn(data);
		replay(employee);
		
		assertEquals(data, employee.getStudentList());
		verify(employee);
		
	}
	
	public void testgetMessworkerList(){

		expect(employee.getMessworkerList()).andReturn(data);
		replay(employee);
		
		assertEquals(data, employee.getMessworkerList());
		verify(employee);
		
	}
	
	public void testgetFeedback(){
		
		expect(employee.getFeedback()).andReturn("Feedback is .....");
		replay(employee);
		
		assertEquals("Feedback is .....", employee.getFeedback());
		verify(employee);
		
	}
	
	public void testupdateFoodstock(){
		
		employee.updateFoodstock(10, "Rice");
		
		expect(employee.getFoodstock()).andReturn("Foodstock is .....Rice - 10kg");
		replay(employee);
		
		assertEquals("Foodstock is .....Rice - 10kg", employee.getFoodstock());
		verify(employee);
		
	}

	public void testgetFoodstock(){
		
		expect(employee.getFoodstock()).andReturn("Foodstock is .....");
		replay(employee);
		
		assertEquals("Foodstock is .....", employee.getFoodstock());
		verify(employee);
		
	}
	
	public void testapproveLeave(){
		
		expect(employee.approveLeave()).andReturn(true);
		replay(employee);
		
		assertEquals(true, employee.approveLeave());
		verify(employee);
		
	}
	
	public void testchangeShift(){
		
		expect(employee.changeShift(employee)).andReturn(true);
		replay(employee);
		
		assertEquals(true, employee.changeShift(employee));
		verify(employee);
		
	}
	
	public void testupdateStudentDatabse(){
		
		employee.updateStudentDatabse(newstudent, true);
		
		expect(data.getStudentList()).andReturn("Student list contains newstudent");
		replay(data);
		
		assertEquals("Student list contains newstudent", data.getStudentList());
		verify(data);
		
}
	
	public void testupdateEmployeedatabase(){
		
		employee.updateEmployeedatabase(newemployee, true);
		
		expect(data.getMessEmployeeList()).andReturn("Employee list contains newemployee");
		replay(data);
		
		assertEquals("Employee list contains newemployee", data.getMessEmployeeList());
		verify(data);
		
	}

}