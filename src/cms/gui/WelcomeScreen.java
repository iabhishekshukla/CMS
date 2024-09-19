package cms.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class WelcomeScreen extends JFrame implements Runnable
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//EventDispatcher Thread concept gets added in jdk 1.5 to reduce the load on main thread
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
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
	
	public void showloginFrame() {
		Thread t = new Thread(new Runnable()//obj of the class which implements runnable interface
				{//inner class body open
				public void run()//overriding interface (runnabele method 
				{
					try {
						Thread.sleep(4000);
						LoginFrame login = new LoginFrame();
						login.setVisible(true);
						WelcomeScreen.this.dispose();//outer class object
					}catch(InterruptedException ie) {
						ie.printStackTrace();
					}
					
				}
				}
					);
					t.start();
	}
	public WelcomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 624);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Automation System Welcome you ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(143, 241, 421, 32);
		contentPane.add(lblNewLabel);
		showloginFrame();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
