package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class MWSMb {
	public static String day=null;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	MessMenu MessMenu=new MessMenu();
	public String messopt;
	MessCrew obj=new MessCrew();
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MWSMb window = new MWSMb();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWSMb window = new MWSMb();
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
	public MWSMb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setVisible(false);
		
		JTextPane txtpnMenu = new JTextPane();
		txtpnMenu.setText("Menu");
		
		final JLabel lblSelectDay = new JLabel("Select day:");
		lblSelectDay.setBackground(SystemColor.inactiveCaption);
		
		final JRadioButton rdbtnMon = new JRadioButton("Mon");
		buttonGroup.add(rdbtnMon);
		
		final JRadioButton rdbtnTue = new JRadioButton("Tue");
		buttonGroup.add(rdbtnTue);
		
		final JRadioButton rdbtnWed = new JRadioButton("Wed");
		buttonGroup.add(rdbtnWed);
		
		final JRadioButton rdbtnSat = new JRadioButton("Sat");
		buttonGroup.add(rdbtnSat);
		
		final JRadioButton rdbtnThu = new JRadioButton("Thu");
		buttonGroup.add(rdbtnThu);
		
		final JRadioButton rdbtnFri = new JRadioButton("Fri");
		buttonGroup.add(rdbtnFri);
		
		final JRadioButton rdbtnSun = new JRadioButton("Sun");
		buttonGroup.add(rdbtnSun);
		
		
		final JLabel lblTheMenuIs = new JLabel("The Menu is:");
		lblTheMenuIs.setVisible(false);
		textField = new JTextField();
		textField.setVisible(false);
		textField.setColumns(10);
		
		final JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnMon.isSelected()){
					day = "monday";
				}
				
				if(rdbtnTue.isSelected()){
					day = "tuesday";
				}
				
				if(rdbtnWed.isSelected()){
					day = "wednesday";
				}
				
				if(rdbtnThu.isSelected()){
					day = "thursday";
				}
				
				if(rdbtnFri.isSelected()){
					day = "friday";
				}
				
				if(rdbtnSat.isSelected()){
					day = "saturday";
				}
				
				if(rdbtnSun.isSelected()){
					day = "sunday";
				}
				if (!day.equals(null)){
					rdbtnFri.hide();
					rdbtnSat.hide();
					rdbtnSun.hide();
					rdbtnMon.hide();
					rdbtnTue.hide();
					rdbtnWed.hide();
					rdbtnThu.hide();
					btnContinue.setVisible(false);
					lblSelectDay.setVisible(false);
					lblTheMenuIs.setVisible(true);
					textField.setVisible(true);
					String[]op=new String[6];
					//messopt=obj.getMessName(Driver.cuser);
					switch (MSWMa.meal){
					
						case "breakfast":op=MessMenu.getBreakfast(day,Driver.cusermess);
							textField.setText(op[0]+", "+op[1]+", "+op[2]+", "+op[3]+", "+op[4]+", "+op[5]);
						break;
						case "lunch":op=MessMenu.getLunch(day,Driver.cusermess);
						textField.setText(op[0]+", "+op[1]+", "+op[2]+", "+op[3]+", "+op[4]+", "+op[5]);
						break;
						case "dinner":op=MessMenu.getDinner(day,Driver.cusermess);
						textField.setText(op[0]+", "+op[1]+", "+op[2]+", "+op[3]+", "+op[4]+", "+op[5]);
						break;	
						default:;
					}
				}
			}
		});
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MSWMa m = new MSWMa();
				m.run();
				textField.setText(null);
				MSWMa.meal=null;
				day=null;
				frame.hide();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(lblSelectDay)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnTue)
								.addComponent(rdbtnMon)
								.addComponent(rdbtnWed)
								.addComponent(rdbtnThu))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(45)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBack)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtpnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
											.addComponent(lblLogout))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(32)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnSat)
											.addGap(68)
											.addComponent(btnContinue))
										.addComponent(rdbtnFri)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(rdbtnSun)))
									.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTheMenuIs)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogout))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(txtpnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectDay)
						.addComponent(rdbtnMon)
						.addComponent(rdbtnFri))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnTue)
						.addComponent(rdbtnSat)
						.addComponent(btnContinue))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnWed)
						.addComponent(rdbtnSun))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnThu)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTheMenuIs))
					.addGap(21)
					.addComponent(btnBack)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
