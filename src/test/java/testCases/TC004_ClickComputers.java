package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Computers;
import testBase.BaseClass;

public class TC004_ClickComputers extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	
	public void clickCompLink() {
		logger.info("**********Started ClickComputersLink*************");
		try {
			Computers cp=new Computers(driver);
			cp.clicklogn();
			cp.entermail(pr.getProperty("emailId"));
			cp.enterpw(pr.getProperty("passw"));
			cp.clicklog();
			cp.clickComp();
			//System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers");
			
		}catch(Exception e) {
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("**********Completed ClickComputersLink*************");
		
	}

}
