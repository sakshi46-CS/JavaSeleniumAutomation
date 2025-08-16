package Utils;

import POM.Demologin;

public class finaltest extends basetest {
 public void validlogintest() {
	 Demologin login=new Demologin(driver);
	 login.login("admin", "admin123");
 }
}
