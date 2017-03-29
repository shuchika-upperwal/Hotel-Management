package hotel.mngmnt;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class allot extends javax.swing.JFrame implements ActionListener {
JFrame j1;
JButton bk,bupdate;
JTextField t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19; 
JComboBox cb;
String t,rm[]=new String[50];
int i;
connections c=new connections();

allot(String s)
{
   t=s;
   Font f1=new Font("Arial",Font.PLAIN,18);

    bk = new JButton("BACK");
       bk.setBounds(720, 680, 180, 80);
       bk.setFont(f1);
       j1=new JFrame();
       j1.setLayout(null);
       j1.setSize(1000,800);
       j1.setVisible(true);
       j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
       j1.setResizable(false);
       j1.add(bk);
       bk.addActionListener(this);
       roomlist();
       room_allotment();

}


public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(bk))
    {
       reservation r=new reservation();
        j1.dispose();
    }
    if(e.getSource().equals(bupdate))
    {
       insert();
    }
}



void room_allotment()
{
   Font f1=new Font("Arial",Font.PLAIN,18);

   Font f2=new Font("Arial",Font.PLAIN,16);

    JLabel l1=new JLabel("CUSTOMER INFORMATION");
   l1.setBounds(90,10,260,80);
   l1.setFont(f2);
   j1.add(l1);

  JLabel l2=new JLabel("CUST_No");
 l2.setBounds(50,110,120,60);
 l2.setFont(f2);
   j1.add(l2);

JLabel l3=new JLabel("NAME");
 l3.setBounds(50,160,120,60);
 l3.setFont(f2);
   j1.add(l3);

 JLabel l4=new JLabel("ADDRESS");
 l4.setBounds(50,210,120,60);
 l4.setFont(f2);
   j1.add(l4);

 JLabel l5=new JLabel("COUNTRY");
 l5.setBounds(50,260,120,60);
 l5.setFont(f2);
   j1.add(l5);

JLabel l6=new JLabel("c.conTACT NO");
 l6.setBounds(50,310,120,60);
 l6.setFont(f2);
   j1.add(l6);

 JLabel l7=new JLabel("EMAIL");
 l7.setBounds(50,360,120,60);
 l7.setFont(f2);
   j1.add(l7);

 JLabel l8=new JLabel("PROOF");
 l8.setBounds(50,410,120,60);
 l8.setFont(f2);
   j1.add(l8);

 JLabel l9=new JLabel("ID No");
 l9.setBounds(50,460,120,60);
 l9.setFont(f2);
   j1.add(l9);

 JLabel l10=new JLabel("ROOM No");
 l10.setBounds(550,110,120,60);
 l10.setFont(f2);
   j1.add(l10);

 JLabel l11=new JLabel("ROOM TYPE");
 l11.setBounds(550,160,120,60);
 l11.setFont(f2);
   j1.add(l11);

 JLabel l12=new JLabel("PACKAGE");
 l12.setBounds(550,210,120,60);
 l12.setFont(f2);
   j1.add(l12);

 JLabel l13=new JLabel("ADULTS");
 l13.setBounds(550,260,120,60);
 l13.setFont(f2);
   j1.add(l13);

 JLabel l14=new JLabel("KIDS");
 l14.setBounds(550,310,120,60);
 l14.setFont(f2);
   j1.add(l14);

 JLabel l15=new JLabel("CHECK IN");
 l15.setBounds(550,360,120,60);
 l15.setFont(f2);
   j1.add(l15);


JLabel  l16=new JLabel("CHECK OUT");
 l16.setBounds(550,410,120,60);
 l16.setFont(f2);
   j1.add(l16);


JLabel  l17=new JLabel("SECURITY");
 l17.setBounds(550,460,120,60);
 l17.setFont(f2);
   j1.add(l17);


   t4=new JTextField("");
   t4.setBounds(180,120,160,40);
   //l1.setFont(f2);
   j1.add(t4);


   t5=new JTextField("");
   t5.setBounds(180,170,160,40);
   j1.add(t5);


  t6=new JTextField("");
   t6.setBounds(180,220,160,40);
   j1.add(t6);


  t7=new JTextField("");
   t7.setBounds(180,270,160,40);
   j1.add(t7);


    t8=new JTextField("");
   t8.setBounds(180,320,160,40);
   j1.add(t8);


    t9=new JTextField("");
   t9.setBounds(180,370,160,40);
   j1.add(t9);


    t10=new JTextField("");
   t10.setBounds(180,420,160,40);
   j1.add(t10);


    t11=new JTextField("");
   t11.setBounds(180,470,160,40);
   j1.add(t11);



    cb=new JComboBox(rm);
    cb.setBounds(680,120,160,40);
   j1.add(cb);


    t13=new JTextField(t);
   t13.setBounds(680,170,160,40);
   j1.add(t13);


    t14=new JTextField("");
   t14.setBounds(680,220,160,40);
   j1.add(t14);


    t15=new JTextField("");
   t15.setBounds(680,270,160,40);
   j1.add(t15);


    t16=new JTextField("");
   t16.setBounds(680,320,160,40);
   j1.add(t16);


    t17=new JTextField("");
   t17.setBounds(680,370,160,40);
   j1.add(t17);


    t18=new JTextField("");
   t18.setBounds(680,420,160,40);
   j1.add(t18);

   t19=new JTextField("");
   t19.setBounds(680,470,160,40);
   j1.add(t19);



   bupdate= new JButton(" SUBMIT ");
   bupdate.setBounds(140,570,230,80);
   bupdate.setFont(f1);
   j1.add(bupdate);
   bupdate.addActionListener(this);


}



void insert()
{
    try{
    c.stmt=c.con.prepareCall("insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
     c.stmt.setString(1,t4.getText());
     c.stmt.setString(2, t5.getText());
     c.stmt.setString(3, t6.getText());
     c.stmt.setString(4, t7.getText());
     c.stmt.setString(5, t8.getText());
     c.stmt.setString(6, t9.getText());
     c.stmt.setString(7, t10.getText());
     c.stmt.setString(8, t11.getText());
     c.stmt.setString(9, String.valueOf(cb.getSelectedItem()));
     c.stmt.setString(10, t13.getText());
     c.stmt.setString(11, t14.getText());
     c.stmt.setString(12, t15.getText());
     c.stmt.setString(13, t16.getText());
     c.stmt.setString(14, t17.getText());
     c.stmt.setString(15, t18.getText());
     c.stmt.setString(16, t19.getText());
     c.stmt.setString(17, "0");
     i=c.stmt.executeUpdate();
     if(i>0)
     JOptionPane.showMessageDialog(this, "Inserted Success");

     c.stmt=c.con.prepareCall("update Rooms set STATUS=? where ROOM_NO=?");
        c.stmt.setString(1,"BOOKED");
        c.stmt.setInt(2,Integer.parseInt(String.valueOf(cb.getSelectedItem())));
        c.stmt.executeUpdate();
    }
    catch(Exception ee){System.out.println(ee);
    JOptionPane.showMessageDialog(this, "try again");
    }
}

void roomlist()
{
    i=0;
    try{
  c.stmt=c.con.prepareCall("select * from Rooms where TYPE=? and STATUS=?");
  c.stmt.setString(1, t);
  c.stmt.setString(2, "free");
       c.rs=c.stmt.executeQuery();
        while(c.rs.next())
       {
        rm[i]=String.valueOf(c.rs.getInt(1));
        i++;
}
    }
    catch(Exception ee){System.out.println(ee);}
}

}