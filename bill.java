package hotel.mngmnt;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;



public class bill extends javax.swing.JFrame implements ActionListener {
JFrame j1,j2;
JButton bk,bco,bob,bsrch,bup,bk1;
JTextField t[]=new JTextField[10]; 
int i;
double rp,vat,st,ttl,pk,dys;
connections c=new connections();
bill()
{
   Font f1=new Font("Arial",Font.PLAIN,18);

       bk = new JButton("BACK");
       bk.setBounds(60, 670,200,70);
       bk.setFont(f1);
       j1=new JFrame();
       j1.setLayout(null);
       j1.setSize(1000,800);
       j1.setVisible(true);
       j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
       j1.setResizable(false);
       j1.add(bk);
       bk.addActionListener(this);
       display();
}


public void actionPerformed(ActionEvent e) {
   if (e.getSource().equals(bco))
   {
       display2();
       checkout();
   }

   if(e.getSource().equals(bsrch))
   {
       search();
   }


   if(e.getSource().equals(bob))
   {
       display2();
   }

   if(e.getSource().equals(bup))
   {
       update();
   }

   if(e.getSource().equals(bk))
    {
       HotelMngmnt h=new HotelMngmnt();
        j1.dispose();
    }

   if(e.getSource().equals(bk1))
    {
       bill b=new bill();
        j2.dispose();
    }
}

void display()
{
 Font f1=new Font("Arial",Font.PLAIN,18);
 Font f2=new Font ("papyrus",Font.BOLD,18);

JLabel l1=new JLabel("ROOM No");
  l1.setBounds(50,100,150,60);
 l1.setFont(f1);
    j1.add(l1);


     JLabel l2=new JLabel("CUST_NO");
  l2.setBounds(50,150,150,60);
  l2.setFont(f1);
    j1.add(l2);


 JLabel l3=new JLabel("NAME");
  l3.setBounds(50,200,150,60);
  l3.setFont(f1);
    j1.add(l3);


  JLabel l4=new JLabel("ROOM TYPE");
  l4.setBounds(50,250,150,60);
  l4.setFont(f1);
    j1.add(l4);


  JLabel l5=new JLabel("PACKAGE");
  l5.setBounds(50,300,150,60);
  l5.setFont(f1);
    j1.add(l5);

    JLabel l6=new JLabel("CHECK IN");
  l6.setBounds(50,350,150,60);
  l6.setFont(f1);
    j1.add(l6);


 JLabel  l7=new JLabel("CHECK OUT");
  l7.setBounds(50,400,150,60);
  l7.setFont(f1);
    j1.add(l7);

    JLabel l8=new JLabel("SECURITY");
  l8.setBounds(50,450,150,60);
  l8.setFont(f1);
    j1.add(l8);


 JLabel  l9=new JLabel("EXTRA CHARGE");
  l9.setBounds(50,500,150,60);
  l9.setFont(f1);
    j1.add(l9);

    for(i=1;i<=9;i++)
    {
        t[i]=new JTextField();
        t[i].setBounds(230,60+(i*50),150,40);
        j1.add(t[i]);
    }
    bco= new JButton("CHECK OUT");
    bco.setBounds(450,600,180,70);
    bco.setFont(f2);
    j1.add(bco);
    bco.addActionListener(this);

    bob= new JButton("ONLY BILL");
    bob.setBounds(720,600,180,70);
    bob.setFont(f2);
    j1.add(bob);
    bob.addActionListener(this);

     bsrch= new JButton("SEARCH");
    bsrch.setBounds(580,450,250,100);
    bsrch.setFont(f1);
    j1.add(bsrch);
    bsrch.addActionListener(this);

}



void search()
{
  if(t[1].getText().equals(""))
  JOptionPane.showMessageDialog(this, "ENTER ROOM NUMBER");
  else
  try{
      i=0;
 c.stmt = c.con.prepareCall("Select * from customer where RNO=?");
     c.stmt.setString(1,t[1].getText());
     c.rs = c.stmt.executeQuery();
     while (c.rs.next()){
             t[1].setText(c.rs.getString(9));
             t[2].setText(c.rs.getString(1));
             t[3].setText(c.rs.getString(2));
             t[4].setText(c.rs.getString(10));
             t[5].setText(c.rs.getString(11));
             t[6].setText(c.rs.getString(14));
             t[7].setText(c.rs.getString(15));
             t[8].setText(c.rs.getString(16));
             t[9].setText(c.rs.getString(17));
             i=1;
     }
     if(i==0)
     {
         JOptionPane.showMessageDialog(this, "NOT FOUND");
     }

 } catch (Exception ee) {
     System.out.println(ee);
 } 
}


void update()
{
    try {
          c.stmt=c.con.prepareCall("update customer set CUST_NO=?,NAME=?,RNO=?,RTYPE=?,PAKAGE=?,CIN=?,COUT=?,SECURITY=?,RMSERVICE=? where RNO=?");
          c.stmt.setString(1, t[2].getText());
          c.stmt.setString(2, t[3].getText());
          c.stmt.setString(3, t[1].getText());
          c.stmt.setString(4, t[4].getText());
          c.stmt.setString(5, t[5].getText());
          c.stmt.setString(6, t[6].getText());
          c.stmt.setString(7, t[7].getText());
          c.stmt.setString(8, t[8].getText());
          c.stmt.setString(9, t[9].getText());
          c.stmt.setString(10, t[1].getText());
        i=c.stmt.executeUpdate();
        if(i>0)
       JOptionPane.showMessageDialog(this, "Updated Success");
         }

         catch (Exception ee) {
         System.out.println(ee);
     } 
}

void display2()
{
  Font f1=new Font("Arial",Font.PLAIN,18);

       j2=new JFrame();
       j2.setLayout(null);
       j2.setSize(1000,800);
       j2.setVisible(true);
       j2.setDefaultCloseOperation(EXIT_ON_CLOSE);
       j2.setResizable(false);
       j1.dispose();
       bk1 = new JButton("BACK");
       bk1.setBounds(740, 650,180,70);
       bk1.setFont(f1);
       j2.add(bk1);
       bk1.addActionListener(this);

  JLabel l2,l1,l3,l4,l5,l6,l7,l8,l9,l10,l[]=new JLabel[11];
      l1=new JLabel("NAME");
 l1.setBounds(50,100,150,60);
 l1.setFont(f1);
   j2.add(l1);


 l2=new JLabel("PACKAGE");
 l2.setBounds(50,160,150,60);
  l2.setFont(f1);
   j2.add(l2);

   l3=new JLabel("CHECK IN");
 l3.setBounds(50,220,150,60);
  l3.setFont(f1);
   j2.add(l3);


 l4=new JLabel("CHECK OUT");
 l4.setBounds(50,280,150,60);
  l4.setFont(f1);
   j2.add(l4);

   l5=new JLabel("ROOM PRICE");
 l5.setBounds(50,340,150,60);
  l5.setFont(f1);
   j2.add(l5);

   l6=new JLabel("SECURITY");
 l6.setBounds(50,400,150,60);
  l6.setFont(f1);
   j2.add(l6);

 l7=new JLabel("EXTRA CHARGE");
 l7.setBounds(50,460,150,60);
  l7.setFont(f1);
   j2.add(l7);

 l8=new JLabel("VAT");
 l8.setBounds(50,520,150,60);
  l8.setFont(f1);
   j2.add(l8);

 l9=new JLabel("SERVICE TAX");
 l9.setBounds(50,580,150,60);
  l9.setFont(f1);
   j2.add(l9);

   l10=new JLabel("TOTAL AMOUNT");
 l10.setBounds(50,640,150,60);
  l10.setFont(f1);
   j2.add(l10);




   for(i=1;i<11;i++)
   {
       l[i]=new JLabel();
       l[i].setBounds(250,40+(i*60),150,60);
       l[i].setFont(f1);
       j2.add(l[i]);
   }
       //l[10]=new JLabel();
       //l[10].setBounds(560,600,150,50);
       //j2.add(l[10]);
   l[1].setText(t[3].getText());
   l[2].setText(t[5].getText());
   l[3].setText(t[6].getText());
   l[4].setText(t[7].getText());
   l[6].setText(t[8].getText());
   l[7].setText(t[9].getText());
   price();
   l[5].setText(String.valueOf(rp));
   l[8].setText(String.valueOf(vat));
   l[9].setText(String.valueOf(st));
   ttl=ttl+Float.parseFloat(l[7].getText())-Float.parseFloat(l[6].getText());
   l[10].setText(String.valueOf(ttl));
}

void checkout()
{
    try{
    c.stmt=c.con.prepareCall("delete from customer where RNO=?");
        c.stmt.setString(1, t[1].getText());
        c.stmt.executeUpdate();

        c.stmt=c.con.prepareCall("update Rooms set STATUS=? where ROOM_NO=?");
        c.stmt.setString(1,"FREE");
        c.stmt.setInt(2,Integer.parseInt(t[1].getText()));
        c.stmt.executeUpdate();
    }
    catch(Exception ee){System.out.println(ee);}
}


void price()
{
    try{
   c.stmt = c.con.prepareCall("Select * from Prices where ROOM_TYPE=?");
       c.stmt.setString(1 , t[4].getText());
       c.rs = c.stmt.executeQuery();
       while (c.rs.next()){
               rp=Float.parseFloat(c.rs.getString(2));
       }
   } catch (Exception ee) {System.out.println(ee);} 
    dys=Float.parseFloat(t[7].getText().substring(0, 2))-Float.parseFloat(t[6].getText().substring(0, 2));
    rp=rp*dys;
    pk=Double.parseDouble(t[5].getText());
    rp=rp-(rp*pk/100);
    vat=rp*0.125;
    st=rp*0.0663;
    ttl=rp+vat+st;
}


}