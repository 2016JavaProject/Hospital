package UI.patientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patient_Register {

	private JFrame frame;
	private JTextField username_text;
	private JTextField userage_text;
	private JTextField userphone_text;
	private JTextField userID_text;
	private JTextField remark_text;
	private JTextField more_1_text;
	private JTextField more_2_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_Register window = new patient_Register();
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
	public patient_Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel username = new JLabel("姓名：");
		username.setBounds(105, 50, 54, 15);
		frame.getContentPane().add(username);
		
		username_text = new JTextField();
		username_text.setBounds(186, 47, 137, 21);
		frame.getContentPane().add(username_text);
		username_text.setColumns(10);
		
		JLabel userage = new JLabel("年龄：");
		userage.setBounds(105, 86, 54, 15);
		frame.getContentPane().add(userage);
		
		userage_text = new JTextField();
		userage_text.setBounds(186, 83, 137, 21);
		frame.getContentPane().add(userage_text);
		userage_text.setColumns(10);
		
		JLabel userphone = new JLabel("电话：");
		userphone.setBounds(105, 128, 54, 15);
		frame.getContentPane().add(userphone);
		
		userphone_text = new JTextField();
		userphone_text.setBounds(186, 125, 137, 21);
		frame.getContentPane().add(userphone_text);
		userphone_text.setColumns(10);
		
		JLabel userID = new JLabel("ID:");
		userID.setBounds(105, 170, 54, 15);
		frame.getContentPane().add(userID);
		
		userID_text = new JTextField();
		userID_text.setBounds(186, 167, 137, 21);
		frame.getContentPane().add(userID_text);
		userID_text.setColumns(10);
		
		JLabel remark = new JLabel("备注：");
		remark.setBounds(105, 208, 54, 15);
		frame.getContentPane().add(remark);
		
		remark_text = new JTextField();
		remark_text.setBounds(186, 205, 137, 21);
		frame.getContentPane().add(remark_text);
		remark_text.setColumns(10);
		
		JLabel more_1 = new JLabel("more");
		more_1.setBounds(105, 252, 54, 15);
		frame.getContentPane().add(more_1);
		
		more_1_text = new JTextField();
		more_1_text.setBounds(186, 249, 137, 21);
		frame.getContentPane().add(more_1_text);
		more_1_text.setColumns(10);
		
		JLabel more_2 = new JLabel("more");
		more_2.setBounds(105, 295, 54, 15);
		frame.getContentPane().add(more_2);
		
		more_2_text = new JTextField();
		more_2_text.setBounds(186, 292, 137, 21);
		frame.getContentPane().add(more_2_text);
		more_2_text.setColumns(10);
		
		JButton Return_btn = new JButton("返回");
		Return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Return_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				patient_login.main(null);
			}
		});
		Return_btn.setBounds(82, 376, 112, 23);
		frame.getContentPane().add(Return_btn);
		
		JButton login_btn = new JButton("注册成功并登录");
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				frame.dispose();
				patient_action.main(null);
				
				
			}
		});
		login_btn.setBounds(250, 376, 122, 23);
		frame.getContentPane().add(login_btn);
	}

}
