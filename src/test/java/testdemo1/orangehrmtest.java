package testdemo1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class orangehrmtest {
    private static final Logger logger = LogManager.getLogger(orangehrmtest.class);

    public static void main(String[] args) {
        WebDriver driver = null;
//instead of usinh system.out.println we can use logger.info
        try {
            logger.info("===== Test Started =====");

            // Launch browser
            driver = new ChromeDriver();
            logger.info("Chrome browser launched");

            // Open OrangeHRM
            driver.get("https://opensource-demo.orangehrmlive.com/");
            logger.info("Navigated to OrangeHRM website");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys("Admin");
//      	driver.findElement(By.xpath("//input[@name='username']"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("admin123");
      	

            // Click Login
            driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
            logger.info("Clicked login button");

            // Verify Dashboard
            String title = driver.getTitle();
            if (title.contains("OrangeHRM")) {
                logger.info("Login successful - Dashboard loaded");
            } else {
                logger.error("Login failed - Dashboard not loaded");
            }

        } catch (Exception e) {
            logger.fatal("Test failed due to exception: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed");
            }
            logger.info("===== Test Finished =====");
        }
    }
}
