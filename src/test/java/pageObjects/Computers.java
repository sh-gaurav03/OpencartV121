package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Computers extends BasePage {
	
	public Computers(WebDriver driver) {
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
	
	@FindBy(xpath="//ul[@class='top-menu']//a[normalize-space()='Computers']") WebElement comp;
	
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
	
	public void clickComp() {
		comp.click();
	}

}
