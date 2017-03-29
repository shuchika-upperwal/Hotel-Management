
package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class reservation extends javax.swing.JFrame implements ActionListener {
 JFrame j1;
 JButton bh,brm,brs,bbl,bcd,bemp,bk,balot;
 JRadioButton rb[]=new JRadioButton[8];
 JLabel l3,l4;
 int i; 
 String t=null;
 ButtonGroup jb;
 connections c=new connections();

 reservation()
 {
      bk = new JButton("BACK");
         bk.setBounds(10, 650, 690, 50);
         j1=new JFrame();
         j1.setLayout(null);
         j1.setSize(1000,800);
         j1.setVisible(true);
         j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
         j1.setResizable(false);
         display();
         reservations();

 }


  public void actionPerformed(ActionEvent e) {
      for(i=0;i<8;i++)
         {
           if (rb[i].isSelected())
           {
               t=rb[i].getText();
               vacancy();
           }
         }

      if (e.getSource().equals(bh))
     {
         j1.dispose();
         HotelMngmnt h=new HotelMngmnt();
     }

     if (e.getSource().equals(brm))
     {
         j1.dispose();
          rooms r=new rooms();
     }

     if(e.getSource().equals(brs))
     {
          j1.dispose();
          reservation rev=new reservation();
     }

      if (e.getSource().equals(bbl))
     {
         bill b=new bill();
     }

     if (e.getSource().equals(bemp))
     {
         j1.dispose();
         employee emp=new employee();
     }

     if (e.getSource().equals(bcd))
     {
         j1.dispose();
         customer c=new customer();
     }

      if(e.getSource().equals(bk))
      {
          j1.dispose();
         HotelMngmnt h=new HotelMngmnt();
      }
      if(e.getSource().equals(balot))
      {
          if(t==null)
          JOptionPane.showMessageDialog(this, "please select catagory");
          else
              if(Integer.parseInt(l3.getText())==0)
              JOptionPane.showMessageDialog(this, "please select another catagory");
          else
          {
         allot al=new allot(t);
          j1.dispose();}
      }
  }


  void display()
 {
     Font f1=new Font("Arial",Font.PLAIN,18);

     bh= new JButton("HOME");
 bh.setBounds (100, 30, 200, 60);
 bh.setFont(f1);

brm= new JButton("ROOMS");
brm.setBounds (380, 30, 200, 60);
 brm.setFont(f1);

 brs= new JButton("RESERVATION");
  brs.setBounds (660, 30, 200, 60);
   brs.setFont(f1);

 bbl= new JButton("BILL");
 bbl.setBounds (320,680,320,60);
  bbl.setFont(f1);

 bcd= new JButton("CUSTOMER DETAILS");
 bcd.setBounds (100, 600, 200, 60);
  bcd.setFont(f1);


bemp=new JButton("EMPLOYEE DETAILS");
bemp.setBounds(660,600,200,60);
bemp.setFont(f1);

          j1.add(bh);
         j1.add(brm);
         j1.add(brs);
         j1.add(bbl);
         j1.add(bcd);
         j1.add(bemp);
     bh.addActionListener(this);
     brm.addActionListener(this);
     brs.addActionListener(this);
     bbl.addActionListener(this);
     bcd.addActionListener(this);
     bemp.addActionListener(this);
 }

  void reservations()
 {
      String s[]={"PREMIER","DELUX","SUPER DELUX","RESIDENCE","HONEYMOON","LUXURY","SUPERIOR","AMBASSADOR"};
   JLabel l1,l2;
   jb=new ButtonGroup();
   for(i=0;i<8;i++)
   {
       rb[i]=new JRadioButton(s[i]);
       rb[i].setBounds(50,100+(i*60),200,60);
       j1.add(rb[i]);
       jb.add(rb[i]);
       rb[i].addActionListener(this);
   }

   balot=new JButton("ROOM ALLOTMENT");
     balot.setBounds(650,400,270,110);
     j1.add(balot);
     balot.addActionListener(this);


   l1=new JLabel("ROOMS VACANT:");
   l1.setBounds(650,200,150,60);
   j1.add(l1);
    l2=new JLabel("ROOMS BOOKED:");
   l2.setBounds(650,300,150,60);
   j1.add(l2);
   l3=new JLabel("");
   l3.setBounds(850,200,150,60);
   j1.add(l3);
   l4=new JLabel("");
   l4.setBounds(850,300,150,60);
   j1.add(l4);
 }

  void vacancy()
  {
      int n=0,b=0,v=0;
      try{
          c.stmt=c.con.prepareCall("select count(*) from Rooms where TYPE=? and STATUS=?");
          c.stmt.setString(1, t);
          c.stmt.setString(2, "FREE");
          c.rs=c.stmt.executeQuery();
         while(c.rs.next())
         v=c.rs.getInt("count(*)");

         c.stmt=c.con.prepareCall("select count(*) from Rooms where TYPE=?");
         c.stmt.setString(1, t);
         c.rs=c.stmt.executeQuery();
         while(c.rs.next())
         n=c.rs.getInt("count(*)");  
      }
      catch(Exception ee){System.out.println(ee);}
      b=n-v;
      l3.setText(String.valueOf(v));
      l4.setText(String.valueOf(b));
  }
}