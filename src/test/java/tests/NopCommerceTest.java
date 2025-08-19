package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.Registerpage;
import pages.productpage;
import listeners.TestListener;
import org.testng.Assert;

@Listeners(listeners.TestListener.class)
public class NopCommerceTest {
    WebDriver driver;
    LoginPage loginPage;
    productpage productPage;
    Registerpage registerpage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        registerpage = new Registerpage(driver);
        productPage = new productpage(driver);
    }

    @Test
    public void fullFlowTest() {
        // 1. Register
        registerpage.openRegisterPage();
        registerpage.selectMaleGender();
        registerpage.enterFirstName("John");
        registerpage.enterLastName("Doe");
        registerpage.enterEmail("john.doe@test.com");
        registerpage.enterCompany("ABC Ltd");
        registerpage.enterPassword("Test1234");
        registerpage.enterConfirmPassword("Test1234");
        registerpage.clickRegisterButton();

        // 2. Login with same credentials
        loginPage.openLogin();
        loginPage.enterEmail("john.doe@test.com");
        loginPage.enterPassword("Test1234"); // FIXED
        loginPage.setRememberMe(true);
        loginPage.clickLogin();

        Assert.assertTrue(driver.getTitle().contains("nopCommerce"));

        // 3. Search product
        productPage.searchProduct("Apple iPhone 16 128GB"); // FIXED keyword

        // 4. Sort and display
        productPage.selectSortBy("Price: Low to High");
        productPage.selectDisplay(3);

        // 5. Open first product & Add to cart
        productPage.openFirstProduct();
        productPage.addToCartFirstProduct();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
