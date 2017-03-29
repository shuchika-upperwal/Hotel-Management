
package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


public class rooms extends javax.swing.JFrame implements ActionListener {
 JFrame j1;
 JButton bh,brm,brs,bbl,bcd,bemp,bk,badd,brem,bup;
 JRadioButton rb[]=new JRadioButton[8];
 JTextField t1,t2,t3; 
 float p=0;
 int i;
 String t=null;
 ButtonGroup jb;
 connections c=new connections();


 rooms()
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
         room();
 }


  public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(bh))
     {
         j1.dispose();
         HotelMngmnt h=new HotelMngmnt();
     }

     if (e.getSource().equals(brm))
     {
         j1.dispose();
          rooms r=new rooms();
          this.dispose();
     }

     if(e.getSource().equals(brs))
     {
         j1.dispose();
          reservation rev=new reservation();
          this.dispose();
     }

      if (e.getSource().equals(bbl))
     {
         j1.dispose();
         bill b=new bill();
         this.dispose();
     }

     if (e.getSource().equals(bemp))
     {
         j1.dispose();
         employee emp=new employee();
         this.dispose();
     }

     if (e.getSource().equals(bcd))
     {
         j1.dispose();
         customer c=new customer();
         this.dispose();
     }

      if(e.getSource().equals(bk))
      {
          j1.dispose();
         HotelMngmnt h=new HotelMngmnt();
      }
      if (e.getSource().equals(badd))
     {
         for(i=0;i<8;i++)
         {
           if (rb[i].isSelected()){
           t=rb[i].getText();
           price();
         }}
       addroom();  
     }
     if (e.getSource().equals(brem))
     {
       removeroom();  
     }

     if (e.getSource().equals(bup))
     {
         for(i=0;i<8;i++)
         {
           if (rb[i].isSelected())
            t=rb[i].getText();
         }
       modifyroom();  
     }


  }     

  public void display()
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

  void room()
 {


     String s[]={"PREMIER","DELUX","SUPER DELUX","RESIDENCE","HONEYMOON","LUXURY","SUPERIOR","AMBASSADOR"};
   
   jb=new ButtonGroup();
   for(i=0;i<8;i++)
   {
       rb[i]=new JRadioButton(s[i]);
       rb[i].setBounds(50,100+(i*60),200,60);
       j1.add(rb[i]);
       jb.add(rb[i]);
   }

     badd=new JButton("ADD ROOM");
     badd.setBounds(500,200,200,60);
     j1.add(badd);
     badd.addActionListener(this);

   brem=new JButton("REMOVE ROOM");
     brem.setBounds(500,300,200,60);
     j1.add(brem);
     brem.addActionListener(this);

     bup=new JButton("UPDATE PRICE");
     bup.setBounds(500,400,200,60);
     j1.add(bup);
     bup.addActionListener(this);

   t1= new JTextField("Type Room No");
   t1.setBounds(720,200,180,60);
   j1.add(t1);

   t2= new JTextField("Type Room No");
   t2.setBounds(720,300,180,60);
   j1.add(t2);

     t3= new JTextField("New Price");
   t3.setBounds(720,400,180,60);
   j1.add(t3);

 }

  void addroom()
  {
      int count=0;
      if(t==null)
      {
          JOptionPane.showMessageDialog(this, "please select catagory");
      }
      else
       try {
           c.stmt=c.con.prepareCall("select * from Rooms where ROOM_NO=?");
          c.stmt.setInt(1,Integer.parseInt(t1.getText()) );
         c.rs=c.stmt.executeQuery();
          while(c.rs.next())
         {
          count++;
  }
          if(count==0){
          c.stmt=c.con.prepareCall("insert into Rooms values(?,?,?,?)");
          c.stmt.setInt(1, Integer.parseInt(t1.getText()));
          c.stmt.setString(2, t);
          c.stmt.setFloat(3, p);
          c.stmt.setString(4, "FREE");
          i=c.stmt.executeUpdate();
          if(i>0)
          JOptionPane.showMessageDialog(this, "Inserted Succesfully");
          else
 JOptionPane.showMessageDialog(this, "try again");
         }
          else
         JOptionPane.showMessageDialog(this, "Already Exist");
       }
         catch (Exception ee) {
         System.out.println(ee);
     } 
  }

  void removeroom()
  {
       try {
          c.stmt=c.con.prepareCall("delete from Rooms where ROOM_NO=?");
          c.stmt.setInt(1, Integer.parseInt(t2.getText()));
        i=c.stmt.executeUpdate();
        if(i>0)
        JOptionPane.showMessageDialog(this, "DELETED Succesfully");
        else
 JOptionPane.showMessageDialog(this, "Does not Exist");
         }
         catch (Exception ee) {
         System.out.println(ee);
     } 
  }


  void modifyroom()
  {
      if(t==null)
      {
          JOptionPane.showMessageDialog(this, "please select catagory");
      }
      else
       try {
          c.stmt=c.con.prepareCall("update Prices set PRICE=? where ROOM_TYPE=?");
          c.stmt.setFloat(1, Float.parseFloat(t3.getText()));
          c.stmt.setString(2, t);
          c.stmt.executeUpdate();
          c.stmt=c.con.prepareCall("update Rooms set PRICE=? where TYPE=?");
          c.stmt.setFloat(1, Float.parseFloat(t3.getText()));
          c.stmt.setString(2, t);
        i=c.stmt.executeUpdate();
        if(i>0)
       JOptionPane.showMessageDialog(this, "Updated Successfully");
         }

         catch (Exception ee) {
         System.out.println(ee);
     } 
  }


  void price()
  {
      try{
    c.stmt=c.con.prepareCall("select * from Prices where ROOM_TYPE=?");
    c.stmt.setString(1, t);
         c.rs=c.stmt.executeQuery();
          while(c.rs.next())
         {
          p=c.rs.getFloat(2);
  }
      }
      catch(Exception ee){System.out.println(ee);}
}
}