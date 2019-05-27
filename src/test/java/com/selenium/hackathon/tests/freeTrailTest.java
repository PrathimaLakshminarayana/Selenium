package com.selenium.hackathon.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.hackathon.Utils.generalUtils;
import com.selenium.hackathon.pages.FreeTrailPage;
import com.selenium.hackathon.pages.loginPage;

public class freeTrailTest extends generalUtils{
	
	
	String data[][] = null ;
	SoftAssert sa = new SoftAssert();
	FreeTrailPage ftPage;
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

		ftPage = new FreeTrailPage();

	}
	
	//Sign Up to XDC
		@Test(enabled = false)
		public void A_SignUpToXDC() throws IOException{			
			
			logger = report.startTest("Sign Up to XDC");
		  
			FreeTrailPage ftPage = PageFactory.initElements(driver, FreeTrailPage.class);
			clickObject(ftPage.tryFree(), "Try free button");
			enterText(ftPage.firstName(),data[1][1],"FirstName");
			enterText(ftPage.lastName(),data[2][1],"LastName");
			enterText(ftPage.emailAddress(),data[3][1],"EmailAddress");
			enterText(ftPage.phoneNumber(),data[4][1],"PhoneNumber");
			clickObject(ftPage.country(), "country");
			selectDropDown(ftPage.country(),"United States" );
			clickObject(ftPage.captcha(), "captcha");
			clickObject(ftPage.termsCheck(), "termsCheck");
			clickObject(ftPage.getStartedButton(), "Get Started");
			 report.endTest(logger);
					
		}
		
		
		//Sign Up to XDC
		@Test (enabled = false)
		public void B_SignUpToXDC() throws IOException{			
			
			logger = report.startTest("Sign Up to XDC with information");
		  
			FreeTrailPage ftPage = PageFactory.initElements(driver, FreeTrailPage.class);
			clickObject(ftPage.tryFree(), "Try free button");
			
			clickObject(ftPage.getStartedButton(), "Get Started");
			errorMsgValidation(ftPage.missingFirstName().getText(),"First name can't be empty");
			errorMsgValidation(ftPage.missingLastName().getText(),"Last name can't be empty");
			errorMsgValidation(ftPage.missingemailAddress().getText(),"Email address can't be empty");
			errorMsgValidation(ftPage.missingPhone().getText(),"Phone number can't be empty");
			enterText(ftPage.emailAddress(),data[3][2],"EmailAddress");
			errorMsgValidation(ftPage.missingemailAddress().getText(),"Email address is invalid");
			clickObject(ftPage.getStartedButton(), "Get Started");
			//check if check box is hignlightned
			 report.endTest(logger);
					
		}
	
		
		@Test
		public void C_SignUpToXDC() throws IOException{			
			
			logger = report.startTest("Sign Up to XDCto check term of use And privacy policy");		  
			FreeTrailPage ftPage = PageFactory.initElements(driver, FreeTrailPage.class);
			clickObject(ftPage.tryFree(), "Try free button");
			clickObject(ftPage.termsOfUse(), "Terms of use");
			logger.addScreenCapture(getScreenShot());
			sa.assertEquals(driver.getCurrentUrl().toString(),"https://www.xero.com/us/about/terms/");			
			clickObject(ftPage.privacyNotice(),"privacy notice");
			logger.addScreenCapture(getScreenShot());
			sa.assertEquals(driver.getCurrentUrl().toString(),"https://www.xero.com/us/about/privacy/");
			driver.quit();
			report.endTest(logger);
					
		}
		
		
		@Test
		public void D_SignUpToXDC() throws IOException{			
			
			logger = report.startTest("Sign Up to XDCto check offer details");		  
			FreeTrailPage ftPage = PageFactory.initElements(driver, FreeTrailPage.class);
			clickObject(ftPage.offerDetials(), "Offer Details");
			
			logger.addScreenCapture(getScreenShot());
			sa.assertEquals(driver.getCurrentUrl().toString(),"https://www.xero.com/us/signup/offer-details/");			
			report.endTest(logger);
					
		}
		
		
		@Test
		public void E_SignUpToXDC() throws IOException{			
			
			logger = report.startTest("Sign Up to XDCto check accountantOrBookkeeper");		  
			FreeTrailPage ftPage = PageFactory.initElements(driver, FreeTrailPage.class);
			clickObject(ftPage.accountantOrBookkeeper(), "accountantOrBookkeeper");
			
			logger.addScreenCapture(getScreenShot());
			sa.assertEquals(driver.getCurrentUrl().toString(),"https://www.xero.com/us/partner-programs/partners/signup/");			
			report.endTest(logger);
			closeReport();		
		}
		
		
	

}
