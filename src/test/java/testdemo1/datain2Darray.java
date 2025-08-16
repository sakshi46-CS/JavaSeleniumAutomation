package testdemo1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datain2Darray {
	   // Test method consumes DataProvider
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Running test with: " + username + " | " + password);
    
}
@DataProvider(name = "loginData")
public Object[][] getData() {
    return new Object[][] {
        {"admin", "admin123"},
      {"admin", "admin123"},
{"admin", "admin123"}
    };
}

}
