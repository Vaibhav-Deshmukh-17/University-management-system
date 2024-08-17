
package University.Management.System;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t ;

    Splash(){

        // taking image and set it accordingly
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(1000 ,700 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        add(image) ;

        // creating new thread to execute task on seperate thread without disturbing main thread
        t = new Thread(this) ;
        t.start();

        setVisible(true);

        // setting animation for it like speed motion etc
        int x = 1 ;
        for (int i = 2; i <= 600; i+=4 , x+=1) {
            setLocation(600-((i+x)/2) , 350-(i/2));
            setSize(i + ( 3*x ) , i + ( x/2 ));

            try {
                Thread.sleep(10);
            }
            catch (Exception e){

            }
        }
    }

    // implementing new window after first one ends in 7 sec
    public void run(){
       try {
          Thread.sleep(4000);
          setVisible(false);

          new Login();
       }
       catch (Exception e) {

       }
    }

    public static void main(String[] args) {
        Splash s = new Splash() ;
    }

}
