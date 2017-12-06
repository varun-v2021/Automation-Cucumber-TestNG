package appium.testobject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testobject.appium.junit.TestObjectTestResultWatcher;
import org.testobject.rest.api.appium.common.TestObject;
import org.testobject.appium.junit.TestObjectAppiumSuite;

//@TestObject(testObjectApiKey = "C5734DB513204E3588440085869A9B8B"/*, testObjectSuiteId = 12345*/)
//@RunWith(TestObjectAppiumSuite.class)
public class App {
	private static final String JavascriptExecutor = null;
    //public WebDriver driver = null;
    public AppiumDriver driver = null;
    
    private static Logger log = Logger.getLogger(App.class);
    
    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();
    
    @BeforeMethod
    public void setUp() throws Exception {
   
    	System.out.println("Executing add contacts application setup");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("testobject_api_key", "C5734DB513204E3588440085869A9B8B");
        //capabilities.setCapability("testobject_test_report_id", resultWatcher.getTestReportId());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("testobject_device", "LG_Nexus_5X_free");
        capabilities.setCapability("appiumVersion","1.6.5");
        //capabilities.setCapability("phoneOnly", "false");
        //capabilities.setCapability("tabletOnly", "false");
        //capabilities.setCapability("privateDevicesOnly", "false");
        capabilities.setCapability("testobject_app_id",3);
        //driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("https://us1.appium.testobject.com/wd/hub"), capabilities);
        //driver = new AndroidDriver<WebElement>(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);
        //driver = new AndroidDriver<WebElement>(TestObjectCapabilities.TESTOBJECT_APPIUM_ENDPOINT, capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        resultWatcher.setAppiumDriver(driver);
        driver.launchApp();
        log.info(testName.getMethodName() + " STARTING - Live view: " + driver.getCapabilities().getCapability("testobject_test_live_view_url"));
    }
    
    
    
	@AfterMethod
	public void tearDown() {
		// The watcher will take care of quitting the driver.
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test
    public void addContactTest() throws InterruptedException {
    	  
        WebElement button = driver.findElement(By.className("android.widget.Button"));
        button.click();
        driver.getScreenshotAs(OutputType.FILE);
        List<WebElement> textFieldsList = driver.findElements(By.className("android.widget.EditText"));
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.getScreenshotAs(OutputType.FILE);
        button.click();
        driver.getScreenshotAs(OutputType.FILE);

    }	
}
