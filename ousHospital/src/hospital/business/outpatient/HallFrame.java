package hospital.business.outpatient;

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
import hospital.business.medicine.Prescription;
import hospital.business.patient.Patient;
import hospital.business.record.Record;

//门诊大厅
public class HallFrame {

	private JFrame frame;
	private JTextField mdicine_text_id;
	private DefaultTableModel tabelModel_dept;
	private static String docInf_dept[] = {"药品","数量"};
	private JTable table_medi;
	private Depart depart;
	private JTextField mdicine_text_fee;
	private JTextField register_text_time;
	private JTextField order_text_name;
	private JTextField register_text_name;
	private OutpatientSystem outpatient;
	private Patient patient;
	private static int fee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HallFrame window = new HallFrame();
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
	public HallFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("门诊大厅");
		frame.setBounds(100, 100, 725, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		depart = new Depart();
		outpatient = new OutpatientSystem();
		patient = new Patient();
		
		JButton btn_register = new JButton("挂号");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("显示库存表格");
			}
		});
		btn_register.setBounds(456, 13, 93, 23);
		frame.getContentPane().add(btn_register);
		
		JButton btn_order = new JButton("预约");
		btn_order.setBounds(115, 13, 93, 23);
		frame.getContentPane().add(btn_order);
		
		tabelModel_dept = new DefaultTableModel();
		table_medi = new JTable();
		table_medi.setModel(tabelModel_dept);
		table_medi.setEnabled(false);
		tabelModel_dept.setColumnIdentifiers(docInf_dept);
		
		JPanel panel__prescription = new JPanel();
		panel__prescription.setLayout(null);
		panel__prescription.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "药方", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		panel__prescription.setBounds(172, 264, 414, 388);
		frame.getContentPane().add(panel__prescription);
		
		JScrollPane scrollPane_medis = new JScrollPane(table_medi);
		scrollPane_medis.setEnabled(false);
		scrollPane_medis.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "药单费用", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		scrollPane_medis.setBounds(10, 94, 386, 284);
		panel__prescription.add(scrollPane_medis);
		
		JButton btn_showPrescription = new JButton("查看药单");
		btn_showPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientName = mdicine_text_id.getText();
				if(patientName == null || patientName.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入病人姓名进行 查看");
				} else {
					String patientid_tem = patient.getId(patientName);
					fee = outpatient.feeObtain(patientName);
					if(patientid_tem == null || patientid_tem.length() == 0 ||fee == 0) {
						JOptionPane.showMessageDialog(null, "病人没有产生费用或没有该病人");
					} else {
						int patientid = Integer.parseInt(patientid_tem);
						mdicine_text_fee.setText(fee + "");
						List<Prescription> values = outpatient.mediList(patientid);
						if(values != null || values.size() > 0) {
							for(Prescription pres : values) {
								Object[] data = new Object[2];
								data[0] = pres.getMediName();
								data[1] = pres.getNum();
								tabelModel_dept.addRow(data);
							}
						}
					}
				}
			}
		});
		btn_showPrescription.setBounds(284, 21, 93, 23);
		panel__prescription.add(btn_showPrescription);
		
		JLabel mdicine_label_fee = new JLabel("药费(含挂号费)：");
		mdicine_label_fee.setBounds(10, 66, 103, 15);
		panel__prescription.add(mdicine_label_fee);
		
		mdicine_text_fee = new JTextField();
		mdicine_text_fee.setEditable(false);
		mdicine_text_fee.setBounds(123, 63, 112, 21);
		panel__prescription.add(mdicine_text_fee);
		mdicine_text_fee.setColumns(10);
		
		mdicine_text_id = new JTextField();
		mdicine_text_id.setBounds(123, 22, 112, 21);
		panel__prescription.add(mdicine_text_id);
		mdicine_text_id.setColumns(10);
		
		JLabel mdicine_label_id = new JLabel("病人姓名：");
		mdicine_label_id.setBounds(10, 25, 103, 15);
		panel__prescription.add(mdicine_label_id);
		
		JButton btn_payoff = new JButton("付费");
		btn_payoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String feeStr = mdicine_text_fee.getText();
				if(feeStr == null || feeStr.equals("") ||fee == 0) {
					JOptionPane.showMessageDialog(null, "没有费用产生");
				} else {
					String patientName = mdicine_text_id.getText();
					String patientid_tem = patient.getId(patientName);
					int patientid = Integer.parseInt(patientid_tem);
					if(outpatient.feeToll(patientid)){
						JOptionPane.showMessageDialog(null, "付费成功");
						mdicine_text_fee.setText("");
						cleardatas(tabelModel_dept);
						Prescription.delete(patientid);
					} else{
						JOptionPane.showMessageDialog(null, "操作失败，请重新获取药费");
					};
				}
				
			}
		});
		btn_payoff.setBounds(284, 62, 93, 23);
		panel__prescription.add(btn_payoff);
		
		JPanel panel_order = new JPanel();
		panel_order.setLayout(null);
		panel_order.setBorder(new TitledBorder(null, "预约", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel_order.setBounds(10, 34, 334, 212);
		frame.getContentPane().add(panel_order);
		
		JLabel order_label_dept = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A");
		order_label_dept.setBounds(22, 43, 67, 15);
		panel_order.add(order_label_dept);
		
		JComboBox order_combox_dept = new JComboBox();
		order_combox_dept.setModel(new DefaultComboBoxModel(new String[] {"外科", "神经科", "眼科", "儿科", "妇科", "放射科"}));
		order_combox_dept.setBounds(99, 40, 190, 21);
		panel_order.add(order_combox_dept);
		
		JLabel order_label_time = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
		order_label_time.setBounds(22, 94, 67, 15);
		panel_order.add(order_label_time);
		
		JComboBox order_text_time_year = new JComboBox();
		order_text_time_year.setModel(new DefaultComboBoxModel(new String[] {"年", "2015", "2016", "2017", "2018", "2019", "2020"}));
		order_text_time_year.setBounds(99, 91, 67, 21);
		panel_order.add(order_text_time_year);
		
		JComboBox order_text_time_month = new JComboBox();
		order_text_time_month.setModel(new DefaultComboBoxModel(new String[] {"月", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		order_text_time_month.setBounds(165, 91, 67, 21);
		panel_order.add(order_text_time_month);
		
		JComboBox order_text_time_day = new JComboBox();
		order_text_time_day.setModel(new DefaultComboBoxModel(new String[] {"日", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		order_text_time_day.setBounds(230, 91, 59, 21);
		panel_order.add(order_text_time_day);
		
		JComboBox order_text_time_hour = new JComboBox();
		order_text_time_hour.setModel(new DefaultComboBoxModel(new String[] {"时", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		order_text_time_hour.setBounds(99, 140, 67, 21);
		panel_order.add(order_text_time_hour);
		
		JComboBox order_text_time_minute = new JComboBox();
		order_text_time_minute.setModel(new DefaultComboBoxModel(new String[] {"分", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		order_text_time_minute.setBounds(165, 140, 67, 21);
		panel_order.add(order_text_time_minute);
		
		JLabel order_label_name = new JLabel("病人姓名：");
		order_label_name.setBounds(22, 174, 67, 15);
		panel_order.add(order_label_name);
		
		order_text_name = new JTextField();
		order_text_name.setColumns(10);
		order_text_name.setBounds(99, 171, 112, 21);
		panel_order.add(order_text_name);
		
		JPanel panel_register = new JPanel();
		panel_register.setLayout(null);
		panel_register.setBorder(new TitledBorder(null, "挂号", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel_register.setBounds(354, 34, 334, 212);
		frame.getContentPane().add(panel_register);
		
		JLabel register_label_dept = new JLabel("挂号部门");
		register_label_dept.setBounds(23, 38, 67, 15);
		panel_register.add(register_label_dept);
		
		JComboBox register_combox_dept = new JComboBox();
		register_combox_dept.setModel(new DefaultComboBoxModel(new String[] {"外科", "神经科", "眼科", "儿科", "妇科", "放射科"}));
		register_combox_dept.setBounds(100, 35, 112, 21);
		panel_register.add(register_combox_dept);
		
		JLabel register_label_time = new JLabel("挂号时间：");
		register_label_time.setBounds(20, 93, 67, 15);
		panel_register.add(register_label_time);
		
		register_text_time = new JTextField();
		register_text_time.setEditable(false);
		register_text_time.setColumns(10);
		register_text_time.setBounds(100, 90, 112, 21);
		panel_register.add(register_text_time);
		
		JLabel register_label_name = new JLabel("病人姓名：");
		register_label_name.setBounds(23, 139, 67, 15);
		panel_register.add(register_label_name);
		
		register_text_name = new JTextField();
		register_text_name.setColumns(10);
		register_text_name.setBounds(100, 136, 112, 21);
		panel_register.add(register_text_name);
		btn_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		btn_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String createTime = order_text_time_year.getSelectedItem()+"-"+order_text_time_month.getSelectedItem()
				+"-"+order_text_time_day.getSelectedItem()+" "+order_text_time_hour.getSelectedItem()+":"+order_text_time_minute.getSelectedItem()+":00";
				String patientName = order_text_name.getText();
				String departName = order_combox_dept.getSelectedItem().toString();
				//System.out.println();
				
				Record record = new Record();
				
				Patient patient = new Patient();
				patient.name = patientName;
				record.setPatient(patient);
				
				Depart depart = new Depart();
				depart.setDeptName(departName);
				record.setDept(depart);
				record.setCreateTime(createTime);
				if(Record.insertRecord(record)) {
					JOptionPane.showMessageDialog(null, "预约成功");
				} else {
					JOptionPane.showMessageDialog(null, "预约失败");
				}
				
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
