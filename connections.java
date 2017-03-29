package hotel.mngmnt;
import java.sql.*;

public class connections {
 static PreparedStatement stmt;
 static Connection con;
 static ResultSet rs;
 public void connect()
 {
      try {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","shuchika");
      }

      catch(Exception ee){System.out.println(ee);}
}

}