package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebShop extends BasePage {
	
	public WebShop(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Log in']") 
	WebElement logn;
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement mail;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement log;
	
	@FindBy(xpath="//div[@class='header-links']//a[@class='account']")
	WebElement headacc;
	
	@FindBy(xpath="//div[@class='header-links']//a[@class='ico-logout']")
	WebElement logout;
	
	public void clicklogn() {
		logn.click();
	}
	
	public void entermail(String em) {
		mail.sendKeys(em);
	}
	
	public void enterpw(String pas) {
		pwd.sendKeys(pas);
	}
	
	public void clicklog() {
		log.click();
	}
	
	public String retText() {
		try {
			return headacc.getText();
		}catch(Exception e) {
			return null;
		}
	}
	
	public void clicklogout() {
		logout.click();
	}

}
