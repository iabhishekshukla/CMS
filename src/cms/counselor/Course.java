package cms.counselor;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyListener;

import cms.dbinfo.DBConnection;
import cms.gui.LoginFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Course extends JFrame implements ActionListener , WindowListener ,KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField coursename;
	private JTextField coursefees;
	private JTextField courseduration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course frame = new Course();
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
	public Course() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 822, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CourseName");
		lblNewLabel.setForeground(new Color(64, 128, 128));
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(280, 82, 103, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course_fees");
		lblNewLabel_1.setForeground(new Color(64, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(280, 147, 132, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course_Duration");
		lblNewLabel_2.setForeground(new Color(64, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(280, 214, 122, 37);
		contentPane.add(lblNewLabel_2);
		
		coursename = new JTextField();
		coursename.addKeyListener(this);
		
		coursename.setBounds(417, 93, 96, 19);
		contentPane.add(coursename);
		coursename.setColumns(10);
		
		coursefees = new JTextField();
		coursefees.addKeyListener(this);
	
		
		//coursename.addKeyListener(this);
		
		coursefees.setBounds(417, 158, 96, 19);
		contentPane.add(coursefees);
		coursefees.setColumns(10);
		
		courseduration = new JTextField();
		courseduration.setBounds(417, 222, 96, 19);
		contentPane.add(courseduration);
		courseduration.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(356, 289, 115, 37);
		contentPane.add(btnNewButton);
		
		
		
		ImageIcon ic = new ImageIcon(DeleteCourse.class.getResource("/cms/images/111.jpg"));
		Image i2=ic.getImage().getScaledInstance(808, 549,Image.SCALE_DEFAULT);
		ImageIcon ic1=new ImageIcon(i2);
		//iblbgimage.setIcon(ic1);
		
		
		JLabel lblbg = new JLabel("");
		lblbg.setIcon(ic1);
		lblbg.setBounds(0, 0, 808, 549);
		contentPane.add(lblbg);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		LoginFrame login = new LoginFrame();
		login.setVisible(true);
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
		System.out.println("button is been clicked");
		String caption_text = e.getActionCommand(); //return caption
		System.out.println(caption_text+"button is been clicked");
		
		String name=coursename.getText();
		String fees=coursefees.getText();
		String duration=courseduration.getText();
		Connection con = DBConnection.createConnection();
		String insertQuery="insert into course_details(course_name, course_fee, course_duration)values(?,?,?)";
		PreparedStatement ps = null;//interface
		try {
			ps=con.prepareStatement(insertQuery);//passes the query to RDbms ---> Parser parse the query
//			and after parsing the query store the compiled query into buffer(memory) and assign the address of that buffer to ps 
			ps.setString(1,name);
			ps.setInt(2,Integer.parseInt(fees));
			ps.setString(3,duration);
			System.out.println(ps);
			int status = ps.executeUpdate();
			if(status>0)
				System.out.println("course addes succesfully");
				JOptionPane.showMessageDialog(this,"Course added Successfully");
				coursename.setText("");
				coursefees.setText("");
				courseduration.setText("");
				
			
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(this, name+"course alredy exits ","duplicate value",JOptionPane.ERROR_MESSAGE);
			
		}
		finally {
			try {
				if(ps!=null) 
					ps.close();
				if(con!=null)
					con.close();
					
				
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("key typed");
//		int code= e.getKeyCode();
		char c = e.getKeyChar();
		if(e.getSource()==coursename)//getsourse() will return the source that is generating event 
		{
			if(!(Character.isAlphabetic(c) ||c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE||c==KeyEvent.VK_SPACE))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed");
			}
			
		}
		
//		System.out.println("char is "+c);
		
		// TODO Auto-generated method stub
		
	
	if(e.getSource()==coursefees)//getsourse() will return the source that is generating event 
	{
		if(!(Character.isDigit(c)))
		{
			e.consume();
			JOptionPane.showMessageDialog(this, "only Digits are allowed");
		}
		
	}
	
//	System.out.println("char is "+c);
	
	// TODO Auto-generated method stub
	
}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("key pressed");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
