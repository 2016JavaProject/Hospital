package hospital.business.apothecary;

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

public class ModifyApot extends JFrame{
	private JPanel contentPane;
	private JTable table;
	private JTextField id_text;
	private JTextField name_text;
	private JTextField pwd_text;
	private Apothecary apot;
	private DataBase dBase;
	private Connection connection;
	private java.sql.PreparedStatement ps;
	private Apothecary apothecary;
	
	
	public ModifyApot(final Apothecary apot) {
		dBase = new DataBase();
		connection = dBase.getCon();
		this.apot = apot;
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
		
		JLabel id_label = new JLabel("证件号");
		id_label.setBounds(10,21,52,15);
		panel.add(id_label);
		
		JLabel name_label = new JLabel("姓名");
		name_label.setBounds(10,50,52,15);
		panel.add(name_label);
		
		JLabel pwd_label = new JLabel("密码");
		pwd_label.setBounds(10,79,52,15);
		panel.add(pwd_label);
		
		
		
		id_text = new JTextField(apot.getId() + "");
		id_text.setEditable(false);
		System.out.println(apot.getId());
		id_text.setColumns(10);
		id_text.setBounds(72,18,66,21);
		panel.add(id_text);
		
		name_text = new JTextField(apot.getName());
		name_text.setColumns(10);
		name_text.setBounds(72,47,66,21);
		panel.add(name_text);
		
		//age_text = new JTextField(apot.getAge());
		pwd_text = new JTextField(apot.getPassword());
		pwd_text.setColumns(10);
		pwd_text.setBounds(72,75,66,21);
		panel.add(pwd_text);
		
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
		        //监听器代码
		    	int id = Integer.parseInt(id_text.getText());
		    	String name = name_text.getText();
		    	String password = pwd_text.getText();
		    	apothecary = new Apothecary(id,name,password);
		    	if(apothecary.update(apothecary)){
		    		JOptionPane.showMessageDialog(null, "修改成功");
		    	} else {
		    		JOptionPane.showMessageDialog(null, "修改失败");
		    	};
		    }
		});
		button.setBounds(47, 175, 67, 23);
		panel.add(button);
		
	}
	
	public static void main(String[] args) {
		Apothecary apot = new Apothecary(1, "test", "12345");
		ModifyApot modifyApot = new ModifyApot(apot);
		modifyApot.setVisible(true);
	}
	/*private boolean checkDatas() {
		boolean result = true;
		return result;
	}*/
	
}

