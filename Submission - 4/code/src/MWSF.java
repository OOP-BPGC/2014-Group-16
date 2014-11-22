package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;

public class MWSF {

	private JFrame frame;
	private JTextField textField;
	private JButton btnShowFoodstockFor;
	private JLabel lblOrEnterThe;
	private JTextPane txtpnFoodstockDetails;
	private JLabel lblLogout;
	String foodstock = null;
	private JTextField textField_1;
	private JLabel lblStockIs;
	MessCrew MessCrew=new MessCrew();
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MWSF window = new MWSF();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWSF window = new MWSF();
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
	public MWSF() {
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
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessWorker m = new MessWorker();
				m.run();
				frame.hide();
			}
		});
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField.setColumns(10);
		
		btnShowFoodstockFor = new JButton("Show foodStock for selected items");
		btnShowFoodstockFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textField.getText();
				double a = MessCrew.getFoodLots(textField.getText());
				btnShowFoodstockFor.setVisible(false);
				textField.setVisible(false);
				lblOrEnterThe.setVisible(false);
				lblStockIs.setVisible(true);
				textField_1.setVisible(true);
				textField_1.setText(a+"");
			}
		});
		
		lblOrEnterThe = new JLabel("Enter the item to check :");
		
		txtpnFoodstockDetails = new JTextPane();
		txtpnFoodstockDetails.setBackground(new Color(255, 228, 196));
		txtpnFoodstockDetails.setText("Foodstock details");
		
		lblLogout = new JLabel("logout");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		lblStockIs = new JLabel("Stock is:");
		lblStockIs.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(175))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShowFoodstockFor)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOrEnterThe)
								.addComponent(lblStockIs))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(124))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(193)
					.addComponent(txtpnFoodstockDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(lblLogout)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(txtpnFoodstockDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOrEnterThe)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStockIs))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnShowFoodstockFor)
							.addGap(18)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogout)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
