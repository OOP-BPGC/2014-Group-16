package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MWSM {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MWSM window = new MWSM();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWSM window = new MWSM();
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
	public MWSM() {
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
		
		JTextPane txtpnMenu = new JTextPane();
		txtpnMenu.setBackground(new Color(189, 183, 107));
		txtpnMenu.setText("Menu");
		
		JButton btnShowCurrentMenu = new JButton("Show current Menu");
		btnShowCurrentMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("this service is exclusive to premium user!!!");
			}
		});
		
		JLabel lblOr = new JLabel("or");
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessWorker m = new MessWorker();
				m.run();
				//MWSFz.messOption=null;
				frame.hide();
			}
		});
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setVisible(false);
		
		JButton btnShowWeeksMenu = new JButton("Show week's Menu");
		btnShowWeeksMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MSWMa m = new MSWMa();
				m.run();
				frame.hide();
			}
		});
		
		JLabel lblCurrentMenu = new JLabel("Current Menu:");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(183)
							.addComponent(txtpnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
							.addComponent(lblLogout))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(164)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnShowWeeksMenu)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnShowCurrentMenu)
										.addComponent(lblOr))
									.addGap(27)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCurrentMenu))))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(txtpnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnShowCurrentMenu)
								.addComponent(lblCurrentMenu))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOr)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnShowWeeksMenu)
							.addGap(41)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogout)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
