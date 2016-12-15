package UI.opdUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guahao_keshi {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guahao_keshi window = new guahao_keshi();
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
	public guahao_keshi() {
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
		
		JLabel keshi = new JLabel("科室：");
		keshi.setBounds(92, 62, 54, 18);
		frame.getContentPane().add(keshi);
		
		JButton logout_btn = new JButton("退出");
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logout_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				opd_action.main(null);
			}
		});
		logout_btn.setBounds(92, 192, 93, 23);
		frame.getContentPane().add(logout_btn);
		
		JButton confirm_btn = new JButton("确定");
		confirm_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirm_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				guahao_success.main(null);
			}
		});
		confirm_btn.setBounds(236, 192, 93, 23);
		frame.getContentPane().add(confirm_btn);
		
		JComboBox keshi_name = new JComboBox();
		keshi_name.setModel(new DefaultComboBoxModel(new String[] {"脑残科", "妇产科", "皮肤科"}));
		keshi_name.setBounds(131, 61, 192, 21);
		frame.getContentPane().add(keshi_name);
		
		JLabel doctor = new JLabel("医生：");
		doctor.setBounds(92, 119, 54, 15);
		frame.getContentPane().add(doctor);
		
		JComboBox doctor_name = new JComboBox();
		doctor_name.setModel(new DefaultComboBoxModel(new String[] {"时道顺", "黄柏豪", "赵乾坤"}));
		doctor_name.setBounds(131, 116, 192, 21);
		frame.getContentPane().add(doctor_name);
	}
}
