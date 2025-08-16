package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Demologin {
	 WebDriver driver;
	    // Locators
	    private By usernameField = By.id("username");
	    private By passwordField = By.id("password");
	    private By loginButton = By.id("loginBtn");
	    // Constructor
	    public  Demologin(WebDriver driver) {
	        this.driver = driver;

}
	    // Actions (Methods)
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }
	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }
	}
