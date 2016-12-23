package hospital.business.admin;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import hospital.business.apothecary.Apothecary;
import hospital.business.apothecary.ModifyApot;
import hospital.business.dept.Depart;
import hospital.business.doctor.Doctor;
import hospital.business.doctor.ModifyDoc;
import hospital.db.DataBase;

public class AdminFrame extends JFrame{
	private JPanel contentPane;
	private JTable table;
	//private JTable table;
	private JTextField id_text_doc;
	private JTextField name_text_doc;
	private JTextField tel_text;
	private JTextField age_text_doc;
	private JTextField deptid_text;
	private JTextField comm_text;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel_apot;
	private DataBase db;
	private Connection con;
	private PreparedStatement ps;
	private static String docInf_doc[]={"����","����","���� ","״̬","����"};
	private static String docInf_medi[]={"���","����","�ۼ�","���"};
	private static String docInf_apot[]={"����","����"};
	private JButton add_btn_doc,showAll_btn_doc,clear_Button;
	private JComboBox status_combox_doc;
	private JComboBox dept_combox_doc;
	private JPopupMenu popMenu;
	private JMenuItem deleteMenuItem;
	private JMenuItem modifyJMenuItem;
	ModifyDoc modifyDoc;
	private ModifyApot modifyApot;
	private JPanel pane_medicine;
	private JLabel id_label_medi;
	private JTextField id_text_medi;
	private JLabel name_label_medi;
	private JTextField name_text_medi;
	private JLabel price_label_medi;
	private JButton add_btn_medi;
	private JTextField price_text_medi;
	private JPanel pane_apothecary;
	private JLabel id_label_apot;
	private JTextField id_text_apot;
	private JLabel name_label_apot;
	private JTextField name_text_apot;
	private JButton add_btn_apot;
	private JTextField stock_text_medi;
	private Apothecary apothecary;
	private static String showEntity = null;
	
	public static void main(String[] args) {
		AdminFrame frame = new AdminFrame();
		
		frame.setVisible(true);
	}
	
