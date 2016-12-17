package PharmacyUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PharmacistUI_1 {

	private JFrame frame;

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
		frame = new JFrame("药师");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("药师:");
		lblNewLabel.setBounds(0, 0, 169, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("病人: "+"   ID:");
		lblNewLabel_1.setBounds(0, 27, 292, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 60, 282, 156);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("完成");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				PharmacyUI.PharmacistUI_1.main(null);
			}
		});
		btnNewButton_1.setBounds(307, 144, 106, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("下一个");
		btnNewButton.setBounds(307, 187, 106, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
