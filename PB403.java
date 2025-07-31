import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
Write a java program to insert book_id, book_name, book_price in the
book table with LJU database. Do this using Statement

 */

public class PB403 {
    public static void main(String[] args)throws Exception {
        String dburi = "jdbc:mysql://localhost:3306/LJU";
        String dbUser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dburi, dbUser, dbPass);

        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        Statement st = con.createStatement();

        String sql1 = "INSERT INTO book (book_id, book_name, book_price) VALUES (1, 'Java Basics', 299.99)";
        String sql2 = "INSERT INTO book (book_id, book_name, book_price) VALUES (2, 'Spring Boot Guide', 499.50)";

        int r1 = st.executeUpdate(sql1);
        int r2 = st.executeUpdate(sql2);

        if (r1 > 0) {
            System.out.println("First book inserted successfully.");
        }
        if (r2 > 0) {
            System.out.println("Second book inserted successfully.");
        }

        st.close();
        con.close();
    }
}
