package testdemo1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.*;

public class SeleniumWithDB {
    public static void main(String[] args) throws Exception {
        // DB Connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/seleniumdb", "root", "yourpassword");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username, password FROM logindata");

        // Loop through DB rows
        while (rs.next()) {
            String user = rs.getString("username");
            String pass = rs.getString("password");

            WebDriver driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Enter login data from DB
            driver.findElement(By.name("username")).sendKeys(user);
            driver.findElement(By.name("password")).sendKeys(pass);
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Check if login successful
            String title = driver.getTitle();
            if (title.contains("OrangeHRM")) {
                System.out.println("✅ Login Success with: " + user);
            } else {
                System.out.println("❌ Login Failed with: " + user);
            }

            driver.quit();
        }

        con.close();
    }
}
