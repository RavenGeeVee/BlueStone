package generic;

import java.time.LocalDate;
import java.time.LocalTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener implements ITestListener, IAutoConstants
{    LocalDate da = LocalDate.now();
     LocalTime te = LocalTime.now();
     Integer d = da.getDayOfMonth();
     Integer mon = da.getMonthValue();
     Integer y = da.getYear();
     Integer h = te.getHour();
     Integer min = te.getMinute();
     
     String text = d.toString()+mon.toString()+y.toString()+"#"+h.toString()+min.toString();
	
	 ExtentHtmlReporter reporter = new ExtentHtmlReporter(EXCEL_REPORT+text+".html");
     ExtentReports reports = new ExtentReports();
     ExtentTest test;
     
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = reports.createTest("Test");
		test.log(Status.PASS, result.getTestClass().getName().toString() + "-" + result.getName().toString()+ " Start");
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, result.getTestClass().getName().toString() + "-" + result.getName().toString()+ " Success");
     
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, result.getTestClass().getName().toString() + "-" + result.getName().toString());

	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.SKIP, result.getTestClass().getName().toString() + "-" + result.getName().toString());

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, result.getTestClass().getName().toString() + "-" + result.getName().toString());

	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, result.getTestClass().getName().toString() + "-" + result.getName().toString());

	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		;
		
		reporter.config().setDocumentTitle("BlueStone Execution");
		reporter.config().setReportName("Test Report");
		reporter.config().setTheme(Theme.STANDARD);
		
		reports.attachReporter(reporter);
		reports.setSystemInfo("Environment", "SIT");
		reports.setSystemInfo("Build", "Version 7.0");
		reports.setSystemInfo("Platform", "Windows 10 x64");
		reports.setSystemInfo("Engineer", "Admin");
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		reports.flush();
	}

}
