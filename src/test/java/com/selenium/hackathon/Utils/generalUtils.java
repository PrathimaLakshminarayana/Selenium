package com.selenium.hackathon.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class generalUtils {
	static public WebDriver driver;
	static public ExtentReports report;
	static public ExtentTest logger;
	
	
	
	
	
	

	public static void InitializeDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\prath\\Desktop\\SeleniumHackathon\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			String FireFoxDriverPath = "C:\\Users\\prath\\Desktop\\SeleniumHackathon\\geckodriver-v0.24.0-win32\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FireFoxDriverPath);
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("no browser setup");
		}
	}

	public static void InitializeExtentReport() {

		String fileName = new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\prath\\Desktop\\SeleniumHackathon\\" + fileName;
		report = new ExtentReports(path);
	}
	
	public static void closeReport() {
		driver.quit();
		report.flush();
	}
	
	public static void verifyExistense(WebElement obj, String objName) {
		if (obj != null) {

			logger.log(LogStatus.INFO, objName + " is Exists");
		} else {
			logger.log(LogStatus.ERROR, objName + " is not Existense in application");
		}
	}
	public static void selectDropDown(WebElement obj, String text) {
		if (obj.isDisplayed()) {
			Select drpdwn = new Select(obj);
			drpdwn.selectByVisibleText(text);
			logger.log(LogStatus.INFO, text + " is Selected");
		} else {
			logger.log(LogStatus.ERROR, text + " is not displayed. Please check your application");
		}

	}
	
	public static String getScreenShot() throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = "C:\\Users\\prath\\Desktop\\SeleniumHackathon\\" + "FailedTestsScreenshots\\" + "ScreenShot"
				+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	public static void enterText(WebElement obj, String textVal, String objName) {
		if (obj.isDisplayed()) {
			obj.sendKeys(textVal);
			 logger.log(LogStatus.INFO, textVal + " is entered in " + objName
			 + " textfield");
		} else {
			 logger.log(LogStatus.ERROR, objName + " is not displayed, Please check your application");
		}
	}

	
	public static void errorMsgValidation(String objMsg, String reqMsg) throws IOException {
		if (objMsg != null) {
			if (objMsg.contains(reqMsg)) {
				logger.log(LogStatus.INFO, objMsg + " is the correctly displayed",
						logger.addScreenCapture(getScreenShot()));
			} else {
				logger.log(LogStatus.ERROR, objMsg + " is the wrongly displayed",
						logger.addScreenCapture(getScreenShot()));
			}
		} else {
			logger.log(LogStatus.ERROR, objMsg + " is the not displayed");
		}
	}
	
	
	public static void clickObject(WebElement obj, String objName) {
		if (obj.isDisplayed()) {
			obj.click();
			logger.log(LogStatus.INFO, objName + " is Clicked");
		} else {
			 logger.log(LogStatus.ERROR, objName + " is not displayed. Please check your application");
		}
	}

	public static String[][] ReadXLData(String filePath, String sheetName) throws IOException {

		File file = new File(filePath);
		FileInputStream fIP = new FileInputStream(file);

		// Get the workbook instance for XLSX file
		XSSFWorkbook workbook = new XSSFWorkbook(fIP);
		XSSFSheet spreadsheet = workbook.getSheet(sheetName);

		int rowCount = spreadsheet.getLastRowNum() + 1;
		int colCount = spreadsheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				if (spreadsheet.getRow(i).getCell(j) != null) {
					data[i][j] = String.valueOf(spreadsheet.getRow(i).getCell(j));
				}

			}
		}
		fIP.close();

		return data;

	}

	public static void write(String filePath, String sheetName, int row) throws IOException {
		File file = new File(filePath);
		FileInputStream fIP = new FileInputStream(file);

		// Get the workbook instance for XLSX file
		XSSFWorkbook workbook = new XSSFWorkbook(fIP);
		XSSFSheet spreadsheet = workbook.getSheet(sheetName);

		XSSFRow row1 = spreadsheet.getRow(row);

		Cell cell = row1.createCell(1);
		cell.setCellValue("tested");

		XSSFCellStyle cellStyle = workbook.createCellStyle();

		// important to close InputStream
		fIP.close();
		// Open FileOutputStream to write updates
		FileOutputStream output_file = new FileOutputStream(
				new File("C:\\Users\\prath\\Desktop\\DataDrivenTesting_Result.xlsx"));
		// write changes
		workbook.write(output_file);

		// close the stream
		output_file.close();

	}

}
