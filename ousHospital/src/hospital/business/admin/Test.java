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
//			DefaultTableModel model = new DefaultTableModel();// �������ģ��
//			// ���ñ�ͷ
//			model.setColumnIdentifiers(new Object[] { "ͼ����", "ͼ���", "����", "����", "������", "���ʱ��" });
//			// �������
//			model.addRow(new Object[] { "C���Գ������", "0008", "56", "������", "ѧ��������", "2011-11-11" });
//			model.addRow(new Object[] { "�罻����", "0028", "29", "XXXX", "���������", "2010-01-14" });
//			// �˴�������Ӷ�����¼������������Ǵ����ݿ��ж�ȡ����ȡѭ��������ʵ������޸�
//
//			table = new JTable(model);// ���ɱ��
//			JTableHeader header = table.getTableHeader();// ��ͷ�����б���
//			header.setFont(new Font("����", Font.BOLD, 24));// ���ñ�ͷ����
//			table.setFont(new Font("����", Font.PLAIN, 16));// �����������
//
//			scrollPane.setViewportView(table);// �ڹ�����ͼ����ʾ
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