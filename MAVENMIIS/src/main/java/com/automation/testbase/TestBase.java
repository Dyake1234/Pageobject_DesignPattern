package com.automation.testbase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.excelhelper.ExcelDriven;



public class TestBase extends Driver{
	
	ExcelDriven excel;
	
	
	private static Logger Log = LogManager.getLogger(TestBase.class.getName());

	public WebDriver Initializer() throws IOException, InterruptedException 
	{
		 loadFile();
		 
		if(prop.getProperty("mode").equals("local"))
		{
		
			Log.info("Initializing LocalDriver");
			driver = LocalDriver();

		}
		 
		else if(prop.getProperty("mode").equals("remote"))
		{
			Log.info("Initializing RemoteDriver");
			driver = RemoteDriver();
		}
		
		return driver;
	}
	
	public void getScreenshot(String methodname, String folder)
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\takescreenshot\\"+folder+"\\"+methodname+".png"));
			Log.debug("Captured Screenshot");
		} catch (IOException e) 
		{
				Log.info(e.getMessage());
		}
		
	}
	public void navigateToBaseURL()
	{
		driver.get(prop.getProperty("url")); 
		Log.info("Navigated to BaseURL");
	}
	
	public void closedriver()
	{
		driver.quit();
		driver = null;
	}
	
	
	public String[][] getData(String excelname, String sheetname)
	{
		loadFile();
		String path = System.getProperty("user.dir")+prop.getProperty("Excelpath")+excelname;
		excel = new ExcelDriven(path, sheetname);   //path of excel and sheetname
		return	excel.DataProviderExcel();
	}
	
	

}
