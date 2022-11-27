package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunClass extends StepBaseClass{

	@BeforeTest
	public void start() {
		setup();
	}

	@Test (priority = 1)
	public void login() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test (priority = 2)
	public void dashboard() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	@AfterTest
	public void stop() {
		teardown();
	}


}
