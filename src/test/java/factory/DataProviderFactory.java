package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	//Create object of ConfigDataProvider in this class using following method, so i don't have to create
	//objects of ConfigDataProvider over and over to access its methods
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	//Create object of ExcelDataProvider in this class using following method, so i don't have to create
	//objects of ExcelataProvider over and over to access its methods
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}

}
