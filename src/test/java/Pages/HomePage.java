package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//a[text()='Log In']")WebElement signInLink;
	@FindBy(xpath="//a[text()='My Account']")WebElement createAccountLink;
	
	
	public void signInLink()
	{
		signInLink.click();
	}
	public void createAnAccount()
	{
		createAccountLink.click();
	}
	public String getApplicationTitle()
	{
	return driver.getTitle();
	}

}
