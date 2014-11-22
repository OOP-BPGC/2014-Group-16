package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class MWSFz {
	public static String messOption = null;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public void run() {
		try {
			MWSFz window = new MWSFz();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MWSFz window = new MWSFz();
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
	public MWSFz() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		//messOption = null;
		JTextPane txtpnMessOption = new JTextPane();
		txtpnMessOption.setText("Mess Option");
		
		JLabel lblSelectMess = new JLabel("Select Mess:");
		
		final JRadioButton rdbtnAMess = new JRadioButton("A Mess");
		buttonGroup.add(rdbtnAMess);
		
		final JRadioButton rdbtnCMess = new JRadioButton("C Mess");
		buttonGroup.add(rdbtnCMess);
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setVisible(false);
		
		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					if(rdbtnAMess.isSelected()){
						messOption = "A";}
					if(rdbtnCMess.isSelected()){
						messOption = "C";}
				if (!messOption.equals(null)){
					MWSM m = new MWSM();
					m.run();
					//MWSFz.messOption=null;
					frame.hide();
				}
			}
		});
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessWorker m = new MessWorker();
				m.run();
				frame.hide();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(165)
					.addComponent(txtpnMessOption, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addComponent(lblLogout)
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBack)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelectMess)
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnCMess)
								.addComponent(rdbtnAMess))
							.addGap(34)))
					.addGap(33)
					.addComponent(btnContinue)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(txtpnMessOption, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnAMess)
								.addComponent(lblSelectMess))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnCMess))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblLogout)
							.addGap(78)
							.addComponent(btnContinue)))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(22))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
