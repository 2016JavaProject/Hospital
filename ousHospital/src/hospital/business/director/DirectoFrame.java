package hospital.business.director;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import hospital.business.dept.Depart;

public class DirectoFrame {

	private JFrame frame;
	private JTextField patient_text_doc;
	private JTextField income_text_doc;
	private DefaultTableModel tabelModel_dept;
	private static String docInf_dept[] = {"部门","挂号数量","金额"};
	private JTable table_dept;
	private Depart depart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectoFrame window = new DirectoFrame();
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
	public DirectoFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("院长查询");
		frame.setBounds(100, 100, 708, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		depart = new Depart();
		
		JButton btn_medi = new JButton("药品统计");
		btn_medi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_medi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("显示库存表格");
			}
		});
		btn_medi.setBounds(474, 472, 93, 23);
		frame.getContentPane().add(btn_medi);
		
		JPanel pane_doc = new JPanel();
		pane_doc.setLayout(null);
		pane_doc.setBorder(new TitledBorder(null, "操作", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		pane_doc.setBounds(329, 36, 344, 213);
		frame.getContentPane().add(pane_doc);
		
		JLabel lblNewLabel_4 = new JLabel("医生就诊金额(含挂号费)");
		lblNewLabel_4.setBounds(43, 144, 149, 15);
		pane_doc.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("医生就诊数量");
		lblNewLabel_3.setBounds(43, 102, 93, 15);
		pane_doc.add(lblNewLabel_3);
		
		patient_text_doc = new JTextField();
		patient_text_doc.setBounds(196, 98, 112, 21);
		pane_doc.add(patient_text_doc);
		patient_text_doc.setText("3333");
		patient_text_doc.setColumns(10);
		
		income_text_doc = new JTextField();
		income_text_doc.setBounds(196, 140, 112, 21);
		pane_doc.add(income_text_doc);
		income_text_doc.setText("4444");
		income_text_doc.setColumns(10);
		
		JButton btn_doc = new JButton("医生统计");
		btn_doc.setBounds(192, 39, 93, 23);
		pane_doc.add(btn_doc);
		
		JComboBox combox_doc = new JComboBox();
		combox_doc.setBounds(43, 40, 84, 21);
		pane_doc.add(combox_doc);
		combox_doc.setModel(new DefaultComboBoxModel(new String[] {"医生"}));
		btn_doc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("医生"+combox_doc.getSelectedItem());
			}
		});
		
		JButton btn_dept = new JButton("部门统计");
		btn_dept.setBounds(115, 13, 93, 23);
		frame.getContentPane().add(btn_dept);
		
		tabelModel_dept = new DefaultTableModel();
		table_dept = new JTable();
		table_dept.setModel(tabelModel_dept);
		table_dept.setEnabled(false);
		tabelModel_dept.setColumnIdentifiers(docInf_dept);
		
		JScrollPane scrollPane_dept = new JScrollPane(table_dept);
		scrollPane_dept.setBounds(14, 36, 301, 213);
		frame.getContentPane().add(scrollPane_dept);
		scrollPane_dept.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "部门显示", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		
		JScrollPane scrollPane_medi = new JScrollPane((Component) null);
		scrollPane_medi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "药品显示", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		scrollPane_medi.setBounds(163, 262, 297, 233);
		frame.getContentPane().add(scrollPane_medi);
		btn_dept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cleardatas(tabelModel_dept);
				List<Depart> values = depart.getIncome();
				if(values != null || values.size() > 0) {
					for(Depart dept : values) {
						Object data[] = new Object[3];
						data[0] = dept.getDeptName();
						data[1] = dept.getPatientNum();
						data[2] = dept.getDeptIncome();
						tabelModel_dept.addRow(data);
					}
				} else {
					JOptionPane.showMessageDialog(null, "查询结果为空�?");
				}
				
			}
		});
		btn_dept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	private void cleardatas(DefaultTableModel tableModel){//清除表格中所有的数据
		int rows = tableModel.getRowCount();
		if (rows != 0) {
			tableModel.setRowCount(0);
			//new Thread(this).interrupt();
		}
	}
}
