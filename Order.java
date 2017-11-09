import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Order {
    int num;

/*THE PRICE OF EVERYTHING ITEM IS 500*/    
    
    public Order()
    {
        try
        {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecafe", "root", "seecs@123");
      System.out.println("The menu is: ");
     Statement stmt1 = con.createStatement();
     ResultSet rs1 = stmt1.executeQuery("select * from orders");
     while(rs1.next())
     {
         System.out.println(rs1.getInt(1)+ " " + rs1.getString(2) + " " + rs1.getInt(3));
     }  
           con.close();  }catch(Exception e){System.out.println(e);}
    }
    public void updateOrder()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecafe", "root", "seecs@123");
                String updateTableSQL = "UPDATE `orders` SET `Ordername`=? WHERE `OrderNum`=?";
                System.out.println("In Update order " + updateTableSQL);
                PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
                preparedStatement.setString(1,"Mahira Khan");
                preparedStatement.setInt(2, 1);
                
    // execute insert SQL stetement
    preparedStatement .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
