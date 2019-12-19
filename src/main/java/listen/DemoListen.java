package listen;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

public class DemoListen implements ISuiteListener,ITestListener {

	@Override
	public void onFinish(ISuite arg0) {
		Reporter.log("Suite is Finished :"+arg0.getName(),true);
		
	}

	@Override
	public void onStart(ISuite arg0) {
		Reporter.log("Suite is started :"+arg0.getName(),true);
		
	}

	

	@Override
	public void onFinish(ITestContext arg0) {
		Reporter.log("TestBlock is Finished :"+arg0.getName(),true);
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		Reporter.log("TestBlock is started :"+arg0.getName(),true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Test is Failed :"+arg0.getName()+" "+arg0.getTestName(),true);
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is Skiped :"+arg0.getName(),true);
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test is started :"+arg0.getName(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Test is Passed :"+arg0.getName(),true);
		
	}

}
