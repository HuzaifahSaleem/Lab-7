
import java.util.*;
import java.sql.*;

public class PECafe {

    public static void main(String[] args) {
        try {
            Customer C1 = new Customer();
            Order O1 = new Order();
            O1.updateOrder();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
