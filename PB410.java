
/*
Write a java program that inserts record of employees like emp_id,
emp_name, emp_designation, emp_salary. Here emp_id is primary key
and auto incremented. Table name is employee. And Database is : LJU.
Now, insert one record using PreparedStatement
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PB410 {
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

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String empName = sc.nextLine();

        System.out.print("Enter employee designation: ");
        String empDesignation = sc.nextLine();

        System.out.print("Enter employee salary: ");
        float empSalary = sc.nextFloat();

        String sql = "INSERT INTO employee (emp_name, emp_designation, emp_salary) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, empName);
        pst.setString(2, empDesignation);
        pst.setFloat(3, empSalary);

        int result = pst.executeUpdate();

        if (result > 0) {
            System.out.println("Employee record inserted successfully.");
        } else {
            System.out.println("Failed to insert employee record.");
        }
    }
}
