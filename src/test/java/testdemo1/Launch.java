package testdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Launch {
    WebDriver driver;

  
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void registerNewUser() {
        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/register']"))).click();

        System.out.println(driver.getTitle());
        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("liver");
        driver.findElement(By.id("Email")).sendKeys("John@gmail.com");
        
        driver.findElement(By.id("ConfirmPassword")).sendKeys("john1234");
        driver.findElement(By.id("Password")).sendKeys("john1234");
        
        driver.findElement(By.id("register-button")).click();

    }
   
  
    
}
