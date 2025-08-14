package testdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoodReadersSimpleTest {

    @Test
    public void signupAndLogin() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1️⃣ Navigate to Goodreads homepage
        driver.get("https://www.goodreads.com/");

        // 2️⃣ Click "Sign up with email"
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign up with email"))).click();

        // 3️⃣ Fill signup form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name"))).sendKeys("Sakshijadhav");
        driver.findElement(By.id("ap_email")).sendKeys("jim1@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("jim1223");
        driver.findElement(By.id("ap_password_check")).sendKeys("jim1223");

        // 4️⃣ Submit signup form
        driver.findElement(By.id("continue")).click();

        // 5️⃣ Skip OTP/email verification by going directly to login
        driver.get("https://www.goodreads.com/user/sign_in");

        // 6️⃣ Click "Sign in with email"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".authPortalSignInButton")
        )).click();

        // 7️⃣ Enter login credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys("jim1@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("jim1223");
        driver.findElement(By.id("signInSubmit")).click();

      
        // 10️⃣ Close browser
        driver.quit();
    }
}
