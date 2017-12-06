package appium.sampleapp.cucumber_testng;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*Integrating TestNG with Cucumber*/
/*
 * Two runner classes examplify the available alternatives:

Let the runner inherit AbstractTestNGCucumberTests. Each scenario will then be executed as a separate TestNG test.
If the runner need to have another base class:
let the runner use the same structure as AbstractTestNGCucumberTests to make each scenario run as a separate TestNG test.
 * */

@RunWith(Cucumber.class)
@CucumberOptions (
monochrome = true,
features = "features",
plugin = {"pretty", "html:target/cucumber-html-report"}//,
//glue = " ",
//tags = "@testdiary"
)
public class CukesRunnerTest extends AbstractTestNGCucumberTests {

}
