package cms.counselor;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cms.dbinfo.DBConnection;
import cms.gui.LoginFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class Student extends JFrame implements ActionListener,WindowListener,KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField email;
	private JTextField phone;
	private JTextField txtcourse;
	private JTextArea txtaddress;
	private JComboBox<String> comboBox;
	private JTextField txtnm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 *
	 */
	//code to populate /fill combo box
	public void fillCombo() {
		Connection con = DBConnection.createConnection();
		
		PreparedStatement ps = null;
		ResultSet rs=null;//used to hold the address of the resultanat data set retured by select query.
		String selectQuery="select*from course_details";//to read the data from table * represent all columns
		try {
			ps=con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while(rs.next()==true) {
				String cname= rs.getString("course_name");//it is used to fect the value from the specified column
				System.out.println(cname);
//					rs.getString(ABORT);
				comboBox.addItem(cname);
			}
			
			
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
			
		
	public Student() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(206, 66, 65, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(206, 109, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(299, 106, 96, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(206, 150, 65, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CourseName");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(186, 187, 103, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(206, 223, 65, 19);
		contentPane.add(lblNewLabel_4);
		
		
//		txtname = new JTextField();
//		txtname.addKeyListener(this);
		phone = new JTextField();
		phone.setBounds(299, 147, 96, 19);
		contentPane.add(phone);
		phone.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Course"}));
		comboBox.setBounds(299, 183, 96, 24);
		fillCombo();
		contentPane.add(comboBox);
		
		 txtaddress = new JTextArea();
		txtaddress.setBounds(299, 217, 96, 35);
		contentPane.add(txtaddress);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(242, 290, 103, 21);
		contentPane.add(btnNewButton);
		
		txtcourse = new JTextField();
		txtcourse.setBounds(432, 184, 96, 19);
		txtcourse.setVisible(false);
		
		contentPane.add(txtcourse);
		txtcourse.setColumns(10);
		
		txtnm = new JTextField();
		txtnm.addKeyListener(this);
		txtnm.setBounds(299, 71, 96, 19);
		contentPane.add(txtnm);
		txtnm.setColumns(10);
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
		String caption_text = e.getActionCommand();
		System.out.println(caption_text+"button is been clicked");
		String stname = txtnm.getText();
		System.out.println(stname);
		String email1 = email.getText();
		String phone1 = phone.getText();
		//String coursename = txtcourse.getText();
		String address = txtaddress.getText();
		String courseName=(String)comboBox.getSelectedItem();
		
		Connection con=DBConnection.createConnection();
		String insertQuery="insert into student_details(name, email, phone, course_name, address)values(?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps=con.prepareStatement(insertQuery);
			ps.setString(1,stname);
			ps.setString(2,email1);
			ps.setString(3,phone1);
			ps.setString(4,courseName);
			ps.setString(5,address);
			System.out.println(ps);
			int status = ps.executeUpdate();
			if(status>0)
			{
				System.out.println("course addes succesfully");
				JOptionPane.showMessageDialog(this,"Course added Successfully");
				txtnm.setText("");
				email.setText("");
				phone.setText("");
				txtcourse.setText("");
				txtaddress.setText("");
				
			}
			
		
			
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			int code = se.getErrorCode();
			System.out.println("code is"+code);
			if(code==1452) 
				JOptionPane.showMessageDialog(this, "Course does not Found","Course name error",JOptionPane.ERROR_MESSAGE);
			if(code==1062)
				JOptionPane.showMessageDialog(this, "Email or phone alredy exits","Duplicate value",JOptionPane.ERROR_MESSAGE);
			
			
			
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
		char c = e.getKeyChar();
		if(e.getSource()==txtnm)//getsourse() will return the source that is generating event 
		{
			if(!(Character.isAlphabetic(c)))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed");
			}
			
		}
		if(e.getSource()==phone)//getsourse() will return the source that is generating event 
		{
			if(!(Character.isDigit(c)))
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
