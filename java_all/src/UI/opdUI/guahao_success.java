package UI.opdUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guahao_success {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guahao_success window = new guahao_success();
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
	public guahao_success() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel guahao = new JLabel("挂号成功！");
		guahao.setFont(new Font("����", Font.PLAIN, 26));
		guahao.setHorizontalAlignment(SwingConstants.CENTER);
		guahao.setBounds(117, 70, 191, 78);
		frame.getContentPane().add(guahao);
		
		JButton Return_btn = new JButton("返回");
		Return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Return_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				guahao_keshi.main(null);
			}
		});
		Return_btn.setBounds(151, 194, 93, 23);
		frame.getContentPane().add(Return_btn);
	}
}
