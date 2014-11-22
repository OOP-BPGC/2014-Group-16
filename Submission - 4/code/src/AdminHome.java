package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminHome {
public String messname;
MessAdmin admin=new MessAdmin(messname);
	public JFrame frmAdminHome;
	JTextArea FeedArea;
	JInternalFrame FeedbackFrame;
	private JTextField TF1;
	private JTextField TF2;
	private JTextField TF3;
	private JTextField TF4;
	private JTextField TF5;
	private JTextField TF6;
	JInternalFrame MenuFrame;
	JInternalFrame StudentFrame;
	private JTextField TID;
	private JTextField TNAME;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JLabel LMess;
	JLabel LBalance;
	JInternalFrame MessFrame;
	JLabel LWel; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
					window.frmAdminHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminHome = new JFrame();
		frmAdminHome.getContentPane().setBackground(new Color(255, 153, 255));
		frmAdminHome.setTitle("Admin Home");
		frmAdminHome.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
			FeedbackFrame.setVisible(false);
			MenuFrame.setVisible(false);
			StudentFrame.setVisible(false);
			MessFrame.setVisible(false);
			LWel.setText(messname+" Mess");
			Driver.acontrol=1;
			
			
			}
		});
		frmAdminHome.setBounds(100, 100, 774, 493);
		frmAdminHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminHome.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(178, 0, 2, 454);
		frmAdminHome.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("View Feedback");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			FeedbackFrame.setVisible(true);
			MenuFrame.setVisible(false);
			StudentFrame.setVisible(false);
			}
			
		});
		btnNewButton.setBounds(0, 100, 180, 32);
		frmAdminHome.getContentPane().add(btnNewButton);
		
		MessFrame = new JInternalFrame("Mess Details");
		MessFrame.getContentPane().setBackground(new Color(102, 153, 204));
		MessFrame.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			LMess.setText(messname+" Mess");
			double balance=admin.getAccountBalance(messname);
			LBalance.setText("Rs."+balance);
			}
		});
		
		MenuFrame = new JInternalFrame("Menu");
		MenuFrame.setBackground(new Color(102, 153, 204));
		MenuFrame.setBounds(178, 0, 570, 454);
		frmAdminHome.getContentPane().add(MenuFrame);
		MenuFrame.getContentPane().setLayout(null);
		
		final JComboBox DayBox = new JComboBox();
		DayBox.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		DayBox.setBounds(173, 22, 167, 20);
		MenuFrame.getContentPane().add(DayBox);
		
		JLabel lblSelectDay = new JLabel("Select Day:-");
		lblSelectDay.setBounds(21, 25, 123, 14);
		MenuFrame.getContentPane().add(lblSelectDay);
		
		final JComboBox MealBox = new JComboBox();
		MealBox.setModel(new DefaultComboBoxModel(new String[] {"Breakfast", "Lunch", "Dinner"}));
		MealBox.setBounds(173, 74, 167, 20);
		MenuFrame.getContentPane().add(MealBox);
		
		JLabel lblSelectMeal = new JLabel("Select Meal:-");
		lblSelectMeal.setBounds(21, 77, 123, 14);
		MenuFrame.getContentPane().add(lblSelectMeal);
		
		JLabel lblEnterMctype = new JLabel("Enter mctype");
		lblEnterMctype.setBounds(21, 140, 320, 14);
		MenuFrame.getContentPane().add(lblEnterMctype);
		
		TF1 = new JTextField();
		TF1.setBounds(173, 137, 168, 20);
		MenuFrame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		TF2 = new JTextField();
		TF2.setColumns(10);
		TF2.setBounds(173, 178, 168, 20);
		MenuFrame.getContentPane().add(TF2);
		
		JLabel lblEnterMc = new JLabel("Enter mc");
		lblEnterMc.setBounds(21, 181, 320, 14);
		MenuFrame.getContentPane().add(lblEnterMc);
		
		TF3 = new JTextField();
		TF3.setColumns(10);
		TF3.setBounds(173, 220, 168, 20);
		MenuFrame.getContentPane().add(TF3);
		
		JLabel lblEnterSide = new JLabel("Enter side");
		lblEnterSide.setBounds(21, 223, 320, 14);
		MenuFrame.getContentPane().add(lblEnterSide);
		
		TF4 = new JTextField();
		TF4.setColumns(10);
		TF4.setBounds(173, 269, 168, 20);
		MenuFrame.getContentPane().add(TF4);
		
		JLabel lblEnterSalad = new JLabel("Enter salad");
		lblEnterSalad.setBounds(21, 272, 320, 14);
		MenuFrame.getContentPane().add(lblEnterSalad);
		
		TF5 = new JTextField();
		TF5.setColumns(10);
		TF5.setBounds(172, 320, 168, 20);
		MenuFrame.getContentPane().add(TF5);
		
		JLabel lblEnterBeverage = new JLabel("Enter beverage");
		lblEnterBeverage.setBounds(20, 323, 320, 14);
		MenuFrame.getContentPane().add(lblEnterBeverage);
		
		TF6 = new JTextField();
		TF6.setColumns(10);
		TF6.setBounds(173, 365, 168, 20);
		MenuFrame.getContentPane().add(TF6);
		
		JLabel lblEnterSweet = new JLabel("Enter sweet");
		lblEnterSweet.setBounds(21, 368, 320, 14);
		MenuFrame.getContentPane().add(lblEnterSweet);
		
		JButton btnNewButton_1 = new JButton("UPDATE ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String day=(String)DayBox.getSelectedItem();
				String meal=(String)MealBox.getSelectedItem();
				String[]menu=new String[6];
				menu[0]=TF1.getText();
				menu[1]=TF2.getText();
				menu[2]=TF3.getText();
				menu[3]=TF4.getText();
				menu[4]=TF5.getText();
				menu[5]=TF6.getText();
										
				switch(meal){
				case "Breakfast":admin.setBreakfast(day, messname, menu);
				break;
				case "Lunch":admin.setLunch(day, messname, menu);
				break;
				case "Dinner":admin.setDinner(day, messname, menu);
				break;
				
				}
				JOptionPane.showMessageDialog(null,"Succesfully added to database");
			}
		});
		btnNewButton_1.setBounds(364, 136, 180, 104);
		MenuFrame.getContentPane().add(btnNewButton_1);
		MenuFrame.setVisible(true);
		MessFrame.setBounds(178, 0, 580, 454);
		frmAdminHome.getContentPane().add(MessFrame);
		MessFrame.getContentPane().setLayout(null);
		
		LMess = new JLabel("");
		LMess.setFont(new Font("Tahoma", Font.PLAIN, 24));
		LMess.setBounds(102, 11, 296, 60);
		MessFrame.getContentPane().add(LMess);
		
		JLabel lblNewLabel_1 = new JLabel("Account Balance");
		lblNewLabel_1.setBounds(40, 99, 98, 27);
		MessFrame.getContentPane().add(lblNewLabel_1);
		
		LBalance = new JLabel("");
		LBalance.setBounds(189, 99, 143, 27);
		MessFrame.getContentPane().add(LBalance);
		
		JButton btnUpdateBalance = new JButton("Update Balance");
		btnUpdateBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			double newbal=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter New Balance"));
			admin.setAccountBalance(newbal,messname);
			}
		});
		btnUpdateBalance.setBounds(203, 188, 129, 45);
		MessFrame.getContentPane().add(btnUpdateBalance);
		MessFrame.setVisible(true);
		
		FeedbackFrame = new JInternalFrame("Feedback");
		FeedbackFrame.getContentPane().setBackground(new Color(102, 153, 204));
		FeedbackFrame.setBounds(178, 0, 580, 454);
		frmAdminHome.getContentPane().add(FeedbackFrame);
		FeedbackFrame.getContentPane().setLayout(null);
		
		JLabel lblWhichFeedbackDo = new JLabel("Which Feedback do you want to view?");
		lblWhichFeedbackDo.setBounds(21, 11, 234, 14);
		FeedbackFrame.getContentPane().add(lblWhichFeedbackDo);
		
		final JComboBox optBox = new JComboBox();
		optBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				/*String[]feed=new String[100];
				
				String opt=(String)optBox.getSelectedItem();
				System.out.println(opt);
					try {
						if(opt.equals("Student Feedback")){
							feed=admin.getStudentFeedback();	
						}
						else{
						if(opt.equals("Guest Feedback"))	
							feed=admin.getGuestFeedback();
						}
		
						
						switch(opt){
						case "Student Feedback":feed=admin.getStudentFeedback();
								break;
						case "Guest Feedback":feed=admin.getGuestFeedback();
							break;
						default:System.out.println("Im here");
							feed=admin.getStudentFeedback();	
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int l=feed.length;
					
					int i=0;
					while(i<l){
					FeedArea.append(feed[i]+"\n");
					i++;
					}*/
					
			}
		});
		optBox.setModel(new DefaultComboBoxModel(new String[] {"Student Feedback\t", "Guest Feedback"}));
		optBox.setBounds(332, 8, 178, 20);
		FeedbackFrame.getContentPane().add(optBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 544, 283);
		FeedbackFrame.getContentPane().add(scrollPane);
		
		FeedArea = new JTextArea();
		FeedArea.setEditable(false);
		scrollPane.setViewportView(FeedArea);
		
		final JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedArea.setText(null);
				String[]feed=new String[100];
								
				String opt=(String)optBox.getSelectedItem();
				System.out.println(opt);
					try {
						/*if(opt.equals("Student Feedback")){
							feed=admin.getStudentFeedback();	
						}
						else{
						if(opt.equals("Guest Feedback"))	
							feed=admin.getGuestFeedback();
						}*/
		
						
						switch(opt){
						case "Student Feedback":feed=admin.getStudentFeedback();
								break;
						case "Guest Feedback":feed=admin.getGuestFeedback();
							break;
						default:System.out.println("Im here");
							feed=admin.getStudentFeedback();	
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int l=feed.length;
					
					int i=0;
					while(!(feed[i].equals("null"))){
					FeedArea.append((i+1)+"."+feed[i]+"\n\n");
					i++;
					}
			}
		});
		btnView.setBounds(224, 36, 89, 23);
		FeedbackFrame.getContentPane().add(btnView);
		
		JButton btnNewButton_2 = new JButton("Clear Feedback");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String opt=(String)optBox.getSelectedItem();
				switch(opt){
				
				case "Guest Feedback":
					try {
						admin.clearGuestFeedback();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					btnView.doClick();
					break;
				default:try {
						admin.clearStudentFeedback();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						btnView.doClick();
				}
			}
		});
		btnNewButton_2.setBounds(140, 367, 234, 23);
		FeedbackFrame.getContentPane().add(btnNewButton_2);
		FeedbackFrame.setVisible(true);
		
		StudentFrame = new JInternalFrame("Student Details");
		StudentFrame.getContentPane().setBackground(new Color(102, 153, 204));
		StudentFrame.setBounds(178, 0, 580, 454);
		frmAdminHome.getContentPane().add(StudentFrame);
		StudentFrame.getContentPane().setLayout(null);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID");
		lblEnterStudentId.setBounds(36, 36, 113, 14);
		StudentFrame.getContentPane().add(lblEnterStudentId);
		
		TID = new JTextField();
		TID.setBounds(159, 33, 213, 20);
		StudentFrame.getContentPane().add(TID);
		TID.setColumns(10);
		
		TNAME = new JTextField();
		TNAME.setColumns(10);
		TNAME.setBounds(159, 81, 213, 20);
		StudentFrame.getContentPane().add(TNAME);
		
		JLabel lblEnterStudentName = new JLabel("Enter Student Name");
		lblEnterStudentName.setBounds(36, 84, 113, 14);
		StudentFrame.getContentPane().add(lblEnterStudentName);
		
		JLabel lblNewLabel = new JLabel("Which Detail do you want to update?");
		lblNewLabel.setBounds(148, 139, 305, 14);
		StudentFrame.getContentPane().add(lblNewLabel);
		
		final JRadioButton rb01 = new JRadioButton("Student ID");
		rb01.setOpaque(false);
		buttonGroup.add(rb01);
		rb01.setBounds(64, 184, 109, 23);
		StudentFrame.getContentPane().add(rb01);
		
		final JRadioButton rb02 = new JRadioButton("Student Name");
		rb02.setOpaque(false);
		buttonGroup.add(rb02);
		rb02.setBounds(344, 184, 109, 23);
		StudentFrame.getContentPane().add(rb02);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID=TID.getText();
				String Name=TNAME.getText();
				if(rb02.isSelected()){
				admin.setStudentName(Name, ID);	
				}
				else
				admin.setStudentIdNumber(Name, ID);	
				JOptionPane.showMessageDialog(null,"Details Successfully Updated");
			}
			
		});
		btnUpdate.setBounds(202, 246, 89, 23);
		StudentFrame.getContentPane().add(btnUpdate);
		StudentFrame.setVisible(true);
		
		JButton btnSetMenu = new JButton("Set Menu");
		btnSetMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedbackFrame.setVisible(false);
				MenuFrame.setVisible(true);
				StudentFrame.setVisible(false);
				MessFrame.setVisible(false);
			}
		});
		btnSetMenu.setBounds(0, 154, 180, 32);
		frmAdminHome.getContentPane().add(btnSetMenu);
		
		JButton btnUpdateStudentDetails = new JButton("Update Student Details");
		btnUpdateStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedbackFrame.setVisible(false);
				MenuFrame.setVisible(false);
				StudentFrame.setVisible(true);
				MessFrame.setVisible(false);
			}
		});
		btnUpdateStudentDetails.setBounds(0, 211, 180, 32);
		frmAdminHome.getContentPane().add(btnUpdateStudentDetails);
		
		JButton btnMessDetails = new JButton("Mess Details");
		btnMessDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedbackFrame.setVisible(false);
				MenuFrame.setVisible(false);
				StudentFrame.setVisible(false);
				MessFrame.setVisible(true);
				double balance=admin.getAccountBalance(messname);
				LBalance.setText("Rs."+balance);
			}
		});
		btnMessDetails.setBounds(0, 271, 180, 32);
		frmAdminHome.getContentPane().add(btnMessDetails);
		
		LWel = new JLabel("");
		LWel.setHorizontalAlignment(SwingConstants.CENTER);
		LWel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		LWel.setBounds(10, 11, 158, 69);
		frmAdminHome.getContentPane().add(LWel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI lg=new LoginGUI();
				
				lg.frame.setVisible(true);
				frmAdminHome.setVisible(false);
			}
		});
		btnLogout.setBounds(0, 329, 180, 32);
		frmAdminHome.getContentPane().add(btnLogout);
	}
}
