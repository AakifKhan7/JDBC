

/*
Write a java code to retrive image in table with name img_table where
columns are img_id, img_name, img_size, img_content.

 */

import java.io.FileOutputStream;
import java.sql.*;

public class PB464 {
    public static void main(String[] args)throws Exception {
        String DBRUI = "jdbc:mysql://localhost:3306/ch10";
        String DBUSER = "root";
        String DBPASS = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(DBRUI, DBUSER, DBPASS);

        if(con == null){
            System.out.println("connection failed");
            return;
        }

        PreparedStatement pst = con.prepareStatement("select * from image_table");
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            Blob b = rs.getBlob("image");

            byte[] arr = b.getBytes(1, (int)b.length());
            String fileName = "E:\\aakif\\JDBC\\error.png";

            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(arr);
            fos.close();
        }
    }
}
