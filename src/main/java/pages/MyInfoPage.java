package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.StepBaseClass;

public class MyInfoPage extends StepBaseClass{
	
	@FindBy(linkText = "My Info")
	WebElement myInfoTitle;
	
	public MyInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyInfoTitle() {
		myInfoTitle.click();
	}
	
	
}
