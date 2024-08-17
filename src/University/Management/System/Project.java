package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Project extends JFrame implements ActionListener {

  Project() {
    setSize(1900, 800);


    // Adding Image in our Projects window
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1900, 850, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);


    // creating information button
    JMenuBar mb = new JMenuBar();
    JMenu newInformation = new JMenu("New Information");
    newInformation.setForeground(Color.black);
    mb.add(newInformation);


    // adding list or item in that information button in menu bar
    JMenuItem Faculty_Info = new JMenuItem("Faculty Info");
    Faculty_Info.setBackground(Color.white);
    Faculty_Info.addActionListener(this);
    newInformation.add(Faculty_Info);

    JMenuItem Student_Info = new JMenuItem("Student Info");
    Student_Info.setBackground(Color.white);
    Student_Info.addActionListener(this);
    newInformation.add(Student_Info);


    // making view details button
    JMenu Details = new JMenu("Details");
    Details.setForeground(Color.black);
    mb.add(Details);

    JMenuItem Facult_Details = new JMenuItem("View Faculty Details ");
    Facult_Details.setBackground(Color.white);
    Facult_Details.addActionListener(this);
    Details.add(Facult_Details);

    JMenuItem Student_Details = new JMenuItem("View Student Details");
    Student_Details.setBackground(Color.white);
    Student_Details.addActionListener(this);
    Details.add(Student_Details);


    //  creating button for Leaves section
    JMenu Leaves = new JMenu("Apply Leaves");
    Leaves.setForeground(Color.black);
    mb.add(Leaves);

    JMenuItem Faculty_Leaves = new JMenuItem("Faculty Leaves ");
    Faculty_Leaves.setBackground(Color.white);
    Faculty_Leaves.addActionListener(this);
    Leaves.add(Faculty_Leaves);

    JMenuItem Student_Leaves = new JMenuItem("Student Leaves");
    Student_Leaves.setBackground(Color.white);
    Student_Leaves.addActionListener(this);
    Leaves.add(Student_Leaves);


    // check leave details as well
    JMenu Leave_Details = new JMenu(" Leave Details");
    Leave_Details.setForeground(Color.black);
    mb.add(Leave_Details);

    JMenuItem Facult_Leave_Details = new JMenuItem("Faculty Leave Details ");
    Facult_Leave_Details.setBackground(Color.white);
    Facult_Leave_Details.addActionListener(this);
    Leave_Details.add(Facult_Leave_Details);

    JMenuItem Student_Leave_Details = new JMenuItem("Student Leave Details");
    Student_Leave_Details.setBackground(Color.white);
    Student_Leave_Details.addActionListener(this);
    Leave_Details.add(Student_Leave_Details);


    // making an exam section
    JMenu Exam_Details = new JMenu(" Examination ");
    Exam_Details.setForeground(Color.black);
    mb.add(Exam_Details);

    JMenuItem E_Result = new JMenuItem(" Results ");
    E_Result.setBackground(Color.white);
    E_Result.addActionListener(this);
    Exam_Details.add(E_Result);

    JMenuItem E_Marks = new JMenuItem("Enter Marks");
    E_Marks.setBackground(Color.white);
    E_Marks.addActionListener(this);
    Exam_Details.add(E_Marks);


    // Update section in case we want to update about our faculty or Students
    JMenu Update_Details = new JMenu(" Update Details");
    Update_Details.setForeground(Color.black);
    mb.add(Update_Details);

    JMenuItem Facult_Update_Details = new JMenuItem("Update Faculty Details ");
    Facult_Update_Details.setBackground(Color.white);
    Facult_Update_Details.addActionListener(this);
    Update_Details.add(Facult_Update_Details);

    JMenuItem Student_Update_Details = new JMenuItem("Update Student Details");
    Student_Update_Details.setBackground(Color.white);
    Student_Update_Details.addActionListener(this);
    Update_Details.add(Student_Update_Details);


    // making fees section
    JMenu Fees_Details = new JMenu(" Fees Details");
    Fees_Details.setForeground(Color.black);
    mb.add(Fees_Details);

    JMenuItem FeesStructure = new JMenuItem("Fees Structure ");
    FeesStructure.setBackground(Color.white);
    FeesStructure.addActionListener(this);
    Fees_Details.add(FeesStructure);

    JMenuItem FeesForm = new JMenuItem("Fees Form");
    FeesForm.setBackground(Color.white);
    FeesForm.addActionListener(this);
    Fees_Details.add(FeesForm);


    // making utility functions
    JMenu Utilities = new JMenu(" Utilities ");
    Utilities.setForeground(Color.black);
    mb.add(Utilities);

    JMenuItem Calculator = new JMenuItem("Calculator ");
    Calculator.setBackground(Color.white);
    Calculator.addActionListener(this);
    Utilities.add(Calculator);

    JMenuItem Notepad = new JMenuItem("Notepad");
    Notepad.setBackground(Color.white);
    Notepad.addActionListener(this);
    Utilities.add(Notepad);


    // making an about section
    JMenu about =  new JMenu("About") ;
    about.setForeground(Color.black);
    mb.add(about) ;

    JMenuItem ab = new JMenuItem("About") ;
    ab.setBackground(Color.white);
    ab.addActionListener(this);
    about.add(ab) ;


    setJMenuBar(mb);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    String msg = ae.getActionCommand();
    if (msg.equals("Calculator")) {
      try {
        Runtime.getRuntime().exec("calc.exe");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (msg.equals("Notepad")) {
      try {
        Runtime.getRuntime().exec("notepad.exe");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (msg.equals("Faculty Info")) {
      new AddTeacher();
    } else if (msg.equals("Student Info")) {
      new AddStudent();
    } else if (msg.equals("View Faculty Details ")) {
      new TeacherDetails();
    } else if (msg.equals("View Student Details")) {
      new StudentDetails();
    }else if (msg.equals("Faculty Leaves ")) {
      new TeacherLeave();
    }else if (msg.equals("Student Leaves")) {
      new StudentLeave();
    }else if (msg.equals("Faculty Leave Details ")) {
      new TeacherLeaveDetails();
    }else if (msg.equals("Student Leave Details")) {
      new StudentLeaveDetails();
    }else if (msg.equals("Update Faculty Details ")) {
      new UpdateTeacher();
    }else if (msg.equals("Update Student Details")) {
      new UpdateStudent();
    }else if (msg.equals("Enter Marks")) {
      new EnterMarks();
    }else if (msg.equals(" Results ")) {
      new Results();
    }else if (msg.equals("Fees Structure ")) {
      new FeeStructure();
    }else if (msg.equals("About")) {
      new About();
    }else if (msg.equals("Fees Form")) {
      new StudentFeeForm();
    }
  }

  public static void main(String[] args) {
    new Project();
  }
}
