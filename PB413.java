
/*
Write a java program for the above same employee table - to do delete
employee those having salary more than salary entered by user. from the
table. Take all details from user and update this by using
PreparedStatement. - Take salary from user.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PB413 {
    public static void main(String[] args) throws Exception{
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

        String sql = "delete from employee where emp_salary > ?";
        PreparedStatement pst = con.prepareStatement(sql);

        System.out.println("Enter salary: ");
        float salary = sc.nextFloat();
        pst.setFloat(1, salary);
        int r = pst.executeUpdate();

        if(r > 0){
            System.out.println("successful");
        }
        else{
            System.out.println("failed");
        }
    }
}
