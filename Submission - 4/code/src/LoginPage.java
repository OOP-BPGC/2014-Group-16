package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {
static String login,pass;
	private JPanel contentPane;
	private JTextField LoginTF;
	private JPasswordField PwdTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(101, 78, 72, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 109, 73, 14);
		contentPane.add(lblPassword);
		
		LoginTF = new JTextField();
		LoginTF.setBounds(173, 75, 119, 20);
		contentPane.add(LoginTF);
		LoginTF.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			login=LoginTF.getText();
			pass=new String(PwdTF.getPassword());
			Login log=new Login();
			if(log.doStudentLogin(login, pass)){
			Student user=new Student(login);
			StudentHome frame = new StudentHome();
			StudentHome.LWelcome.setText("Welcome, "+user.getName(login));
			StudentHome.LMess.setText("Your Mess - "+user.getMessChosen(login)+" mess");
			frame.setVisible(true);
			}
			}
		});
		btnNewButton.setBounds(127, 152, 89, 23);
		contentPane.add(btnNewButton);
		
		PwdTF = new JPasswordField();
		PwdTF.setBounds(173, 109, 119, 17);
		contentPane.add(PwdTF);
	}
}
