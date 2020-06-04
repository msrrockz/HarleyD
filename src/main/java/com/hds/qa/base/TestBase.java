package com.hds.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hds.qa.utils.TestUtil;
import com.hds.qa.utils.WebEventListener;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public  static EventFiringWebDriver ef_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\MadhuCeeti\\Eclipse_Workspace_JavaTraining\\HarleyDavidson\\src\\main\\java\\com\\hds\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browser = prop.getProperty("Browser");
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		ef_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		ef_driver.register(eventListener);
		driver = ef_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("URL"));
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);	
		
	}

}
