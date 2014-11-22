package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class MSWMa {
	public static String meal;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MSWMa window = new MSWMa();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MSWMa window = new MSWMa();
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
	public MSWMa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		
		JLabel lblSelectMeal = new JLabel("Select meal:");
		
		final JRadioButton rdbtnBreakfast = new JRadioButton("breakfast");
		buttonGroup.add(rdbtnBreakfast);
		
		final JRadioButton rdbtnLunch = new JRadioButton("lunch");
		buttonGroup.add(rdbtnLunch);
		
		final JRadioButton rdbtnDinner = new JRadioButton("dinner");
		buttonGroup.add(rdbtnDinner);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MWSM m = new MWSM();
				m.run();
				frame.hide();
			}
		});
		
		JTextPane txtpnMenu = new JTextPane();
		txtpnMenu.setText("Menu");
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setVisible(false);
		
		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnBreakfast.isSelected()){
					meal = "breakfast";
				}
				if(rdbtnLunch.isSelected()){
					meal = "lunch";
				}
				if(rdbtnDinner.isSelected()){
					meal = "dinner";
				}
				if(!meal.equals(null)){
				MWSMb m = new MWSMb();
				m.run();
				frame.hide();}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(lblSelectMeal)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnDinner)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnBreakfast)
							.addGap(18)
							.addComponent(rdbtnLunch))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnContinue, Alignment.TRAILING)
								.addComponent(btnBack, Alignment.TRAILING))
							.addGap(90)
							.addComponent(lblLogout)))
					.addGap(80))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLogout)
						.addComponent(txtpnMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnBreakfast)
						.addComponent(rdbtnLunch)
						.addComponent(lblSelectMeal))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnDinner)
					.addGap(33)
					.addComponent(btnContinue)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(20))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 460, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
