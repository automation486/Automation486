package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro; 
	public ConfigDataProvider() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: "+e.getMessage());
		}
	}
	public String getChromePath()
	{
		String ChromePath = pro.getProperty("ChromePath");
		return ChromePath;
	}
	public String getIEPath()
	{
		String IEPath = pro.getProperty("IEPath");
		return IEPath;
	}
		
		public String getApplicationURL()
		{
			String URL = pro.getProperty("URL");
			return URL;
		}

}
