package cms.counselor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class DeleteStudent extends JFrame implements ActionListener , WindowListener ,KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField delstudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent frame = new DeleteStudent();
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
	public DeleteStudent() {
		setTitle("Delete Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setForeground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel deltxt = new JLabel("ROLL_NO");
		deltxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		deltxt.setBounds(91, 59, 85, 28);
		contentPane.add(deltxt);
		
		delstudent = new JTextField();
		delstudent.addKeyListener(this);
		
		
		delstudent.setBounds(186, 66, 96, 19);
		contentPane.add(delstudent);
		delstudent.setColumns(10);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.setForeground(new Color(128, 0, 0));
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Serif", Font.BOLD, 15));
		btndelete.setBounds(126, 121, 107, 21);
		contentPane.add(btndelete);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("delete button is been clicked");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("in key type");
		char c = e.getKeyChar();
		if(e.getSource()==delstudent)//getsourse() will return the source that is generating event 
		{
			if((Character.isAlphabetic(c)))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "only Digits are allowed");
			}
			
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

