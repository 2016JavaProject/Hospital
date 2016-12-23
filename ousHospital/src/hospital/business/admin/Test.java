package hospital.business.admin;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Test extends JTable {
	JTable table;
	JFrame frame;
	JScrollPane scrollPane = new JScrollPane();
	
	public static void main(String[] args) {
		//new Test().setVisible(true);
		//new Test().setVisible(true);
	}
	
	
	
	
	
	
		

//		/*private Test() {
//			fsetTitle("Hello Table");
//			setLocationRelativeTo(null);
//			setSize(500, 300);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//			DefaultTableModel model = new DefaultTableModel();// 建立表格模型
//			// 设置表头
//			model.setColumnIdentifiers(new Object[] { "图书名", "图书号", "单价", "作者", "出版社", "入库时间" });
//			// 表格数据
//			model.addRow(new Object[] { "C语言程序设计", "0008", "56", "披风侠", "学生出版社", "2011-11-11" });
//			model.addRow(new Object[] { "社交礼仪", "0028", "29", "XXXX", "东风出版社", "2010-01-14" });
//			// 此处可以添加多条记录，多数情况下是从数据库中读取，采取循环。根据实际情况修改
//
//			table = new JTable(model);// 生成表格
//			JTableHeader header = table.getTableHeader();// 表头，即列标题
//			header.setFont(new Font("隶书", Font.BOLD, 24));// 设置表头字体
//			table.setFont(new Font("楷体", Font.PLAIN, 16));// 表格正文字体
//
//			scrollPane.setViewportView(table);// 在滚动视图中显示
//
//			add(scrollPane, BorderLayout.CENTER);
//		}*/

		/*private Test() {
			setTitle("Hello Table");
			setLocationRelativeTo(null);
			setSize(500, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			String[] columnNames = new String[] { "A", "B", "C" };

			JTable table = new JTable(columnNames, 0);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			DefaultTableModel model = new DefaultTableModel(columnNames , 0);
			table.setModel(model);
			Random seed = new Random();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			for (int i = 0; i < 1000; i++) {
				table.addRow(new String[] { format.format(new Date()), String.valueOf(seed.nextInt()),
						String.valueOf(seed.nextInt()) });
				table.fireTableDataChanged();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}}*/

		
}