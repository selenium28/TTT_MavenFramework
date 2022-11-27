package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.StepBaseClass;
import pages.LoginPage;
import pages.MyInfoPage;

public class TestCaseExecution extends StepBaseClass{
	LoginPage objLoginPage;
	MyInfoPage objMyInfoPage;
	
	@BeforeTest
	public void start() {
		setup();
	}

	@Test (priority = 1)
	public void login() {
		String users = "Admin";
		String password = "admin123";

		objLoginPage = new LoginPage();
		objLoginPage.enterUser(users);
		objLoginPage.enterPass(password);
		objLoginPage.clickLoginBtn();
		
	}
	
	@Test (priority = 2)
	public void myInfo() {
		objMyInfoPage.clickMyInfoTitle();
//		Assert.assertEquals(false, false);
		
	}

	@AfterTest
	public void stop() {
		teardown();
	} 

}
