package project;

import junit.framework.TestCase;

public class testMessAdmin extends TestCase{
	MessAdmin m = new MessAdmin("A"); 
	public void testgetUsername(){
		try{
			assertEquals(m.getUsername(1),"2014b4a4444g");
			}
			catch(Exception e){
				e.printStackTrace();	
		}
	}
	
	public void testetStudentPassword(){
		try{
			assertEquals(m.getStudentPassword("2014b4a4444g"),"imawesome");
		}
		catch(Exception e){
			e.printStackTrace();	
	}
	}
	public void testgetAccountBalance(){
		try{
			assertEquals(m.getAccountBalance("master"),11111.11);
		}
		catch(Exception e){
			e.printStackTrace();	
	}
		
	}
}