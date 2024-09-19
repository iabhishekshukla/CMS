package cms.counselor;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import cms.dbinfo.DBConnection;
import cms.gui.LoginFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;
public class DeleteCourse extends JFrame implements ActionListener ,WindowListener,KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textcourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourse frame = new DeleteCourse();
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
	public DeleteCourse() {
		setTitle("DeleteCourse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coursename = new JLabel("CourseName");
		coursename.setBackground(new Color(128, 128, 64));
		coursename.setFont(new Font("Tahoma", Font.BOLD, 15));
		coursename.setBounds(58, 59, 97, 29);
		contentPane.add(coursename);
		
		textcourse = new JTextField();
		textcourse.addKeyListener(this);
		textcourse.setBounds(194, 66, 96, 19);
		contentPane.add(textcourse);
		textcourse.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(121, 116, 104, 21);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		
		//btnsubmit.setIcon(new ImageIcon(LoginFrame.class.getResource("/cms/images/icons8-button-50.png")));
		ImageIcon ic = new ImageIcon(DeleteCourse.class.getResource("/cms/images/111.jpg"));
		
		
		Image i2=ic.getImage().getScaledInstance(126, 176,Image.SCALE_DEFAULT);
		ImageIcon ic1=new ImageIcon(i2);
		
		
		
		
		
		JLabel lblimage = new JLabel("");
		lblimage.setIcon(ic1);
		lblimage.setBounds(300, 43, 126, 176);
		contentPane.add(lblimage);
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
		System.out.println("button is been clicked");
		String cname=textcourse.getText();
		if(cname.isEmpty()) {
			
			JOptionPane.showMessageDialog(this, "please enter the course");
		}else {
			int choice= JOptionPane.showConfirmDialog(this, "Do you wish to delete"+cname+"course");
//			System.out.println(choice);
			if(choice==0) {
				//data deletion code will be here
				Connection con = DBConnection.createConnection();
				PreparedStatement ps = null;
				String deleteQuery= "delete from course_details where course_name=?";
				try {
					ps=con.prepareStatement(deleteQuery);
					ps.setString(1, cname);
					int status= ps.executeUpdate();
					if(status>0) {
						JOptionPane.showMessageDialog(this, cname+"course delete succesfully");
						
					}else {
						JOptionPane.showMessageDialog(this, "no such course exits");
					}
					
				}
				catch(SQLException se) {
					se.printStackTrace();
				}	finally {
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
			}
			
		}
			
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(e.getSource()==textcourse)//getsourse() will return the source that is generating event 
		{
			if(!(Character.isAlphabetic(c)))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed");
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
