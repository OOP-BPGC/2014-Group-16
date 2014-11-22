package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MWSP {

	private JFrame frame;
	private JTextField textField;
	MessWorker MessWorker=new MessWorker();
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MWSP window = new MWSP();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWSP window = new MWSP();
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
	public MWSP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		
		JTextPane txtpnAccountBalance = new JTextPane();
		txtpnAccountBalance.setText("Account Balance");
		
		JLabel lblYourBalanceIs = new JLabel("Your balance is:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setVisible(false);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessWorker m = new MessWorker();
				m.run();
				frame.hide();
			}
		});
		
		JButton btnShow = new JButton("show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textField.setText(MessCrew.getAccountBalance(username)+"");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(159)
					.addComponent(txtpnAccountBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
					.addComponent(lblLogout)
					.addGap(25))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(lblYourBalanceIs)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnShow)
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(btnBack)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogout)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnAccountBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYourBalanceIs)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShow))))
					.addGap(57)
					.addComponent(btnBack)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
