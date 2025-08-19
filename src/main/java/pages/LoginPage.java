package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 // =================== Login Elements ===================
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(id = "RememberMe")
    WebElement rememberMeCheckbox;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    // Open login page
    public void openLogin() { 
        loginLink.click(); 
    }

    // Enter email
    public void enterEmail(String email) { 
        emailField.sendKeys(email); 
    }

    // Enter password
    public void enterPassword(String password) { 
        passwordField.sendKeys(password); 
    }

    // Select/Deselect Remember Me
    public void setRememberMe(boolean value) {
        if (rememberMeCheckbox.isSelected() != value) {
            rememberMeCheckbox.click();
        }
    }

    // Click login
    public void clickLogin() { 
        loginButton.click(); 
    }
}
