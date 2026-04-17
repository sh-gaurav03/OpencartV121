package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.WebShop;
import testBase.BaseClass;

public class TC002_WebLoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		logger.info("*********WebShop-Login-Verification**********");
		try {
			WebShop wb=new WebShop(driver);
			wb.clicklogn();
			
			wb.entermail(pr.getProperty("emailId"));
			wb.enterpw(pr.getProperty("passw"));
			wb.clicklog();
			String c=wb.retText();
			Assert.assertEquals(c, "notesting@gmail.com","Login failed");
			wb.clicklogout();
		}catch(Exception e) {
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*********WebShop-Login-Completed**************");
		
	}

}
