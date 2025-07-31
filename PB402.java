import java.sql.Connection;
import java.sql.DriverManager;

public class PB402 {
    public static void main(String[] args) throws Exception{
        String dburi = "jdbc:mysql://localhost:3306/ch9";
        String dbUser = "root";
        String dbPass = "";

        String driverName = "com.mysql.cj.jdbc.Driver";

        Class.forName(driverName);

        Connection con = DriverManager.getConnection(dburi, dbUser, dbPass);

        if(con == null){
            System.out.println("connection failed");
        }else{
            System.out.println("connection successful");
        }
    }
}
