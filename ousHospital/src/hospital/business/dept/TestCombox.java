package hospital.business.dept;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class TestCombox {

	public static void main(String[] args) {
		showComponent();
	}
	
	public static void showComponent() {
		JFrame frm = new JFrame();
		frm.setTitle("使用常用组件");
		frm.setLayout(null);// 设置为不使用布局管理器
		// 创建各组件并添加到容器中
		
		//1.标签组件的使用
		JLabel label = new JLabel("常用组件:");
		label.setBounds(5,5,160,80);
		label.setFont(new Font("",Font.BOLD,22));
		label.setIcon(new ImageIcon("label.jpg"));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		//设置标记相对图片的位置,在高JDK高版本中增加了新的静态常量
		label.setHorizontalTextPosition(JLabel.CENTER); 
		label.setVerticalTextPosition(JLabel.BOTTOM); 
		frm.getContentPane().add(label);
		
		//2.按钮组件的使用
		JButton button=new JButton();
		button.setText("这是一个按钮");
		button.setBounds(170,5,120,30);
		frm.getContentPane().add(button);
		
		//3.文本框组件的使用
		JTextField text=new JTextField();
		text.setText("请输入文本");
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setBounds(170,45,120,30);
		frm.getContentPane().add(text);
		
		//4.密码框组件的使用
		JPasswordField pwdText=new JPasswordField();
		pwdText.setText("mypassword");
		pwdText.setEchoChar('?');
		pwdText.setBounds(170,80,120,30);
		frm.getContentPane().add(pwdText);
		
		//5.文本域组件的使用
		JTextArea textArea=new JTextArea();
		textArea.setLineWrap(true);
		textArea.setColumns(10);
		textArea.setRows(3);
		textArea.append("这是一个多行文本域，");
		textArea.insert("将会自动回车。", 11);
		textArea.setBounds(300,5,120,60);
		frm.getContentPane().add(textArea);
		
		//6.单选按钮组件的使用参见例8-8
		//7.复选框组件的使用参见例8-9
		
		//8.列表框组件的使用
		
		//String[] likes={"数学","网购","游戏","看电影","上网","聊天","编程"};		//(new Depart()).getComItem();
		String[] likes = (new Depart()).getComItem();
		JList list=new JList(likes);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setFixedCellHeight(20);
		list.setVisibleRowCount(5);
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(list);
		scrollpane.setBounds(30,130,120,120);
		frm.getContentPane().add(scrollpane);
		
		//9.选择框组件的使用
		JComboBox comboBox=new JComboBox(likes);
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(6);
		comboBox.insertItemAt("哲学", 3);
			
		comboBox.setBounds(230,130,120,25);
		frm.getContentPane().add(comboBox);
		
		frm.setBounds(400, 200, 450, 320);
		frm.setVisible(true);
	}

}
