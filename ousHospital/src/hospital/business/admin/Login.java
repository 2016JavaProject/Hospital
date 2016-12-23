package hospital.business.admin;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hospital.business.doctor.DocFrame;
import hospital.business.doctor.Doctor;
import hospital.db.DataBase;


public class Login extends JFrame {
	private JFrame frame;
	private JTextField account_text;
	private JTextField password_text;
	private static String saveValue = null;
	private RadioButtonListener radioButtonListener=new RadioButtonListener();
	private DataBase db;
	private Connection con;
	private PreparedStatement ps;
	private DocFrame docFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	
	public class RadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JRadioButton temp = (JRadioButton)arg0.getSource();
			if(temp.isSelected()) {
				saveValue = temp.getText();
				System.out.println(temp.getText());
			}
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//frame.setLocationRelativeTo(c);
		
		/*Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰� 
		 Dimension screenSize = kit.getScreenSize(); // ��ȡ��Ļ�ĳߴ� 
		 int screenWidth = screenSize.width/2; // ��ȡ��Ļ�Ŀ�
		 int screenHeight = screenSize.height/2; // ��ȡ��Ļ�ĸ�
		 int height = this.getHeight(); int width = this.getWidth(); 
		 //setLocation(screenWidth-width/2, screenHeight-height/2);
		 frame.setLocation(screenWidth-width/2, screenHeight-height/2);*/
		
		JLabel account_label = new JLabel("�ʺ�:");
		account_label.setBounds(75, 55, 54, 15);
		frame.getContentPane().add(account_label);
		
		JLabel password_label = new JLabel("����:");
		password_label.setBounds(75, 104, 54, 15);
		frame.getContentPane().add(password_label);
		
		account_text = new JTextField();
		account_text.setText("�������ʺ�");
		account_text.setBounds(150, 52, 134, 21);
		frame.getContentPane().add(account_text);
		account_text.setColumns(10);
		
		password_text = new JTextField();
		//password_text.setText("����ͨ�����");
		//password_text.setEditable(false);
		password_text.setBounds(150, 101, 134, 21);
		frame.getContentPane().add(password_text);
		password_text.setColumns(10);
		
		JButton login_btn = new JButton("��¼");
		/*login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("��ӭ��½����");
				frame.dispose();
				
			}
		});*/
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = account_text.getText();
				String password = password_text.getText();
				boolean flagPs = false;
				db = new DataBase();
				con = db.getCon();
				
				try {
					
					if(saveValue.equals("ҽ��")) {
						ps = con.prepareStatement("select * from t_doctor where name='" + name +"' and password='" + password +"' ");
					} else if(saveValue.equals("ҩʦ")) {
						ps = con.prepareStatement("select * from t_apothecary where name='" + name +"' and password='" + password +"' ");
					} else {
						ps = con.prepareStatement("select * from t_user where name='" + name +"' and password='" + password +"'  and role='" + saveValue +"' " );
					}
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
							//JOptionPane.showMessageDialog(null, "ye");
							if(saveValue.equalsIgnoreCase("ҽ��")) {
								frame.dispose();
								Doctor doctor = new Doctor(rs.getInt("id")+"",name,rs.getInt("age"),rs.getInt("deptid")+""," ");
								docFrame = new DocFrame(doctor);
								docFrame.setVisible(true);
							} else if(saveValue.equalsIgnoreCase("ҩʦ")) {
								JOptionPane.showMessageDialog(null, "test success");
							} else {
								JOptionPane.showMessageDialog(null, "i am ?");
							}
							flagPs = true;
					}
					
					if( !flagPs) {
						JOptionPane.showMessageDialog(null,"�����������˺����룬��ѡ���� ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		login_btn.setBounds(166, 188, 93, 23);
		frame.getContentPane().add(login_btn);
		
		
		ButtonGroup btnGroup = new ButtonGroup();
		//JRadioGroup  rdGroup = new JRadioGroup();
		JRadioButton rdbtn_admin = new JRadioButton("����Ա");
		rdbtn_admin.addActionListener(radioButtonListener);
		//rdbtn_admin.setSelected(true);
		rdbtn_admin.setBounds(26, 141, 81, 27);
		frame.getContentPane().add(rdbtn_admin);
		
		JRadioButton rdbtn_doc = new JRadioButton("ҽ��");
		rdbtn_doc.addActionListener(radioButtonListener);
		rdbtn_doc.setBounds(132, 141, 81, 27);
		frame.getContentPane().add(rdbtn_doc);
		
		JRadioButton rdbtn_apot = new JRadioButton("ҩʦ");
		rdbtn_apot.addActionListener(radioButtonListener);
		rdbtn_apot.setBounds(227, 141, 81, 27);
		frame.getContentPane().add(rdbtn_apot);
		
		JRadioButton rdbtn_director = new JRadioButton("Ժ��");
		rdbtn_director.addActionListener(radioButtonListener);
		rdbtn_director.setBounds(316, 141, 81, 27);
		frame.getContentPane().add(rdbtn_director);
		
		btnGroup.add(rdbtn_director);
		btnGroup.add(rdbtn_apot);
		btnGroup.add(rdbtn_doc);
		btnGroup.add(rdbtn_admin);
		
		JButton retry_btn = new JButton("����");
		retry_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account_text.setText("");
				password_text.setText("");
			}
		});
		retry_btn.setBounds(304, 188, 93, 23);
		frame.getContentPane().add(retry_btn);
		
		/*JButton see_btn = new JButton("���");
		see_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlString = account_text.getText();
				if(sqlString.isEmpty() || sqlString.length() > 18) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�ջ��ܳ���18λ");
				}
				db = new DataBase();
				con = db.getCon();
				try {
					ps = con.prepareStatement("select id from t_user where id='" + sqlString +"'");
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						if(rs.getString("id").equals(sqlString)) {
							JOptionPane.showMessageDialog(null, "�����û�������������");
							password_text.setEditable(true);
							password_text.setText("");;
						} else {
							JOptionPane.showMessageDialog(null, "error");
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		see_btn.setBounds(304, 49, 93, 23);
		frame.getContentPane().add(see_btn);*/
		
		//int selected = btnGroup.getC
	}
}