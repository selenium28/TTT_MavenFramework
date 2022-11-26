package core;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ExtentReport {
	WebDriver driver;
	ExtentHtmlReporter htmlRepoter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() {
		
		htmlRepoter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/ExtentHTMLReport.html");	
		reports = new ExtentReports();
		reports.attachReporter(htmlRepoter);
		
		htmlRepoter.config().setChartVisibilityOnOpen(true);
		htmlRepoter.config().setDocumentTitle("OrangeHRM Automation Report");
		htmlRepoter.config().setReportName("Test Report");
		htmlRepoter.config().setTheme(Theme.DARK);	
		htmlRepoter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
			
	}

	@Test
	public void test_case_1() {
		test = reports.createTest("Passed");
		test.log(Status.INFO, "Test Case Start");
		test.assignCategory("P0");
		
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String title = "OrangeHRM";
		Assert.assertEquals(title, driver.getTitle(),"Title is not matched");
		test.log(Status.INFO, "Test End");
	}

	@Test
	public void test_case_2() {
//		test = reports.createTest("Test Case Two -- Failed");
		test.log(Status.INFO, "Starting");
		test = reports.createTest("Test Case Two", "Testcase two is Failed ");
		Assert.assertTrue(false);
	}

	@Test
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
	public void afterTest() {
		
		reports.flush();
		driver.close();
	}

}
