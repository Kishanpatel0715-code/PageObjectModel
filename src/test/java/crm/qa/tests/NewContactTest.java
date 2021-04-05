package crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.base.TestBase;
import crm.qa.pages.ContactPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.util.TestUtil;

public class NewContactTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;

	public NewContactTest() {
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

	@Test
	public void createNewContactTest() {
		homePage.clickOnNewContactLink();
		contactPage.createNewContact("Mr.", "nilu", "patel", "gooooogle");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
