package POM;
import java.sql.*;

public class DBUtils {
    public static void main(String[] args) throws Exception {
      
        // Connect to DB
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/seleniumdb", "root", "yourpassword");

        // Execute query
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username, password FROM logindata");

        // Print fetched data
        while (rs.next()) {
            String user = rs.getString("username");
            String pass = rs.getString("password");
            System.out.println("DB Data -> Username: " + user + " | Password: " + pass);
        }

        // Close connection
        con.close();
    }
}
