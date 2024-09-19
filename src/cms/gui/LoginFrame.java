package cms.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/cms/images/121.jpg")));
		setTitle("LoginFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// to place the frame screen in the centre
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(130, 60, 101, 39);
		contentPane.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setBounds(284, 62, 121, 39);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(130, 125, 91, 47);
		contentPane.add(lblNewLabel_1);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(284, 133, 121, 35);
		contentPane.add(txtpass);
		
		JButton btnsubmit = new JButton("");
		btnsubmit.setIcon(new ImageIcon(LoginFrame.class.getResource("/cms/images/icons8-button-50.png")));
		btnsubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnsubmit.setBounds(193, 268, 149, 51);
		contentPane.add(btnsubmit);
		
		JRadioButton rdAdmin = new JRadioButton("Admin");
		rdAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdAdmin.setBounds(151, 211, 67, 39);
		contentPane.add(rdAdmin);
		
		JRadioButton rdCounselor = new JRadioButton("Counselor");
		rdCounselor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdCounselor.setBounds(302, 211, 91, 39);
		contentPane.add(rdCounselor);
	}
}
