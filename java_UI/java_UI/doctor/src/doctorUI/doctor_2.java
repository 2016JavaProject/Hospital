package doctorUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class doctor_2 {

	private JFrame frame;
	String illness = new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor_2 window = new doctor_2();
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
	public doctor_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("医生");
		frame.setBounds(100, 100, 580, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String Patient_name = new String("xxx");
		int Patient_ID=0;
		JLabel lblNewLabel = new JLabel("病人:"+Patient_name+"          ID:"+Patient_ID);
		lblNewLabel.setBounds(0, 0, 418, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textPane_illness = new JTextPane();
		textPane_illness.setBounds(138, 36, 379, 290);
		frame.getContentPane().add(textPane_illness);
		
		JButton btn_illness = new JButton("本次病情");
		btn_illness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_illness.setText(illness);
			}
		});
		btn_illness.setBounds(0, 36, 123, 29);
		frame.getContentPane().add(btn_illness);
		
		
		JButton btnNewButton_1 = new JButton("开处方");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doctorUI.chufang.main(null);
			}
		});
		btnNewButton_1.setBounds(0, 80, 123, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton btn_save = new JButton("保存");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				illness=textPane_illness.getText();
				System.out.println(illness);
				System.out.println("1");
			}
		});
		btn_save.setBounds(282, 350, 100, 29);
		frame.getContentPane().add(btn_save);
		
		JButton btn_next = new JButton("下一个");
		btn_next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				doctorUI.doctor_2.main(null);
			}
		});
		btn_next.setBounds(424, 350, 93, 29);
		frame.getContentPane().add(btn_next);
		
		JButton btn_OldIllness = new JButton("以往病例");
		btn_OldIllness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String OldIllness = new String("以往病情");
				textPane_illness.setText(OldIllness);
			}
		});
		btn_OldIllness.setBounds(0, 128, 123, 29);
		frame.getContentPane().add(btn_OldIllness);
		
		JButton btn_Return = new JButton("返回");
		btn_Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doctor_1.main(null);
				frame.dispose();
			}
		});
		btn_Return.setBounds(458, -4, 100, 25);
		frame.getContentPane().add(btn_Return);
	}
}
