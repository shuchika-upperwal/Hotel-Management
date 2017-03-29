package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class addemp extends javax.swing.JFrame implements ActionListener {
  JFrame j1;
  JButton bk,badd,bmod;
  JTextField t20,t21,t22,t23,t24,t25,t26,t27,t28; 
  String s;
  int i;
  int id;
 connections c=new connections();

  addemp(int f, String u)
  {
      Font f1= new Font("Arial",Font.PLAIN,18);
       s=u;
           id=f;
          bk = new JButton("BACK");
          bk.setBounds(720, 660, 200, 80);
          bk.setFont(f1);
          j1=new JFrame();
          j1.setLayout(null);
          j1.setSize(1000,800);
          j1.setVisible(true);
          j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
          j1.setResizable(false);
          j1.add(bk);
          bk.addActionListener(this);
          update();
  }


   public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(bk))
       {
          employee emp=new employee();
           j1.dispose();
       }
       if(e.getSource().equals(badd))
       {
          addemp();  
       }
       if(e.getSource().equals(bmod))
       {
          modemp();
       }
   }


   void update()
   {
       Font f2= new Font("papyrus",Font.BOLD,18);
       
       if(s.equals("add")){
           details();
           badd=new JButton("ADD");
           badd.setBounds(220,550,230,80);
           badd.setFont(f2);
           j1.add(badd);
           badd.addActionListener(this);
       }
       if(s.equals("mod")){
           details();
           search_employee();
           bmod=new JButton("MODIFY");
           bmod.setBounds(220,550,230,80);
           bmod.setFont(f2);
           j1.add(bmod);
           bmod.addActionListener(this);
       }
       if(s.equals("srch")){
           details();
           search_employee();  
           }
   }


   void details()
  {
        JLabel l19=new JLabel("EID");
    l19.setBounds(100,50,100,40);
      j1.add(l19); 

        JLabel l20=new JLabel("Emp Name");
    l20.setBounds(100,100,100,40);
      j1.add(l20); 

       JLabel l21=new JLabel("Gender");
    l21.setBounds(100,150,100,40);
      j1.add(l21); 

        JLabel l22=new JLabel("Contact No");
    l22.setBounds(100,200,100,40);
      j1.add(l22); 

      JLabel l23=new JLabel("Email");
    l23.setBounds(100,250,100,40);
      j1.add(l23); 

        JLabel l24=new JLabel("Address");
    l24.setBounds(100,300,100,40);
      j1.add(l24); 

        JLabel l25=new JLabel("Department");
    l25.setBounds(100,350,100,40);
      j1.add(l25); 

        JLabel l26=new JLabel("Length Of Service");
    l26.setBounds(100,400,120,40);
      j1.add(l26); 

        JLabel l27=new JLabel("Salary");
    l27.setBounds(100,450,100,40);
      j1.add(l27); 

       t20=new JTextField("");
      t20.setBounds(250,45,150,30);
      j1.add(t20);

       t21=new JTextField("");
      t21.setBounds(250,95,150,30);
      j1.add(t21);

        t22=new JTextField("");
      t22.setBounds(250,145,150,30);
      j1.add(t22);

        t23=new JTextField("");
      t23.setBounds(250,195,150,30);
      j1.add(t23);

        t24=new JTextField("");
      t24.setBounds(250,245,150,30);
      j1.add(t24);

        t25=new JTextField("");
      t25.setBounds(250,295,150,30);
      j1.add(t25);

        t26=new JTextField("");
      t26.setBounds(250,345,150,30);
      j1.add(t26);

        t27=new JTextField("");
      t27.setBounds(250,395,150,30);
      j1.add(t27);

        t28=new JTextField("");
      t28.setBounds(250,445,150,30);
      j1.add(t28);
  }


   void addemp()
   {
     try{
       c.stmt=c.con.prepareCall("insert into employee values(?,?,?,?,?,?,?,?,?)");
        c.stmt.setInt(1, Integer.parseInt(t20.getText()));
        c.stmt.setString(2, t21.getText());
        c.stmt.setString(3, t22.getText());
        c.stmt.setFloat(4, Float.parseFloat(t23.getText()));
        c.stmt.setString(5, t24.getText());
        c.stmt.setString(6, t25.getText());
        c.stmt.setString(7, t26.getText());
        c.stmt.setString(8, t27.getText());
        c.stmt.setInt(9, Integer.parseInt(t28.getText()));
        i=c.stmt.executeUpdate();
        System.out.println(i);
        if(i>0)
        JOptionPane.showMessageDialog(this, "Inserted Success");
       }
       catch(Exception ee){System.out.println(ee);
       JOptionPane.showMessageDialog(this, "try again");
       }  
   }

   void search_employee()
   {
       try{
           c.stmt=c.con.prepareCall("select * from employee where ID=?");
           c.stmt.setInt(1, id);
           c.rs = c.stmt.executeQuery();
           while(c.rs.next())
           {
                  t20.setText(String.valueOf(c.rs.getInt(1)));
                  t21.setText(c.rs.getString(2));
                  t22.setText(c.rs.getString(3));
                  t23.setText(String.valueOf(c.rs.getFloat(4)));
                  t24.setText(c.rs.getString(5));
                  t25.setText(c.rs.getString(6));
                  t26.setText(c.rs.getString(7));
                  t27.setText(c.rs.getString(8));
                  t28.setText(String.valueOf(c.rs.getInt(9)));
           }
       }
       catch(Exception ee){System.out.println(ee);}
       }

   void modemp()
   {
       try{
       c.stmt=c.con.prepareCall("update employee set ID=?,NAME=?,GENDER=?,CONTACT_NO=?,EMAIL=?,ADDRESS=?,DEPT=?,L_O_S=?,SALARY=?");
        c.stmt.setInt(1, Integer.parseInt(t20.getText()));
        c.stmt.setString(2, t21.getText());
        c.stmt.setString(3, t22.getText());
        c.stmt.setFloat(4, Float.parseFloat(t23.getText()));
        c.stmt.setString(5, t24.getText());
        c.stmt.setString(6, t25.getText());
        c.stmt.setString(7, t26.getText());
        c.stmt.setString(8, t27.getText());
        c.stmt.setInt(9, Integer.parseInt(t28.getText()));
        i=c.stmt.executeUpdate();
        System.out.println(i);
        if(i>0)
        JOptionPane.showMessageDialog(this, "MODIFIED");
       }
       catch(Exception ee){System.out.println(ee);
       JOptionPane.showMessageDialog(this, "error");
       }   
   }
   }