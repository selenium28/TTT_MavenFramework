package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import core.StepBaseClass;
import pages.LoginPage;
import pages.MyInfoPage;

public class TestCaseExecution extends StepBaseClass{
	LoginPage objLoginPage;
	MyInfoPage objMyInfoPage;
	ExtentHtmlReporter htmlRepoter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void start() {
		setup();
		htmlRepoter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport3/ExtentHTMLReport.html");	
		reports = new ExtentReports();
		reports.attachReporter(htmlRepoter);
		
		htmlRepoter.config().setChartVisibilityOnOpen(true);
		htmlRepoter.config().setDocumentTitle("OrangeHRM Automation Report");
		htmlRepoter.config().setReportName("Test Report");
		htmlRepoter.config().setTheme(Theme.DARK);	
		htmlRepoter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		
	}

	@Test (priority = 1)
	public void login() {
		test = reports.createTest("Passed");
		test.log(Status.INFO, "Test Case Start");
		test.assignCategory("P0");
		
		objLoginPage = new LoginPage();
		objLoginPage.loginMethod();
		
		String title = "OrangeHRM";
		Assert.assertEquals(title, driver.getTitle(),"Title is not matched");
		test.log(Status.INFO, "Test End");
		
	}
	
	@Test (priority = 2)
	public void myInfo() {
		test.log(Status.INFO, "Starting");
		test = reports.createTest("Test Case Two", "Testcase two is Failed ");
//		Assert.assertTrue(false);
		objMyInfoPage.clickMyInfoTitle();
		test.log(Status.INFO, "Test End");
		
	}
	
	@Test (priority = 3)
	public void test_case_3() {
//		test = reports.createTest("Test Case Three -- Passed");
		test.log(Status.INFO, "Test Case Start");
		test = reports.createTest("Test Case Three", "TestCase Three is skipped");
		throw new SkipException("This test Case has been skipped");
		
//		Assert.assertTrue(true);
	}

	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName());
		}
		else {
			test.log(Status.SKIP, result.getTestName());
		}
	}
	
	@AfterTest
	public void stop() {
	
		reports.flush();
		teardown();
	} 

}
