package com.sap.timp.base;

import java.io.*;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DevopsMain {

	String result = "";
	InputStream inputStream;
	
	public static WebDriver driver;
	
	public WebDriver initialization() {

		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-extensions");
        
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		return driver;
	}
 
	public String getPropValues() throws IOException {
 
		//	Properties prop = new Properties();
			String propFileName = "parameter.properties";
			String parent = System.getProperty("user.dir");
			String filePath = parent+ "\\" +propFileName;
			System.out.println("filepath "+filePath);
			 FileInputStream fis = null;
		      Properties prop = null;
		      try {
		         fis = new FileInputStream(filePath);
		         prop = new Properties();
		         prop.load(fis);
		      } catch(FileNotFoundException fnfe) {
		         fnfe.printStackTrace();
		      } catch(IOException ioe) {
		         ioe.printStackTrace();
		      } finally {
		         fis.close();
		      }
		      
		     result = prop.getProperty("url");
	//	result = "https://coronadev-forgiving-badger-ft.cfapps.us10.hana.ondemand.com/";
		return result;
	}
}
