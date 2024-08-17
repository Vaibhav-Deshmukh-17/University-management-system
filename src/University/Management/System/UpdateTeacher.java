package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField  tfaddress , tfcourse ;
    JTextField tfphno , tfemail , tfdistrict , tfstate , tfbranch ;
    JButton Submit , Cancel ;
    JLabel labelEmpID ;
    Choice cEmpID ;


    UpdateTeacher(){
        setSize(900 , 650);
        setLocation(350 , 50);
        setLayout(null);

        // For heading
        JLabel heading = new JLabel("Update Teacher Details") ;
        heading.setBounds(50 , 10 , 500 , 50);
        heading.setFont(new Font("serif" , Font.ITALIC , 35));
        add(heading) ;


        JLabel lblrollnumber = new JLabel("Select Employee ID") ;
        lblrollnumber.setBounds(50 , 100 , 200 , 20);
        lblrollnumber.setFont(new Font("serif" , Font.PLAIN , 20));
        add(lblrollnumber) ;

        cEmpID = new Choice();
        cEmpID.setBounds(250 , 100 , 200 ,20);
        add(cEmpID) ;

        try{
            Conn c = new Conn() ;
            ResultSet rs = c.s.executeQuery("select * from teacher") ;
            while (rs.next()){
                cEmpID.add(rs.getString("EmpID"));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        // setting Name panel with Textfield
        JLabel lblname = new JLabel(" Name : ") ;
        lblname.setBounds(50 , 150 , 100 , 30);
        lblname.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblname) ;

        JLabel labelname  = new JLabel();
        labelname.setBounds(150 , 150 , 200, 30);
        labelname.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(labelname);


        //Setting Father's name panel with textfield
        JLabel lblfathername = new JLabel(" Father's Name : ") ;
        lblfathername.setBounds(400 , 150 , 200 , 30);
        lblfathername.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblfathername) ;

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600 , 150 , 200, 30);
        labelfname.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(labelfname);


        // setting Roll no section with auto generated roll numbers
        JLabel lblEmpID = new JLabel(" Employee ID : ") ;
        lblEmpID.setBounds(50 , 200 , 200 , 30);
        lblEmpID.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblEmpID) ;

        labelEmpID = new JLabel() ;
        labelEmpID.setBounds(200 , 200 , 200 , 30);
        labelEmpID.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(labelEmpID) ;


        // setting date of birth section with calender
        JLabel lbldob = new JLabel(" Date of Birth : ") ;
        lbldob.setBounds(400 , 200 , 200 , 30);
        lbldob.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbldob) ;

        JLabel labeldcdob = new JLabel() ;
        labeldcdob.setBounds(600 ,200 , 150 , 30);
        labeldcdob.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(labeldcdob) ;


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

        JLabel label10th = new JLabel();
        label10th.setBounds(600 , 350 , 200, 30);
        label10th.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(label10th);


        // creating 12th marks section
        JLabel lbl12th = new JLabel(" Class XII Marks : ") ;
        lbl12th.setBounds(30 , 400 , 400 , 30);
        lbl12th.setFont(new Font("serif" , Font.BOLD , 20));
        add(lbl12th) ;

        JLabel label12th = new JLabel();
        label12th.setBounds(250 , 400 , 100, 30);
        label12th.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(label12th);


        // asking interested course details
        JLabel lblcourse = new JLabel(" Qualification :") ;
        lblcourse.setBounds(400 , 400 , 200 , 30);
        lblcourse.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblcourse) ;

        tfcourse = new JTextField();
        tfcourse.setBounds(600 , 400 , 200 , 30);
        add(tfcourse) ;


        // creating branch section
        JLabel lblbranch = new JLabel(" Department : ") ;
        lblbranch.setBounds(50 , 450 , 100 , 30);
        lblbranch.setFont(new Font("serif" , Font.BOLD , 20));
        add(lblbranch) ;

        tfbranch = new JTextField();
        tfbranch.setBounds(150 , 450 , 200, 30);
        add(tfbranch);


        try {
            Conn c = new Conn() ;
            String query = "select * from teacher where EmpID = '"+cEmpID.getSelectedItem()+"'" ;
            ResultSet rs = c.s.executeQuery(query) ;
            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelEmpID.setText(rs.getString("EmpID"));
                labeldcdob.setText(rs.getString("dob"));
                tfemail.setText(rs.getString("email"));
                tfdistrict.setText(rs.getString("district"));
                tfstate.setText(rs.getString("state"));
                tfaddress.setText(rs.getString("address"));
                tfphno.setText(rs.getString("contact"));
                label10th.setText(rs.getString("classx"));
                label12th.setText(rs.getString("classxii"));
                tfcourse.setText(rs.getString("qualification"));
                tfbranch.setText(rs.getString("department"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cEmpID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn() ;
                    String query = "select * from teacher where EmpId = '"+cEmpID.getSelectedItem()+"'" ;
                    ResultSet rs = c.s.executeQuery(query) ;
                    while (rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labelEmpID.setText(rs.getString("EmpID"));
                        labeldcdob.setText(rs.getString("dob"));
                        tfemail.setText(rs.getString("email"));
                        tfdistrict.setText(rs.getString("district"));
                        tfstate.setText(rs.getString("state"));
                        tfaddress.setText(rs.getString("address"));
                        tfphno.setText(rs.getString("contact"));
                        label10th.setText(rs.getString("classx"));
                        label12th.setText(rs.getString("classxii"));
                        tfcourse.setText(rs.getString("qualification"));
                        tfbranch.setText(rs.getString("department"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        Submit = new JButton("Update") ;
        Submit.setBounds(250 , 500 , 120 , 30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("arial" , Font.BOLD , 15));
        Submit.addActionListener(this);
        add(Submit) ;

        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(450 , 500 , 120 , 30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 15));
        Cancel.addActionListener(this);
        add(Cancel) ;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Submit){
            String EmpID = labelEmpID.getText() ;
            String email = tfemail.getText() ;
            String district = tfdistrict.getText() ;
            String state = tfstate.getText() ;
            String address = tfaddress.getText() ;
            String contact = tfphno.getText() ;
            String course = tfcourse.getText() ;
            String branch =tfbranch.getText() ;

            try{
                String query = "update teacher set email = '"+email+"' , district = '"+district+"' , state='"+state+"' , address='"+address+"' , contact='"+contact+"' , qualification='"+course+"' , department='"+branch+"' where EmpID='"+EmpID+"'";
                Conn con = new Conn() ;
                con.s.executeUpdate(query) ;

                JOptionPane.showMessageDialog(null , "Teacher Details Updated Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher() ;
    }
}
