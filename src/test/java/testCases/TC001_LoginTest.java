package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_LoginTest extends BaseClass{
	
	
	@Test
	public void pageLogin() {
		
		logger.info("*********Starting TC001_LoginTest******");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickShop();
			hp.enterEmail("demo@demo.com");
			hp.enterPassword("demo");
			hp.clickLogin();
			String b="https://shop.qaautomationlabs.com/shop.php";
			Assert.assertEquals(driver.getCurrentUrl(), b);
			
		}catch(Exception e) {
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*************Completed TC001_LoginTest********");
		
		
		
	}

	
	

}
