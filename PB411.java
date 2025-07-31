
/*
Write a java program that inserts record of employees like emp_id,
emp_name, emp_designation, emp_salary. Here emp_id is primary key
and auto incremented. Table name is employee. And Database is : LJU.
Now, insert one record using PreparedStatement. Ask User how many
records you want to enter. And insert n - records using prepared
statement
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PB411 {
    public static void main(String[] args) throws Exception {
        String dburi = "jdbc:mysql://localhost:3306/ch9";
        String dbuser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dburi, dbuser, dbPass);

        if (con == null) {
            System.out.println("connection failed");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("How many employee records do you want to insert? ");
        int n = sc.nextInt();
        sc.nextLine();


        String sql = "INSERT INTO employee (emp_name, emp_designation, emp_salary) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for employee " + i + ":");

            System.out.print("Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Designation: ");
            String designation = sc.nextLine();

            System.out.print("Salary: ");
            float salary = sc.nextFloat();
            sc.nextLine();

            pst.setString(1, name);
            pst.setString(2, designation);
            pst.setFloat(3, salary);

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Employee " + i + " inserted successfully.");
            } else {
                System.out.println("Failed to insert employee " + i + ".");
            }
        }

        pst.close();
        con.close();
        sc.close();
    }
}
