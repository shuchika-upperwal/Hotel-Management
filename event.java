
package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class event extends javax.swing.JFrame implements ActionListener {
   JFrame j1;
   JTextField t1,t2;
   JButton bh,brm,brs,bbl,bcd,bemp,bk,bevnt,bd1,bd2,bp1,bp2,bbk1,bbk2;
   String s[]={"select  Type","Type A","Type B","Type C"};
   String s1[]={"select Type","Type A","Type B","Type C","Type D","Type E"};
   JTextField t3,t4;
   JComboBox cb1,cb2;
   int i;
   connections c=new connections();


   event()
   {
       c.connect();
        Font f3=new Font("Arial",Font.PLAIN,22);
       bk = new JButton("BACK");
           bk.setBounds(760, 690, 200, 70);
           bk.setFont(f3);
           
           cb1=new JComboBox(s1);
       cb1.setBounds(230,240,200,80);
      
       
       cb2=new JComboBox(s);
       cb2.setBounds(630,240,200,80);
           
           j1=new JFrame();
           display();
           j1.setLayout(null);
           j1.setSize(1000,800);
           j1.setVisible(true);
           j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
           j1.setResizable(false);
           
           j1.setTitle("EVENTS");
   }
 public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bh))
       {
           this.dispose();
           HotelMngmnt h=new HotelMngmnt();
       }

        if (e.getSource().equals(brm))
       {
            rooms r=new rooms();
            this.dispose();
       }

       if(e.getSource().equals(brs))
       {
            reservation rev=new reservation();
            this.dispose();
       }

        if (e.getSource().equals(bbl))
       {
           bill b=new bill();
           this.dispose();
       }

       if (e.getSource().equals(bemp))
       {
           employee emp=new employee();
           this.dispose();
       }

       if (e.getSource().equals(bcd))
       {
           customer c=new customer();
           this.dispose();
       }

        if(e.getSource().equals(bk))
        {
           HotelMngmnt h=new HotelMngmnt();
            j1.dispose();
        }

        if(e.getSource().equals(cb1))
        {
           i=1;
        }
        if(e.getSource().equals(cb2))
        {
           i=2;
        }
        
        if(e.getSource().equals(bd1))
        {
           date d=new date("GATHERING","Type A");
           d.booking();
        }
        if(e.getSource().equals(bd2))
        {
            date d2=new date("MEETING","Type A");
        }
  
        
      if (e.getSource().equals(bbk1))
       {
           insert("GATHERING");
       }
      if (e.getSource().equals(bbk2))
       {
           insert("MEETING");
       }
  
        
 }

  void display()
   {
        Font f1=new Font("Arial",Font.PLAIN,18);
        Font f2=new Font("PAPYRUS", Font.BOLD,22);
        
       JLabel l1,l2;
     
       j1.add(cb1);
       cb1.addActionListener(this);

       
       j1.add(cb2);
       cb2.addActionListener(this);
       
       
       
       bh= new JButton("HOME");
   bh.setBounds (100, 30, 200, 60);
   bh.setFont(f1);

  brm= new JButton("ROOMS");
  brm.setBounds (380, 30, 200, 60);
  brm.setFont(f1);
  
   brs= new JButton("RESERVATION");
    brs.setBounds (660, 30, 200, 60);
    brs.setFont(f1);

  
  
           j1.add(bh);
           j1.add(brm);
           j1.add(brs);
           j1.add(bk);
           
       bh.addActionListener(this);
       brm.addActionListener(this);
       brs.addActionListener(this);
       bk.addActionListener(this);

       l1= new JLabel("GATHERING  HALL");
       l1.setBounds (230, 200, 200, 60);
       l1.setFont(f2);
       j1.add(l1);

       l2= new JLabel("MEETING  HALL");
       l2.setBounds (630, 200, 180, 60);
       l2.setFont(f2);
       j1.add(l2);
       
        bp1= new JButton("PRICE");
        bp1.setBounds (190, 400, 120, 40);
        bp1.setFont(f1);
       j1.add(bp1);
        
      
      t1=new JTextField("");
        t1.setBounds(340,403,140,40);
        j1.add(t1);
        
        bp2= new JButton("PRICE");
        bp2.setBounds (600, 400, 120, 40);
        bp2.setFont(f1);
       j1.add(bp2);
      
        t2=new JTextField("");
        t2.setBounds(750,403,140,40);
        j1.add(t2);
        
        bd1= new JButton("DATE");
   bd1.setBounds (190, 480, 120, 40);
   bd1.setFont(f1);
   j1.add(bd1);
   bd1.addActionListener(this);
   
   
   t3=new JTextField("");
        t3.setBounds(340,480,140,40);
        j1.add(t3);
        
        
    bd2= new JButton("DATE");
   bd2.setBounds (600, 480, 120, 40);
   bd2.setFont(f1);
   j1.add(bd2);
   bd2.addActionListener(this);
   
   t4=new JTextField("");
        t4.setBounds(750,480,140,40);
        j1.add(t4);
        
   
   bbk1= new JButton("BOOK");
   bbk1.setBounds (190, 550, 120, 40);
   bbk1.setFont(f1);
   j1.add(bbk1);
   bbk1.addActionListener(this);
   
   
   bbk2= new JButton("BOOK");
   bbk2.setBounds (600, 550, 120, 40);
   bbk2.setFont(f1);
   j1.add(bbk2);
   bbk2.addActionListener(this);

   
        
   }
  
  void insert(String s)
  {
      
 if(String.valueOf(cb1.getSelectedItem()).equals("select Type")||t1.getText().equals("")||t3.getText().equals(""))
    JOptionPane.showMessageDialog(this, "Insert all the Fields");
 else{
            try{
          c.stmt=c.con.prepareCall("insert into Events values(?,?,?,?)");
          
           c.stmt.setString(1,s);
           
          c.stmt.setString(2, String.valueOf(cb1.getSelectedItem()));
           
           c.stmt.setString(3, t1.getText());
           
            c.stmt.setString(4, t3.getText());
            
            c.stmt.executeUpdate();
                    
      }
      catch(Exception ee){System.out.println(ee);
  }
  }
  }
      
  public static void main(String args[]){
      event e=new event();
}
}