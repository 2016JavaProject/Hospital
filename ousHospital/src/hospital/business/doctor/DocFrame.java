package hospital.business.doctor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import hospital.business.medicine.Medicine;
import hospital.business.medicine.Prescription;
import hospital.business.patient.Patient;
import hospital.db.DataBase;

public class DocFrame extends JFrame implements Runnable{
	private JPanel contentPane;
	private JTable table_wait;
	private JTextField tel_text;
	private JTextField deptid_text;
	private JTextField comm_text;
	private DefaultTableModel tableModel_wait;
	private DefaultTableModel tableModel_fee;
	private DataBase db;
	private Connection con;
	private PreparedStatement ps;
	private static String docInf[]={"病人","备注"};
	private static String staticFee[]={"挂号费","1","15"};
	private static String patFee[]={"药品名称","数量","价格"}; 
	private static String docInf2[]=null;
	private JButton showAll_button,clear_Button;
	private JPopupMenu popMenu;
	private JMenuItem deleteMenuItem;
	private JMenuItem modifyJMenuItem;
	private JPanel panel_Searcher;
	private JTextField medi_text_sear;
	private JButton btn_search;
	private JLabel pati_label_name;
	private JTextField pati_text_name;
	private JScrollPane scrollPane_medis;
	private JTable table_fee;
	private JTextField medi_text_num;
	private static Doctor doc;
	private static String cur_patientId;
	private static boolean  doc_see_pat = false;
	private Medicine medicine;
	private Patient patient;
	private Prescription prescription;
	
