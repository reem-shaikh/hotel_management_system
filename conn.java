
package hotel.management.system;

//creating a connection using connector - to create database connection
//we use jdc concept to connect java with db
//jdbc is an API to execute java quieries 

import java.sql.*;    //contains interfaces and classes

public class conn{  

    Connection c;   //declaring objects
    Statement s;
	
    public conn(){    //constructor 
        try{  
		
		// 1. REGISTER THE DRIVER CLASS
		//install connector jar file "mysql jdbc driver" through adding it from libraries after installing mysql
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///hms","root","root"); 
			//in string you pass mysql driver
            
            s =c.createStatement();   //this will form connection with db
			
		//to use db we go to login.java class and use actionlistener
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  


//1.register the driver class -using static method forname
//2.create the connection object -using drivermanager class which contains
//static method getconnection where we will pass the connection string -forming connection with db
//3. create the statement object
//4. execute the query 
//5. close connection