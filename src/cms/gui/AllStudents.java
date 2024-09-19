package cms.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import cms.dbinfo.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class AllStudents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllStudents frame = new AllStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillTable() {
		Connection con = DBConnection.createConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery="select * from student_details";
		try {
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery(); //10 rows ka referance will hold by rs
			TableModel model=DbUtils.resultSetToTableModel(rs);
			table.setModel(model);
			TableColumnModel tcm = table.getColumnModel();
			tcm.getColumn(0).setHeaderValue("Rollno");
			tcm.getColumn(1).setHeaderValue("Name");
			tcm.getColumn(2).setHeaderValue("Email");
			tcm.getColumn(3).setHeaderValue("Phone");
			tcm.getColumn(4).setHeaderValue("Course");
			tcm.getColumn(5).setHeaderValue("Address");
			
			
			
			
		}catch(SQLException se) {
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
				
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		
		
	}


	/**
	 * Create the frame.
	 */
	public AllStudents() {
		setTitle("All Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 416, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(64, 128, 128));
		fillTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("All Students");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(149, 23, 101, 22);
		contentPane.add(lblNewLabel);
	}
}
