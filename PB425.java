
/*
Management of the LJ wants to do compilation of total marks of the
students. For this they do the following process.
1. Table - mse_marks with columns - roll_no, t1, t2, bonus.
2. Table – final_marks with roll_no, total ( where total = (t1+t2)/2 + bonus
)
Process 1: Need to fetch all the details from the table mse_marks using
CallableStatement. Write SQL code an Java code for the same. Procedure
name is getMarks().
Process 2: Need to insert same roll_no fetched from the mse_marks to
final_marks table and total after calculating it perfectly from the table
mse_marks.
This insertion query you have to write using PreparedStatement.

 */

import java.sql.*;

public class PB425 {
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


        CallableStatement cst = con.prepareCall("{call getMarks()}");
        ResultSet rs = cst.executeQuery();

        PreparedStatement pst = con.prepareStatement("INSERT INTO final_marks (roll_no, total) VALUES (?, ?)");

        while (rs.next()){
            int roll = rs.getInt("roll_no");
            int t1 = rs.getInt("t1");
            int t2 = rs.getInt("t2");
            int bonus = rs.getInt("bonus");

            double total = ((t1 + t2)/2.0) +bonus;

            pst.setInt(1, roll);
            pst.setDouble(2, total);
            pst.executeUpdate();
            System.out.println("Inserted roll_no: " + roll + ", total: " + total);
        }
    }
}
