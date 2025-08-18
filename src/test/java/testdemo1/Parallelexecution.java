package testdemo1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Parallelexecution {

    @Test(invocationCount = 6, threadPoolSize = 3)
    public void loginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

     // Wait for username field to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("admin");

        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("admin123");

        // Click login button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']"))).click();


        Thread.sleep(2000); // Wait for dashboard

        String dashboardText = driver.findElement(By.xpath("//span[text()='Dashboard']")).getText();
        if(dashboardText.equals("Dashboard")) {
            System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Login Successful");
        }

        driver.quit();
    }
}
