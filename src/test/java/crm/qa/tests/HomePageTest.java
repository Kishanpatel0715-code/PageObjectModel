package crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.base.TestBase;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void validateHomePageTitleTest() {
			String title = homePage.validateHomePageTitle();
			Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test
	public void validateContactUserTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.validateContactUser());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
