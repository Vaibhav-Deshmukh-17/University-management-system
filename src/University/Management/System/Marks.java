package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {

    String rollno ;
    JButton Cancel ;

    Marks(String rollno){

    this.rollno = rollno ;

   setSize(600 , 600);
    setLocation(600 , 100);
    setLayout(null);


        getContentPane().setBackground(Color.white);

        // heading without any input field
        JLabel heading = new JLabel("Chhatrapati Shivaji Maharaj Technical University") ;
        heading.setBounds(10 , 10 , 800 , 30);
        heading.setFont(new Font("Arial" , Font.BOLD , 24));
        add(heading) ;


        // adding subheading without any input field
        JLabel subheading = new JLabel("Result of Examination ") ;
        subheading.setBounds(200 , 80 , 500 , 18);
        subheading.setFont(new Font("Lionel Classic" , Font.BOLD , 20));
        add(subheading) ;


        // getting roll no information
        JLabel lblrollno = new JLabel("Roll Number : "+rollno) ;
        lblrollno.setBounds(60 , 130 , 500 , 18);
        lblrollno.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(lblrollno) ;


        //  getting semester information
        JLabel lblsemester = new JLabel("Semester : ") ;
        lblsemester.setBounds(60 , 170 , 500 , 18);
        lblsemester.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(lblsemester) ;


        // creating fields information about five subjects
        JLabel sub1 = new JLabel() ;
        sub1.setBounds(100 , 250 , 500 , 20);
        sub1.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(sub1) ;


        JLabel sub2 = new JLabel() ;
        sub2.setBounds(100 , 280 , 500 , 20);
        sub2.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(sub2) ;


        JLabel sub3 = new JLabel() ;
        sub3.setBounds(100 , 310 , 500 , 20);
        sub3.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(sub3) ;


        JLabel sub4 = new JLabel() ;
        sub4.setBounds(100 , 340 , 500 , 20);
        sub4.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(sub4) ;


        JLabel sub5 = new JLabel() ;
        sub5.setBounds(100 , 370 , 500 , 20);
        sub5.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(sub5) ;


            try{
                Conn c = new Conn() ;

                // getting subjects data from database
                ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'") ;
                while (rs1.next()){
                    sub1.setText(rs1.getString("sub1"));
                    sub2.setText(rs1.getString("sub2"));
                    sub3.setText(rs1.getString("sub3"));
                    sub4.setText(rs1.getString("sub4"));
                    sub5.setText(rs1.getString("sub5"));
                }

                // getting marks data from database
                ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'") ;

                while (rs2.next()){
                    sub1.setText(sub1.getText() + "----------------------"+rs2.getString("marks1"));
                    sub2.setText(sub2.getText() + "----------------------"+rs2.getString("marks2"));
                    sub3.setText(sub3.getText() + "----------------------"+rs2.getString("marks3"));
                    sub4.setText(sub4.getText() + "----------------------"+rs2.getString("marks4"));
                    sub5.setText(sub5.getText() + "----------------------"+rs2.getString("marks5"));
                    lblsemester.setText("Semester " +rs2.getString("semester"));

                }

            }catch (Exception e){
               e.printStackTrace();
            }

            // making cancel button
        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(220 , 450 , 120 , 25);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 18));
        Cancel.addActionListener(this);
        add(Cancel) ;

        setVisible(true);

    }

public  void  actionPerformed(ActionEvent ae){

            setVisible(false);

}

    public static void main(String[] args) {
        new Marks("") ;
    }
}
