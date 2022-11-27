package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.StepBaseClass;

public class LoginPage extends StepBaseClass{
	
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
	
	public void enterUser(String user) {
		username.sendKeys(user);
	}
	
	public void enterPass(String pass) {
		username.sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		username.click();
	}	

}
