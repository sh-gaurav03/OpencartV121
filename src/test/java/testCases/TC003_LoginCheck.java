package testCases;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.WebShop;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;


public class TC003_LoginCheck extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void checkLogin(String email,String pwd,String res) throws IOException {
		
		logger.info("********Started TC003_LoginCheck********");
		try {
			WebShop ws=new WebShop(driver);
			ws.clicklogn();
			ws.entermail(email);
			ws.enterpw(pwd);
			ws.clicklog();
			String c=ws.retText();
			boolean fg=true;
			if(c==null || c.isEmpty() || !c.equals(email)) {
				fg=false;
			}
			
			if(res.equalsIgnoreCase("valid")) {
				if(fg==true) {
					ws.clicklogout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}
			if(res.equalsIgnoreCase("invalid")) {
				if(fg==true) {
					ws.clicklogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("********Finished TC003_LoginCheck********");
		
	}
	
	

}
