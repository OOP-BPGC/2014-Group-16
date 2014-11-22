package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class MessWorker {

	private JFrame frame;
	public static double balance=0.0;
	MessCrew MessCrew=new MessCrew();
	public static String username;
	
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MessWorker window = new MessWorker();
			window.frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessWorker window = new MessWorker();
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
	public MessWorker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.windowBorder);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Show Foodstock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MWSF m = new MWSF();
				m.run();
				//frame.hide();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Update Foodstock");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MWUF m = new MWUF();
				m.run();
				//frame.hide();
			}
		});
		
		JButton btnApplyForLeave = new JButton("Apply for leave");
		btnApplyForLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Driver.cusername=username;
				MWAL m = new MWAL();
				m.run();
				//frame.hide();
			}
		});
		
		JButton btnShowShift = new JButton("Show Shift");
		btnShowShift.setVisible(false);
		JButton btnNewButton_2 = new JButton("Show Balance");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*MWSP m = new MWSP();
				m.run();*/
		JOptionPane.showMessageDialog(null,"Current balance is: Rs."+MessCrew.getAccountBalance(username));
		//frame.hide();
			}
		});
		
		JButton btnShowMenu = new JButton("Show Menu");
		btnShowMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MWSM m = new MWSM();
				m.run();
				//frame.hide();
			}
		});
		
		JTextArea txtrBitsMessSystem = new JTextArea();
		txtrBitsMessSystem.setBackground(new Color(216, 191, 216));
		txtrBitsMessSystem.setText("Bits Mess System");
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginGUI lg=new LoginGUI();
				lg.frame.setVisible(true);
				frame.dispose();	
			}
		});
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2)
								.addComponent(btnNewButton)
								.addComponent(btnApplyForLeave))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnShowShift)
								.addComponent(btnShowMenu)
								.addComponent(btnNewButton_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(txtrBitsMessSystem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(394, Short.MAX_VALUE)
					.addComponent(lblLogout)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogout)
					.addContainerGap(236, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(txtrBitsMessSystem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnShowMenu)
								.addComponent(btnApplyForLeave)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnShowShift)
								.addComponent(btnNewButton_2))))
					.addGap(54))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
