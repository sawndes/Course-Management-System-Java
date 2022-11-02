package coursemansystem;

//Importing Required Packages
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// AdminPanel Class that is child class of JFrame and implements ActionListener Interface
public class AdminPanel extends JFrame implements ActionListener {
	// Private Variables which is used only in this class
	private JLabel l1;
	private JButton b1;
	// Constructor AdminPanel
    AdminPanel()
    {
    	// GUI 
        super("School Management System");
        // Size of panel
        setSize(650,300);
        setLocationRelativeTo(null);
        // Adding Label on panel
        l1 = new JLabel("Welcome, Admin");
        l1.setBounds(150,0,400,80);
        l1.setFont(new Font("Senserif", Font.BOLD, 40));
        add(l1);
        // Button for logout
        b1 = new JButton("Logout Admin");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250, 180, 115 ,30);
        add(b1);
        b1.addActionListener(this);
        // Menubar with options
        JMenuBar mb  = new JMenuBar();
        JMenu New = new JMenu("New");
        JMenuItem m1 = new JMenuItem("New Course");
        JMenuItem m2 = new JMenuItem("Assign Teacher");
        JMenuItem m3 = new JMenuItem("Register Student");
        New.setForeground(Color.BLACK);
        New.setFont(new Font("monospaces",Font.BOLD,27));


        m1.setFont(new Font("monospaced",Font.BOLD,16));
        m1.setBackground(Color.WHITE);

        m2.setFont(new Font("monospaced",Font.BOLD,16));
        m2.setBackground(Color.WHITE);
        
        m3.setFont(new Font("monospaced",Font.BOLD,16));
        m3.setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);


        JMenu user = new JMenu("Details");
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        user.setForeground(Color.BLACK);
        user.setFont(new Font("monospaces",Font.BOLD,27));

        u1.setFont(new Font("monospaced",Font.BOLD,16));
        u1.setBackground(Color.WHITE);

        u2.setFont(new Font("monospaced",Font.BOLD,16));
        u2.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);



        JMenu exam = new JMenu("Report");
        JMenuItem c1 = new JMenuItem("Result Slip");
        exam.setForeground(Color.BLACK);
        exam.setFont(new Font("monospaces",Font.BOLD,27));

        c1.setFont(new Font("monospaced",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        exam.add(c1);
        
        c1.addActionListener(this);
     
        JMenu report = new JMenu("Edit/Delete");
        JMenuItem r1 = new JMenuItem("Edit Course");
        JMenuItem r2 = new JMenuItem("Delete Course");
        report.setForeground(Color.BLACK);
        report.setFont(new Font("monospaces",Font.BOLD,30));

        r1.setFont(new Font("monospaced",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        
        r2.setFont(new Font("monospaced",Font.BOLD,16));
        r2.setBackground(Color.WHITE);

        r1.addActionListener(this);
        r2.addActionListener(this);

        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        exit.setFont(new Font("monospaces",Font.BOLD,27));


        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);

        New.add(m1);
        New.add(m2);
        New.add(m3);

        user.add(u1);
        user.add(u2);

        report.add(r1);
        report.add(r2);

        exit.add(ex);

        mb.add(New);
        mb.add(user);
        mb.add(exam);
        mb.add(report);
        mb.add(exit);

        setJMenuBar(mb);
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(null);
        setVisible(false);
        



        
    }
    public void actionPerformed(ActionEvent ae){
    	// Go to specific class when clicked
        String msg = ae.getActionCommand();
        if(msg.equals("New Course")){
            new AddCourse().setVisible(true);
//
        }else if(msg.equals("Assign Teacher")){
            new AssignTeacher().setVisible(true);
//		
        }else if (msg.equals("Register Student")) {
        	new RegisterStudent().setVisible(true);
        	
        } else if(msg.equals("Student Details")){
            new StudentDetails().setVisible(true);
//
        }else if(msg.equals("Teacher Details")){
            new TeacherDetails().setVisible(true);
//
        }
        else if(msg.equals("Result Slip")){
            new StudentResult().setVisible(true);
//
        }
        else if(msg.equals("Edit Course")){
            try {
				new SelectCourse().setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        else if(msg.equals("Delete Course")){
            try {
				new SelectCourse("del").setVisible(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        else if (ae.getSource() == b1){
        	new Login().setVisible(true);
        	this.dispose();
        }
        else if(msg.equals("Exit")){
            System.exit(0);
        }


    }


    public static void main(String[] args){
        new AdminPanel().setVisible(true);

    }
}
