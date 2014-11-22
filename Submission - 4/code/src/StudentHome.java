package project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentHome extends JFrame {
String ID=LoginGUI.username;
Student user=new Student(ID);
BitsDatabase db=new BitsDatabase();
MessMenu menu=new MessMenu();
DefaultListModel mod= new DefaultListModel();

	private JPanel contentPane;
	static JLabel LWelcome;
	static JLabel LMess;
	static JLabel LCurrMeal;
	JLabel LMessage;
	JLabel L1;
	JLabel L2;
	JLabel L4;
	JComboBox DayList;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextPane FeedPane;
	JInternalFrame FeedbackFrame;
	JInternalFrame MenuFrame;
	JInternalFrame PassFrame;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPasswordField pwdTF;
	private JPasswordField cpwdTF;
	 StudentHome frame;
	 JLabel LNextMeal;
	//public StudentHome frame1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome  frame = new StudentHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentHome() {
		setTitle("Student Home");
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
			FeedbackFrame.setVisible(false);
			MenuFrame.setVisible(false);
			PassFrame.setVisible(false);
			Driver.control=1;
			
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MenuFrame = new JInternalFrame("Menu");
		MenuFrame.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				
				String[] curmenu = new String [6];
				curmenu=menu.getCurrentMeal(user.getMessChosen(ID));
				LCurrMeal.setText(curmenu[0]+" "+curmenu[1]+" "+curmenu[2]+" "+curmenu[3]+" "+curmenu[4]+" "+curmenu[5]);
				String[] nextmenu=new String[6];
				nextmenu=menu.getNextMeal(user.getMessChosen(ID));
				LNextMeal.setText(nextmenu[0]+" "+nextmenu[1]+" "+nextmenu[2]+" "+nextmenu[3]+" "+nextmenu[4]+" "+nextmenu[5]);
				//LNextMeal.
				
			}
		});
		MenuFrame.setBounds(208, 0, 519, 449);
		contentPane.add(MenuFrame);
		MenuFrame.getContentPane().setLayout(null);
		
		final JRadioButton rb01 = new JRadioButton("Today's");
		rb01.setSelected(true);
		buttonGroup_1.add(rb01);
		rb01.setBounds(10, 94, 109, 23);
		MenuFrame.getContentPane().add(rb01);
		
		JLabel lblNewLabel_2 = new JLabel("Currently Serving");
		lblNewLabel_2.setBounds(10, 11, 122, 23);
		MenuFrame.getContentPane().add(lblNewLabel_2);
		
		LCurrMeal = new JLabel("");
		LCurrMeal.setBounds(142, 15, 351, 14);
		MenuFrame.getContentPane().add(LCurrMeal);
		
		JLabel lblWhichMenuDo = new JLabel("Which Menu do you want to view?");
		lblWhichMenuDo.setBounds(132, 73, 217, 14);
		MenuFrame.getContentPane().add(lblWhichMenuDo);
		
		JRadioButton rb02 = new JRadioButton("Other");
		buttonGroup_1.add(rb02);
		rb02.setBounds(240, 94, 109, 23);
		MenuFrame.getContentPane().add(rb02);
		
		JButton btnViewMenu = new JButton("View Menu");
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String []menu1=new String[6];
				String []menu2=new String[6];
				String []menu3=new String[6];
				String []menu4=new String[6];
				
				
				if(rb01.isSelected()){
				String day=db.getCurrentDay();
				
				menu1=menu.getBreakfast(day, user.getMessChosen(ID));
				menu2=menu.getLunch(day, user.getMessChosen(ID));
				//menu3=menu.getSnacks(day, user.getMessChosen(ID));
				menu4=menu.getDinner(day, user.getMessChosen(ID));
				L1.setText(menu1[0]+" "+menu1[1]+" "+menu1[2]+" "+menu1[3]+" "+menu1[4]+" "+menu1[5]);
				L2.setText(menu2[0]+" "+menu2[1]+" "+menu2[2]+" "+menu2[3]+" "+menu2[4]+" "+menu2[5]);
				//L3.setText(menu3[0]+" "+menu3[1]+" "+menu3[2]+" "+menu3[3]+" "+menu3[4]+" "+menu3[5]);
				L4.setText(menu4[0]+" "+menu4[1]+" "+menu4[2]+" "+menu4[3]+" "+menu4[4]+" "+menu4[5]);
			
							
				}
				else
				{
					String day=(String)DayList.getSelectedItem();
					menu1=menu.getBreakfast(day, user.getMessChosen(ID));
					menu2=menu.getLunch(day, user.getMessChosen(ID));
					//menu3=menu.getSnacks(day, user.getMessChosen(ID));
					menu4=menu.getDinner(day, user.getMessChosen(ID));
					L1.setText(menu1[0]+" "+menu1[1]+" "+menu1[2]+" "+menu1[3]+" "+menu1[4]+" "+menu1[5]);
					L2.setText(menu2[0]+" "+menu2[1]+" "+menu2[2]+" "+menu2[3]+" "+menu2[4]+" "+menu2[5]);
					//L3.setText(menu3[0]+" "+menu3[1]+" "+menu3[2]+" "+menu3[3]+" "+menu3[4]+" "+menu3[5]);
					L4.setText(menu4[0]+" "+menu4[1]+" "+menu4[2]+" "+menu4[3]+" "+menu4[4]+" "+menu4[5]);
				
					
				}
			}
		});
		btnViewMenu.setBounds(149, 125, 142, 23);
		MenuFrame.getContentPane().add(btnViewMenu);
		
		DayList = new JComboBox();
		DayList.setMaximumRowCount(7);
		DayList.setModel(new DefaultComboBoxModel(new String[] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"}));
		DayList.setSelectedIndex(0);
		DayList.setBounds(365, 95, 109, 20);
		MenuFrame.getContentPane().add(DayList);
		
		L1 = new JLabel("");
		L1.setBounds(98, 159, 366, 14);
		MenuFrame.getContentPane().add(L1);
		
		L2 = new JLabel("");
		L2.setBounds(98, 188, 366, 14);
		MenuFrame.getContentPane().add(L2);
		
		L4 = new JLabel("");
		L4.setBounds(98, 221, 366, 14);
		MenuFrame.getContentPane().add(L4);
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(10, 159, 78, 14);
		MenuFrame.getContentPane().add(lblBreakfast);
		
		JLabel lblLunch = new JLabel("Lunch");
		lblLunch.setBounds(10, 188, 78, 14);
		MenuFrame.getContentPane().add(lblLunch);
		
		JLabel lblDinner = new JLabel("Dinner");
		lblDinner.setBounds(10, 221, 78, 14);
		MenuFrame.getContentPane().add(lblDinner);
		
		JLabel lblNextMeal = new JLabel("Next Meal");
		lblNextMeal.setBounds(10, 39, 122, 23);
		MenuFrame.getContentPane().add(lblNextMeal);
		
		LNextMeal = new JLabel("");
		LNextMeal.setBounds(142, 43, 351, 14);
		MenuFrame.getContentPane().add(LNextMeal);
		MenuFrame.setVisible(true);
		
		PassFrame = new JInternalFrame("Change Password");
		PassFrame.setBounds(208, 0, 519, 449);
		contentPane.add(PassFrame);
		PassFrame.getContentPane().setLayout(null);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setBounds(33, 36, 153, 14);
		PassFrame.getContentPane().add(lblEnterNewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setBounds(33, 86, 153, 14);
		PassFrame.getContentPane().add(lblConfirmNewPassword);
		
		pwdTF = new JPasswordField();
		pwdTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pwd=new String(pwdTF.getPassword());
				String cpwd=new String(cpwdTF.getPassword());
				if(pwd.equals(cpwd)){
				LMessage.setText("<html><font color=\"green\">passwords match</font></html>");	
				
				}
				else
				LMessage.setText("<html><font color=\"red\">passwords do not match</font></html>");	
			}
		});
		pwdTF.setBounds(196, 33, 158, 20);
		PassFrame.getContentPane().add(pwdTF);
		
		cpwdTF = new JPasswordField();
		cpwdTF.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pwd=new String(pwdTF.getPassword());
				String cpwd=new String(cpwdTF.getPassword());
				if(pwd.equals(cpwd)){
				LMessage.setText("<html><font color=\"green\">passwords match</font></html>");	
				
				}
				else
				LMessage.setText("<html><font color=\"red\">passwords do not match</font></html>");	
			}
		});
		cpwdTF.setBounds(196, 83, 158, 20);
		PassFrame.getContentPane().add(cpwdTF);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pwd=new String(pwdTF.getPassword());
				user.setPassword(pwd, ID);
				JOptionPane.showMessageDialog(null,"Password Succesfully Changed");
			}
		});
		btnConfirm.setBounds(151, 169, 89, 23);
		PassFrame.getContentPane().add(btnConfirm);
		
		LMessage = new JLabel("");
		LMessage.setBounds(50, 132, 368, 14);
		PassFrame.getContentPane().add(LMessage);
		PassFrame.setVisible(true);
		
		LWelcome = new JLabel("");
		LWelcome.setBounds(10, 11, 199, 20);
		contentPane.add(LWelcome);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedbackFrame.setVisible(true);
				MenuFrame.setVisible(false);
				PassFrame.setVisible(false);
			}
		});
		ImageIcon icon=new ImageIcon("feedback.png");
		btnNewButton.setIcon(new ImageIcon(StudentHome.class.getResource("/project/Feedback.png")));
		btnNewButton.setBounds(0, 58, 209, 46);
		contentPane.add(btnNewButton);
		
		LMess = new JLabel("");
		LMess.setHorizontalAlignment(SwingConstants.RIGHT);
		LMess.setBounds(501, 11, 216, 20);
		contentPane.add(LMess);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setSize(new Dimension(500, 150));
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(208, 0, 2, 449);
		contentPane.add(separator);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuFrame.setVisible(true);
				FeedbackFrame.setVisible(false);
				PassFrame.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(StudentHome.class.getResource("/project/View Menu.png")));
		button.setBounds(0, 136, 209, 46);
		contentPane.add(button);
		
		FeedbackFrame = new JInternalFrame("Feedback");
		FeedbackFrame.setBounds(208, 0, 519, 449);
		contentPane.add(FeedbackFrame);
		FeedbackFrame.setName("FeedbackFrame");
		FeedbackFrame.getContentPane().setName("FeedbackFrame");
		FeedbackFrame.getContentPane().setLayout(null);
		
		final JRadioButton rdbtnYes = new JRadioButton("Yes");
		buttonGroup.add(rdbtnYes);
		rdbtnYes.setName("");
		rdbtnYes.setBounds(143, 35, 109, 23);
		FeedbackFrame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(292, 35, 109, 23);
		FeedbackFrame.getContentPane().add(rdbtnNo);
		
		FeedPane = new JTextPane();
		FeedPane.setBounds(10, 113, 483, 236);
		FeedbackFrame.getContentPane().add(FeedPane);
		
		JLabel lblNewLabel = new JLabel("Submit your name?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 11, 249, 23);
		FeedbackFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your Feedback");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(78, 88, 323, 23);
		FeedbackFrame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Submit\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String feedback=FeedPane.getText();
			if(rdbtnYes.isSelected())
				try {
					user.Feedback(feedback, false);
					JOptionPane.showMessageDialog(null, "Feedback has been succesfully submitted");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				try {
					user.Feedback(feedback, true);
					JOptionPane.showMessageDialog(null, "Feedback has been succesfully submitted");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(188, 360, 123, 48);
		FeedbackFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedbackFrame.setVisible(false);
				MenuFrame.setVisible(false);
				PassFrame.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(StudentHome.class.getResource("/project/ChangePass.png")));
		btnNewButton_2.setBounds(0, 205, 209, 65);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI lg=new LoginGUI();
				lg.frame.setVisible(true);
				//Driver.control=1;
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
						
						
			
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(StudentHome.class.getResource("/project/Logout.png")));
		btnNewButton_3.setBounds(0, 306, 209, 46);
		contentPane.add(btnNewButton_3);
		FeedbackFrame.setVisible(true);
		
	}
}
