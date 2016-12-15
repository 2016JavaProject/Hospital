package java_Home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import UI.patientUI.patient_order;

import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class java_Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					java_Home window = new java_Home();
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
	public java_Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("主界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logout_btn = new JButton("退出");
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logout_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		logout_btn.setBounds(166, 228, 93, 23);
		frame.getContentPane().add(logout_btn);
		
		JButton patient = new JButton("患者");
		patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		patient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				UI.patientUI.patient_login.main(null);
				
			}
		});
		patient.setBounds(166, 20, 93, 23);
		frame.getContentPane().add(patient);
		
		JButton Doctor_btn = new JButton("医生");
		Doctor_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Doctor_btn.setBounds(166, 53, 93, 23);
		frame.getContentPane().add(Doctor_btn);
		
		JButton phar_btn = new JButton("药师");
		phar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		phar_btn.setBounds(166, 86, 93, 23);
		frame.getContentPane().add(phar_btn);
		
		JButton opd_btn = new JButton("门诊");
		opd_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		opd_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				UI.opdUI.opd_login.main(null);
			}
		});
		opd_btn.setBounds(166, 119, 93, 23);
		frame.getContentPane().add(opd_btn);
		
		JButton more_btn = new JButton("more");
		more_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		more_btn.setBounds(166, 152, 93, 23);
		frame.getContentPane().add(more_btn);
	}
}
