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

public class chufang {

	int count=0;
	private JFrame frame;

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
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(266, 15, 49, 28);
		frame.getContentPane().add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		comboBox.setBounds(35, 15, 158, 27);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("Ìí¼Ó");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
				JSpinner spinner1 =new JSpinner();
				spinner1.setBounds(266, 15+50*count, 49, 28);
				frame.getContentPane().add(spinner1);
				
				JComboBox comboBox1 = new JComboBox();
				comboBox1.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
				comboBox1.setBounds(35, 15+50*count, 158, 27);
				frame.getContentPane().add(comboBox1);
			}
		});
		button.setBounds(35, 399, 123, 29);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("±£´æ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(217, 399, 123, 29);
		frame.getContentPane().add(btnNewButton);
		
	}
}
