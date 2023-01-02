package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parawithout {

	

		
		
		@Test
		public void test1() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		
	
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.findElement(By.id("Email")).clear();
		
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.id("Password")).clear();
		
		driver.findElement(By.id("Password")).sendKeys("axdmin");
		
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		driver.close();
		driver.quit();
	}
	
}
