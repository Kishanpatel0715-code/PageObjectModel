package crm.qa.util;

import org.openqa.selenium.By;

import crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long page_load_timeout = 30;
	public static long implicitly_timeout = 20;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
