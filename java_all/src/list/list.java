package list;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
 
//�������.
import java.util.ArrayList;
import java.util.List;
 
 
//�������.
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
public class list extends JFrame{
	  private static final long serialVersionUID=1L;
	  private JPanel contentPane;
	  private JTable table;

	  public static void main(String[] args){

	 list frame=new list();
	 frame.setVisible(true);
	  }
	  

	  public list(){

	 super();
	 setTitle("表格");
	 setBounds(100,100,400,230);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 contentPane=new JPanel();
	 contentPane.setBorder(new EmptyBorder(5,5,5,5));
	 contentPane.setLayout(new BorderLayout(0,0));
	 setContentPane(contentPane);
	 
	 JScrollPane scrollPane=new JScrollPane();
	 contentPane.add(scrollPane);
	 scrollPane.setViewportView(getTable());
	  }
	  
	  //getTable()
	  private JTable getTable(){
	 if(table==null){  
	 table=new JTable(); 
	 table.setRowHeight(25); 
	 String[] columns={"姓名","编号","总价","医生"}; //列
	
	 DefaultTableModel model=new DefaultTableModel(columns,0);
	 table.setModel(model); 
	 
	 List<String> students=getStudents(); 
	 for(String info:students){ 
	 String[] args=info.split(","); 
	 model.addRow(args);
	 }
	 
	 }
	 return table;
	  }
	 
	  private List<String> getStudents(){
	
	 List<String> list=new ArrayList<String>();//行
	
	 list.add("张三,74110,50.6,时道顺");
	 list.add("李四,74120,108.9,刘梓豪");
	 list.add("钱五,74119,500.7,胡永志");
	 return list;
	  }
	  
	}