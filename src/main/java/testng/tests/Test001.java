package testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {
	
	//RetryAnalyzer to execute a failed test again and again for a specified no of times
	//to make sure its actually failing everytime and not depending on environment changes
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void test1(){
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(false, true);
	}
}
