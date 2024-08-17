package University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname , tffathername , tfaddress ;
    JTextField tfphno , tfemail , tfdistrict , tfstate ;
    JTextField tf10th , tf12th ;
    JButton Submit , Cancel ;

    JLabel labelEmpId ;
    JDateChooser dcdob ;
    JComboBox cbcourse , cbbranch ;

    Random ran = new Random() ;
    long four4 = Math.abs((ran.nextLong() % 9000L) + 1000L) ;

    AddTeacher(){

        // setting window size
        setSize(900 , 700);
        setLocation(350 , 50);
        setLayout(null);

        // creating heading
        JLabel heading = new JLabel("New Teacher Details") ;
        heading.setBounds(310 , 30 , 500 , 50);
        heading.setFont(new Font("serif" , Font.BOLD , 30));
        add(heading) ;

        // setting Name panel with Textfield
        JLabel lblname = new JLabel(" Name : ") ;
        lblname.setBounds(50 , 150 , 100 , 30);
        lblname.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblname) ;

        tfname = new JTextField();
        tfname.setBounds(150 , 150 , 200, 30);
        add(tfname);


        //Setting Father's name panel with textfield
        JLabel lblfathername = new JLabel(" Father's Name : ") ;
        lblfathername.setBounds(400 , 150 , 200 , 30);
        lblfathername.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblfathername) ;

        tffathername = new JTextField();
        tffathername.setBounds(600 , 150 , 200, 30);
        add(tffathername);


        // setting Employee ID no section with auto generated Employee ID
        JLabel lblEmpID = new JLabel(" Employee ID : ") ;
        lblEmpID.setBounds(50 , 200 , 200 , 30);
        lblEmpID.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblEmpID) ;

        labelEmpId = new JLabel("" +four4) ;
        labelEmpId.setBounds(200 , 200 , 200 , 30);
        labelEmpId.setFont(new Font("serif" , Font.BOLD , 20));
        add(labelEmpId) ;


        // setting date of birth section with calender
        JLabel lbldob = new JLabel(" Date of Birth : ") ;
        lbldob.setBounds(400 , 200 , 200 , 30);
        lbldob.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbldob) ;

        dcdob = new JDateChooser() ;
        dcdob.setBounds(600 ,200 , 150 , 30);
        add(dcdob) ;


        // creating address panel with textfield
        JLabel lbladdress = new JLabel(" Address : ") ;
        lbladdress.setBounds(50 , 250 , 100 , 30);
        lbladdress.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbladdress) ;

        tfaddress = new JTextField();
        tfaddress.setBounds(150 , 250 , 200, 30);
        add(tfaddress);


        // creating phone number section
        JLabel lblphno = new JLabel(" Contact Number : ") ;
        lblphno.setBounds(400 , 250 , 200 , 30);
        lblphno.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblphno) ;

        tfphno = new JTextField();
        tfphno.setBounds(600 , 250 , 200, 30);
        add(tfphno);


        // creating section to collect details about district
        JLabel lbldistrict = new JLabel(" District : ") ;
        lbldistrict.setBounds(50 , 300 , 100 , 30);
        lbldistrict.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbldistrict) ;

        tfdistrict = new JTextField();
        tfdistrict.setBounds(150 , 300 , 200, 30);
        add(tfdistrict);


        // creating section to collect state information
        JLabel lblstate = new JLabel(" State : ") ;
        lblstate.setBounds(400 , 300 , 200 , 30);
        lblstate.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblstate) ;

        tfstate = new JTextField();
        tfstate.setBounds(600 , 300 , 200, 30);
        add(tfstate);


        // creating email id section
        JLabel lblemail = new JLabel(" Email : ") ;
        lblemail.setBounds(50 , 350 , 100 , 30);
        lblemail.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblemail) ;

        tfemail = new JTextField();
        tfemail.setBounds(150 , 350 , 200, 30);
        add(tfemail);


        // creating  10th percentage section
        JLabel lbl10th = new JLabel(" Class X Marks :") ;
        lbl10th.setBounds(400 , 350 , 200 , 30);
        lbl10th.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbl10th) ;

        tf10th = new JTextField();
        tf10th.setBounds(600 , 350 , 200, 30);
        add(tf10th);


        // creating 12th percentage section
        JLabel lbl12th = new JLabel(" Class XII Marks : ") ;
        lbl12th.setBounds(30 , 400 , 400 , 30);
        lbl12th.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbl12th) ;

        tf12th = new JTextField();
        tf12th.setBounds(250 , 400 , 100, 30);
        add(tf12th);


        // asking Qualification details and dropdown for that
        JLabel lblcourse = new JLabel(" Qualification :") ;
        lblcourse.setBounds(400 , 400 , 200 , 30);
        lblcourse.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblcourse) ;

        String [] courses = {"B.Tech" , "BCA" , "Bsc" , "BA" , "B.com" ,"M.Tech" , "MCA" , "Msc" , "MA" , "M.com" , "MBA" } ;
        cbcourse = new JComboBox(courses);
        cbcourse.setBounds(600 , 400 , 200 , 30);
        add(cbcourse) ;


        // creating department section and dropdown for that
        JLabel lblbranch = new JLabel(" Department : ") ;
        lblbranch.setBounds(50 , 450 , 100 , 30);
        lblbranch.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblbranch) ;

        String [] branch = {"Computer Science" , "Mechanical" , "IT" , "Civil" , "Electrical" , "Finance" , "Marketing" , " Automobile" , "Psychology" , "Humanities"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(150 , 450 , 200, 30);
        add(cbbranch);


        // creating submit button
        Submit = new JButton("Submit") ;
        Submit.setBounds(250 , 550 , 120 , 30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("arial" , Font.BOLD , 15));
        Submit.addActionListener(this);
        add(Submit) ;


        // creating cancel button
        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(450 , 550 , 120 , 30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 15));
        Cancel.addActionListener(this);
        add(Cancel) ;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Submit){
            String name = tfname.getText() ;
            String fname = tffathername.getText() ;
            String EmpId = labelEmpId.getText() ;
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText() ;
            String email = tfemail.getText() ;
            String district = tfdistrict.getText() ;
            String state = tfstate.getText() ;
            String address = tfaddress.getText() ;
            String contact = tfphno.getText() ;
            String classx = tf10th.getText() ;
            String classxii = tf12th.getText() ;
            String qualification = (String) cbcourse.getSelectedItem() ;
            String department = (String) cbbranch.getSelectedItem() ;

            try{
                String query = "insert into teacher values ('"+name+"' , '"+fname+"' , '"+EmpId+"' , '"+email+"' , '"+dob+"' , '"+district+"' , '"+state+"' , '"+address+"' , '"+classx+"' , '"+classxii+"' , '"+contact+"' , '"+qualification+"' , '"+department+"')";
                Conn con = new Conn() ;
                con.s.executeUpdate(query) ;

                JOptionPane.showMessageDialog(null , "Teacher Details Inserted Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher() ;
    }
}
