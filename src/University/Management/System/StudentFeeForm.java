package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno ;
    JLabel labeltotal ;
    JButton update , pay , back ;
    JComboBox cbcourse , cbbranch , cbsem ;

    StudentFeeForm(){
        setSize(900,500);
        setBounds(300,100,900,500);
        setLocation(400,150);

        getContentPane().setBackground(Color.white);

        // Adding Image in our Projects window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,500,300);
        add(image);



        JLabel lblrollnumber = new JLabel("Select Roll No.") ;
        lblrollnumber.setBounds(40 , 60 , 150 , 20);
        lblrollnumber.setFont(new Font("Tahoma" , Font.BOLD , 16));
        add(lblrollnumber) ;

        crollno = new Choice();
        crollno.setBounds(200 , 60 , 150 ,20);
        add(crollno) ;

        try{
            Conn c = new Conn() ;
            ResultSet rs = c.s.executeQuery("select * from student") ;
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        // setting Name panel with Textfield
        JLabel lblname = new JLabel(" Name : ") ;
        lblname.setBounds(40 , 100 , 150 , 20);
        lblname.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(lblname) ;

        JLabel labelname  = new JLabel();
        labelname.setBounds(200 , 100 , 150, 20);
        labelname.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        add(labelname);


        //Setting Father's name panel with textfield
        JLabel lblfathername = new JLabel(" Father's Name : ") ;
        lblfathername.setBounds(40 , 140 , 150 , 20);
        lblfathername.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(lblfathername) ;

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200 , 140 , 150, 20);
        labelfname.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        add(labelfname);



        try {
            Conn c = new Conn() ;
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'" ;
            ResultSet rs = c.s.executeQuery(query) ;
            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel lblcourse = new JLabel(" Course :") ;
        lblcourse.setBounds(40 , 180 , 150 , 20);
        lblcourse.setFont(new Font("Tahoma" , Font.BOLD , 16));
        add(lblcourse) ;


        // creating string of courses to show in our dropdown
        // used JCombobox to create dropdown

        String [] courses = {"BTech" , "BCA" , "Bsc" , "BA" , "Bcom" ,"MTech" , "MCA" , "Msc" , "MA" , "Mcom" , "MBA" } ;
        cbcourse = new JComboBox(courses);
        cbcourse.setBounds(200 , 180 , 150 , 20);
        add(cbcourse) ;


        // creating branch section
        JLabel lblbranch = new JLabel(" Branch : ") ;
        lblbranch.setBounds(40 , 220 , 150 , 30);
        lblbranch.setFont(new Font("Tahoma" , Font.BOLD , 16));
        add(lblbranch) ;


        // creating string of branch to show in our dropdown
        // used JCombobox to create dropdown

        String [] branch = {"Computer Science" , "Mechanical" , "IT" , "Civil" , "Electrical" , "Finance" , "Marketing" , " Automobile" , "Psychology" , "Humanities"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200 , 220 , 150, 20);
        add(cbbranch);


        JLabel lblsem = new JLabel("Select Semester :") ;
        lblsem.setBounds(40 , 260 , 150 , 20);
        lblsem.setFont(new Font("Tahoma" , Font.BOLD , 16));
        add(lblsem) ;

        String[] semester = {"semester1" , "semester2" , "semester3" , "semester4" , "semester5" , "semester6" , "semester7" , "semester8"} ;
        cbsem = new JComboBox(semester);
        cbsem.setBounds(200 , 260 , 150 , 20);
        cbsem.setBackground(Color.white);
        add(cbsem) ;


        JLabel lbltotal = new JLabel("Total Payable :") ;
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD , 16));
        add(lbltotal) ;

         labeltotal = new JLabel() ;
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN , 18));
        add(labeltotal) ;

        // creating submit button and add action listener to it
        update = new JButton("Update") ;
        update.setBounds(30 , 380 , 100 , 25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setFont(new Font("arial" , Font.BOLD , 15));
        update.addActionListener(this);
        add(update) ;


        // creating cancel button and add action listener to it
        pay = new JButton("Pay Fee") ;
        pay.setBounds(150 , 380 , 100 , 25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.setFont(new Font("arial" , Font.BOLD , 15));
        pay.addActionListener(this);
        add(pay) ;


        back = new JButton("Back") ;
        back.setBounds(270 , 380 , 100 , 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("arial" , Font.BOLD , 15));
        back.addActionListener(this);
        add(back) ;


        setLayout(null);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ie){
        if (ie.getSource() == update){
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsem.getSelectedItem() ;

            try{
               Conn c = new Conn() ;
               ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'") ;

               while (rs.next()){
                    labeltotal.setText((rs.getString(semester)));
               }

            } catch (Exception e){
                e.printStackTrace();
            }

        }else if(ie.getSource() == pay){

            String rollno = crollno.getSelectedItem() ;
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsem.getSelectedItem() ;
            String branch  = (String) cbbranch.getSelectedItem() ;
            String total = labeltotal.getText() ;

            try{

                Conn c = new Conn() ;
                String query = "insert into collegefee values ('"+rollno+"' , '"+course+"' ,'"+semester+"' ,'"+branch+"' ,'"+total+"')";
                c.s.executeUpdate(query) ;

                JOptionPane.showMessageDialog(null , "College fee submitted successfully");
                setVisible(false);

            } catch (Exception e){
                e.printStackTrace();
            }

        }else {

        }
    }

    public static void main(String[] args) {
        new StudentFeeForm() ;
    }
}
