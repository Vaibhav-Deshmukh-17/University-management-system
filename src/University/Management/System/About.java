package University.Management.System;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){
         setSize(700 , 500);
         setLocation(400 , 150);

         getContentPane().setBackground(Color.white);


        // Adding Image in our Projects window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,300,200);
        add(image);


        setLayout(null);

        JLabel heading = new JLabel("University") ;
        heading.setBounds(40,10,200,130);
        heading.setFont(new Font("Tahoma",Font.BOLD , 30));
        add(heading)  ;

        JLabel heading1 = new JLabel("Management") ;
        heading1.setBounds(90,40,200,130);
        heading1.setFont(new Font("Tahoma",Font.BOLD , 30));
        add(heading1) ;

        JLabel heading2 = new JLabel("System") ;
        heading2.setBounds(240,70,200,130);
        heading2.setFont(new Font("Tahoma",Font.BOLD , 30));
        add(heading2) ;


        JLabel name = new JLabel("Developed By : Vaibhav Deshmukh") ;
        name.setBounds(40,220,600,40);
        name.setFont(new Font("Tahoma",Font.PLAIN , 25));
        add(name) ;


         JLabel contact = new JLabel("Contact : deshmukhvaibhav697@gmail.com") ;
        contact.setBounds(40,270,600,40);
        contact.setFont(new Font("Tahoma",Font.ITALIC , 20));
        add(contact) ;

        JLabel end = new JLabel("Made with Love !!!") ;
        end.setBounds(280,400,600,40);
        end.setFont(new Font("serif",Font.BOLD , 18));
        add(end) ;


        setVisible(true);
    }

    public static void main(String[] args) {
        new About() ;
    }
}
