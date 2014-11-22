package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class LoginDummy extends JFrame{
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	public JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private static JRadioButton rdbtnAMess,rdbtnCMess;
	static String username;
	StudentHome frame1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public LoginDummy() {
		initialize();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
			//frame1.setVisible(false);
			
			}
		});
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mess Management");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				frame1.setVisible(false);
				rdbtnAMess.setVisible(true);
				rdbtnCMess.setVisible(true);
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Student Check-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//mylogin=Loginstate.checkin;
				lblNewLabel.setText("ID No:-");
				lblNewLabel_1.setText("Student Check-in");
				lblNewLabel_2.setVisible(false);
				textField_1.setVisible(false);
				rdbtnAMess.setVisible(true);
				rdbtnCMess.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Student Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Username");
				lblNewLabel_1.setText("Student Login");
				lblNewLabel_2.setVisible(true);
				textField_1.setVisible(true);

				rdbtnAMess.setVisible(false);
				rdbtnCMess.setVisible(false);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Mess Admin Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Username");
				lblNewLabel_1.setText("Mess Admin Login");
				lblNewLabel_2.setVisible(true);
				textField_1.setVisible(true);
				rdbtnAMess.setVisible(true);
				rdbtnCMess.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Mess Crew Login");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Username");
				lblNewLabel_1.setText("Mess Crew Login");
				lblNewLabel_2.setVisible(true);
				textField_1.setVisible(true);
				rdbtnAMess.setVisible(true);
				rdbtnCMess.setVisible(true);
			}
		});
		
		final JButton btnNewButton_4 = new JButton("Guest");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GuestHome gh=new GuestHome();
				gh.setVisible(true);
				
				
			}
		});
		
		JSeparator separator = new JSeparator();
		
		lblNewLabel = new JLabel("ID No:-");
		
		lblNewLabel_1 = new JLabel("Student Check-in");
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setVisible(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String login = lblNewLabel_1.getText();
				username = textField.getText();
				String password = textField_1.getText();
				System.out.print("check");
				Login log=new Login();
				String mymess = null;
				if(rdbtnAMess.isSelected())
					mymess="A";
				if(rdbtnCMess.isSelected())
					mymess="C";
				
				boolean checklogin=true;//boolean from your database.
				switch (login) {
				case "Student Check-in":
					//your code for checking only username and assign boolean to checklogin
					checklogin=log.doStudentCheckIn(username, mymess);
					if(checklogin){
						JOptionPane.showMessageDialog(null,"Succesfully checked in");
						
						//move to other page
					}else{
						JOptionPane.showMessageDialog( frame,"Login failed");
					}
					break;

				case "Mess Admin Login":
					//your code for checking username and password and assign boolean to checklogin
					checklogin=log.doMessAdminLogin(username, password, mymess);
					if(checklogin){
						AdminHome adminHome = new AdminHome();
						adminHome.frmAdminHome.setVisible(true);
						frame.setVisible(false);
						//move to other page
					}else{
						JOptionPane.showMessageDialog( frame,"Login failed");
					}
					
					break;
				case "Mess Crew Login":
					//your code for checking only username and assign boolean to checklogin
					checklogin=log.doMessCrewLogin(username, password, mymess);
					//checklogin=log.(username, password);
					if(checklogin){
						//move to other page
						MessWorker messWorker = new MessWorker();
						messWorker.run();
						frame.setVisible(false);
						
					}else{
						JOptionPane.showMessageDialog( frame,"Login failed");
					}
													
					break;
				
				case "Student Login":
					//your code for checking username and password and assign boolean to checklogin
					//Login log=new Login();
					checklogin=log.doStudentLogin(username, password);
					if(checklogin){
						
						//if(log.doStudentLogin(login, password)){
						Student user=new Student(username);
						frame1 = new StudentHome();
						StudentHome.LWelcome.setText("Welcome, "+user.getName(username));
						StudentHome.LMess.setText("Your Mess - "+user.getMessChosen(username)+" mess");
						frame1.setVisible(true);
						frame.setVisible(false);
					//	}
						//move to other page
					}else{
						JOptionPane.showMessageDialog( frame,"Login failed");
					}
					
					break;
					
				default:
					break;
				}
			}
		});
		
		rdbtnAMess = new JRadioButton("A Mess");
		buttonGroup.add(rdbtnAMess);
		rdbtnCMess = new JRadioButton("C Mess");
		buttonGroup.add(rdbtnCMess);
		rdbtnCMess.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(54)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_1)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(rdbtnAMess)
											.addComponent(rdbtnCMess)))))
							.addGap(30))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_5)
							.addGap(88))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4)
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnAMess)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCMess)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnNewButton_5)
					.addGap(33))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
