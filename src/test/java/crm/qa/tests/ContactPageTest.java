package crm.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.base.TestBase;
import crm.qa.pages.ContactPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;
	
	
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.contactLink();
		
	}
	
	@Test(priority = 1)
	public void validateContactLogoTest() {
		boolean flag = contactPage.validateContactLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	public void selectSingleNameTest() throws InterruptedException {
		contactPage.selectSingleName("Chandru Selvam");
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void selectMultipleNameTest() throws InterruptedException {
		contactPage.selectSingleName("bmala t");
		Thread.sleep(2000);
		contactPage.selectSingleName("David Cris");
		Thread.sleep(2000);
		contactPage.selectSingleName("David Morton");
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority = 4)
	public void createNewContactTest() {
		homePage.clickOnNewContactLink();
		contactPage.createNewContact("Mr.", "kishan", "patel", "google");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
