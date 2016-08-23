package users;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection connect() throws Exception{
        String url = "jdbc:mysql://localhost:3306/db_users";
        String user = "root";
        String pass = "qwe";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }

}
