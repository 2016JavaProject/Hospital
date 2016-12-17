package doctorUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class doctor_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor_1 window = new doctor_1();
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
	public doctor_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("医生");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("开始看病");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				doctorUI.doctor_2.main(null);
			}
		});
		
		button.setBounds(59, 183, 123, 29);
		frame.getContentPane().add(button);
		
		JButton button_return = new JButton("返回");
		button_return.setBounds(226, 183, 123, 29);
		frame.getContentPane().add(button_return);
		
		String doctor=new String("Doctor!");	
		JLabel label_welcome = new JLabel(doctor+",你好!");
		label_welcome.setBounds(59, 38, 81, 21);
		frame.getContentPane().add(label_welcome);
		
		int number=0;
		JLabel lblNewLabel = new JLabel("还有"+number+"病人等待!");
		lblNewLabel.setBounds(171, 95, 160, 21);
		frame.getContentPane().add(lblNewLabel);
	}
}
