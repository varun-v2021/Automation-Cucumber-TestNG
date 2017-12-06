package appium.sampleapp.cucumber_testng;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/*
 * Integrating Cucumber with Selenium
 * */
public class cucumberJava { 
   WebDriver driver = null; 
	
   @Given("^I have open the browser$") 
   public void openBrowser() { 
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\varun_venkatesh\\workspace\\cucumber\\resources\\chromedriver.exe");
	   driver = new ChromeDriver();
   } 
	
   @When("^I open Facebook website$") 
   public void goToFacebook() { 
      driver.navigate().to("https://www.facebook.com/");
   } 
	
   @Then("^Login button should exits$") 
   public void loginButton() { 
      if(driver.findElement(By.id("u_0_v")).isEnabled()) { 
         System.out.println("Test Passed"); 
      } else { 
         System.out.println("Test Failed"); 
      } 
      driver.close(); 
   } 
}
