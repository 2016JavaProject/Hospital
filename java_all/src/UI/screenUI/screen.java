package UI.screenUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class screen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					screen window = new screen();
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
	public screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("院长查询");
		frame.setBounds(100, 100, 676, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  挂号量：");
		lblNewLabel.setBounds(10, 75, 71, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("    金额：");
		lblNewLabel_1.setBounds(10, 135, 71, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("1111");
		textField.setBounds(91, 72, 102, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("2222");
		textField_1.setBounds(91, 132, 102, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox keshi = new JComboBox();
		keshi.setModel(new DefaultComboBoxModel(new String[] {"科室"}));
		keshi.setBounds(91, 24, 83, 21);
		frame.getContentPane().add(keshi);
		
		JLabel lblNewLabel_2 = new JLabel("科室：");
		lblNewLabel_2.setBounds(27, 27, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("显示");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("科室："+keshi.getSelectedItem());
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(184, 23, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("药房库存");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("显示库存表格");
			}
		});
		btnNewButton_1.setBounds(302, 23, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JComboBox doctor = new JComboBox();
		doctor.setModel(new DefaultComboBoxModel(new String[] {"医生"}));
		doctor.setBounds(437, 24, 84, 21);
		frame.getContentPane().add(doctor);
		
		JButton xianshi2_btn = new JButton("显示");
		xianshi2_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("医生："+doctor.getSelectedItem());
			}
		});
		xianshi2_btn.setBounds(532, 23, 93, 23);
		frame.getContentPane().add(xianshi2_btn);
		
		JLabel lblNewLabel_3 = new JLabel("医生就诊数量：");
		lblNewLabel_3.setBounds(268, 75, 93, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("医生就诊金额：");
		lblNewLabel_4.setBounds(268, 135, 93, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setText("3333");
		textField_2.setBounds(375, 72, 112, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("4444");
		textField_3.setBounds(375, 132, 112, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("药房库存：");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(29, 234, 121, 39);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
