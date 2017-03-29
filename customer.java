package hotel.mngmnt;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class customer extends javax.swing.JFrame implements ActionListener {
JFrame j1;
JButton bk,bsr,bup;
JTextField t,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20; 
JRadioButton rb[]=new JRadioButton[4];
int i,j;
String s=null;
ButtonGroup jb;
connections c=new connections();

customer()
{

   Font f1=new Font("Arial",Font.PLAIN,18);

    bk = new JButton("BACK");
       bk.setBounds(760, 690, 200, 70);
       bk.setFont(f1);

       j1=new JFrame();
       j1.setLayout(null);
       j1.setSize(1000,800);
       j1.setVisible(true);
       j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
       j1.setResizable(false);
       j1.add(bk);
       bk.addActionListener(this);
       room_allotment();

}


public void actionPerformed(ActionEvent e) {
    for(i=0;i<4;i++)
       {
         if (rb[i].isSelected())
         {
             s=rb[i].getText();
         }
       }

    if(e.getSource().equals(bk))
    {
       HotelMngmnt h=new HotelMngmnt();
        j1.dispose();
    }
    if(e.getSource().equals(bsr))
    {
       search();
    }

    if(e.getSource().equals(bup))
    {
       update();
    }
}
void room_allotment()
{


    JLabel l1=new JLabel("CUSTOMER INFORMATION");
   l1.setBounds(80,10,200,80);
   j1.add(l1);


  JLabel l2=new JLabel("CUST_No");
 l2.setBounds(50,110,100,60);
   j1.add(l2);


JLabel l3=new JLabel("NAME");
 l3.setBounds(50,160,100,60);
   j1.add(l3);


 JLabel l4=new JLabel("ADDRESS");
 l4.setBounds(50,210,100,60);
   j1.add(l4);


 JLabel l5=new JLabel("COUNTRY");
 l5.setBounds(50,260,100,60);
   j1.add(l5);


JLabel l6=new JLabel("CONTACT NO");
 l6.setBounds(50,310,100,60);
   j1.add(l6);


 JLabel l7=new JLabel("EMAIL");
 l7.setBounds(50,360,100,60);
   j1.add(l7);



 JLabel l8=new JLabel("PROOF");
 l8.setBounds(50,410,100,60);
   j1.add(l8);


 JLabel l9=new JLabel("ID No");
 l9.setBounds(50,460,100,60);
   j1.add(l9);

 JLabel l10=new JLabel("ROOM No");
 l10.setBounds(550,110,100,60);
   j1.add(l10);

 JLabel l11=new JLabel("ROOM TYPE");
 l11.setBounds(550,160,100,60);
   j1.add(l11);

 JLabel l12=new JLabel("PACKAGE");
 l12.setBounds(550,210,100,60);
   j1.add(l12);

 JLabel l13=new JLabel("ADULTS");
 l13.setBounds(550,260,100,60);
   j1.add(l13);

 JLabel l14=new JLabel("KIDS ");
 l14.setBounds(550,310,100,60);
   j1.add(l14);

 JLabel l15=new JLabel("CHECK IN");
 l15.setBounds(550,360,100,60);
   j1.add(l15);

JLabel  l16=new JLabel("CHECK OUT");
 l16.setBounds(550,410,100,60);
   j1.add(l16);

   JLabel  l17=new JLabel("EXTRA CHARGE");
 l17.setBounds(550,460,120,60);
   j1.add(l17);

   JLabel  l18=new JLabel("SECURITY");
 l18.setBounds(50,510,100,60);
   j1.add(l18);


   t4=new JTextField("");
   t4.setBounds(150,120,160,30);
   j1.add(t4);


   t5=new JTextField("");
   t5.setBounds(150,170,160,30);
   j1.add(t5);


  t6=new JTextField("");
   t6.setBounds(150,220,160,30);
   j1.add(t6);


  t7=new JTextField("");
   t7.setBounds(150,270,160,30);
   j1.add(t7);


    t8=new JTextField("");
   t8.setBounds(150,320,160,30);
   j1.add(t8);


    t9=new JTextField("");
   t9.setBounds(150,370,160,30);
   j1.add(t9);


    t10=new JTextField("");
   t10.setBounds(150,420,160,30);
   j1.add(t10);


    t11=new JTextField("");
   t11.setBounds(150,470,160,30);
   j1.add(t11);



    t12=new JTextField("");
   t12.setBounds(660,120,160,30);
   j1.add(t12);


    t13=new JTextField("");
   t13.setBounds(660,170,160,30);
   j1.add(t13);


    t14=new JTextField("");
   t14.setBounds(660,220,160,30);
   j1.add(t14);


    t15=new JTextField("");
   t15.setBounds(660,270,160,30);
   j1.add(t15);


    t16=new JTextField("");
   t16.setBounds(660,320,160,30);
   j1.add(t16);


    t17=new JTextField("");
   t17.setBounds(660,370,160,30);
   j1.add(t17);


    t18=new JTextField("");
   t18.setBounds(660,420,160,30);
   j1.add(t18);

   t19=new JTextField("");
   t19.setBounds(150,520,160,30);
   j1.add(t19);

   t20=new JTextField("");
   t20.setBounds(660,470,160,30);
   j1.add(t20);


   jb= new ButtonGroup();
    String s1[]={"CUST_NO","NAME","RNO","ID_NO"};

 JLabel l19=new JLabel(" SEARCH :");
 l19.setBounds(100,580,80,40);
   j1.add(l19);


   t=new JTextField("");
   t.setBounds(200,590,160,40);
   j1.add(t);

   bsr=new JButton("GO ");
   bsr.setBounds(400,590,70,40);
   j1.add(bsr);
   bsr.addActionListener(this);

   bup=new JButton("UPDATE");
   bup.setBounds(500,590,120,40);
   j1.add(bup);
   bup.addActionListener(this);


 JLabel l20=new JLabel(" By :");
 l20.setBounds(100,635,40,30);
   j1.add(l20); 

   for(i=0;i<4;i++)
   {
   rb[i]= new JRadioButton(s1[i]);
   rb[i].setBounds(150+(i*200),630,160,50);
   j1.add(rb[i]);
   jb.add(rb[i]);
   rb[i].addActionListener(this);
   }
}


void search()
{
    if(s==null)
JOptionPane.showMessageDialog(this, "select choice");
    else
    if(t.getText().equals(""))
JOptionPane.showMessageDialog(this, "enter customer "+s);
    else
    try{
   c.stmt = c.con.prepareCall("Select * from customer where "+s+"=?");
       c.stmt.setString(1,t.getText());
       c.rs = c.stmt.executeQuery();
       while (c.rs.next()){
               t4.setText(c.rs.getString(1));
               t5.setText(c.rs.getString(2));
               t6.setText(c.rs.getString(3));
               t7.setText(c.rs.getString(4));
               t8.setText(c.rs.getString(5));
               t9.setText(c.rs.getString(6));
               t10.setText(c.rs.getString(7));
               t11.setText(c.rs.getString(8));
               t12.setText(c.rs.getString(9));
               t13.setText(c.rs.getString(10));
               t14.setText(c.rs.getString(11));
               t15.setText(c.rs.getString(12));
               t16.setText(c.rs.getString(13));
               t17.setText(c.rs.getString(14));
               t18.setText(c.rs.getString(15));
                t19.setText(c.rs.getString(16));
                 t20.setText(c.rs.getString(17));

       }

   } catch (Exception ee) { System.out.println(ee);} 
}

void update()
{
    try {
          c.stmt=c.con.prepareCall("update customer set CUST_NO=?,NAME=?,ADDRESS=?,COUNTRY=?,CONTACT_NO=?,EMAIL=?,PROOF=?,ID_NO=?,RNO=?,RTYPE=?,PACKAGE=?,ADULT=?,KIDS=?,CIN=?,COUT=?,SECURITY=?,RMSERVICE=? where CUST_NO=?");
          c.stmt.setString(1, t4.getText());
          c.stmt.setString(2, t5.getText());
          c.stmt.setString(3, t6.getText());
          c.stmt.setString(4, t7.getText());
          c.stmt.setString(5, t8.getText());
          c.stmt.setString(6, t9.getText());
          c.stmt.setString(7, t10.getText());
          c.stmt.setString(8, t11.getText());
          c.stmt.setString(9, t12.getText());
          c.stmt.setString(10, t13.getText());
          c.stmt.setString(11, t14.getText());
          c.stmt.setString(12, t15.getText());
          c.stmt.setString(13, t16.getText());
          c.stmt.setString(14, t17.getText());
          c.stmt.setString(15, t18.getText());
          c.stmt.setString(16, t19.getText());
          c.stmt.setString(17, t20.getText());
          c.stmt.setString(18, t4.getText());
        i=c.stmt.executeUpdate();
        if(i>0)
       JOptionPane.showMessageDialog(this, "Updated Success");
         }

         catch (Exception ee) {
         System.out.println(ee);
     } 
}

}