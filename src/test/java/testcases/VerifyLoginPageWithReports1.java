package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReports1 {
	
	WebDriver driver; 
	ExtentReports reports;
	ExtentTest test;
	HomePage home;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		reports=new ExtentReports(".\\Reports\\LoginPageReport.html",true);//Create report and replace new with old (i-e,true)
		test =reports.startTest("Login Functionality Test");
		
		
		driver = BrowserFactory.getBrowser("chrome"); //Open Browser
		test.log(LogStatus.INFO, "Browser is opened");
		driver.get(DataProviderFactory.getConfig().getApplicationURL()); //Open URL given in config.properties
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "URL is opened");
	}
	@Test
	public void testHomePage()
	{
		
		//Now because i am dealing with HomePage first so i will use Selenium's PageFactory class, invoke initElements method
		//on it which takes current driver and HomePage.class as parameters (wq:values we want to pass to HomePage to get HomePage working)
		home = PageFactory.initElements(driver, HomePage.class);//HomePage.class will return the object of HomePage.java class
		
		System.out.println("Home Page Title is: "+ home.getApplicationTitle());
		Assert.assertTrue(home.getApplicationTitle().contains("Avactis Demo"));
		test.log(LogStatus.PASS,test.addScreenCapture(Helper.captureScreenshot(driver, "TitleisValidated")));
		test.log(LogStatus.INFO, "Home Page Title is Validated");
		
		
		//test.addScreenCapture(Helper.captureScreenshot(driver, "LougOutTextLinkValidation"));
		//test.log(LogStatus.PASS, "Link Text is validated.",test.addScreenCapture(Helper.captureScreenshot(driver, "LougOutTextLinkValidation")));
		
		home.signInLink(); //Click on signIn link on home page to proceed to loginIn page from home page
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);//LoginPage.class, because i am dealing with LoginPage class now
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		login.verifyLogoutLink();
		test.log(LogStatus.PASS, "Link Text is validated.");
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)  //Screenshots of failed testcases
		{
		String path = Helper.captureScreenshot(driver, result.getName());
		test.log(LogStatus.FAIL, test.addScreenCapture(path));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String path = Helper.captureScreenshot(driver, result.getName());
			test.log(LogStatus.PASS, test.addScreenCapture(path));	
		}
		
	}
	@AfterClass
	public void testClose()
	{
		BrowserFactory.closeBrowser(driver);
		reports.endTest(test);
		reports.flush();
	}

}
