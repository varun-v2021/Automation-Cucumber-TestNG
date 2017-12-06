package testng.tests;

import org.testng.*;

public class RetryAnalyser implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 4;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter < retryLimit)
		{
			counter++;
			return true; //re-executes a failed test case if this method returns true
		}
		return false; // false if doesn't want to retry
	}

}
