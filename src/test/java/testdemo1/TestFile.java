package testdemo1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFile {
 WebDriver driver;
	@Test(dataProvider="getdata",dataProviderClass=ExcelDataProvider.class)
	public void login(String username,String password) throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();  
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys(username);
	     driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	       driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	       Thread.sleep(2000);
		try {
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
		    System.out.println("Login successful for user: " + username);
		} catch (Exception e) {
		    String errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")).getText();
		    System.out.println("Login failed for user: " + username + " | Message: " + errorMsg);
		    Assert.fail("Login failed for user: " + username);
		}
 driver.quit();
	}
}
