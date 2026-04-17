package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//a[normalize-space()='Shop'])[2]") WebElement shop;
	
	@FindBy(xpath="//input[@id='email']") WebElement email;
	
	@FindBy(xpath="//input[@id='password']") WebElement pass;
	
	@FindBy(xpath="//button[@id='loginBtn']") WebElement login;
	
	public void clickShop() {
		shop.click();
	}
	
	public void enterEmail(String em) {
		email.sendKeys(em);
	}
	
	public void enterPassword(String pw) {
		pass.sendKeys(pw);
	}
	
	public void clickLogin() {
		login.click();
	}

}
