import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class PB461 {
    public static void main(String[] args)throws Exception {
        String dbUri = "jdbc:mysql://localhost:3306/ch9";
        String dbUser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUri, dbUser, dbPass);

        if(con == null){

            System.out.println("Connection failed");
            return;
        }

        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("version: " + dbmd.getDriverVersion());
        System.out.println("➡ Driver Version: " + dbmd.getDriverVersion());
        System.out.println("➡ Database Product Name: " + dbmd.getDatabaseProductName());
        System.out.println("➡ Database Product Version: " + dbmd.getDatabaseProductVersion());
        System.out.println("➡ JDBC URL: " + dbmd.getURL());
    }
}
