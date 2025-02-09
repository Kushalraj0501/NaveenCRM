package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage HomePage;
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{

		initialization();
		loginpage = new LoginPage();

	}
	
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginpage();
		AssertJUnit.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
		
		
	}
	
	@Test(priority = 2)
	public void CRMLogoTest()
	
	{
		
		boolean logo = loginpage.validateCRMlogo();
		SoftAssert asssert = new SoftAssert();
		asssert.assertTrue(logo);
		System.out.println("Soft assert failed");
		asssert.assertAll();
	}
	
	@Test(priority = 3)
	public void login()
	
	{
		
		HomePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 4)
	public void verifyLoggedin()
	{
		String homepagetitle = HomePage.verifyHomePageTitle();
		
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepagetitle not mached");
		System.out.println("Hard assert failed");
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
