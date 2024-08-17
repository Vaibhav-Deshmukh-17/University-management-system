package University.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Results extends JFrame implements ActionListener {

    JTextField  search ;
    JButton Submit , Cancel ;
    JTable table ;

    Results(){

        // setting result windows parameter
        setSize(1000 , 475);
        setLocation(300 , 100);
        setLayout(null);

        getContentPane().setBackground(Color.white);


        // making heading here
        JLabel heading = new JLabel("Check Results") ;
        heading.setBounds(80 , 15 , 400 , 50);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 24));
        add(heading) ;


        // text field
        search = new JTextField() ;
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma" , Font.PLAIN , 18));
        add(search) ;


        // making submit button
        Submit = new JButton("View Result") ;
        Submit.setBounds(300 , 90 , 120 , 25);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("arial" , Font.BOLD , 15));
        Submit.addActionListener(this);
        add(Submit) ;


        // making cancel button
        Cancel = new JButton("Cancel") ;
        Cancel.setBounds(450 , 90 , 120 , 25);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("arial" , Font.BOLD , 15));
        Cancel.addActionListener(this);
        add(Cancel) ;


        table = new JTable() ;
        table.setFont(new Font("Tahoma" , Font.PLAIN , 16));

        JScrollPane jsp = new JScrollPane(table) ;
        jsp.setBounds(0,130,1000,300);
        add(jsp) ;


        try{
            Conn c = new Conn() ;
            ResultSet rs = c.s.executeQuery("select * from student") ;
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }


        table.addMouseListener(new MouseAdapter() {
            public void  mouseClicked(MouseEvent me){
                int row = table.getSelectedRow() ;
               search.setText( table.getModel().getValueAt(row , 2).toString()) ;
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == Submit){
        setVisible(false);
        new Marks(search.getText()) ;

    }else {
        setVisible(false);
    }
    }

    public static void main(String[] args) {
        new Results() ;
    }
}
