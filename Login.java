//HOTEL MANAGEMENT SYSTEM
//DESKTOP APPLICATION WITH THE HELP OF SWINGS
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  //importing all classes of event package - it also includes actionlistener
import java.sql.*;        //resultset is inside this package

public class Login extends JFrame implements ActionListener{  //implement this interface actionlistener which is inside event package java.awt.event.*
 //we use actionlistener to connect the main frame with login frame through next button 

  
    JLabel l1,l2;         //variables declared globally
    JTextField t1;
    JPasswordField t2;   //whatever you write in this field wont be visible to user
    JButton b1,b2;

    Login(){   

        super("Login");

        setLayout(null);  //we set this because by default its border layout to get the text in the center

        l1 = new JLabel("Username");  //defining label
        l1.setBounds(40,20,100,30);    
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();            //creating field next to username text
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();         //creating field next to username text
        t2.setBounds(150,70,150,30);
        add(t2);
        
		
		
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
       //to add image we use imageicon class and define the location of the image


	   Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	   //ceating image class object i2. we use function getimage to change
	   //size of the image because the image we set before using jlabel i3 
	   //was too large .
	   
	   //get image takes 3 arguments -width of image, height of image, scale
        ImageIcon i3 =  new ImageIcon(i2);
		
		
        JLabel l3 = new JLabel(i3);   //label of the image
        l3.setBounds(350,10,150,150); //frame size of label
        add(l3);                      //add image on label


        b1 = new JButton("Login");  //defining button which says login
		
		
        b1.setBounds(40,140,120,30);  //setting location of button
		
        b1.setFont(new Font("serif",Font.BOLD,15));
	

	
        b1.addActionListener(this);   //adding action listener on this button
		
		
		
		
        b1.setBackground(Color.BLACK);  //setting bg color for button
        b1.setForeground(Color.WHITE);   //setting color of text in button
        add(b1);

        b2=new JButton("Cancel");    //creating another button cancel
		
        b2.setBounds(180,140,120,30);
		
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
		
		

        b2.addActionListener(this);
        
		
		
        
        getContentPane().setBackground(Color.WHITE); //to set bg color of the frame

        setVisible(true);
        setSize(600,300);     //setting size of the frame
        setLocation(600,350);

    }

    public void actionPerformed(ActionEvent ae){    //actionevent class object ae
	//this method is to overwrite an unimplemented method 
	
	//new Login().setVisible(true);
	//all coding is inside the constructor login().
	//when you click on "next" login frame will open
	
	//this.setVisible(false); this command is to close the main frame ; basically it
	//closes current class frame
	
        if(ae.getSource()==b1){            //class object ae is to differentiate when user clicks on b1      
        try{
            conn c1 = new conn();           //this is used to form connection with db
            String u = t1.getText();       //to extract data entered from user and store it in a string
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
			//string is created to ensure that login values entered by user
			//matches the database
           

//this snippet is to throw from login page to the dashboard frame		   
            ResultSet rs = c1.s.executeQuery(q);   //execute query here and stored in resultset class object
            if(rs.next()){                          //if values matched 
                new Dashboard().setVisible(true);
                setVisible(false);
            }else{                                 //if values dont match
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);                //closing
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
	
    public static void main(String[] arg){   //creating main method
        new Login();
    }
}
//
//import java.awt.EventQueue;
//import java.sql.*;	
//import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Image;
//
//public class Login {
//Connection conn = null;
//ResultSet rs = null;
//PreparedStatement pst = null;
//
//	private JFrame frame;
//	private JTextField txt_username;
//	private JPasswordField txt_password;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	/**
//	 * Create the application.
//	 * @throws SQLException 
//	 */
//	public Login() throws SQLException {
//		initialize();
//		//conn = Javaconnect.getDBConnection();
//	}
//	public void close(){
//		this.frame.dispose();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 683, 445);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JLabel lblUsername = new JLabel("Username:");
//		lblUsername.setBounds(357, 114, 67, 27);
//		frame.getContentPane().add(lblUsername);
//		
//		JLabel lblPassword = new JLabel("Password:");
//		lblPassword.setBounds(357, 187, 67, 27);
//		frame.getContentPane().add(lblPassword);
//		
//		txt_username = new JTextField();
//		txt_username.setBounds(419, 117, 86, 20);
//		frame.getContentPane().add(txt_username);
//		txt_username.setColumns(10);
//		
//		JButton btnLogin = new JButton("Login");
//		btnLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String loginsql = "select * from Manager where m_name=? and password=?";
////				try{
////					pst = conn.prepareStatement(loginsql);
////					pst.setString(1, txt_username.getText());
////					pst.setString(2, txt_password.getText());
////					
////					rs = pst.executeQuery();
////					if(rs.next()){
////						JOptionPane.showMessageDialog(null, "Login Successful");
////						Manager manager = new Manager();
////						manager.setVisible(true);
////						close();
////					}
////					else
////					{
////						JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
////					}
////				}
////				catch(Exception e){
////					JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
////				}
//			}
//		});
//		btnLogin.setBounds(400, 275, 89, 23);
//		frame.getContentPane().add(btnLogin);
//		
//		txt_password = new JPasswordField();
//		txt_password.setBounds(418, 190, 87, 20);
//		frame.getContentPane().add(txt_password);
//	}
//}