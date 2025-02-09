package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

public class WebEventListener  extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		String testname = result.getName();
		System.out.println(testname +""+ "Test started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname +""+ "Test finished");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname +""+ "failure");
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String sspath = System.getProperty("user.dir")+"\\screenshot\\"+testname+".png";
	try {
		FileUtils.copyFile(file, new File (sspath) );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		String testname = context.getName();
		System.out.println(testname +""+ "Test class started by first ");
	}

	@Override
	public void onFinish(ITestContext context) {
		String testname = context.getName();
		System.out.println(testname +""+ "Test class finish by first ");
	}

	
	
	
}
