package cms.gui;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import cms.dbinfo.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CourseWiseStudent extends JFrame implements ItemListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String>cmbcourse;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseWiseStudent frame = new CourseWiseStudent();
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
	public void fillcombo()
	{
	Connection con=	DBConnection.createConnection();
	String Select_query="select * from course_details";
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		ps=con.prepareStatement(Select_query);
		rs=ps.executeQuery();
		
		while(rs.next()==true)
		{
		String n=rs.getString("course_name");
		//System.out.println(n);
		cmbcourse.addItem(n);
		}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	}
	public CourseWiseStudent() {
		setTitle("CourseWiseStudent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbcourse = new JComboBox();
		cmbcourse.addItemListener(this);
		cmbcourse.setModel(new DefaultComboBoxModel(new String[] {"Select Course"}));
		fillcombo();
		cmbcourse.setBounds(96, 11, 145, 22);
		contentPane.add(cmbcourse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 560, 368);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int c=e.getStateChange();
		if(c==1)
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			String strselect="select * from student_details where course_name=?";
			String coursename=(String)e.getItem();
			try
			{
				if(coursename.equalsIgnoreCase("Select Course"))
				{
					JOptionPane.showMessageDialog(this,"Please select a valid course");
				}
				else
				{
				ps=con.prepareStatement(strselect);
				ps.setString(1, coursename);
				rs=ps.executeQuery();
				TableModel model=DbUtils.resultSetToTableModel(rs);
				int count=model.getRowCount();
				if(count==0)
				{
					JOptionPane.showMessageDialog(this,"No student has been registered in "+coursename);
				}
				table.setModel(model);
			}
			}
			catch (SQLException se) {
				se.printStackTrace();	
			}	
		}		
	}
}