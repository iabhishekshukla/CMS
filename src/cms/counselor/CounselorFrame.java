package cms.counselor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cms.gui.LoginFrame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.*;
import javax.swing.ImageIcon;
public class CounselorFrame extends JFrame implements ActionListener ,WindowListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CounselorFrame frame = new CounselorFrame();
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
	public CounselorFrame() {
		this.addWindowListener(this);//register the frame with window listener
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("CounselorFrame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCourse = new JMenu("Course");
		menuBar.add(mnCourse);
		
		JMenuItem mi_addcourse = new JMenuItem("Add");
		mi_addcourse.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-add-16.png")));
		mi_addcourse.addActionListener(this);
		mnCourse.add(mi_addcourse);
		
		JMenuItem mi_updatecourse = new JMenuItem("Update");
		mi_updatecourse.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-update-16.png")));
		mi_updatecourse.addActionListener(this);
		mnCourse.add(mi_updatecourse);
		
		JMenuItem mi_deletecourse = new JMenuItem("Delete");
		mi_deletecourse.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-delete-16.png")));
		mi_deletecourse.addActionListener(this);
		mnCourse.add(mi_deletecourse);
		
		JMenu Student = new JMenu("Student");
		menuBar.add(Student);
		
		JMenuItem mi_addstudent = new JMenuItem("AddStudent");
		mi_addstudent.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-student-16.png")));
		mi_addstudent.addActionListener(this);
		Student.add(mi_addstudent);
		
		JMenuItem mi_updatestudent = new JMenuItem("UpdateStudent");
		mi_updatestudent.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-update-16.png")));
		mi_updatestudent.addActionListener(this);
		Student.add(mi_updatestudent);
		
		JMenuItem mi_delstudent = new JMenuItem("DeleteStudent");
		mi_delstudent.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-deleting-16.png")));
		mi_delstudent.addActionListener(this);
		Student.add(mi_delstudent);
		
		JMenu admin = new JMenu("Admin");
		menuBar.add(admin);
		
		JMenuItem report = new JMenuItem("Report");
		report.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-report-16.png")));
		admin.add(report);
		
		JMenuItem allstudent = new JMenuItem("AllStudents");
		allstudent.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-all-16 (1).png")));
		admin.add(allstudent);
		
		JMenuItem allcourse = new JMenuItem("AllCourse");
		allcourse.setIcon(new ImageIcon(CounselorFrame.class.getResource("/cms/images/icons8-courses-16.png")));
		admin.add(allcourse);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 241);
		contentPane.add(panel);
		
		
		ImageIcon ic = new ImageIcon(CounselorFrame.class.getResource("/cms/images/111.jpg"));
		
		
		Image i2=ic.getImage().getScaledInstance(126, 176,Image.SCALE_DEFAULT);
		ImageIcon ic1=new ImageIcon(i2);
		JLabel lblimage = new JLabel("");
		lblimage.setIcon(ic1);
		lblimage.setBounds(300, 43, 126, 176);
		contentPane.add(lblimage);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String menu_text=e.getActionCommand();
		
		if(menu_text.equalsIgnoreCase("Add")) {
			Course course= new Course();
			course.setVisible(true);
		}
		if(menu_text.equalsIgnoreCase("Update")) {
			Updatecourse updatecourse= new Updatecourse();
			updatecourse.setVisible(true);
			
		}
		if(menu_text.equalsIgnoreCase("Delete")) {
			DeleteCourse delcourse = new DeleteCourse();
			delcourse.setVisible(true);
			
		}
		String stmenu_text=e.getActionCommand();
		if(stmenu_text.equalsIgnoreCase("AddStudent")) {
			Student student = new Student();
			student.setVisible(true);
			
		}
		if(stmenu_text.equalsIgnoreCase("UpdateStudent")) {
			UpdateStudent upstudent = new UpdateStudent();
			upstudent.setVisible(true);
			
		}
		if(stmenu_text.equalsIgnoreCase("DeleteStudent")) {
			DeleteStudent deleStudent = new DeleteStudent();
			deleStudent.setVisible(true);
			
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		LoginFrame login = new LoginFrame();
		login.setVisible(true);
		
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
}
