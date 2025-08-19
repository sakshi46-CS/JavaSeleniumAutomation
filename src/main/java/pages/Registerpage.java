package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registerpage {

    WebDriver driver;
    WebDriverWait wait;
    
    // =================== Registration Elements ===================
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "gender-male")
    WebElement maleRadioBtn;

    @FindBy(id = "gender-female")
    WebElement femaleRadioBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement lastNameField;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Company")
    WebElement company;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    WebElement registerButton;

    // =================== Constructor ===================
    public Registerpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =================== Actions ===================
    public void openRegisterPage() {
        registerLink.click();
    }

    public void selectMaleGender() {
        maleRadioBtn.click();
    }

    public void selectFemaleGender() {
        femaleRadioBtn.click();
    }

    public void enterFirstName(String fname) {
        firstNameField.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastNameField.sendKeys(lname);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterCompany(String comp) {
        company.sendKeys(comp);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        confirmPasswordField.sendKeys(cpwd);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
