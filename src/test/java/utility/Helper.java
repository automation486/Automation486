package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName)
	
	{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String dest = "C:\\Users\\Rai\\workspace\\NewFramework\\com.automation.hybrid\\Screenshots"+screenshotName+System.currentTimeMillis()+".png";
	try {
		FileUtils.copyFile(src, new File(dest));
	} catch (IOException e) {
		System.out.println("Faailled to capture the Screeshot." +e.getMessage());
	}
	return dest;
	
	}

}
