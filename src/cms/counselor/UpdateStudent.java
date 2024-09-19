package cms.counselor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cms.dbinfo.DBConnection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateStudent extends JFrame implements ActionListener,WindowListener,ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usname;
	private JTextField usemail;
	private JTextField usphone;
	private JTextField usaddress;
	private JComboBox <String> updscombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
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
		String selectQuery="select * from student_details";
		try {
			ps=con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while(rs.next()==true) {
				String cname= rs.getString("roll_number");//it is used to fect the value from the specified column
				System.out.println(cname);
//					rs.getString(ABORT);
				updscombo.addItem(cname);
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
	public UpdateStudent() {
		setTitle("UpdateStudent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 679, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		updscombo = new JComboBox();
		updscombo.addItemListener(this); 
		updscombo.setModel(new DefaultComboBoxModel(new String[] {"SELECT Roll_No"}));
		updscombo.setToolTipText("");
		updscombo.setBounds(190, 59, 169, 21);
		fillCombo();
		contentPane.add(updscombo);
		
		JLabel uname = new JLabel("Name");
		uname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uname.setBounds(146, 132, 90, 30);
		contentPane.add(uname);
		
		JLabel uemail = new JLabel("Email");
		uemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uemail.setBounds(146, 197, 45, 13);
		contentPane.add(uemail);
		
		JLabel uphone = new JLabel("Phone");
		uphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uphone.setBounds(146, 256, 45, 13);
		contentPane.add(uphone);
		
		JLabel uaddress = new JLabel("Address");
		uaddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uaddress.setBounds(146, 309, 71, 13);
		contentPane.add(uaddress);
		
		usname = new JTextField();
		usname.setBounds(266, 140, 96, 19);
		contentPane.add(usname);
		usname.setColumns(10);
		
		usemail = new JTextField();
		usemail.setBounds(266, 196, 96, 19);
		contentPane.add(usemail);
		usemail.setColumns(10);
		
		usphone = new JTextField();
		usphone.setBounds(266, 255, 96, 19);
		contentPane.add(usphone);
		usphone.setColumns(10);
		
		usaddress = new JTextField();
		usaddress.setBounds(266, 308, 96, 19);
		contentPane.add(usaddress);
		usaddress.setColumns(10);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnupdate.setBounds(205, 376, 102, 21);
		contentPane.add(btnupdate);
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		//functional interface
//		System.out.println(state+" "+cname);
		int state = e.getStateChange();
		String cname=(String)e.getItem();//cmbcourse.getSelectedItem()   <-------  yeh bhi use kr sakte the.
		if(state==1)//current state
		{
			if(cname.equalsIgnoreCase("roll_no"))
			{
				JOptionPane.showMessageDialog(this, "Please select valid Rollno");
				usname.setText("");
				usemail.setText("");
				usphone.setText("");
				usaddress.setText("");
				
			}
			Connection con = DBConnection.createConnection();
			String strselect="select * from student_details where roll_number=?";
			PreparedStatement ps = null;
			
			ResultSet rs=null;
			try {
				ps=con.prepareStatement(strselect);
				ps.setString(1, cname);
				rs=ps.executeQuery();//it will return a single row
				rs.next();//it will put the pointer on the row or dataset
				//int fees = rs.getString("course_fees");
				String uname=rs.getString("name");
				String uemail=rs.getString("email");
				String uphone=rs.getString("phone");
				String uaddress=rs.getString("address");
				usname.setText(uname);
				usemail.setText(uemail);
				usphone.setText(uphone);
				usaddress.setText(uaddress);
				
				
			
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
		// TODO Auto-generated method stub
		
	
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
		// TODO Auto-generated method stub
		String caption_text = e.getActionCommand();
		String usroll=(String)updscombo.getSelectedItem();
		String usName = usname.getText(); 
		String usEmail = usemail.getText();
		String usPhone = usphone.getText();
		String usAddress = usaddress.getText();
		if(usName.isEmpty()||usEmail.isEmpty() ||usroll.equalsIgnoreCase("SELECT ROLLNO")) {
			JOptionPane.showMessageDialog(this, "Data Needed");
		}
		else {
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = null;
			String strUpdate="update student_details set name=?,email=?,phone=?,address=? where roll_number=?";
			
			try {
				ps=con.prepareStatement(strUpdate);
				ps.setString(1, usName);
				ps.setString(2, usEmail);
				ps.setString(3,usPhone);
				ps.setString(4,usAddress);
				ps.setString(5, usroll);
				System.out.println(ps);
				int status= ps.executeUpdate();
				if(status>0) {
					JOptionPane.showMessageDialog(this, usroll+"student details updated successfully");
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
	}

