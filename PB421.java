import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class PB421 {
    public static void main(String[] args) throws Exception{
        String dburi = "jdbc:mysql://localhost:3306/ch9";
        String dbUser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dburi, dbUser, dbPass);

        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        CallableStatement cst = con.prepareCall("{call multiProduct(?, ?, ?)}");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID to update: ");
        int productId = sc.nextInt();

        System.out.print("Enter new price: ");
        double newPrice = sc.nextDouble();

        cst.setInt(1, productId);
        cst.setDouble(2, newPrice);

        cst.registerOutParameter(3, Types.VARCHAR);

        cst.execute();

        String productName = cst.getString(3);
        System.out.println("Updated Product Name: " + productName);
    }
}
