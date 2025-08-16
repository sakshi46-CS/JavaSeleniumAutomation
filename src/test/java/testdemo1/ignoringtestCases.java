package testdemo1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ignoringtestCases {
     WebDriver driver;
     
     @BeforeSuite
	public void beforeSuite(){
		System.out.println("Started working on Before Suite");

	}
     @BeforeTest
     public void beforeTest() {
    	 System.out.println("Preparing test environment");

     }
     @BeforeClass
     public void beforeclass() {
    	 driver=new ChromeDriver();
    	 driver.manage().window().maximize();
     }
     @BeforeMethod
     public void beforeMethod() {
    	 System.out.println("Navigating to the Home Page");
 		driver.get("https://sauce-demo.myshopify.com/");

     }
     @Test
     public void signuppage() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// Click Sign up link
    	WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//a[@id='customer_register_link' and text()='Sign up']")));
    	signUpLink.click();

    	// First Name
    	WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//input[@name='customer[first_name]' and @id='first_name']")));
    	firstName.sendKeys("Sakshi");

    	// Last Name
    	WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//input[@name='customer[last_name]' and @id='last_name']")));
    	lastName.sendKeys("Jadhav");

    	// Email
    	WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//input[@name='customer[email]' and @id='email']")));
    	email.sendKeys("jadhav@gmail.com");

    	// Password
    	WebElement password = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//input[@name='customer[password]' and @id='password']")));
    	password.sendKeys("1234jadhav");

    	// Click Create button
    	WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//input[@type='submit' and @value='Create']")));
    	createBtn.click();
     }
     @Test(priority=2)
     public void loginpage() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Navigate to login page (click login link)
         WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer_login_link"))); 
         loginLink.click();

         // Wait for email field to be visible
         WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_email")));
         emailField.sendKeys("jadhav@gmail.com");

         WebElement passwordField = driver.findElement(By.id("customer_password"));
         passwordField.sendKeys("1234jadhav");

         WebElement signInBtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Sign In']"));
         signInBtn.click();
     }

     @Ignore
     @Test(priority=3)
     public void searchProducts() {
    	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Search' ] ")));
     }
@AfterMethod
public void afterMethod() {
	System.out.println("Returning to Homepage");
	driver.get("https://sauce-demo.myshopify.com/");
}
@AfterClass
public void afterClass() {
	if(driver!=null) {
		driver.quit();
	}
}
@AfterTest
public void afterTest() {
	System.out.println("Closing the Test Environment");
}
@AfterSuite
public void afterSuite() {
	System.out.println("Closing After Suite");
}

}
