package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase()

	{

		try {

			prop = new Properties();
			File file = new File("C:\\Users\\kusha\\eclipse-workspace2024\\FreeCRMByNaveen\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);			

		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public static void initialization()
	
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implisit_wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_load_timeout));
		driver.get(prop.getProperty("url"));
	}

}
