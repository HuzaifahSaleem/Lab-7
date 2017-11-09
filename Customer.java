
import java.util.*;
import java.text.*;
import java.sql.*;

public final class Customer {
    String name;
    String address;
    int bill = 0;
    int time = 0;
    
  public Customer()
  {
      try
      {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecafe", "root", "seecs@123");
     Setname();
     SetAddress();
     String n = getName();
     String adrs = getAddress();
                String insertTableSQL = "INSERT INTO `orders`(`CustomerID`, `name`, `Address`) VALUES (?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
                preparedStatement.setInt(1,1000);
                preparedStatement.setString(2, n);
                preparedStatement.setString(2, n);
                
    // execute insert SQL stetement
    preparedStatement .executeUpdate();
      con.close();
      }catch(Exception e){System.out.println(e);}

  }
  public void Setname()
  {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter Your Name: ");
      name = in.next();   
  }
  public void SetAddress()
  {
      Scanner in1 = new Scanner(System.in);
      System.out.println("Enter Your Address: ");
      address = in1.nextLine();   
  }
  public String getAddress()
  {
      return address;
  }
  public String getName()
  {
      return name;
  }
  public void TakeOrder()
  {
      int c = 1;
      Scanner check = new Scanner(System.in);
      System.out.println("EVERY ITEM COSTS 500");
      System.out.println("YOU CAN ONLY ORDER 3 ITEMS");
      while(c != -1)
      {
      System.out.println("Enter the ItemNumber to Order:");
      for (int j = 0; j<3; j++)
      {
          int i = check.nextInt();
          bill +=500;
          time +=10;
      }
      Scanner n = new Scanner(System.in);
      System.out.println("Enter -1 to exit, 2 to Continue");
      c = n.nextInt();
      }
      System.out.println("Your Order costs you: " + bill + "\n" + "It will take " + time + " minutes to deliver it to you");
  }
}
