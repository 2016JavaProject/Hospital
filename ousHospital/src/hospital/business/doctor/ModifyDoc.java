package hospital.business.doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import hospital.business.dept.Depart;
import hospital.db.DataBase;

public class ModifyDoc extends JFrame{
	private JPanel contentPane;
	private JTable table;
	private JTextField id_text;
	private JTextField name_text;
	private JTextField tel_text;
	private JTextField age_text;
	private JTextField deptid_text;
	private JTextField comm_text;
	private Doctor doc;
	private DataBase dBase;
	private Connection connection;
	private java.sql.PreparedStatement ps;
	private JComboBox status_combox;
	private JComboBox dept_combox;
	
	
	/*public static void main (String[] args) {
		Doctor doctor=new Doctor("1","2",Integer.parseInt("3"),Integer.parseInt("4"),"5");
		ModifyDoc modifyBook=new ModifyDoc(doctor);
		modifyBook.setVisible(true);
	}*/
	
	public ModifyDoc(final Doctor doc) {
		dBase = new DataBase();
		connection = dBase.getCon();
		this.doc = doc;
		setResizable(false);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 185, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("信息修改");
		label_2.setFont(new Font("楷体", Font.PLAIN, 23));
		label_2.setBounds(35,10,92,30);
		contentPane.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "信息修改", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel.setBounds(10,52,159,200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("证件号");
		label.setBounds(10,21,52,15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(10,50,52,15);
		panel.add(label_1);
		
		JLabel label_6 = new JLabel("状态");
		label_6.setBounds(10, 75, 52, 15);
		panel.add(label_6);
		
		JLabel label_3 = new JLabel("电话");
		label_3.setBounds(10,100,52,15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("年龄");
		label_4.setBounds(10,125,52,15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("部门");
		label_5.setBounds(10,150,52,15);
		panel.add(label_5);
		
		
		
		id_text = new JTextField(doc.getId());
		id_text.setColumns(10);
		id_text.setEditable(false);
		id_text.setBounds(72,18,66,21);
		panel.add(id_text);
		
		name_text = new JTextField(doc.getName());
		name_text.setColumns(10);
		name_text.setBounds(72,47,66,21);
		panel.add(name_text);
		
		tel_text = new JTextField(doc.getTel());
		tel_text.setColumns(10);
		tel_text.setBounds(72,97,66,21);
		panel.add(tel_text);
		
		//age_text = new JTextField(doc.getAge());
		String docAge = doc.getAge() +"";
		age_text = new JTextField(docAge);
		age_text.setColumns(10);
		age_text.setBounds(72,125,66,21);
		panel.add(age_text);
		
		//deptid_text = new JTextField(doc.getDepatid() + "");
		/*deptid_text = new JTextField(doc.getDepatid());
		deptid_text.setColumns(10);
		deptid_text.setBounds(72,150 , 66, 21);
		panel.add(deptid_text);*/
		
		dept_combox = new JComboBox();
		dept_combox.setModel(new DefaultComboBoxModel(((new Depart()).getComItem())));
		dept_combox.setSelectedIndex((new Depart()).listIndex(doc.getDepatid()));
		/*int i = (new Depart()).getComIndex(doc.getDepatid());
		System.out.println(i);*/
		dept_combox.setBounds(72,150 , 66, 21);
		panel.add(dept_combox);
		
		
		status_combox = new JComboBox();
		status_combox.setModel(new DefaultComboBoxModel (new String[] {"空闲", "忙碌","休班" ,"离职"}));
		if(doc.getStatus().equals("空闲")) {
			status_combox.setSelectedIndex(0);
		} else if(doc.getStatus().equals("忙碌")) {
			status_combox.setSelectedIndex(1);
		} else if(doc.getStatus().equals("休班")) {
			status_combox.setSelectedIndex(2);
		} else if(doc.getStatus().equals("离职")) {
			status_combox.setSelectedIndex(3);
		}
		status_combox.setBounds(72, 72, 66, 21);
		panel.add(status_combox);
		
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
		        //监听器代码
		    	if(checkDatas()) {
		    		System.out.println(doc.getId() + doc.getName() + doc.getTel() + doc.getAge() + doc.getDepatid() + doc.getStatus() + doc.getComment());
		    		try {
						ps = connection.prepareStatement("update t_doctor set name=?, tel=?, age=?, deptid=?, status=? where id=? ");
						String docId = id_text.getText();
						String  docName = name_text.getText();
						String docAge = age_text.getText();
						String docStatus = status_combox.getSelectedItem().toString();
						String docTel = tel_text.getText();
						//String docDeptid = deptid_text.getText();
						ps.setString(6, id_text.getText());
						ps.setString(1, name_text.getText());
						ps.setString(2, tel_text.getText());
						ps.setString(3, age_text.getText());
						ps.setInt(4, (new Depart()).getComIndex(dept_combox.getSelectedItem().toString()));		//(new Depart(Integer.parseInt(rs.getString(5)))).name
						ps.setString(5, status_combox.getSelectedItem().toString());
						connection.setAutoCommit(false);
						ps.executeUpdate();
					    connection.commit();
					    JOptionPane.showMessageDialog(null, "信息更新成功！");
					    setVisible(false);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "信息修改时出现错误！");
						  try {
							connection.rollback();
						} catch (SQLException e2) {
							 JOptionPane.showMessageDialog(null, "信息修改时出现错误！");
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}
		    	}
		    }
		});
		button.setBounds(47, 175, 67, 23);
		panel.add(button);
		
	}
	
	private boolean checkDatas() {
		boolean result = true;
		String docId = id_text.getText();
		String  docName = name_text.getText();
		String docAge = age_text.getText();
		String docStatus = status_combox.getSelectedItem().toString();
		String docTel = tel_text.getText();
		//String docDeptid = deptid_text.getText();
		String docDeptid = dept_combox.getSelectedItem().toString();
		System.out.println(docId + docName + docAge + docStatus + docTel + docDeptid);
		
		if(docName == null || docName.equals("")) {
			JOptionPane.showMessageDialog(null,"姓名不能为空" );
			name_text.requestFocus();
			result = false;
		} else if(docDeptid == null || docDeptid.equals("")) {
			JOptionPane.showMessageDialog(null,"部门不能为空" );
			deptid_text.requestFocus();
			result = false;
		} else {
			int age = Integer.parseInt(docAge);
				try {
					if(age <= 0 || age>= 100) {
						JOptionPane.showMessageDialog(null, "输入年龄不许介于0-100之间");
						result = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"年龄格式出现错误" );
					result = false;
				}
		}
		return result;
	}
	
}
