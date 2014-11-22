package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MWAL {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	MessCrew MessCrew=new MessCrew();
	
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MWAL window = new MWAL();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWAL window = new MWAL();
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
	public MWAL() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane txtpnApplyForLeave = new JTextPane();
		txtpnApplyForLeave.setBackground(new Color(255, 222, 173));
		txtpnApplyForLeave.setText("Apply for leave");
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "submitted");
				MessCrew.applyLeave(textField.getText(),textField_1.getText());
			}
		});
		
		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		
		JLabel lblDdmmyyyy_1 = new JLabel("dd/mm/yyyy");
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessWorker m = new MessWorker();
				m.run();
				frame.hide();
			}
		});
		
		JLabel lblApplyinLeaveFrom = new JLabel("Applyin leave from:");
		
		JLabel lblApplyinLeaveTill = new JLabel("Applyin leave till:");
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApplyinLeaveFrom)
								.addComponent(lblApplyinLeaveTill))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDdmmyyyy)
								.addComponent(lblDdmmyyyy_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(175)
							.addComponent(txtpnApplyForLeave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(177))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(394, Short.MAX_VALUE)
					.addComponent(lblLogout)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(btnSubmit)
					.addContainerGap(231, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(txtpnApplyForLeave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblApplyinLeaveFrom)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDdmmyyyy))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblApplyinLeaveTill)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDdmmyyyy_1))
							.addGap(31)
							.addComponent(btnSubmit)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogout)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
