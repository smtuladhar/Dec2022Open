package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvocationTest {

@Test(invocationCount=5)	
	public void testInvocation() {

	System.setProperty("webdriver.gecko.driver", 
			"C:\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	driver.get("https://admin-demo.nopcommerce.com/login");
	
	String title;
	title=driver.getTitle();

	Assert.assertEquals("Your store. Login",title,"titles mismatched");
	driver.quit();
}
}

