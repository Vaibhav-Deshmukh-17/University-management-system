package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

   JButton  jb_login , jb_cancel ;
   JTextField tfusername , tfpassword ;

    Login(){

        getContentPane().setBackground(Color.white);
        setLayout(null);


        // Taking Username here with text field
        JLabel lblusername = new JLabel("UserName : ") ;
        lblusername.setBounds(40 , 20 , 100 , 20);
        add(lblusername) ;

         tfusername = new JTextField();
        tfusername.setBounds(120,20,150,20);
        add(tfusername) ;


        // Taking password here with text field
        JLabel lblpassword = new JLabel("Password : ") ;
        lblpassword.setBounds(40 , 70 , 100 , 20);
        add(lblpassword) ;

         tfpassword = new JPasswordField();
        tfpassword.setBounds(120,70,150,20);
        add(tfpassword) ;


            // making login button here
        jb_login = new JButton("Login") ;
        jb_login.setBounds(40 , 130 , 120 , 30);
        jb_login.setBackground(Color.black);
        jb_login.setForeground(Color.white);
        jb_login.setFont(new Font("arial" , Font.BOLD , 15));
        jb_login.addActionListener(this);
        add(jb_login) ;


        // making cancel button here
        jb_cancel = new JButton("Cancel") ;
        jb_cancel.setBounds(200 , 130 , 120 , 30);
        jb_cancel.setBackground(Color.black);
        jb_cancel.setForeground(Color.white);
        jb_cancel.addActionListener(this);
        jb_cancel.setFont(new Font("arial" , Font.BOLD , 15));
        add(jb_cancel) ;


        // adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(200 ,200 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(350 , 20 , 200 , 150 );
        add(image) ;


        // login window parameters
        setSize(600 , 300);
        setLocation(500 , 250);
        setVisible(true);
    }

    // adding event/action listener to login and cancel button
    public void actionPerformed (ActionEvent ae ){
       if (ae.getSource() == jb_login){
           String username = tfusername.getText();
           String password = tfpassword.getText();

           // sql query to identify username and password
           String query = "select * from jb_login where Username = '" + username + "' and Password = '" + password + "'" ;

           try {
              Conn c =  new Conn();
              ResultSet rs = c.s.executeQuery(query) ;

              // if credential is correct then close the current window and open new projects window else show invalid's msg
              if (rs.next()){
                 setVisible(false);
                 new Project();
              }else{
                  JOptionPane.showMessageDialog(null , "Invalid Username or Password");
                  setVisible(false);
              }
                c.s.close();
           }catch (Exception e){
               e.printStackTrace();
           }

       } else if (ae.getSource() == jb_cancel) {
           setVisible(false);
       }
    }

    public static void main(String[] args) {
       new Login();
    }

}
