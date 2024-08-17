package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno ;
    JComboBox cbsem ;
    JTextField tfsub1  , tfsub2 , tfsub3 , tfsub4 , tfsub5 ;
    JTextField  tfmarks1 , tfmarks2 , tfmarks3 , tfmarks4 , tfmarks5 ;
    JButton Submit , Cancel ;



    EnterMarks(){

        // creating window
        setSize(1000,500);
        setLocation(300 , 150);
        setLayout(null);

        getContentPane().setBackground(Color.white);

            // adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500 , 40 , 400 , 300);
        add(image);


                // adding heading without text field
        JLabel heading = new JLabel("Enter Marks of Student") ;
        heading.setBounds(50 , 0 , 500 , 50);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 20));
        add(heading) ;


                    // adding roll no without any text field
        JLabel lblrollnumber = new JLabel("Select Roll Number") ;
        lblrollnumber.setBounds(40 , 70 , 200 , 20);
        lblrollnumber.setFont(new Font("serif" , Font.PLAIN , 20));
        add(lblrollnumber) ;


        // dropdown using Choice class
        crollno = new Choice();
        crollno.setBounds(250 , 70 , 150 ,20);
        add(crollno) ;


        // accessing student roll no that will be auto displayed
        try{
            Conn c = new Conn() ;
            ResultSet rs = c.s.executeQuery("select * from student") ;
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }


        // creating semester section with dropdown
        JLabel lblsem = new JLabel("Select Semester") ;
        lblsem.setBounds(40 , 120 , 200 , 20);
        lblsem.setFont(new Font("serif" , Font.PLAIN , 20));
        add(lblsem) ;

        String[] semester = {"1st Semester" , "2nd Semester" , "3rd Semester" , "4th Semester" , "5th Semester" , "6th Semester" , "7th Semester" , "8th Semester"} ;
        cbsem = new JComboBox(semester);
        cbsem.setBounds(200 , 120 , 150 , 20);
        cbsem.setBackground(Color.white);
        add(cbsem) ;



        // creatign subject section
        JLabel lblentersubject = new JLabel("Enter Subject") ;
        lblentersubject.setBounds(100 , 150 , 200 , 40);
        lblentersubject.setFont(new Font("serif" , Font.PLAIN , 20));
        add(lblentersubject) ;


        // creating marks section
        JLabel lblentermarks = new JLabel("Enter Marks") ;
        lblentermarks.setBounds(320 , 150 , 200 , 40);
        lblentermarks.setFont(new Font("serif" , Font.PLAIN , 20));
        add(lblentermarks) ;


        // text field to enter subjects name in it ----- total 5 subjects
        tfsub1 = new JTextField() ;
        tfsub1.setBounds(50 , 200 , 200 , 20 );
        add(tfsub1) ;


        tfsub2 = new JTextField() ;
        tfsub2.setBounds(50 , 230 , 200 , 20 );
        add(tfsub2) ;


        tfsub3 = new JTextField() ;
        tfsub3.setBounds(50 , 260 , 200 , 20 );
        add(tfsub3) ;


        tfsub4 = new JTextField() ;
        tfsub4.setBounds(50 , 290 , 200 , 20 );
        add(tfsub4) ;


        tfsub5 = new JTextField() ;
        tfsub5.setBounds(50 , 320 , 200 , 20 );
        add(tfsub5) ;


        // text field to enter marks in it ----- total 5 marks section
        tfmarks1 = new JTextField() ;
        tfmarks1.setBounds(280 , 200 , 200 , 20 );
        add(tfmarks1) ;


        tfmarks2 = new JTextField() ;
        tfmarks2.setBounds(280 , 230 , 200 , 20 );
        add(tfmarks2) ;


        tfmarks3 = new JTextField() ;
        tfmarks3.setBounds(280 , 260 , 200 , 20 );
        add(tfmarks3) ;


        tfmarks4 = new JTextField() ;
        tfmarks4.setBounds(280 , 290 , 200 , 20 );
        add(tfmarks4) ;


        tfmarks5 = new JTextField() ;
        tfmarks5.setBounds(280 , 320 , 200 , 20 );
        add(tfmarks5) ;


        // creating submit button
        Submit = new JButton("Submit") ;
        Submit.setBounds(70 , 370 , 150 , 30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("arial" , Font.BOLD , 15));
        Submit.addActionListener(this);
        add(Submit) ;


        // creating cancel button
        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(260 , 370 , 150 , 30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 15));
        Cancel.addActionListener(this);
        add(Cancel) ;


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Submit){
           try{
               Conn c = new Conn() ;

                // inserting data into respective tables to be get displayed
               String query = "insert into subject values('"+crollno.getSelectedItem()+"' , '"+cbsem.getSelectedItem()+"' , '"+tfsub1.getText()+"' , '"+tfsub2.getText()+"'  , '"+tfsub3.getText()+"' , '"+tfsub4.getText()+"' , '"+tfsub5.getText()+"' )";
               String query1 = "insert into marks values('"+crollno.getSelectedItem()+"' , '"+cbsem.getSelectedItem()+"' , '"+tfmarks1.getText()+"' , '"+tfmarks2.getText()+"'  , '"+tfmarks3.getText()+"' , '"+tfmarks4.getText()+"' , '"+tfmarks5.getText()+"' )";

               c.s.executeUpdate(query);
               c.s.executeUpdate(query1);

               JOptionPane.showMessageDialog(null , "Marks Inserted Successfully ");
               setVisible(false);

           }catch (Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks() ;
    }
}
