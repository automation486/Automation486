package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {
	WebDriver driver; 
	
	@BeforeMethod
	public void setUp()
	{
		driver = BrowserFactory.getBrowser("chrome"); //Open Browser
		driver.get(DataProviderFactory.getConfig().getApplicationURL()); //Open URL given in config.properties	
	}
	@Test
	public void testHomePage()
	{
		
		//Now because i am dealing with HomePage first so i will use Selenium's PageFactory class, invoke initElements method
		//on it which takes current driver and HomePage.class as parameters (wq:values we want to pass to HomePage to get HomePage working)
		HomePage home = PageFactory.initElements(driver, HomePage.class);//HomePage.class will return the object of HomePage.java class
		
		System.out.println("Home Page Title is: "+ home.getApplicationTitle());
		Assert.assertTrue(home.getApplicationTitle().contains("Avactis Demo"));
		
	}
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}
	

}
