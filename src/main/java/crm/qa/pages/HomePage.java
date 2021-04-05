package crm.qa.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//page factory or Object repository
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement UserName;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//initialize page factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//action
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateContactUser() {
		return UserName.isDisplayed();
	}
	
	public ContactPage contactLink() {
		ContactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage dealLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
	}
	
}
