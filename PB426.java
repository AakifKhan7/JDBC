
/*
Ask User to do the following taks in book table. All the details of table are
given in above examples.
1 - for insertion
2 - for deletion by book name
3 - for update book name and price both BY book id.
4. for show all books from the table.
Do above program using switch case and untill user press - 5 - ask them
again do the above operations
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PB426 {
    public static void main(String[] args) throws Exception{
        String dbUri = "jdbc:mysql://localhost:3306/ch9";
        String dbUser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUri, dbUser, dbPass);

        int choice;
        do {
            System.out.println("\n------ BOOK TABLE OPERATIONS ------");
            System.out.println("1 - Insert a new book");
            System.out.println("2 - Delete a book by name");
            System.out.println("3 - Update book name and price by ID");
            System.out.println("4 - Show all books");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    insertBook(con, sc);
                    break;
                case 2:
                    deleteBookByName(con, sc);
                    break;
                case 3:
                    updateBookById(con, sc);
                    break;
                case 4:
                    showAllBooks(con);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    static void insertBook(Connection con, Scanner sc) throws Exception{
        System.out.print("Enter book name: ");
        String name = sc.nextLine();

        System.out.print("Enter book price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        String sql = "insert into book(book_name, book_price) values(?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, name);
        pst.setDouble(2, price);

        int rows = pst.executeUpdate();
        if (rows > 0) {
            System.out.println("Book inserted successfully.");
        }
    }

    static void deleteBookByName(Connection con, Scanner sc)throws Exception{
        System.out.print("Enter book name to delete: ");
        String name = sc.nextLine();

        String sql = "delete from book where book_name = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, name);
        int rows = pst.executeUpdate();
        if (rows > 0) {
            System.out.println("Book inserted successfully.");
        }

    }

    static void updateBookById(Connection con, Scanner sc)throws Exception{
        System.out.print("Enter book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new book name: ");
        String name = sc.nextLine();

        System.out.print("Enter new price: ");
        double price = sc.nextDouble();
        sc.nextLine();


        String sql = "UPDATE book SET book_name = ?, book_price = ? WHERE book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setInt(3, id);

        int rows = pst.executeUpdate();
        if (rows > 0) {
            System.out.println("Book inserted successfully.");
        }
    }

    static void showAllBooks(Connection con)throws Exception{
        String sql = "SELECT * FROM book";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("book_id");
            String name = rs.getString("book_name");
            double price = rs.getDouble("book_price");

            System.out.printf("%-5d %-25s %-10.2f\n", id, name, price);
        }

    }
}
