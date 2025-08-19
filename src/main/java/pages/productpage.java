package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class productpage {
    WebDriver driver;
    WebDriverWait wait;

    public productpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    WebElement searchButton;

    @FindBy(id = "products-orderby")
    WebElement sortByDropdown;

    @FindBy(id = "products-pagesize")
    WebElement displayDropdown;

    @FindBy(css = "h2.product-title > a")
    List<WebElement> productLinks; // All products in search results

    @FindBy(css = "button.product-box-add-to-cart-button")
    List<WebElement> addToCartButtons; // All "Add to Cart" buttons

    public void openFirstProduct() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(productLinks));
            
            // If no products found
            if (productLinks.isEmpty()) {
                System.out.println("❌ No products found for this search keyword.");
                return;
            }

            WebElement firstProduct = productLinks.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
            firstProduct.click();
            System.out.println("✅ Opened first product: " + firstProduct.getText());

        } catch (Exception e) {
            System.out.println("⚠️ Exception while opening product: " + e.getMessage());
        }
    }


    public void addToCartFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons));
        if (addToCartButtons.isEmpty()) {
            throw new RuntimeException("No Add to Cart buttons found!");
        }
        WebElement firstButton = addToCartButtons.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();
    }

    public void searchProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(product);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        // Handle alert if it appears
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert detected: " + alert.getText());
            alert.accept();
        } catch(Exception e) {
            // No alert, continue
        }
    }

    public void selectSortBy(String sortOption) {
        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown));
        new Select(sortByDropdown).selectByVisibleText(sortOption);
    }

    public void selectDisplay(int number) {
        wait.until(ExpectedConditions.elementToBeClickable(displayDropdown));
        new Select(displayDropdown).selectByVisibleText(String.valueOf(number));
    }
}
