import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class PB406 {
    public static void main(String[] args) throws Exception{
        String dburi = "jdbc:mysql://localhost:3306/ch9";
        String dbuser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dburi, dbuser, dbPass);

        if(con == null){
            System.out.println("connection failed");
            return;
        }

        Statement st = con.createStatement();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book name to update: ");
        String bookName = sc.nextLine();

        System.out.print("Enter new price: ");
        float newPrice = sc.nextFloat();

        String sql = "UPDATE book SET book_price = " + newPrice + " WHERE book_name = '" + bookName + "'";

        int r = st.executeUpdate(sql);

        if(r > 0){
            System.out.println("Book price updated successfully.");
        } else {
            System.out.println("No book found with the given name.");
        }

        st.close();
        con.close();
        sc.close();
    }
}
