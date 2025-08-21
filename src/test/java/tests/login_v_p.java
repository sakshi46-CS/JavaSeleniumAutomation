package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//with page factory
@Test
public class login_v_p {
	WebDriver driver;

	public login_v_p(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);//It should applicable for all webelements
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement txt_username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(css = ".orangehrm-login-button")
	WebElement btn_loginclick;

	@FindBy(tagName="a")
	List<WebElement>links;  //Group of web elements
	
	public void setusername(String username) {
		txt_username.sendKeys(username);
	}

	public void setpassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickloginbutton() {
		btn_loginclick.click();
	}
}
