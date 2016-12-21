import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class screenUI {

	private JFrame frame;
	private JTable table;
	String[] Department = new String[]{"null","呼吸科","五官科","内科","外科","儿科"};
	String message = new String("输出文本信息");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					screenUI window = new screenUI();
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
	public screenUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("显示屏");
		frame.setBounds(100, 100, 636, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane text_message = new JTextPane();//输出文本信息
		text_message.setText(message);
		text_message.setBounds(10, 30, 589, 74);
		frame.getContentPane().add(text_message);
		
		JComboBox comboBox_department = new JComboBox(Department);//下拉框信息
		comboBox_department.setBounds(63, 173, 123, 40);
		frame.getContentPane().add(comboBox_department);
		
		JButton btn_display = new JButton("显示");//显示屏
		btn_display.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(comboBox_department.getSelectedItem());
			}
		});
		btn_display.setBounds(63, 286, 123, 29);
		frame.getContentPane().add(btn_display);
		
		table = new JTable();//表格信息,填写编号,名字
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"编号", "大名"
			}
		));
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setBounds(325, 119, 274, 266);
		frame.getContentPane().add(table);
		
		
		
	}
}
