package testdemo1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreportmanager_v implements ITestListener {
public ExtentSparkReporter sparkreporter;//UI of the report
public ExtentReports extent;//Populate common info of the report
public ExtentTest test;//Creating the status P/F/S4e3
public static WebDriver driver;

public void onStart(ITestContext context) {
	sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");//Location of report
	
	sparkreporter.config().setDocumentTitle("Automation report");//title of the report
	sparkreporter.config().setReportName("Functional Testing");//name of the report
	sparkreporter.config().setTheme(Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter(sparkreporter);
	
	extent.setSystemInfo("Computer name","localhost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("Tester name","sakshi");
	extent.setSystemInfo("os","windows11");
	extent.setSystemInfo("Browser name","chrome");
	
	
}
//ITestResult result :- It will captures the info of passed test method

public void onTestSuccess(ITestResult result) {
	test=extent.createTest(result.getName());  //create a new entry in the report
	test.log(Status.PASS, "Test case passed is:"+result.getName());//update status P/F/S
	try {
        String screenshotPath = getScreenshot(result.getName());
        test.addScreenCaptureFromPath(screenshotPath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void onTestFailure(ITestResult result) {
	test=extent.createTest(result.getName());
	test.log(Status.FAIL,"Test case is failed is:"+result.getName());
	test.log(Status.FAIL,"Test case is failed cause is:"+result.getThrowable());//	The error message captured by getThrowable

    try {
        String screenshotPath = getScreenshot(result.getName());
        test.addScreenCaptureFromPath(screenshotPath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void onTestSkipped(ITestResult result) {
	test=extent.createTest(result.getName());
	test.log(Status.SKIP,"Test case is skipped is:"+result.getName());
	try {
        String screenshotPath = getScreenshot(result.getName());
        test.addScreenCaptureFromPath(screenshotPath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Override
public void onFinish(ITestContext context) {
    extent.flush();
}

// 📌 Utility method to capture screenshots
public static String getScreenshot(String testName) throws IOException {
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String destination = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + dateName + ".png";
    File finalDestination = new File(destination);
    FileUtils.copyFile(source, finalDestination);
    return destination;
}

}
