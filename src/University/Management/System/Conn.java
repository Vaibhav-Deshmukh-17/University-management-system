package University.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// In this class we are making connection with MySQL through JDBC
public class Conn {

    Connection c ;
    Statement s ;

    Conn(){

        try {
            // connecting mysql with java using jdbc using Driver
           Class.forName("com.mysql.cj.jdbc.Driver");

           // forming a coonection with mysql local host and our database name  also provide username and password of our mysql to access
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem" , "root" , "Vaibhav@17") ;
           s = c.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
