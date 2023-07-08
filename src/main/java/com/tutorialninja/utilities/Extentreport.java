package com.tutorialninja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tutorialsninja.pages.basepage;

public class Extentreport{
	public static ExtentReports GenerateExtentreports() {
	File filereport=new File(System.getProperty("user.dir")+"\\test-output\\extentreports.html");
	ExtentReports reports = new ExtentReports();
	ExtentSparkReporter sparkreporter=new ExtentSparkReporter(filereport);
	sparkreporter.config().setTheme(Theme.DARK);
	sparkreporter.config().getTimeStampFormat();
	sparkreporter.config().setReportName("RESULTS REPORT");
	sparkreporter.config().setDocumentTitle("TN automation report");
	sparkreporter.config().setTimeStampFormat("dd/MM/yyyy");
	reports.attachReporter(sparkreporter);
	Properties configProp=new Properties();

	File configfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
	FileInputStream fis;
	try {
		fis = new FileInputStream(configfile);
		configProp.load(fis);
		} 
	catch (Throwable e) {
	
		e.printStackTrace();
	}
	reports.setSystemInfo("Application url",configProp.getProperty("url"));
	reports.setSystemInfo("browsername",configProp.getProperty("browsername"));
	reports.setSystemInfo("username",configProp.getProperty("validemail"));
	reports.setSystemInfo("password",configProp.getProperty("validpassword"));
	
	return reports;
	


	
}
}
