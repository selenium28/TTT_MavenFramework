package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class StepBaseClass {
	
	public static WebDriver driver;
	ExtentTest test;
	
	@BeforeMethod
	public static void setup() {
		  System.setProperty("webdriver.chrome.driver", "Driverss/chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      

	}

	@AfterMethod
	public static void teardown() {
		
		driver.quit();

	}
	
//	@AfterMethod
//	public void getResult(ITestResult result) {
//		if(result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL,result.getThrowable());
//		}
//		else if(result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, result.getTestName());
//		}
//		else {
//			test.log(Status.SKIP, result.getTestName());
//		}
//	}


}
