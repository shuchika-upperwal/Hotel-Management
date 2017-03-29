
package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class employee extends javax.swing.JFrame implements ActionListener {
  JFrame j1;
  JButton bh,brm,brs,bt,bcd,bemp,bk,addemp,rememp,sremp,modemp;
  JTextField t20; 

  int i,j;
  connections c=new connections();

  employee()
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
          employees();
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
        if(e.getSource().equals(addemp))
        {
            addemp ae=new addemp(Integer.parseInt(t20.getText()),"add");
            j1.dispose();
        }
        if(e.getSource().equals(sremp))
        {
            addemp ae=new addemp(Integer.parseInt(t20.getText()),"srch");
            j1.dispose();
        }
        if(e.getSource().equals(modemp))
        {
            addemp ae=new addemp(Integer.parseInt(t20.getText()),"mod");
            j1.dispose();
        }
        if(e.getSource().equals(rememp))
        {
            remove();
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

  bt= new JButton("BILL");
  bt.setBounds (320,680,320,60);
  bt.setFont(f1);

  bcd= new JButton("CUSTOMER DETAILS");
  bcd.setBounds (100, 600, 200, 60);
  bcd.setFont(f1);

 bemp=new JButton("EMPLOYEE DETAILS");
 bemp.setBounds(660,600,200,60);
 bemp.setFont(f1); 

          j1.add(bh);
          j1.add(brm);
          j1.add(brs);
          j1.add(bt);
          j1.add(bcd);
          j1.add(bemp);
      bh.addActionListener(this);
      brm.addActionListener(this);
      brs.addActionListener(this);
      bt.addActionListener(this);
      bcd.addActionListener(this);
      bemp.addActionListener(this);
  }

    void employees()
  {
     Font f1=new Font("papyrus",Font.BOLD,18);

      String a="<html>"+"MODIFY"+"<br>"+"EMPLOYEE DETAILS"+"<html>";

      t20=new JTextField("Enter Employee ID");
      t20.setBounds(350,160,300,50);

      j1.add(t20);

      addemp =new JButton("ADD EMPLOYEE");
      addemp.setBounds(180,260,210,110);
      addemp.setFont(f1);
      j1.add(addemp);
      addemp.addActionListener(this);

      rememp =new JButton("REMOVE EMPLOYEE");
      rememp.setBounds(580,260,210,110);
      rememp.setFont(f1);
      j1.add(rememp);
      rememp.addActionListener(this);


      sremp =new JButton("SEARCH EMPLOYEE");
      sremp.setBounds(180,420,210,110);
      sremp.setFont(f1);
      j1.add(sremp);
      sremp.addActionListener(this);

      modemp =new JButton(a);
      modemp.setBounds(580,420,210,110);
      modemp.setFont(f1);
      j1.add(modemp);
      modemp.addActionListener(this);


  }

    void remove()
    {
        try {
           c.stmt=c.con.prepareCall("delete from employee where ID=?");
           c.stmt.setInt(1, Integer.parseInt(t20.getText()));
         i=c.stmt.executeUpdate();
         if(i>0)
         JOptionPane.showMessageDialog(this, "DELETED Succesfully");
         else
  JOptionPane.showMessageDialog(this, "does not present");
          }

          catch (Exception ee) {
          System.out.println(ee);
      } 
    }

}