package Day29;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListnerClassForDay28 implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		System.out.println("My test Started ...."+result.getName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("My test passed ........"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("My test Failed ....... "+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("My test Skipped .... "+result.getName());
	}
}
