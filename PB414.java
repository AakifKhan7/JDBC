import java.sql.*;

/*
Write a java program that fetch all details of employees from employee
table.
Table name is employee. And Database is : LJU.
Now, fetch record using CallableStatement. - Create procedure with name
: getEmployees() Emp id is auto incremented.
 */

public class PB414 {
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

        CallableStatement cst = con.prepareCall("{call getEmployees()}");
        ResultSet rs = cst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(2));
        }
    }
}
