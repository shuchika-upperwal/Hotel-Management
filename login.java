
package hotel.mngmnt;
import javax.swing.*;
import java.awt.event.*;



public class login extends javax.swing.JFrame implements ActionListener {
JFrame j2;
JButton bpass;
JTextField t1,t2; 
login()
{
   j2=new JFrame("LOGIN PAGE");
 j2.setLayout(null);

 t1=new JTextField("USERNAME");
        t1.setBounds(200,300,150,40);
        j2.add(t1);

        t2=new JTextField("PASSWORD");
        t2.setBounds(370,300,150,40);
        j2.add(t2);

    bpass= new JButton("enter");
    bpass.setBounds(540,300,120,50);
    j2.add(bpass);
    bpass.addActionListener(this);

    JLabel ll=new JLabel(new ImageIcon(getClass().getResource("hotel.jpg")));
        ll.setBounds(5,5,1000,800);
       j2.add(ll);
  j2.setSize(1000, 800);
 j2.setVisible(true);
 j2.setDefaultCloseOperation(EXIT_ON_CLOSE);
 j2.setResizable(false);

}


public void actionPerformed(ActionEvent e) {
    String value1=t1.getText();
  String value2=t2.getText();
  if (value1.equals("a") && value2.equals("a")) {
      connections c=new connections();
     c.connect();
  HotelMngmnt h=new HotelMngmnt();
  j2.dispose();
  }
  else{
  JOptionPane.showMessageDialog(this,"Incorrect Username or "
          + "Password","Error",JOptionPane.ERROR_MESSAGE);
  }
}


static public void main(String arg[])
{
    login g=new login();
}

}