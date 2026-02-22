import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_name",//your db name
                    "root", //your username
                    "password" //your password
            );

            return con;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
