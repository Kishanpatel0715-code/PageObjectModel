package crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm.qa.base.TestBase;

public class ContactPage extends TestBase{

	//page factory - object repository
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactLogo;
	
	@FindBy(name = "first_name")
	WebElement firstname;
	
	@FindBy(name = "surname")
	WebElement lastname;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save' ]")
	WebElement saveBtn;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactLogo() {
		return ContactLogo.isDisplayed();
	}
	
	public void selectSingleName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
				+ "//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fname,String lname,String com) {
		Select s = new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(com);
		saveBtn.click();
		
		
	}
	
	
}
