import java.io.FileWriter;
import java.io.Reader;
import java.sql.*;

/*
Write a java code to retrieval text file or java file in table with name
file_table where columns are file_id, file_name, file_size, file_content,
file_extension
 */
public class PB466 {
    public static void main(String[] args) throws Exception{
        String DBRUI = "jdbc:mysql://localhost:3306/ch10";
        String DBUSER = "root";
        String DBPASS = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(DBRUI, DBUSER, DBPASS);

        if(con == null){
            System.out.println("connection failed");
            return;
        }

        String sql = "select * from file_table";
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            String fileName = rs.getString(2);
            String fileExtension = rs.getString(5);

            Clob fClob = rs.getClob(4);
            Reader r = fClob.getCharacterStream();
            FileWriter fw = new FileWriter("E:\\aakif\\JDBC\\downloads\\" + fileName);
            int i;
            while ((i = r.read()) != -1){
                fw.write((char) i);
            }
            fw.close();
        }
    }
}
