package coursemansystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class NewCourse extends JFrame implements ActionListener{
	 private JLabel l1,l2,l3,l4,l5,l6,l7;
	    private JTextField t1,t2,t3,t4;
	    private JPasswordField t5;
	    private JComboBox cb,combo;
	    private JButton b1;
	    private String x,y;
	    private Statement s;
	    private Connection c;
	    NewCourse() {
	    	super("New Course");
	        setBackground(Color.white);
	        setLayout(null);
	        
	        l1 = new JLabel("Course Name");
	        l1.setBounds(40,20,100,30);
	        add(l1);
	        t1=new JTextField();
	        t1.setBounds(150,20,150,30);
	        add(t1);
	        
//	        l1 = new JLabel("Course Module ");
//	        l1.setBounds(40,20,100,30);
//	        add(l1);
//	        t1=new JTextField();
//	        t1.setBounds(150,20,150,30);
//	        add(t1);
//	        
	        
	        
	        b1 = new JButton("Submit");
	        b1.setBounds(350,250,120,30);
	        b1.setFont(new Font("serif",Font.BOLD,15));
	        b1.addActionListener(this);
	        b1.setBackground(Color.BLACK);
	        b1.setForeground(Color.WHITE);
	        add(b1);
	        
	        getContentPane().setBackground(Color.WHITE);

	        setVisible(true);
	        setSize(800,450);
	        setLocation(400,200);
	        
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource()== b1){
                 try {
                     Connect c1 = new Connect();
                     String name = t1.getText();
                     String a = "Insert into courses(CourseName)  values('"+name+"')";
                     c1.s.executeUpdate(a);
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 }
			 }
             JOptionPane.showMessageDialog(null, "Course Added Successfully");
             setVisible(false);
		}
		public static void main(String[] args) throws SQLException{
	        new NewCourse();
	    }
}
