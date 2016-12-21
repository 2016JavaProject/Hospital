package PharmacyUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PharmacistUI_1 {

	private JFrame frame;
	private JTable table;
	int sum;
	String Patient = new String("Patient");
	int Patient_ID;
	String Pharmacist = new String("Pharmacist");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PharmacistUI_1 window = new PharmacistUI_1();
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
	public PharmacistUI_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ҩʦ");
		frame.setBounds(100, 100, 609, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ҩʦ:"+Pharmacist);
		lblNewLabel.setBounds(0, 0, 169, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����: "+Patient+"   ID:"+Patient_ID);
		lblNewLabel_1.setBounds(0, 27, 292, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btn_Next = new JButton("��һ��");
		btn_Next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				PharmacyUI.PharmacistUI_1.main(null);
			}
		});
		btn_Next.setBounds(454, 300, 106, 29);
		frame.getContentPane().add(btn_Next);
		
		JButton btn_Complete = new JButton("���");
		btn_Complete.setBounds(454, 344, 106, 29);
		frame.getContentPane().add(btn_Complete);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{11, 12, 13, null},
				{21, 22, 23, null},
				{31, 32, 33, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ҩƷ����", "ҩƷ����", "ҩƷ�۸�", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setBounds(10, 87, 429, 242);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_2 = new JLabel("ҩƷ����");
		lblNewLabel_2.setBounds(25, 64, 81, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ҩƷ����");
		lblNewLabel_3.setBounds(128, 63, 81, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ҩƷ�۸�");
		lblNewLabel_4.setBounds(237, 63, 81, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(347, 64, 81, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		sum=0;
		JLabel Label_Sum = new JLabel("�ܼ۸�"+sum+"Ԫ");
		Label_Sum.setBounds(321, 348, 118, 25);
		frame.getContentPane().add(Label_Sum);
	}
}
