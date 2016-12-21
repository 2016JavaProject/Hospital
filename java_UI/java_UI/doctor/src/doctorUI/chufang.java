package doctorUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class chufang {

	int count=0;
	private JFrame frame;
	String[] a = new String[]{null,"A", "B", "C"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chufang window = new chufang();
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
	public chufang() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 402, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JSpinner spinner_medicine1 = new JSpinner();//药物的数量
		spinner_medicine1.setBounds(251, 56, 49, 28);
		frame.getContentPane().add(spinner_medicine1);
		
		JSpinner spinner_medicine2 = new JSpinner();
		spinner_medicine2.setBounds(251, 99, 49, 28);
		frame.getContentPane().add(spinner_medicine2);
		
		JSpinner spinner_medicine3 = new JSpinner();
		spinner_medicine3.setBounds(251, 142, 49, 28);
		frame.getContentPane().add(spinner_medicine3);
		
		JSpinner spinner_medicine4 = new JSpinner();
		spinner_medicine4.setBounds(251, 185, 49, 28);
		frame.getContentPane().add(spinner_medicine4);
		
		JSpinner spinner_medicine5 = new JSpinner();
		spinner_medicine5.setBounds(251, 228, 49, 28);
		frame.getContentPane().add(spinner_medicine5);
		
		JComboBox comboBox_medicine1 = new JComboBox();//药品名称
		comboBox_medicine1.setForeground(Color.BLACK);
		comboBox_medicine1.setBackground(Color.LIGHT_GRAY);
		comboBox_medicine1.setModel(new DefaultComboBoxModel(a));
		comboBox_medicine1.setBounds(34, 56, 158, 27);
		frame.getContentPane().add(comboBox_medicine1);
		
		JComboBox comboBox_medicine2 = new JComboBox();
		comboBox_medicine2.setForeground(Color.BLACK);
		comboBox_medicine2.setBackground(Color.LIGHT_GRAY);
		comboBox_medicine2.setModel(new DefaultComboBoxModel(a));
		comboBox_medicine2.setBounds(34, 99, 158, 27);
		frame.getContentPane().add(comboBox_medicine2);
		
		JComboBox comboBox_medicine3 = new JComboBox();
		comboBox_medicine3.setForeground(Color.BLACK);
		comboBox_medicine3.setBackground(Color.LIGHT_GRAY);
		comboBox_medicine3.setModel(new DefaultComboBoxModel(a));
		comboBox_medicine3.setBounds(34, 142, 158, 27);
		frame.getContentPane().add(comboBox_medicine3);
		
		JComboBox comboBox_medicine4 = new JComboBox();
		comboBox_medicine4.setForeground(Color.BLACK);
		comboBox_medicine4.setBackground(Color.LIGHT_GRAY);
		comboBox_medicine4.setModel(new DefaultComboBoxModel(a));
		comboBox_medicine4.setBounds(34, 185, 158, 27);
		frame.getContentPane().add(comboBox_medicine4);
		
		JComboBox comboBox_medicine5 = new JComboBox();
		comboBox_medicine5.setForeground(Color.BLACK);
		comboBox_medicine5.setBackground(Color.LIGHT_GRAY);
		comboBox_medicine5.setModel(new DefaultComboBoxModel(a));
		comboBox_medicine5.setBounds(34, 228, 158, 27);
		frame.getContentPane().add(comboBox_medicine5);
		
		JButton button_close = new JButton("关闭");
		button_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button_close.setBounds(217, 399, 123, 29);
		frame.getContentPane().add(button_close);
		
		JButton btn_Save = new JButton("保存");
		btn_Save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print(comboBox_medicine1.getSelectedItem());
				System.out.println(spinner_medicine1.getValue());
				System.out.print(comboBox_medicine2.getSelectedItem());
				System.out.println(spinner_medicine2.getValue());
				System.out.print(comboBox_medicine3.getSelectedItem());
				System.out.println(spinner_medicine3.getValue());
				System.out.print(comboBox_medicine4.getSelectedItem());
				System.out.println(spinner_medicine4.getValue());
				System.out.print(comboBox_medicine5.getSelectedItem());
				System.out.println(spinner_medicine5.getValue());
				
			}
		});
		btn_Save.setBounds(35, 399, 123, 29);
		frame.getContentPane().add(btn_Save);
		
		JLabel lblNewLabel = new JLabel("药品");
		lblNewLabel.setBounds(77, 15, 81, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("数量");
		lblNewLabel_1.setBounds(251, 15, 49, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
