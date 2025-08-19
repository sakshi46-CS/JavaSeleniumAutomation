package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {
    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "screenshots/" + testName + ".png";
            Files.copy(src.toPath(), new File(path).toPath());
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
