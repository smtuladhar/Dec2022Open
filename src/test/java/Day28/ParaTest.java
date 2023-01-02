package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParaTest {

	WebDriver driver;
	@Test(priority=1)
	@Parameters( {"browser"})
	void LaunchApp(String br) {
		if( br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();	
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
				driver.get("https://admin-demo.nopcommerce.com/login");
	}
	@Test(priority=2, dependsOnMethods= {"LaunchApp"})
	void Login() throws InterruptedException {
		driver.findElement(By.id("Email")).clear();
		
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.id("Password")).clear();
		
		driver.findElement(By.id("Password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		Thread.sleep(2000);
		String actitle=driver.getTitle();
		
		System.out.println("Actual title:"+actitle);
		if(actitle.equals("Dashboard / nopCommerce administration")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
	
	
	@Test(priority=3,dependsOnMethods= {"Login"})
	void Logout() throws InterruptedException {
		driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();
		Thread.sleep(2000);
	}
	@Test(priority=4,dependsOnMethods= {"Logout"})
	void close () {
		driver.close();
	}

}
