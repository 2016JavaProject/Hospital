package UI.patientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class patient_login {

	private JFrame frame;
	private JTextField account_text;
	private JTextField password_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_login window = new patient_login();
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
	public patient_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel account_label = new JLabel("帐号:");
		account_label.setBounds(75, 55, 54, 15);
		frame.getContentPane().add(account_label);
		
		JLabel password_label = new JLabel("密码:");
		password_label.setBounds(75, 104, 54, 15);
		frame.getContentPane().add(password_label);
		
		account_text = new JTextField();
		account_text.setText("请输入帐号");
		account_text.setBounds(150, 52, 134, 21);
		frame.getContentPane().add(account_text);
		account_text.setColumns(10);
		
		password_text = new JTextField();
		password_text.setText("请输入密码");
		password_text.setBounds(150, 101, 134, 21);
		frame.getContentPane().add(password_text);
		password_text.setColumns(10);
		
		JButton Register_btn = new JButton("\u6CE8\u518C");
		Register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Register_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				patient_Register.main(null);
				
				
			}
		});
		Register_btn.setBounds(105, 182, 93, 23);
		frame.getContentPane().add(Register_btn);
		
		JButton login_btn = new JButton("登录");
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("欢迎登陆！！");
				frame.dispose();
				patient_action.main(null);
			}
		});
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login_btn.setBounds(244, 182, 93, 23);
		frame.getContentPane().add(login_btn);
		
		JButton Return_btn = new JButton("返回");
		Return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Return_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				java_Home.java_Home.main(null);
			}
		});
		Return_btn.setBounds(10, 10, 93, 23);
		frame.getContentPane().add(Return_btn);
	}
}
