package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	public static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			//ConfigDataProvider config = new ConfigDataProvider(); Don't need this after we have created object of 
			//ConfigDataProvider class in DataProviderFactory.java class, using class name and invoking its method
			//getConfig(),(which returns object of ConfigDataProvider),invoking getChromePath() on getConfig() or config object
			//will give me Chrome Driver, same will apply for IE driver
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			//ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.close();
	}

}
