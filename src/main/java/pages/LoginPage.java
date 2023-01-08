package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.StepBaseClass;
import test.UtilitiFile;

public class LoginPage extends StepBaseClass{
	UtilitiFile objUtilitiFile = new UtilitiFile();
	
	// Page Object Model - design pattern.
	
	
//	By username = By.xpath("");
	
	@FindBy(xpath = "//*[@name='username']")
	WebElement username;
	
	@FindBy(xpath = "//*[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	public void enterUser(String user) {
////		username.sendKeys(user);
//		objUtilitiFile.sendKeysWebElement(username, user);
//	}
//	
//	public void enterPass(String pass) {
////		username.sendKeys(pass);
//		objUtilitiFile.sendKeysWebElement(password, pass);
//	}
//	
//	public void clickLoginBtn() {
////		username.click();
//		objUtilitiFile.clickOnWebElement(loginBtn, 5);
//	}	
	String users = "Admin";
	String pass = "admin123";
	
	public void loginMethod() {
		objUtilitiFile.sendKeysWebElement(username, users);
		objUtilitiFile.sendKeysWebElement(password, pass);
		objUtilitiFile.clickOnWebElement(loginBtn, 5);
	}

}
