package appium.sampleapp.cucumber_testng;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
/*@CucumberOptions(format = { "pretty",
		"html:target/cucumber" }, features = "classpath:src/test/features/cucumberJava.feature")*/
@CucumberOptions(format = { "pretty",
"html:target/cucumber" }, features = "src/test/features")

public class cucumberJavaTest {

}