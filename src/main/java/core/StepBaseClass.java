package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class StepBaseClass {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public static void setup() {
		  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      

	}

	@AfterMethod
	public static void teardown() {
		
		driver.quit();

	}


}
