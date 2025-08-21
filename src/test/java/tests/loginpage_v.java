package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Without pagefactory

public class loginpage_v {
    
    WebDriver driver;

    // Constructor
    public loginpage_v(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By txt_username = By.xpath("//input[@name='username']");
    By txt_password = By.xpath("//input[@name='password']");
    By txt_login    = By.cssSelector(".orangehrm-login-button");

    // Action methods
    public void setusername(String username) {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void setpassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickloginbutton() {
        driver.findElement(txt_login).click();
    }
}
