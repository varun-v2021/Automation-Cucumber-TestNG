package testng.dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	private static WebDriver driver;
	
	@DataProvider(name = "Authentication")
	public static Object[][] method1(){
		return new Object[][] {{"testUser1","Test@123"},{"testUser2","Test@100"}};
	}
	
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\varun_venkatesh\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	      driver.get("http://www.store.demoqa.com");	 
	      
	      driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	 
	      driver.findElement(By.id("log")).sendKeys(sUsername);
	 
	      driver.findElement(By.id("pwd")).sendKeys(sPassword);
	 
	      driver.findElement(By.id("login")).click();
	 
	      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	 
	      driver.quit();
	}
	
}
