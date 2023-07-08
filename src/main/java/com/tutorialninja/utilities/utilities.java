package com.tutorialninja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;



public class utilities {
	public final static int WAIT_TIME=120;
	public static final int PAGE_WAIT_TIME=120;
	public static final int Explicitwait=30;
	public static WebDriverWait wait=null;
	public static JavascriptExecutor js;
	public static  String generateEmailWithTimeStamp()
	{
		
		String tilestamp=java.time.LocalTime.now().toString().replace(":", "").replace(".", "");
		return "swapnaparlapu02081993"+tilestamp+"@gmail.com";
	}
	public static Object[][] testdatafromexcel(String sheetname) {
		XSSFWorkbook workbook=null;
		File excelfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\tutorialninjatestdata.xlsx");
		try
		{
			FileInputStream fis=new FileInputStream(excelfile);
			workbook=new XSSFWorkbook(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		 
		XSSFSheet sheet=workbook.getSheet(sheetname);
		int rows=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rows][col];

		for(int i=0;i<rows;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<col;j++)
			{
				XSSFCell cell=row.getCell(j);
				CellType celltype=cell.getCellType();

				switch(celltype) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;	
		
				}
				
			}
		}
		return data;
																																																																																																																																																																																																																																																	
		
	}
	public static Object[][] validtestdatafromexcel(String Sheetname)
	{
		XSSFWorkbook wb=null;
		File excelfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\loginvalidcrendencial.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(excelfile);
			wb=new XSSFWorkbook(fis);
		} catch ( Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=wb.getSheet(Sheetname);
		int rows=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rows][col];

		for(int i=0;i<rows;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<col;j++)
			{
				XSSFCell cell=row.getCell(j);
				CellType celltype=cell.getCellType();

				switch(celltype) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;	
		
				}
		
					}
		}
		
		return data;
		
	}
public static String captureScreenshot(WebDriver driver,String testName) {
	File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	
	try {
		FileUtils.copyFile(srcScreenshot,new File(destinationScreenshotPath));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return destinationScreenshotPath;	
		
}
public static WebElement getwebdriverwait(WebDriver driver,WebElement ele) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(Explicitwait));
	return wait.until(ExpectedConditions.visibilityOf(ele));
	
}
public static JavascriptExecutor getjavascriptexceutor(WebDriver driver)
{
	return js = (JavascriptExecutor) driver;
	
}
}


