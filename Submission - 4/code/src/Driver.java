package project;

public class Driver {
public static StudentHome obj;
public static int control;
public static int acontrol;
public static AdminHome aobj;
public static String cusermess;
public static String cusername;
public static GuestHome gobj;
public static int gcontrol;
static void exit(){
	obj.setVisible(false);
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginGUI gui=new LoginGUI();
		gui.frame.setVisible(true);
		if(control==1)
		obj.setVisible(false);	
	}

}
