package cms.gui;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import cms.dbinfo.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class AllCourses extends JFrame {

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
					AllCourses frame = new AllCourses();
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
		String selectQuery="select * from course_details";
		try {
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery(); //10 rows ka referance will hold by rs
			TableModel model=DbUtils.resultSetToTableModel(rs);
			table.setModel(model);
			TableColumnModel tcm = table.getColumnModel();
			tcm.getColumn(0).setHeaderValue("Course Name");
			tcm.getColumn(1).setHeaderValue("Course Fees");
			tcm.getColumn(2).setHeaderValue("Course Duration");
			
			
			
			
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
	public AllCourses() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Availabe courses");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(382, 35, 119, 26);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 83, 806, 548);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0, 0, 0));
		table.setForeground(new Color(255, 255, 0));
		//formating for table headings
		JTableHeader header= table.getTableHeader();
		header.setBackground(Color.cyan);
		header.setFont(new Font("Arial",Font.BOLD,20));
		fillTable();
		scrollPane.setViewportView(table);
	}
}
