
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{   //jframe class inside swing package java.swing.*

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
	
        setForeground(Color.CYAN);
        setLayout(null);    //because default is border layout

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
		//i2 to change size of image to fill fullpage 
		
        ImageIcon i3 = new ImageIcon(i2); 
		
	JLabel NewLabel = new JLabel(i3);            //you can only place images in label
	NewLabel.setBounds(0, 0, 1950, 1000);        //setting frame size 
        add(NewLabel);
        
        JLabel AirlineManagementSystem = new JLabel("THE TAJ GROUP WELCOMES YOU");
	AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
	AirlineManagementSystem.setBounds(600, 60, 1000, 85);
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();   //creating menubar
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("HOTEL MANAGEMENT");
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("RECEPTION");  //creating menu items inside hotel management
	AirlineSystem.add(FlightDetails);
		
	JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
	menuBar.add(AirlineSystemHello);
        
        JMenuItem FlightDetailshello1 = new JMenuItem("ADD EMPLOYEE");
	AirlineSystemHello.add(FlightDetailshello1);
        
        FlightDetailshello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem FlightDetailshello2 = new JMenuItem("ADD ROOMS");
	AirlineSystemHello.add(FlightDetailshello2);
        
        FlightDetailshello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem FlightDetailshello3 = new JMenuItem("ADD DRIVERS");
	AirlineSystemHello.add(FlightDetailshello3);
        
	FlightDetailshello3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}

/*
//open frame when you click on add employeee (menu item)



public void actionPerformed (ActionEvent ae)
{
if (ae.getactioncommand().equals("reception"))
{
}
else if (ae.getActionCommand.equals("add employee"))
{
new addemployee().setvisible(true);
}/*