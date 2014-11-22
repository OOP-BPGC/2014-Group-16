package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class GuestHome extends JFrame {

	private JPanel contentPane;
	private JTextField NameTF;
	JButton btnSubmit;
	JTextPane FeedPane;
	JInternalFrame FeedbackFrame;
	JInternalFrame MenuFrame;
	static JLabel LCurrMeal;
	JLabel L1;
	JLabel L2;
	JLabel L3;
	JLabel L4;
	JComboBox DayList;
	JComboBox messBox;
	Guest user=new Guest();
	MessMenu menu=new MessMenu();
	BitsDatabase db=new BitsDatabase();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestHome frame = new GuestHome();
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
	public GuestHome() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				FeedbackFrame.setVisible(false);
				MenuFrame.setVisible(false);
				Driver.gcontrol=1;
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 487);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(500, 150));
		contentPane.setMaximumSize(new Dimension(2147483647, 2147483647));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuFrame.setVisible(true);
				FeedbackFrame.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(GuestHome.class.getResource("/project/View Menu.png")));
		btnNewButton.setBounds(0, 192, 211, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FeedbackFrame.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(GuestHome.class.getResource("/project/Feedback.png")));
		btnNewButton_1.setBounds(0, 82, 211, 48);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		separator_1.setOpaque(true);
		separator_1.setBounds(209, 0, 0, 448);
		contentPane.add(separator_1);
		
		MenuFrame = new JInternalFrame("Menu");
		MenuFrame.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				String[] curmenu = new String [6];
				curmenu=menu.getCurrentMeal((String)messBox.getSelectedItem());
				LCurrMeal.setText(curmenu[0]+" "+curmenu[1]+" "+curmenu[2]+" "+curmenu[3]+" "+curmenu[4]+" "+curmenu[5]);
			}
		});
		MenuFrame.setBounds(209, 0, 517, 448);
		contentPane.add(MenuFrame);
		MenuFrame.getContentPane().setLayout(null);
		
		JLabel lblCurrentlyServing = new JLabel("Currently Serving");
		lblCurrentlyServing.setBounds(10, 11, 116, 14);
		MenuFrame.getContentPane().add(lblCurrentlyServing);
		
		LCurrMeal = new JLabel("");
		LCurrMeal.setBounds(128, 11, 351, 14);
		MenuFrame.getContentPane().add(LCurrMeal);
		
		JLabel label_1 = new JLabel("Which Menu do you want to view?");
		label_1.setBounds(26, 55, 217, 14);
		MenuFrame.getContentPane().add(label_1);
		
		final JRadioButton rb01 = new JRadioButton("Today's");
		buttonGroup.add(rb01);
		rb01.setSelected(true);
		rb01.setBounds(25, 93, 109, 23);
		MenuFrame.getContentPane().add(rb01);
		
		JRadioButton rb02 = new JRadioButton("Other");
		buttonGroup.add(rb02);
		rb02.setBounds(255, 93, 109, 23);
		MenuFrame.getContentPane().add(rb02);
		
		DayList = new JComboBox();
		DayList.setModel(new DefaultComboBoxModel(new String[] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"}));
		DayList.setSelectedIndex(0);
		DayList.setMaximumRowCount(7);
		DayList.setBounds(370, 94, 109, 20);
		MenuFrame.getContentPane().add(DayList);
		
		JButton button = new JButton("View Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String []menu1=new String[6];
				String []menu2=new String[6];
				String []menu3=new String[6];
				String []menu4=new String[6];
				
				
				if(rb01.isSelected()){
				String day=db.getCurrentDay();
				
				menu1=menu.getBreakfast(day, (String)messBox.getSelectedItem());
				menu2=menu.getLunch(day, (String)messBox.getSelectedItem());
				menu3=menu.getSnacks(day, (String)messBox.getSelectedItem());
				menu4=menu.getDinner(day, (String)messBox.getSelectedItem());
				L1.setText(menu1[0]+" "+menu1[1]+" "+menu1[2]+" "+menu1[3]+" "+menu1[4]+" "+menu1[5]);
				L2.setText(menu2[0]+" "+menu2[1]+" "+menu2[2]+" "+menu2[3]+" "+menu2[4]+" "+menu2[5]);
				L3.setText(menu3[0]+" "+menu3[1]+" "+menu3[2]+" "+menu3[3]+" "+menu3[4]+" "+menu3[5]);
				L4.setText(menu4[0]+" "+menu4[1]+" "+menu4[2]+" "+menu4[3]+" "+menu4[4]+" "+menu4[5]);
			
							
				}
				else
				{
					String day=(String)DayList.getSelectedItem();
					menu1=menu.getBreakfast(day, (String)messBox.getSelectedItem());
					menu2=menu.getLunch(day, (String)messBox.getSelectedItem());
					menu3=menu.getSnacks(day, (String)messBox.getSelectedItem());
					menu4=menu.getDinner(day, (String)messBox.getSelectedItem());
					L1.setText(menu1[0]+" "+menu1[1]+" "+menu1[2]+" "+menu1[3]+" "+menu1[4]+" "+menu1[5]);
					L2.setText(menu2[0]+" "+menu2[1]+" "+menu2[2]+" "+menu2[3]+" "+menu2[4]+" "+menu2[5]);
					L3.setText(menu3[0]+" "+menu3[1]+" "+menu3[2]+" "+menu3[3]+" "+menu3[4]+" "+menu3[5]);
					L4.setText(menu4[0]+" "+menu4[1]+" "+menu4[2]+" "+menu4[3]+" "+menu4[4]+" "+menu4[5]);
				
					
				}
			}
		});
		button.setBounds(164, 142, 142, 23);
		MenuFrame.getContentPane().add(button);
		
		JLabel label_2 = new JLabel("Breakfast");
		label_2.setBounds(25, 176, 78, 14);
		MenuFrame.getContentPane().add(label_2);
		
		L1 = new JLabel("");
		L1.setBounds(113, 176, 366, 14);
		MenuFrame.getContentPane().add(L1);
		
		JLabel label_4 = new JLabel("Lunch");
		label_4.setBounds(25, 205, 78, 14);
		MenuFrame.getContentPane().add(label_4);
		
		L2 = new JLabel("");
		L2.setBounds(113, 205, 366, 14);
		MenuFrame.getContentPane().add(L2);
		
		JLabel label_6 = new JLabel("Snacks");
		label_6.setBounds(25, 238, 78, 14);
		MenuFrame.getContentPane().add(label_6);
		
		L3 = new JLabel("");
		L3.setBounds(113, 238, 366, 14);
		MenuFrame.getContentPane().add(L3);
		
		JLabel label_8 = new JLabel("Dinner");
		label_8.setBounds(25, 273, 78, 14);
		MenuFrame.getContentPane().add(label_8);
		
		L4 = new JLabel("");
		L4.setBounds(113, 273, 366, 14);
		MenuFrame.getContentPane().add(L4);
		
		JLabel lblMess = new JLabel("Mess");
		lblMess.setBounds(260, 55, 46, 14);
		MenuFrame.getContentPane().add(lblMess);
		
		messBox = new JComboBox();
		messBox.setModel(new DefaultComboBoxModel(new String[] {"A", "C"}));
		messBox.setSelectedIndex(0);
		messBox.setMaximumRowCount(2);
		messBox.setBounds(370, 52, 109, 20);
		MenuFrame.getContentPane().add(messBox);
		MenuFrame.setVisible(true);
		
		FeedbackFrame = new JInternalFrame("Feedback");
		FeedbackFrame.setBounds(221, 0, 505, 448);
		contentPane.add(FeedbackFrame);
		FeedbackFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your name");
		lblNewLabel.setBounds(26, 11, 116, 22);
		FeedbackFrame.getContentPane().add(lblNewLabel);
		
		NameTF = new JTextField();
		NameTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				String text=NameTF.getText();
				if(text.equals(null))
				;	
				else
					btnSubmit.setEnabled(true);	
					
			}
		});
		NameTF.setBounds(152, 12, 188, 20);
		FeedbackFrame.getContentPane().add(NameTF);
		NameTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your Feedback");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(135, 55, 188, 14);
		FeedbackFrame.getContentPane().add(lblNewLabel_1);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String feedback=FeedPane.getText();
				String name=NameTF.getText();
				user.setName(name);
				user.giveFeedback(feedback);
				JOptionPane.showMessageDialog(null, "Feedback has been succesfully submitted");
			}
		});
		btnSubmit.setToolTipText("Name is compulsory");
		btnSubmit.setBounds(196, 363, 89, 44);
		FeedbackFrame.getContentPane().add(btnSubmit);
		
		FeedPane = new JTextPane();
		FeedPane.setBounds(10, 93, 469, 259);
		FeedbackFrame.getContentPane().add(FeedPane);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginGUI lg=new LoginGUI();
				lg.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		btnNewButton_2.setBounds(0, 297, 211, 48);
		contentPane.add(btnNewButton_2);
		FeedbackFrame.setVisible(true);
	}
}