	public AdminFrame() {
		db=new DataBase();
		con=db.getCon();
		
		apothecary = new Apothecary();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		popMenu=new JPopupMenu();
        deleteMenuItem=new JMenuItem("ɾ��������¼");
        deleteMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				String Id=table.getValueAt(row, 0)+"";
				if(showEntity.equals("ҽ��")) {
					try {
						ps=con.prepareStatement("delete from t_doctor where id=?");
						ps.setString(1, Id);
						con.setAutoCommit(false);
						ps.execute();
						con.setAutoCommit(true);
						tableModel.removeRow(row);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "ɾ��ʱ�����˴���!");
						try {
							con.rollback();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "ɾ��ʱ�����˴���!");
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
				} else if(showEntity.equals("ҩƷ")) {
					
				} else {
					if(apothecary.delete(Integer.parseInt(Id))) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
					} else {
						JOptionPane.showMessageDialog(null, "ɾ��ʱ�����˴���!");
					};
				}
				
			}
		});
        
        popMenu.add(deleteMenuItem);
        modifyJMenuItem=new JMenuItem("�޸ĸ�����¼");
        modifyJMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				if(showEntity.equals("ҽ��")) {
					String Id=table.getValueAt(row, 0)+"";
					String Name=table.getValueAt(row, 1)+"";
					String Age=table.getValueAt(row, 2)+"";
					String Status=table.getValueAt(row, 3)+"";
					String Deptid=table.getValueAt(row, 4)+"";
					System.out.println(Deptid);
					Doctor doctor=new Doctor(Id,Name,Integer.parseInt(Age),Deptid,Status);
					modifyDoc=new ModifyDoc(doctor);
					modifyDoc.setVisible(true);
				} else if(showEntity.equals("ҩƷ")) {
					
				} else {
					String id_temp=table.getValueAt(row, 0)+"";
					int Id = Integer.parseInt(id_temp);
					String Name=table.getValueAt(row, 1)+"";
					String Pwd = apothecary.getInfo(apothecary, Id).getPassword();
					apothecary = new Apothecary(Id,Name,Pwd);
					modifyApot = new ModifyApot(apothecary);
					modifyApot.setVisible(true);
				}
				
			}
		});
        
        popMenu.add(modifyJMenuItem);
        
        JPanel panel_doctor = new JPanel();
		panel_doctor.setBorder(new TitledBorder(null, "����", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel_doctor.setBounds(20, 22, 711, 54);
		contentPane.add(panel_doctor);
		panel_doctor.setLayout(null);
		
		JLabel id_label_doc = new JLabel("����:");
		id_label_doc.setBounds(10, 29, 32, 15);
		panel_doctor.add(id_label_doc);
		
		id_text_doc = new JTextField();
		id_text_doc.setText("���빤��");
		id_text_doc.setBounds(52, 26, 54, 21);
		panel_doctor.add(id_text_doc);
		id_text_doc.setColumns(10);
		
		JLabel name_lable_doc = new JLabel("����:");
		name_lable_doc.setBounds(112, 29, 32, 15);
		panel_doctor.add(name_lable_doc);
		
		name_text_doc = new JTextField();
		name_text_doc.setText("��������");
		name_text_doc.setColumns(10);
		name_text_doc.setBounds(142, 26, 66, 21);
		panel_doctor.add(name_text_doc);
		
		JLabel status_label_doc = new JLabel("״̬:");
		status_label_doc.setBounds(210, 29, 32, 15);
		panel_doctor.add(status_label_doc);
		
		status_combox_doc = new JComboBox();
		status_combox_doc.setModel(new DefaultComboBoxModel(new String[] {"����", "æµ","�ݰ�" ,"��ְ"}));
		status_combox_doc.setSelectedIndex(0);
		status_combox_doc.setBounds(240, 26, 55, 21);
		panel_doctor.add(status_combox_doc);
		
		JLabel deptid_label_doc = new JLabel("����:");
		deptid_label_doc.setBounds(425, 29, 32, 15);
		panel_doctor.add(deptid_label_doc);
		
		dept_combox_doc = new JComboBox();
		dept_combox_doc.setModel(new DefaultComboBoxModel(((new Depart()).getComItem())));
		dept_combox_doc.setSelectedIndex(0);
		dept_combox_doc.setBounds(467, 26, 86, 21);
		panel_doctor.add(dept_combox_doc);
		

		 add_btn_doc = new JButton("���ҽ��");
		 add_btn_doc.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(checkDatas()){
		 		String Id=id_text_doc.getText();
		 		String Name=name_text_doc.getText();
		 		String Age=age_text_doc.getText();
		 		String Status=status_combox_doc.getSelectedItem().toString();
		 		int statusTest = status_combox_doc.getSelectedIndex();
		 		System.out.println(statusTest);
		 		//String Deptid=deptid_text.getText();
		 		//String Dept = dept_combox.getSelectedItem().toString();
		 		String Dept = dept_combox_doc.getSelectedIndex() + 1 + "";
		 		try {
		 			
					ps=con.prepareStatement("select *  from t_doctor where Id=?");
					ps.setString(1, Id);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){//˵�����Id�Ѿ����˼�ʹ����
						JOptionPane.showMessageDialog(null, "���ID�Ѿ�������ʹ�ã�������һ��ID");
						rs.close();
					}
					else{
						con.setAutoCommit(false);
						
						ps=con.prepareStatement("insert into t_doctor(id,name,age,status,deptid) values(?,?,?,?,?)");
						ps.setString(1, Id);
						ps.setString(2, Name);
						ps.setString(3, Age);
						ps.setString(4, Status);
						ps.setString(5, Dept);
						ps.execute();
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
						
					}
				} catch (SQLException e1) {
				  JOptionPane.showMessageDialog(null, "ִ������ǳ��ִ���");
					e1.printStackTrace();
				}
		 		
		 		
		 	}}
		 });
		 
			add_btn_doc.setToolTipText("��Ӽ�¼");
			add_btn_doc.setBounds(590, 25, 100, 23);
			panel_doctor.add(add_btn_doc);
			
			JLabel age_label_doc = new JLabel("����:");
			age_label_doc.setBounds(303, 29, 32, 15);
			panel_doctor.add(age_label_doc);
			
			age_text_doc = new JTextField();
			age_text_doc.setText("��������");
			age_text_doc.setColumns(10);
			age_text_doc.setBounds(345, 26, 66, 21);
			panel_doctor.add(age_text_doc);
        
			
			//table = new JTable();
			 tableModel =new DefaultTableModel();
			table = new JTable();
			table.setModel(tableModel);
			table.setEnabled(false);
				//tableModel.setColumnIdentifiers(docInf_doc);
			
				
				 table.addMouseListener(new MouseAdapter() {//��ӵ�����굯������ѡ��
						public void mouseReleased(MouseEvent e){
							
							popMenu.show(e.getComponent(), e.getX(), e.getY());
						}
					});
				 
				  table.addMouseMotionListener(new MouseMotionListener() {
						//�������ÿ����¼�����ߵ�ʱ�򣬼�¼�ᱻѡ��
						@Override
						public void mouseMoved(MouseEvent e) {
							Point p=e.getPoint();
							int x=table.rowAtPoint(p);
							table.getSelectionModel().setSelectionInterval(x, x);
							popMenu.setVisible(false);
							
						}
						
						@Override
						public void mouseDragged(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
					});
				  
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(20, 211, 590, 225);
				scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "��ʾ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
				contentPane.add(scrollPane);
			 showAll_btn_doc = new JButton("��ʾ����ҽ��");
			 showAll_btn_doc.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		cleardatas();
			 		tableModel.setColumnIdentifiers(docInf_doc);
			 		
			 		try {
						ps=con.prepareStatement("select * from t_doctor");
						ResultSet rs=ps.executeQuery();
						boolean flag=false;
						while(rs.next()){
							showEntity = "ҽ��";
						flag=true;
							String data[]=new String[5];
							data[0]=rs.getString(1);
							data[1]=rs.getString(2);		
							data[2]=rs.getString(4);
							data[3]=rs.getString(6);
							//data[4]=rs.getString(5);		//(new Depart(Integer.parseInt(rs.getString(5)))).name
							data[4]=(new Depart(Integer.parseInt(rs.getString(5)))).name;
							tableModel.addRow(data);	
						}
						if(!flag){
							JOptionPane.showMessageDialog(null, "��ѯ���Ϊ�գ�");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 		
			 	}
			 });
			showAll_btn_doc.setToolTipText("����������ʾ����ҽ������Ϣ");
			showAll_btn_doc.setBounds(10, 443, 137, 23);
			contentPane.add(showAll_btn_doc);
			
			 clear_Button = new JButton("��ձ������");
			 clear_Button.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		cleardatas();	
			 	}
			 });
			clear_Button.setBounds(588, 443, 113, 23);
			contentPane.add(clear_Button);
			
			pane_medicine = new JPanel();
			pane_medicine.setLayout(null);
			pane_medicine.setBorder(new TitledBorder(null, "����", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
			pane_medicine.setBounds(20, 86, 711, 54);
			contentPane.add(pane_medicine);
			
			id_label_medi = new JLabel("\u836F\u54C1\u7F16\u53F7:");
			id_label_medi.setBounds(10, 29, 73, 15);
			pane_medicine.add(id_label_medi);
			
			id_text_medi = new JTextField();
			id_text_medi.setText("����ҩƷ��");
			id_text_medi.setColumns(10);
			id_text_medi.setBounds(83, 25, 73, 21);
			pane_medicine.add(id_text_medi);
			
			name_label_medi = new JLabel("\u540D\u79F0:");
			name_label_medi.setBounds(170, 29, 32, 15);
			pane_medicine.add(name_label_medi);
			
			name_text_medi = new JTextField();
			name_text_medi.setText("����ҩƷ����");
			name_text_medi.setColumns(10);
			name_text_medi.setBounds(202, 25, 106, 21);
			pane_medicine.add(name_text_medi);
			
			price_label_medi = new JLabel("\u552E\u4EF7\uFF1A");
			price_label_medi.setBounds(316, 29, 46, 15);
			pane_medicine.add(price_label_medi);
			
			add_btn_medi = new JButton("���ҩƷ");
			add_btn_medi.setToolTipText("��Ӽ�¼");
			add_btn_medi.setBounds(590, 25, 100, 23);
			pane_medicine.add(add_btn_medi);
			
			price_text_medi = new JTextField();
			price_text_medi.setText("����ҩƷ�۸�");
			price_text_medi.setColumns(10);
			price_text_medi.setBounds(361, 25, 79, 21);
			pane_medicine.add(price_text_medi);
			
			JLabel stock_label_medi = new JLabel("��棺");
			stock_label_medi.setBounds(449, 27, 46, 15);
			pane_medicine.add(stock_label_medi);
			
			stock_text_medi = new JTextField();
			stock_text_medi.setText("ҩƷ��棺");
			stock_text_medi.setColumns(10);
			stock_text_medi.setBounds(490, 24, 73, 21);
			pane_medicine.add(stock_text_medi);
			
			pane_apothecary = new JPanel();
			pane_apothecary.setLayout(null);
			pane_apothecary.setBorder(new TitledBorder(null, "����", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
			pane_apothecary.setBounds(20, 144, 711, 54);
			contentPane.add(pane_apothecary);
			
			id_label_apot = new JLabel("���ţ�");
			id_label_apot.setBounds(10, 29, 52, 15);
			pane_apothecary.add(id_label_apot);
			
			id_text_apot = new JTextField();
			id_text_apot.setText("���빤��");
			id_text_apot.setColumns(10);
			id_text_apot.setBounds(58, 25, 73, 21);
			pane_apothecary.add(id_text_apot);
			
			name_label_apot = new JLabel("������");
			name_label_apot.setBounds(145, 29, 46, 15);
			pane_apothecary.add(name_label_apot);
			
			name_text_apot = new JTextField();
			name_text_apot.setText("��������");
			name_text_apot.setColumns(10);
			name_text_apot.setBounds(196, 25, 106, 21);
			pane_apothecary.add(name_text_apot);
			
			add_btn_apot = new JButton("���ҩʦ");
			add_btn_apot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String Id = id_text_apot.getText();
					String Name = name_text_apot.getText();
					boolean flag = false;
					if(apothecary.isHave(apothecary, Integer.parseInt(Id))) {
						JOptionPane.showMessageDialog(null, "���id�Ѿ���ռ��");
					} else {
						if(apothecary.insert(new Apothecary(Integer.parseInt(Id),Name,"12345")));{
							JOptionPane.showMessageDialog(null, "��ӳɹ�");
							flag = true;
						} 
						if(!flag) {
							JOptionPane.showMessageDialog(null, "ִ������ǳ��ִ���");
						}
					}
					
				}
			});
			add_btn_apot.setToolTipText("���ҩʦ");
			add_btn_apot.setBounds(590, 25, 100, 23);
			pane_apothecary.add(add_btn_apot);	
			
			JButton showAll_btn_medi = new JButton("��ʾ����ҩƷ");
			showAll_btn_medi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cleardatas();
					tableModel.setColumnIdentifiers(docInf_medi);
				}
			});
			showAll_btn_medi.setToolTipText("����������ʾ����ҩƷ����Ϣ");
			showAll_btn_medi.setBounds(165, 443, 137, 23);
			contentPane.add(showAll_btn_medi);
			
			JButton showAll_btn_apot = new JButton("��ʾ����ҩʦ");
			showAll_btn_apot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cleardatas();
					tableModel.setColumnIdentifiers(docInf_apot);
					List<Apothecary> values = apothecary.getAllInfo();
					if(values != null || values.size() > 0) {
						for(Apothecary apothecary : values) {
							showEntity = "ҩʦ";
							//flag = true;
							Object data[] = new Object[2];
							data[0] = apothecary.getId();
							data[1] = apothecary.getName();
							System.out.println(data[0] +"  " + data[1]);
							tableModel.addRow(data);
						}
					} else {
						JOptionPane.showMessageDialog(null, "��ѯ���Ϊ�գ�");
					}
					
				}
			});
			showAll_btn_apot.setToolTipText("����������ʾ����ҩʦ����Ϣ");
			showAll_btn_apot.setBounds(316, 443, 137, 23);
			contentPane.add(showAll_btn_apot);
		}
	
	
		private void cleardatas(){//�����������е�����
			int rows = tableModel.getRowCount();
			/*if (rows != 0) {
				for (int i = 0; i < rows; i++) {
					tableModel.removeRow(0);
				}
			}*/
			if (rows != 0) {
				tableModel.setRowCount(0);
			} 
			
			
			//tableModel.rem
		}
	
	private boolean checkDatas() {
		boolean result = true;
		String docId=id_text_doc.getText();
		String  docName = name_text_doc.getText();
		String docAge = age_text_doc.getText();
		//String docDeptid = deptid_text.getText();
		String docDeptid = dept_combox_doc.getSelectedItem().toString();
		if(docId==null||docId.equals("")){
 			JOptionPane.showMessageDialog(null, "���Ų���Ϊ�գ�");
 			id_text_doc.requestFocus();
 			result=false;
 		}
 		else if(docName == null || docName.equals("")) {
			JOptionPane.showMessageDialog(null,"��������Ϊ��" );
			name_text_doc.requestFocus();
			result = false;
		}	
 		else if(docAge==null||docAge.equals("")){
 			JOptionPane.showMessageDialog(null, "���䲻��Ϊ�գ�");
 			age_text_doc.requestFocus();
 			result=false;
 		} else if(docDeptid == null || docDeptid.equals("")) {
			JOptionPane.showMessageDialog(null,"���Ų���Ϊ��" );
			deptid_text.requestFocus();
			result = false;
		} else {
			int age = Integer.parseInt(docAge);
				try {
					if(age <= 0 || age>= 100) {
						JOptionPane.showMessageDialog(null, "�������䲻�����0-100֮��");
						result = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"�����ʽ���ִ���" );
					result = false;
				}
		}
		return result;
	}
}
