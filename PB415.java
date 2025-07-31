/*
Write a java program that inserts record of employees like emp_id,
emp_name, emp_designation, emp_salary. Here emp_id is primary key
and auto incremented. Table name is employee. And Database is : LJU.
Now, insert one record using CallableStatement. - Create procedure with
name : insertEmployee(?,?,?) Emp id is auto incremented. Consider all
parameters as IN parameter
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PB415 {
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

        CallableStatement cst = con.prepareCall("{call insertEmployee(?, ?, ?)}");
        cst.setString(1, "alfina");
        cst.setString(2, "intern");
        cst.setFloat(3, 900000);

        int r = cst.executeUpdate();
        if(r > 0){
            System.out.println("successful");
        }else{
            System.out.println("Failed");
        }
    }
}