	public static void main(String[] args) {
		//String id, String name, int age, String depatid, String status
		doc = new Doctor("12", "jason", 15, "7", "忙碌");
		DocFrame frame = new DocFrame(doc);
		
		frame.setVisible(true);
		//new Thread(frame).start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			showAll_button.doClick();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {  
                e.printStackTrace();  
            } 
		}
	}
	
	public DocFrame(final Doctor doc) {
		db=new DataBase();
		con=db.getCon();
		this.doc = doc;
		String title = "科室：" + doc.getDepatid() +"----" + doc.getName() + "医生";
		setTitle(title);
		setResizable(false);
		
		medicine = new Medicine();
		patient = new Patient();
		prescription = new Prescription();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
			
			//table = new JTable();
			 tableModel_wait =new DefaultTableModel();
				table_wait = new JTable();
				table_wait.setModel(tableModel_wait);
				table_wait.setEnabled(false);
				tableModel_wait.setColumnIdentifiers(docInf);
				
				  
				JScrollPane scrollPane = new JScrollPane(table_wait);
				scrollPane.setEnabled(false);
				scrollPane.setBounds(10, 13, 263, 130);
				scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "显示", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
				contentPane.add(scrollPane);
			 showAll_button = new JButton("显示等待的病人");
			 //showAll_button.cl
			 showAll_button.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		cleardatas(tableModel_wait);
			 		try {
			 			//获取就诊时间为当天的  前5名病人
						//ps =con.prepareStatement("select id,createTime  from t_record  where status=1 limit 5");
			 			//ps =con.prepareStatement("select id,createTime  from t_record  where createTime>=date(now()) and createTime<DATE_ADD(date(now()),INTERVAL 1 DAY) and status = 1 limit 5");
			 			ps = con.prepareStatement("select patientId,deptid,createTime from (select * from t_record where status=1 and createTime>=date(now()) and createTime<DATE_ADD(date(now()),INTERVAL 1 DAY))temp order by createTime asc limit 5");
			 			ResultSet rs = ps.executeQuery();
						boolean flag = false;
						while(rs.next()) {
							if(rs.getString("deptid").equals(doc.getDepatid())) {
								flag = true;
								String data[] = new String[2];
								data[0] = rs.getInt("patientId") +"";
								data[1] = rs.getString("createTime").trim();
								System.out.println(data[1]);
									Pattern pattern = Pattern.compile("\\s");
									Matcher matcher = pattern.matcher(data[1]);
									if(matcher.find()) {
										data[1] = data[1].substring(matcher.start(0),19);
									}
								tableModel_wait.addRow(data);
							}
							
						}
						if( !flag) {
							JOptionPane.showMessageDialog(null, "查询结果为空");;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 		
			 	}
			 });
			showAll_button.setToolTipText("显示等待的病人");
			showAll_button.setBounds(10, 443, 158, 23);
			contentPane.add(showAll_button);
			
			 clear_Button = new JButton("清空表格数据");
			 clear_Button.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		cleardatas(tableModel_wait);	
			 	}
			 });
			clear_Button.setBounds(180, 443, 113, 23);
			contentPane.add(clear_Button);
			
			JPanel panel_DocP = new JPanel();
			panel_DocP.setBounds(307, 23, 414, 388);
			panel_DocP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "药方", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
			contentPane.add(panel_DocP);
			panel_DocP.setLayout(null);
			
			pati_label_name = new JLabel("病人姓名：");
			pati_label_name.setBounds(24, 23, 74, 18);
			panel_DocP.add(pati_label_name);
			
			pati_text_name = new JTextField();
			pati_text_name.setEditable(false);
			pati_text_name.setColumns(10);
			pati_text_name.setBounds(112, 20, 79, 21);
			panel_DocP.add(pati_text_name);
			
			table_fee =  new JTable();
			tableModel_fee = new DefaultTableModel();
			table_fee.setModel(tableModel_fee);
			table_fee.setEnabled(false);
			tableModel_fee.setColumnIdentifiers(patFee);
			
			
			scrollPane_medis = new JScrollPane(table_fee);
			scrollPane_medis.setEnabled(false);
			scrollPane_medis.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "药单费用", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
			scrollPane_medis.setBounds(14, 76, 386, 299);
			panel_DocP.add(scrollPane_medis);
			
			JButton btn_NextP = new JButton("下一个病人");
			btn_NextP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean flag = false;
					String sql = "select patientId,deptid from (select * from t_record where status=1 and createTime>=date(now()) and createTime<DATE_ADD(date(now()),INTERVAL 1 DAY))temp order by createTime asc limit 1 ";
					try {
						ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							if(doc_see_pat == false) {
								tableModel_fee.addRow(staticFee);
								flag = true;
								doc_see_pat = true;
								if(rs.getString("deptid").equals(doc.getDepatid()))  {
									cur_patientId = rs.getInt("patientId") + "";
									System.out.println(doc.getId());
									String sqlChange = "update t_record set status = 2,doctorid="+doc.getId() +" where patientId=" + cur_patientId;
									System.out.println(sqlChange);
									ps = con.prepareStatement(sqlChange);
									ps.executeUpdate();
									pati_text_name.setText( (new Patient(cur_patientId)).name );
								}
							} else {
								JOptionPane.showMessageDialog(null, "当前有病人正在看病");
							}
						}	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(!flag) {
						JOptionPane.showMessageDialog(null, "当前没有病人");
					}
				}
			});
			btn_NextP.setToolTipText("下一个病人");
			btn_NextP.setBounds(552, 425, 113, 25);
			contentPane.add(btn_NextP);
			
			panel_Searcher = new JPanel();
			panel_Searcher.setLayout(null);
			panel_Searcher.setBorder(new TitledBorder(null, "药品检索", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
			panel_Searcher.setBounds(10, 166, 283, 216);
			contentPane.add(panel_Searcher);
			
			medi_text_sear = new JTextField();
			medi_text_sear.setText("输入药品名称/简称");
			medi_text_sear.setColumns(10);
			medi_text_sear.setBounds(14, 26, 166, 34);
			panel_Searcher.add(medi_text_sear);
			
			btn_search = new JButton("检索");
			btn_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String medicine = medi_text_sear.getText();
					if(medicine.isEmpty() || medicine.length() >18) {
						JOptionPane.showMessageDialog(null, "输入不能为空或不能超过18位");
					}
					try {
						String sql ="select name from t_medicine where name like " + "'" + "%" + medicine + "%" + "'" ;
						System.out.println(sql);
						ps = con.prepareStatement(sql);
						//ps = con.prepareStatement("select name from t_medicine where name like '% " + medicine + "  %' or id = '" + medicine + "' ");
						//ps = con.prepareStatement("select name from t_medicine where name like ?");
						//ps.setString(1,"'" + "%" + medicine + "%" + "'");
						//ps.setString(2, "%" + medicine + "%");
						ResultSet rs = ps.executeQuery();
						//ResultSet rs2 = rs;
						boolean flag = false;
						
						rs.last(); 
						System.out.println(rs.getRow());
						String[] medis = new String[rs.getRow()];
						int i =0; rs.absolute(0);
						while(rs.next()) {
							medis[i] = rs.getString("name");
							i++;
							flag = true;
						}
						if(flag) {
							String temp = (String)JOptionPane.showInputDialog(null, "请选择药品:\n", "药品", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), medis, medis[0]);
							medi_text_sear.setText(temp);
						} else {
							JOptionPane.showMessageDialog(null, "没有相关药品");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			btn_search.setToolTipText("输入名称可模糊查找");
			btn_search.setBounds(204, 30, 65, 27);
			panel_Searcher.add(btn_search);
			
			JButton btn_add = new JButton("加入药方");
			btn_add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String Name = medi_text_sear.getText();
					String Num = medi_text_num.getText();
					float Price = medicine.getInfo(medicine,Name).getPrice() * Integer.parseInt(Num);
					if(medicine.isHave(medicine, Name)) {
						if(doc_see_pat) {
							if(medicine.isHave(medicine, Name)) {
								Object data[] = new Object[3];
								data[0] = Name;
								data[1] = Num;
								data[2] = Price;
								tableModel_fee.addRow(data);
								medicine.takeSale(medicine,Name,Integer.parseInt(Num));
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "当前没有病人,请选择下个病人");
						}
					} else {
						JOptionPane.showMessageDialog(null, "没有相关药品,请重新检索");
					}	
				}
			});
			btn_add.setBounds(35, 158, 157, 27);
			panel_Searcher.add(btn_add);
			

			
			JButton btn_prescription = new JButton("开药方");
			btn_prescription.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					List<Prescription> values = new ArrayList<Prescription>();
					int rowCount = tableModel_fee.getRowCount();
					float price = 15;
					
					for(int i = 1; i < rowCount; i++) {
						int patientid = Integer.parseInt(cur_patientId);
						String medicineName = (String) table_fee.getValueAt(i, 0);
						int medicineid = (medicine.getInfo(medicine, medicineName)).getId();
						int num = Integer.parseInt((String)table_fee.getValueAt(i, 1));
						values.add(new Prescription(patientid,medicineid,num));
						price = price + (float)table_fee.getValueAt(i, 2);
						
						//System.out.println(price);
					}
					System.out.println(price);
					prescription.storeList(values);
					System.out.println(price);
					int patientid = Integer.parseInt(cur_patientId);
					System.out.println(patientid);
					patient.castFee(patientid, price);
					doc_see_pat = false;
					cleardatas(tableModel_fee);
					
				}
			});
			btn_prescription.setToolTipText("");
			btn_prescription.setBounds(242, 19, 113, 25);
			panel_DocP.add(btn_prescription);
			
			JLabel medi_label_num = new JLabel("数量：");
			medi_label_num.setBounds(14, 92, 57, 18);
			panel_Searcher.add(medi_label_num);
			
			medi_text_num = new JTextField();
			medi_text_num.setText("1-10");
			medi_text_num.setColumns(10);
			medi_text_num.setBounds(66, 90, 79, 21);
			panel_Searcher.add(medi_text_num);
			
			
			
			//new Thread(this).start();
		}
	
	
		private void cleardatas(DefaultTableModel tableModel){//清除表格中所有的数据
			int rows = tableModel.getRowCount();
			if (rows != 0) {
				tableModel.setRowCount(0);
				//new Thread(this).interrupt();
			}
		}
	
	private boolean checkDatas() {
		
		return true;
	}
}