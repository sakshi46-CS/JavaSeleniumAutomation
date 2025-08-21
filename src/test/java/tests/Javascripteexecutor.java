package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascripteexecutor {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("name"));
		// Passing the text into element-alternate of sendkeys
		// if we cause any element intercepted exception we can use this if any button
		// is not clickable
		JavascriptExecutor js = (JavascriptExecutor) driver; // upcasting
		js.executeScript("arguments[0].setAttribute('value','john')", element);
		WebElement radiobutton=driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click()", radiobutton);
		
		//1 Scroll down page by pixel number
		js.executeScript("window.scrollBy(0,1590)", "");
		System.out.println(js.executeScript("return window.pageYoffset;"));
		
		//2.scroll the element till element is visible
		WebElement element1=driver.findElement(By.linkText("merrymoonmary"));
		
		js.executeScript(" argument[0].scrollIntoview();",element1);
		System.out.println(js.executeScript("return window.pageYoffset;"));
		
		//3 scroll till page end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYoffset;"));
		
		//set zoom level
		js.executeScript("document.body.style.zoom='90%'");
		
		//upload files
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.findElement(By.id("filesToUpload")).sendKeys("C:\\Program Files (x86)\\Common Files");
	}
}
