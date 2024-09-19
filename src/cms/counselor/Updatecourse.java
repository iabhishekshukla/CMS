package cms.counselor;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.cj.xdevapi.PreparableStatement;

import cms.dbinfo.DBConnection;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class Updatecourse extends JFrame implements ActionListener, WindowListener,ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField updfees;
	private JTextField updduration;
	private JComboBox <String> cmbcourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatecourse frame = new Updatecourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillCombo() {
		Connection con = DBConnection.createConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery="select * from course_details";
		try {
			ps=con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while(rs.next()==true) {
				String cname= rs.getString("course_name");//it is used to fect the value from the specified column
				System.out.println(cname);
//					rs.getString(ABORT);
				cmbcourse.addItem(cname);
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

	/**
	 * Create the frame.
	 */
	public Updatecourse() {
		setTitle("Update Course");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbcourse = new JComboBox();
		cmbcourse.addItemListener(this); 
		cmbcourse.setModel(new DefaultComboBoxModel(new String[] {"SELECT COURSE"}));
		cmbcourse.setToolTipText("");
		cmbcourse.setBounds(104, 42, 156, 21);
		fillCombo();
		contentPane.add(cmbcourse);
		
		JLabel lblNewLabel = new JLabel("Fees");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(74, 98, 66, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Duration");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(74, 141, 66, 21);
		contentPane.add(lblNewLabel_1);
		
		updfees = new JTextField();
		updfees.setBounds(164, 107, 96, 19);
		contentPane.add(updfees);
		updfees.setColumns(10);
		
		updduration = new JTextField();
		updduration.setBounds(164, 144, 96, 19);
		contentPane.add(updduration);
		updduration.setColumns(10);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(this);
		btnupdate.setForeground(new Color(128, 64, 64));
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnupdate.setBounds(104, 193, 96, 21);
		contentPane.add(btnupdate);
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
//		System.out.println("button is been clicked");
//		System.out.println(caption_text+"button is  been clicked");
		String caption_text = e.getActionCommand();
		String courseName=(String)cmbcourse.getSelectedItem();
		String fees1 = updfees.getText();
		String duration = updduration.getText();
		if(fees1.isEmpty()||duration.isEmpty() ||courseName.equalsIgnoreCase("SELECT COURSE")) {
			JOptionPane.showMessageDialog(this, "Data Needed");
		}
		else {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = null;
			String strUpdate="update course_details set course_duration=?,course_fee=? where course_name=?";
			
			try {
				ps=con.prepareStatement(strUpdate);
				ps.setString(1, duration);
				ps.setString(2, fees1);
				ps.setString(3,courseName);
				System.out.println(ps);
				int status= ps.executeUpdate();
				if(status>0) {
					JOptionPane.showMessageDialog(this, courseName+"course details updated successfully");
				}
				
				
				
			}catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
				try {
					if(ps!=null)
						ps.close();
					if(con!=null)
						con.close();
					
				}catch(SQLException se ) {
					se.printStackTrace();
				}
			}
		}
		
			
			
		}
		
		// TODO Auto-generated method stub
		

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		//functional interface
//		System.out.println(state+" "+cname);
		int state = e.getStateChange();
		String cname=(String)e.getItem();//cmbcourse.getSelectedItem()   <-------  yeh bhi use kr sakte the.
		if(state==1)//current state
		{
			if(cname.equalsIgnoreCase("SELECT COURSE"))
			{
				JOptionPane.showMessageDialog(this, "Please select valid course");
				updfees.setText("");
				updduration.setText("");
			}
			Connection con = DBConnection.createConnection();
			String strselect="select * from course_details where course_name=?";
			PreparedStatement ps = null;
			
			ResultSet rs=null;
			try {
				ps=con.prepareStatement(strselect);
				ps.setString(1, cname);
				rs=ps.executeQuery();//it will return a single row
				rs.next();//it will put the pointer on the row or dataset
				//int fees = rs.getString("course_fees");
				String fees=rs.getString("course_fee");
				String duration=rs.getString("course_duration");
				updfees.setText(fees);
				updduration.setText(duration);
			
			}catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)
						rs.clearWarnings();
					if(ps!=null)
						ps.close();
					if(con!=null)
						con.close();
					
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}	
	}