import java.sql.*;

public class PB462 {
    public static void main(String[] args)throws Exception {
        String dbUri = "jdbc:mysql://localhost:3306/ch9";
        String dbUser = "root";
        String dbPass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUri, dbUser, dbPass);

        if (con == null) {

            System.out.println("Connection failed");
            return;
        }

        String query = "SELECT * FROM employee";
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("➡ Number of Columns: " + rsmd.getColumnCount());

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println("   • " + rsmd.getColumnLabel(i) + " (" + rsmd.getColumnTypeName(i) + ")");
        }

        rs.last();
        int rowCount = rs.getRow();
        System.out.println("\n➡ Number of Records: " + rowCount);
    }
}
