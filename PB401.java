import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
Consider a table with name – student and database as admission. The
student table have fields like stdId, stdName, stdMarks(float). Write a
java program that adds 2 records using PreparedStatement. [have to
write connection code here.]

 */

public class PB401 {
    public static void main(String[] args) throws  Exception{
        String dburl = "jdbc:mysql://localhost:3306/ch9";
        String dbuser = "root";
        String dbPass = "";

        String driverName = "com.mysql.cj.jdbc.Driver";

        Class.forName(driverName);

        Connection con = DriverManager.getConnection(dburl, dbuser, dbPass);

        if(con == null){
            System.out.printf("fail to connect with database");
            return;
        }
        PreparedStatement pst = con.prepareStatement("insert into student value (?, ?, ?)");
        pst.setInt(1, 1);
        pst.setString(2, "aakif");
        pst.setFloat(3, 90.0f);


        PreparedStatement pst2 = con.prepareStatement("insert into student value (?, ?, ?)");
        pst2.setInt(1, 2);
        pst2.setString(2, "anzar");
        pst2.setFloat(3, 90.0f);

        int r1 = pst.executeUpdate();
        int r2 = pst2.executeUpdate();

        if(r1 > 0){
            System.out.printf("Inserted first record");
        }
        if(r2 > 0){
            System.out.printf("inserted second record");
        }
    }
}
