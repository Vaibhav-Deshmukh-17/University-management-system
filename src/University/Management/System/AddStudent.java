package University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JTextField tfname , tffathername , tfaddress ;
    JTextField tfphno , tfemail , tfdistrict , tfstate ;
    JTextField tf10th , tf12th ;
    JButton Submit , Cancel ;

    JLabel labelRollno ;
    JDateChooser dcdob ;
    JComboBox cbcourse , cbbranch ;

    Random ran = new Random() ;
    long four4 = Math.abs((ran.nextLong() % 9000L) + 1000L) ;

    AddStudent(){

                // Setting display size
        setSize(900 , 700);
        setLocation(350 , 50);
        setLayout(null);


                // Setting heading
        JLabel heading = new JLabel("New Student Details") ;
        heading.setBounds(310 , 30 , 500 , 50);
        heading.setFont(new Font("serif" , Font.BOLD , 30));
        add(heading) ;


            // setting Name panel
        JLabel lblname = new JLabel(" Name : ") ;
        lblname.setBounds(50 , 150 , 100 , 30);
        lblname.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblname) ;

                    // setting text field for name section
        tfname = new JTextField();
        tfname.setBounds(150 , 150 , 200, 30);
        add(tfname);


                      //Setting Father's name panel
        JLabel lblfathername = new JLabel(" Father's Name : ") ;
        lblfathername.setBounds(400 , 150 , 200 , 30);
        lblfathername.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblfathername) ;


                    // setting text field for father name section
        tffathername = new JTextField();
        tffathername.setBounds(600 , 150 , 200, 30);
        add(tffathername);


                    // setting Roll no section
        JLabel lblRollno = new JLabel(" Roll Number : ") ;
        lblRollno.setBounds(50 , 200 , 200 , 30);
        lblRollno.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblRollno) ;


            // generating automatic roll no ---- if we want any predefined sequence before or after
            // auto generated roll no use that numbers in below string sign
        labelRollno = new JLabel("" +four4) ;
        labelRollno.setBounds(200 , 200 , 200 , 30);
        labelRollno.setFont(new Font("serif" , Font.BOLD , 20));
        add(labelRollno) ;


        // setting date of birth section
        JLabel lbldob = new JLabel(" Date of Birth : ") ;
        lbldob.setBounds(400 , 200 , 200 , 30);
        lbldob.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbldob) ;


                // setting calendar using date chooser function
        dcdob = new JDateChooser() ;
        dcdob.setBounds(600 ,200 , 150 , 30);
        add(dcdob) ;


        // creating address panel
        JLabel lbladdress = new JLabel(" Address : ") ;
        lbladdress.setBounds(50 , 250 , 100 , 30);
        lbladdress.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbladdress) ;


                // Address panels text field
        tfaddress = new JTextField();
        tfaddress.setBounds(150 , 250 , 200, 30);
        add(tfaddress);


        // creating phone number section
        JLabel lblphno = new JLabel(" Contact Number : ") ;
        lblphno.setBounds(400 , 250 , 200 , 30);
        lblphno.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblphno) ;


            // text field to take contact details
        tfphno = new JTextField();
        tfphno.setBounds(600 , 250 , 200, 30);
        add(tfphno);


        // creating section to collect details about district
        JLabel lbldistrict = new JLabel(" District : ") ;
        lbldistrict.setBounds(50 , 300 , 100 , 30);
        lbldistrict.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbldistrict) ;


                // text field to take district info
        tfdistrict = new JTextField();
        tfdistrict.setBounds(150 , 300 , 200, 30);
        add(tfdistrict);


        // creating section to collect state information
        JLabel lblstate = new JLabel(" State : ") ;
        lblstate.setBounds(400 , 300 , 200 , 30);
        lblstate.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblstate) ;


        // text field to take state info
        tfstate = new JTextField();
        tfstate.setBounds(600 , 300 , 200, 30);
        add(tfstate);


        // creating email id section
        JLabel lblemail = new JLabel(" Email : ") ;
        lblemail.setBounds(50 , 350 , 100 , 30);
        lblemail.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblemail) ;


        // text field to take email id
        tfemail = new JTextField();
        tfemail.setBounds(150 , 350 , 200, 30);
        add(tfemail);


        // creating  10th percentage section
        JLabel lbl10th = new JLabel(" Class X Marks :") ;
        lbl10th.setBounds(400 , 350 , 200 , 30);
        lbl10th.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbl10th) ;


        // text field to take 10th percentage
        tf10th = new JTextField();
        tf10th.setBounds(600 , 350 , 200, 30);
        add(tf10th);


        // creating 12th marks section
        JLabel lbl12th = new JLabel(" Class XII Marks : ") ;
        lbl12th.setBounds(30 , 400 , 400 , 30);
        lbl12th.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbl12th) ;


        // text field to take 12th percentage
        tf12th = new JTextField();
        tf12th.setBounds(250 , 400 , 100, 30);
        add(tf12th);


        // asking interested course details
        JLabel lblcourse = new JLabel(" Course :") ;
        lblcourse.setBounds(400 , 400 , 200 , 30);
        lblcourse.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblcourse) ;


        // creating string of courses to show in our dropdown
        // used JCombobox to create dropdown
        String [] courses = {"B.Tech" , "BCA" , "Bsc" , "BA" , "B.com" ,"M.Tech" , "MCA" , "Msc" , "MA" , "M.com" , "MBA" } ;
        cbcourse = new JComboBox(courses);
        cbcourse.setBounds(600 , 400 , 200 , 30);
        add(cbcourse) ;


        // creating branch section
        JLabel lblbranch = new JLabel(" Branch : ") ;
        lblbranch.setBounds(50 , 450 , 100 , 30);
        lblbranch.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblbranch) ;


        // creating string of branch to show in our dropdown
        // used JCombobox to create dropdown
        String [] branch = {"Computer Science" , "Mechanical" , "IT" , "Civil" , "Electrical" , "Finance" , "Marketing" , " Automobile" , "Psychology" , "Humanities"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(150 , 450 , 200, 30);
        add(cbbranch);


        // creating submit button and add action listener to it
        Submit = new JButton("Submit") ;
        Submit.setBounds(250 , 550 , 120 , 30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("arial" , Font.BOLD , 15));
        Submit.addActionListener(this);
        add(Submit) ;


        // creating cancel button and add action listener to it
        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(450 , 550 , 120 , 30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 15));
        Cancel.addActionListener(this);
        add(Cancel) ;

        setVisible(true);
    }


    // Down here we are performing particular task based on button selected
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Submit){
            String name = tfname.getText() ;
            String fname = tffathername.getText() ;
            String rollno = labelRollno.getText() ;
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText()  ;
            String email = tfemail.getText() ;
            String district = tfdistrict.getText() ;
            String state = tfstate.getText() ;
            String address = tfaddress.getText() ;
            String contact = tfphno.getText() ;
            String classx = tf10th.getText() ;
            String classxii = tf12th.getText() ;
            String course = (String) cbcourse.getSelectedItem() ;
            String branch = (String) cbbranch.getSelectedItem() ;



            try{
                String query = "insert into student values ('"+name+"' , '"+fname+"' , '"+rollno+"' , '"+dob+"' , '"+email+"' , '"+district+"' , '"+state+"' , '"+address+"' , '"+contact+"' , '"+classx+"' , '"+classxii+"' , '"+course+"' , '"+branch+"')";
                Conn con = new Conn() ;
                con.s.executeUpdate(query) ;

                JOptionPane.showMessageDialog(null , "Student Details Inserted Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent() ;
    }
}
