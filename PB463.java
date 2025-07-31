
/*
Write a java code to insert image in table with name img_table where
columns are img_id, img_name, img_size, img_content
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PB463 {
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

        PreparedStatement pst = con.prepareStatement("insert into image_table(image_name, image_size, image) values(?, ?, ?)");

        String imagePath = "E:\\aakif\\JDBC\\Screenshot 2025-07-31 125427.png";

        File f = new File(imagePath);
        FileInputStream fis = new FileInputStream(f);

        pst.setString(1, f.getName());
        pst.setLong(2, f.length());
        pst.setBinaryStream(3, fis);

        int r = pst.executeUpdate();
        if(r > 0){
            System.out.println("Successful");
        }else{
            System.out.println("Failed");
        }
    }
}
