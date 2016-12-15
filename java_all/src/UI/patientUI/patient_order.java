package UI.patientUI;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class patient_order {

	private JFrame frame;
	private JTextField order_time_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_order window = new patient_order();
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
	public patient_order() {
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
		
		JLabel order_keshi_label = new JLabel("预约科室：");
		order_keshi_label.setBounds(77, 38, 67, 15);
		frame.getContentPane().add(order_keshi_label);
		
		JLabel order_time_label = new JLabel("预约时间：");
		order_time_label.setBounds(77, 89, 67, 15);
		frame.getContentPane().add(order_time_label);
		
		order_time_text = new JTextField();
		order_time_text.setBounds(154, 86, 133, 21);
		frame.getContentPane().add(order_time_text);
		order_time_text.setColumns(10);
		
		JButton Return_btn = new JButton("返回");
		Return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Return_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				patient_action.main(null);
			}
		});
		Return_btn.setBounds(90, 181, 93, 23);
		frame.getContentPane().add(Return_btn);
		
		JButton confirm_btn = new JButton("确定");
		confirm_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				success.main(null);
				
			}
		});
		confirm_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirm_btn.setBounds(241, 181, 93, 23);
		frame.getContentPane().add(confirm_btn);
		
		JComboBox order_keshi_cb = new JComboBox();
		order_keshi_cb.setModel(new DefaultComboBoxModel(new String[] {"脑残科", "妇产科", "皮肤科"}));
		order_keshi_cb.setBounds(154, 35, 133, 21);
		frame.getContentPane().add(order_keshi_cb);
		
		JLabel geshi_label = new JLabel("格式：年/月/日");
		geshi_label.setBounds(288, 89, 146, 15);
		frame.getContentPane().add(geshi_label);
	}

}
