
/*
Write a java program to insert brochure_id brochure_name,
brochure_pages in the brochure table with LJU database. Do this using
Statement Interface. Take necessary data from user for inserting atleast 5
records.

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class PB405 {
    public static void main(String[] args) throws Exception {
        String dburi = "jdbc:mysql://localhost:3306/ch9";
        String dbUser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dburi, dbUser, dbPass);

        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        Statement stmt = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 brochure records:");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Record " + i + ":");

            System.out.print("Enter brochure_id (int): ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter brochure_name: ");
            String name = sc.nextLine();

            System.out.print("Enter brochure_pages (int): ");
            int pages = sc.nextInt();

            String sql = "INSERT INTO brochure (brochure_id, brochure_name, brochure_pages) VALUES ("
                    + id + ", '" + name + "', " + pages + ")";

            int r = stmt.executeUpdate(sql);

            if (r > 0) {
                System.out.println("Inserted successfully.\n");
            } else {
                System.out.println("Failed to insert.\n");
            }
        }

        sc.close();
        stmt.close();
        con.close();

    }
}
