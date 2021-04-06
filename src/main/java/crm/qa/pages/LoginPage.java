package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//This is my page factory or I can say that object repository!!!!!!!!!!
	//page factory or OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "(//img[@class='img-responsive'])[1]")
	WebElement CRMLogo;
	
	//initialize the page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//actions
	public String validateTitlePage() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMLogo() {
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
