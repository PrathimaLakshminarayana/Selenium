package com.selenium.hackathon.tests;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.hackathon.Utils.generalUtils;
import com.selenium.hackathon.pages.FreeTrailPage;
import com.selenium.hackathon.pages.homePage;
import com.selenium.hackathon.pages.loginPage;

public class homePageTest extends generalUtils {
	String data[][] = null ;
	SoftAssert sa = new SoftAssert();
	loginPage loginPO ;
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		generalUtils.InitializeDriver(browser);
		generalUtils.InitializeExtentReport();
		try {
			data = ReadXLData("C:\\Users\\prath\\Desktop\\SeleniumHackathon\\seleHackathondata.xlsx", "Sheet2");
		} catch (IOException e) {
			System.out.println("error  while reading from xlsx");
			e.printStackTrace();
		}

		loginPO = new loginPage(driver);
	}
	
	
	@Test
	public void logOutFunctionality() throws IOException{
	
	
		logger = report.startTest("Logout Functionality");
	    loginPage loginPO = PageFactory.initElements(driver,loginPage.class);
	    
	    enterText(loginPO.email(),data[2][1],"Email");
		enterText(loginPO.password(),data[2][2],"Password");
		clickObject(loginPO.login(),"LOgin");		
		sa.assertEquals(driver.getCurrentUrl().toString(),"https://go.xero.com/Dashboard/");
		homePage hPage = PageFactory.initElements(driver, homePage.class);
		clickObject(hPage.userInitials(),"USER INITIALS");
		clickObject(hPage.logout(),"Logout");
		sa.assertEquals(driver.getCurrentUrl().toString(),"https://login.xero.com/");		
		report.endTest(logger);
	}
	
	
	//
	
	/*@Test
	public void testAllTabs() throws IOException{			
		readExternalData();
		logger = report.startTest("Test all tabs page");		
		loginPage loginPO = PageFactory.initElements(driver,loginPage.class);
	    enterText(loginPO.email(),data[2][1],"Email");
		enterText(loginPO.password(),data[2][2],"Password");
		clickObject(loginPO.login(),"LOgin");		
		sa.assertEquals(driver.getCurrentUrl().toString(),"https://go.xero.com/Dashboard/");
	    
		homePage hPage = PageFactory.initElements(driver, homePage.class);
		clickObject(hPage.dashBoard(),"dashboard");
		
		clickObject(hPage.accounts(), "Accounts tab");
		//check for all drop down option I will done only two
		verifyExistense(hPage.bankAccounts(),"Bank Accounts" );
		verifyExistense(hPage.reports(), "reports");		
		logger.addScreenCapture(getScreenShot());
		
		clickObject(hPage.reports(), "reports");
		logger.addScreenCapture(getScreenShot());
		sa.assertEquals(driver.getCurrentUrl().toString(),"https://reporting.xero.com/!6KwZB/summary");
		
		clickObject(hPage.contacts(), "contacts");
		//check for all drop down option I will done only one
		verifyExistense(hPage.allContacts(),"All Contacts" );
		logger.addScreenCapture(getScreenShot());
		
		clickObject(hPage.companyName(),"Company name");
		clickObject(hPage.settings(), "settings");
		//please verify
		logger.addScreenCapture(getScreenShot());
		
		clickObject(hPage.plus(),"plus\new");
		verifyExistense(hPage.invoice(),"Invoice");
		
		clickObject(hPage.companyName(),"Company name");
		clickObject(hPage.files(), "Files");
				
		 report.endTest(logger);
		 closeReport();
				
	}
	
	*/
	

}
