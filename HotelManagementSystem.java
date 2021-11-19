
package hotel.management.system;

import java.awt.*;       //importing color
import javax.swing.*;   //jframe class is inside swing package
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public HotelManagementSystem() {
		
                setSize(1366,430);          // setContentPane(300,300,1366,390);   frame size (length, breadth, x axis, y axis)
                setLayout(null);           //by default layout is border layout, that's why we set to null, which means we can place components according to our preference
                setLocation(300,300);

		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
				
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
				
				//classloader contains a static method "getsystemresource" to give adress of the frame. your telling the java compiler 
				//where your image is located
				
                Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
				
			
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
				
				
                JLabel lid= new JLabel("HOTEL MANAGEMENT SYSTEM");
					//icon cannot be put directly on the frame, that's why you need to put an image ina  frame called Jlabel
				
                lid.setBounds(30,300,1500,100);  //setting the frame of the image
				
                lid.setFont(new Font("serif",Font.PLAIN,70));  //to set font for the text "hotel management system"
			    lid.setForeground(Color.red); //to set the color for the text "hotel management system"
				l1.add(lid);  //adding the text "hotel management system"
                
                b1.setBounds(1170,325,150,50);  //setting location of the text with respect to the frame
				
		l1.setBounds(0, 0, 1366, 390);
                
                l1.add(b1);  //adding text on image
		        add(l1);
 
                b1.addActionListener(this);
                setVisible(true);  //the image shows on the frame 
                
                while(true){     //starting infinite loop to make the text flash 
                        lid.setVisible(false); // lid =  j label  
						//text "hotel management system"  initially making it invisible
						
                    try{
                        Thread.sleep(500); //1000 = 1 second  //making the frame reveal itself
                    }
					catch(Exception e){} 
					
                        lid.setVisible(true);
                    
					try{
                        Thread.sleep(500);
                    }
					catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){   
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagementSystem window = new HotelManagementSystem();
                window.setVisible(true);			
	}
}
