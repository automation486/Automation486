package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver)   //driver is coming from LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	{
		this.driver=driver;
	}
	@FindBy(xpath=".//*[@id='account_sign_in_form_email_id']")WebElement username;
	@FindBy(name="passwd")WebElement password;
	@FindBy(id="send2")WebElement signInButton;
	
	//@FindBy(xpath="//a[text()='Log Out']")WebElement logoutText;
	
	By logout = By.xpath("//a[text()='Log Out']");
	public void loginApplication(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		signInButton.click();
	}
	public void verifyLogoutLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(logout));
		String linkText = ele.getText();
		Assert.assertTrue(linkText.contains("Log Out"),"Logout link Text not found.");
	}
	

}
