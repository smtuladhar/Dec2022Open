package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver= new FirefoxDriver();
	}
	
	@Test(dataProvider="dp1")
	public void testDataProvider(String uname,String pass) throws InterruptedException {
		

		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.findElement(By.id("Email")).clear();
		
		driver.findElement(By.id("Email")).sendKeys(uname);
		
		driver.findElement(By.id("Password")).clear();
		
		driver.findElement(By.id("Password")).sendKeys(pass);
		
		

		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	
//		Thread.sleep(5000);
		
		String title;
		title=driver.getTitle();
		
		System.out.println(title);
		Assert.assertEquals("Dashboard / nopCommerce administration",title,"titles mismatched");
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
	
	@DataProvider(name="dp1")
	Object[][]  loginData() {
		
		Object data[][]= {{"admin@yourstore.com","admin"},
						{"admin@yourstore1.com","admin"},
						{"admin@yourstore.com","admin1"}};
		
		return data;
				
		}
		
	}
	

