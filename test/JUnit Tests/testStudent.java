package project;

import junit.framework.TestCase;

public class testStudent extends TestCase {

Student s = new Student();
public void testGetID(){
	try{
	
	assertEquals(s.getIdNumber(1),"2014b4a4444g");
	}
	catch(Exception e){
		e.printStackTrace();	
}
}
public void testSetMessChosen(){
	try{
		s.setMessChosen("A");
	
	}
	catch(Exception e){
		fail("Exception should not have occured");	
	}
	//s.setMessChosen("A");
	}
public void testGetName(){
	try{
		assertEquals(s.getName("2014b4a4444g"), "Lionel Messi");
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	
public void testgetMessChosen(){
		try{
			assertEquals(s.getName("2014b4a4444g"), "C");
		}
		catch(Exception e){
			e.printStackTrace();
		}
}


}

