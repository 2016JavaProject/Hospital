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
import javax.swing.JTextArea;
import javax.swing.JList;

public class patient_order {

	private JFrame frame;

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
		JComboBox order_keshi_cb = new JComboBox();
		JComboBox month = new JComboBox();
		JComboBox day = new JComboBox();
		JComboBox year = new JComboBox();
		JComboBox hour = new JComboBox();
		JComboBox minute = new JComboBox();
		
		JLabel order_keshi_label = new JLabel("预约科室：");
		order_keshi_label.setBounds(77, 38, 67, 15);
		frame.getContentPane().add(order_keshi_label);
		
		JLabel order_time_label = new JLabel("预约时间：");
		order_time_label.setBounds(77, 89, 67, 15);
		frame.getContentPane().add(order_time_label);
		
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
				System.out.println("预约科室："+order_keshi_cb.getSelectedItem());
				System.out.println("预约时间："+year.getSelectedItem()+"/"+month.getSelectedItem()
				+"/"+day.getSelectedItem()+"  "+hour.getSelectedItem()+":"+minute.getSelectedItem());
				
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
		
		
		order_keshi_cb.setModel(new DefaultComboBoxModel(new String[] {"选择科室", "脑残科", "妇产科", "皮肤科"}));
		order_keshi_cb.setBounds(154, 35, 190, 21);
		frame.getContentPane().add(order_keshi_cb);
		
		
		month.setModel(new DefaultComboBoxModel(new String[] {"月", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month.setBounds(220, 86, 67, 21);
		frame.getContentPane().add(month);
		
		
		day.setModel(new DefaultComboBoxModel(new String[] {"日", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day.setBounds(285, 86, 59, 21);
		frame.getContentPane().add(day);
		
		
		year.setModel(new DefaultComboBoxModel(new String[] {"年", "2015", "2016", "2017", "2018", "2019", "2020"}));
		year.setBounds(154, 86, 67, 21);
		frame.getContentPane().add(year);
		
		
		hour.setModel(new DefaultComboBoxModel(new String[] {"时", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		hour.setBounds(154, 135, 67, 21);
		frame.getContentPane().add(hour);
		
		
		minute.setModel(new DefaultComboBoxModel(new String[] {"分", "00", "10", "20", "30", "40", "50"}));
		minute.setBounds(220, 135, 67, 21);
		frame.getContentPane().add(minute);
	}
}
