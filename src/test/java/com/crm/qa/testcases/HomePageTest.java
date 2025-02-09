package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	
	public HomePageTest()
	
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 loginpage = new LoginPage();
		 testutil = new TestUtil();
		  contactpage = new ContactsPage();
		homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	     
	}
	
	@Test(priority = 2)
	public void verifyHomepageTitle()
	{
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepagetitle not mached");
	}
	
	
	@Test(priority = 1)
	public void validateUser()
	{
		testutil.switchFrame();
		boolean userloggedname = homepage.verifyUser();
		Assert.assertTrue(userloggedname);
	}
	
	@Test(priority = 3)
	public void verifycontactlink()
	{
		testutil.switchFrame();
		contactpage = 	homepage.clickContact();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
