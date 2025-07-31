

/*
Write a java code to insert text file or java file in table with name
file_table where columns are file_id, file_name, file_size, file_content,
file_extension
 */

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PB465 {
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

        String sql = "INSERT INTO file_table (file_name, file_size, file, file_extension) VALUES(?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        String filePath = "E:\\aakif\\JDBC\\PB413.java";
        File f = new File(filePath);

        pst.setString(1, f.getName());
        pst.setLong(2, f.length());
        pst.setCharacterStream(3, new FileReader(f));
        pst.setString(4, f.getName().substring(f.getName().lastIndexOf(".")));
        int r = pst.executeUpdate();
        if(r > 0){
            System.out.println("successful");
        }else{
            System.out.println("Failed");
        }
    }
}
