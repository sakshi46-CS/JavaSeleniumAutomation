package Cucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {

  WebDriver driver;

  @Given("User is on login page")
  public void user_on_login_page() {
      driver = new ChromeDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @When("User enters username {string} and password {string}")
  public void user_enters_credentials(String username, String password) {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys("Admin");
//	driver.findElement(By.xpath("//input[@name='username']"));
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("admin123");
	

  }

  @Then("clicks on login button")
  public void clicks_login() {
	  driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
  }
 
}
