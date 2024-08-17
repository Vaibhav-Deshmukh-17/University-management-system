package University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener{

    Choice crollno  ;
    JDateChooser dcdateFrom , dcdateTo  ;
    JButton Submit , Cancel ;
    JTextField tfreason ;

    StudentLeave(){
        setSize(500,550);
        setLocation(500 , 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Apply Leaves (Students)");
        heading.setBounds(40,30,300,30);
        heading.setFont(new Font("Arial" , Font.BOLD , 20));
        add(heading) ;



        JLabel lblrollno = new JLabel("Search by Roll Number") ;
        lblrollno.setBounds(40 , 80 , 300 , 20);
        lblrollno.setFont(new Font("Arial" , Font.ITALIC , 18));
        add(lblrollno) ;

        crollno = new Choice();
        crollno.setBounds(60 , 130 , 200 ,20);
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



        JLabel lbldate = new JLabel("Date") ;
        lbldate.setBounds(160 , 180 , 200 , 20);
        lbldate.setFont(new Font("Arial" , Font.BOLD , 18));
        add(lbldate) ;

        JLabel lblfrom = new JLabel("From : ") ;
        lblfrom.setBounds(20 , 210 , 200 , 20);
        lblfrom.setFont(new Font("Arial" , Font.ITALIC , 18));
        add(lblfrom) ;

        dcdateFrom = new JDateChooser() ;
        dcdateFrom.setBounds(80 ,210 , 150 , 25);
        add(dcdateFrom) ;


        JLabel lblto = new JLabel("To : ") ;
        lblto.setBounds(250 , 210 , 200 , 20);
        lblto.setFont(new Font("Arial" , Font.ITALIC , 18));
        add(lblto) ;

        dcdateTo = new JDateChooser() ;
        dcdateTo.setBounds(300 ,210 , 150 , 25);
        add(dcdateTo) ;


        JLabel lbltime = new JLabel("Reason : ") ;
        lbltime.setBounds(20 , 280 , 200 , 20);
        lbltime.setFont(new Font("Arial" , Font.BOLD , 18));
        add(lbltime) ;


        tfreason  = new JTextField() ;
        tfreason.setBounds(120,280,300,40);
        tfreason.setFont(new Font("serif" , Font.ITALIC , 15));
        add(tfreason) ;



        Submit = new JButton("Submit") ;
        Submit.setBounds(60 , 400 , 100 , 25);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("arial" , Font.BOLD , 15));
        Submit.addActionListener(this);
        add(Submit) ;

        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(200 , 400 , 100 , 25);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 15));
        Cancel.addActionListener(this);
        add(Cancel) ;



        setVisible(true);
    }


    public  void actionPerformed(ActionEvent ae){
            if (ae.getSource() == Submit){
                String rollno = crollno.getSelectedItem() ;
                String dateFrom = ((JTextField)dcdateFrom.getDateEditor().getUiComponent()).getText() ;
                String dateTo = ((JTextField)dcdateTo.getDateEditor().getUiComponent()).getText() ;
                String reason = tfreason.getText() ;

                String query = "insert into studentleave values ('" + rollno + "' , '"+ dateFrom+ "' , '"+ dateTo+ "' , '" + reason + "')" ;

                try{
                    Conn c = new Conn() ;
                    c.s.executeUpdate(query) ;
                    JOptionPane.showMessageDialog(null , "Leave Confirmed");
                    setVisible(false);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }else{
                setVisible(false);
            }
    }


    public static void main(String[] args) {
        new StudentLeave() ;
    }
}
