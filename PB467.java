
/*
Table name: product
Columns: pId, pName, pPrice, pCategory
Create a java program through which user can ask for the following.
Enter 1 to know Number of Column
Enter 2 to know the Table Name
Enter 3 to know Column Name & Ask for Index of column
Enter 4 to know the type of column of Index given by user
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Scanner;

public class PB467 {
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

    }


}
