package UI.opdUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class opd_login {

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
					opd_login window = new opd_login();
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
	public opd_login() {
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
		
		JLabel account = new JLabel("帐号：");
		account.setBounds(82, 60, 54, 15);
		frame.getContentPane().add(account);
		
		JLabel password = new JLabel("密码：");
		password.setBounds(82, 103, 54, 15);
		frame.getContentPane().add(password);
		
		account_text = new JTextField();
		account_text.setBounds(139, 57, 147, 21);
		frame.getContentPane().add(account_text);
		account_text.setColumns(10);
		
		password_text = new JTextField();
		password_text.setBounds(139, 100, 147, 21);
		frame.getContentPane().add(password_text);
		password_text.setColumns(10);
		
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
		Return_btn.setBounds(102, 185, 93, 23);
		frame.getContentPane().add(Return_btn);
		
		JButton login_btn = new JButton("登录");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				opd_action.main(null);
			}
		});
		login_btn.setBounds(237, 185, 93, 23);
		frame.getContentPane().add(login_btn);
	}
}
