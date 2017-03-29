package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class date extends javax.swing.JFrame implements ActionListener {
    JFrame j1;
    int i;
    connections c=new connections();
    String a,b;
    
    date(String s, String s1)
    {
        a=s;
        b=s1;
           j1=new JFrame();
           j1.setLayout(null);
           j1.setSize(350,250);
           j1.setVisible(true);
           j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
           j1.setResizable(false);
           j1.setTitle("BOOKINGS");
       
}
    public void actionPerformed(ActionEvent e){
        
    }
    
    void booking()
    {
        i=0;
        String date[]=new String[10];
         try{
    c.stmt=c.con.prepareCall("select * from Events where TYPE=? and CAPACITY=?");
    c.stmt.setString(1,a);
    c.stmt.setString(2,b);
    c.rs=c.stmt.executeQuery();
    while(c.rs.next())
    {
        date[i]=c.rs.getString(3);
        System.out.println(date[i]);
        i++;
        
    }
    
    }
           catch(Exception ee){System.out.println(ee);
           }
    
    }

}