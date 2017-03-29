package hotel.mngmnt;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


public class HotelMngmnt extends javax.swing.JFrame implements ActionListener {


JButton bh,brm,brs,bbl,bcd,bemp;
JFrame j1;

HotelMngmnt() 
{
   j1=new JFrame("HOME PAGE");
  j1.setLayout(null);
 j1.setSize(1000, 800);
 j1.setVisible(true);
 j1.setDefaultCloseOperation(EXIT_ON_CLOSE);
 j1.setResizable(false);
 display();
  JLabel ll=new JLabel(new ImageIcon(getClass().getResource("hotel.jpg")));
        ll.setBounds(5,5,1000,800);
        j1.add(ll);
}

 public void actionPerformed(ActionEvent e) {
     if (e.getSource().equals(bh))
     {
         j1.dispose();
         HotelMngmnt h=new HotelMngmnt();
     }

     if (e.getSource().equals(brm))
     {
          rooms r=new rooms();
          j1.dispose();
     }

     if(e.getSource().equals(brs))
     {
          reservation rev=new reservation();
          j1.dispose();
     }

     if (e.getSource().equals(bemp))
     {
         employee emp=new employee();
         j1.dispose();
     }

     if (e.getSource().equals(bcd))
     {
         customer c=new customer();
         j1.dispose();
     }

     if (e.getSource().equals(bbl))
     {
         bill b=new bill();
         j1.dispose();
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


 bcd= new JButton("CUSTOMER  DETAILS");
 bcd.setBounds (100, 600, 200, 60);
 bcd.setFont(f1);


bemp=new JButton("EMPLOYEE  DETAILS");
bemp.setBounds(660,600,200,60);
bemp.setFont(f1);

     j1.add(bh);
     bh.addActionListener(this);
     j1.add(brm);
     brm.addActionListener(this);
     j1.add(brs);
     brs.addActionListener(this);
     j1.add(bbl);
     bbl.addActionListener(this);
     j1.add(bcd);
     bcd.addActionListener(this);
     j1.add(bemp);
     bemp.addActionListener(this); 
}

}  