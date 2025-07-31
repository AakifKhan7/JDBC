import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PB409 {
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

        Statement st = con.createStatement();
        String sql = "select * from brochure";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            System.out.println("id: " + rs.getInt(1));
            System.out.println("name: " + rs.getString(2));
            System.out.println("pages: " + rs.getInt(3));
        }

        rs.close();
        st.close();
        con.close();

    }
}
