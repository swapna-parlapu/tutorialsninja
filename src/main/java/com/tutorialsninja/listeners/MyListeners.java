package com.tutorialsninja.listeners;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialninja.utilities.Extentreport;
import com.tutorialninja.utilities.utilities;
import com.tutorialsninja.pages.basepage;
public class MyListeners extends basepage implements ITestListener{
	ExtentReports reports;
	ExtentTest extenttest;
	
	

	public void onStart(ITestContext context) {
		
		reports=Extentreport.GenerateExtentreports();
	}

	public void onTestStart(ITestResult result) {
		String testname=result.getName();
		extenttest=reports.createTest(testname);
		extenttest.log(Status.INFO, testname);
		System.out.println(testname+" start executing");
	
		}

	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		extenttest=reports.createTest(testname);
		extenttest.log(Status.PASS, testname);
		System.out.println(testname+" sucessfully exceuted");
		
	}

	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		TakesScreenshot scnshot=(TakesScreenshot)driver;
		File original=scnshot.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png";		
		try {
			FileHandler.copy(original, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.addScreenCaptureFromPath(dest);
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.FAIL,result.getName()+" got failed");
		
	
	}

	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		extenttest.log(Status.SKIP, testname);
	
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}
		
	}
	
