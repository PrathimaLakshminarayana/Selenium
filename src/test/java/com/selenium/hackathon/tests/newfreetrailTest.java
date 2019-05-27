package com.selenium.hackathon.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.hackathon.Utils.generalUtils;
import com.selenium.hackathon.pages.newFreeTrailPage;
import com.selenium.hackathon.pages.newLoginPage;

public class newfreetrailTest  extends generalUtils {
		newFreeTrailPage ftPage;
		String data[][];
		

		@BeforeClass
		@Parameters("browser")
		public void setUp(String browser) {
			generalUtils.InitializeDriver(browser);
			generalUtils.InitializeExtentReport();
			try {
				data = ReadXLData("C:\\Users\\prath\\Desktop\\SeleniumHackathon\\seleHackathondata.xlsx", "Sheet1");
			} catch (IOException e) {
				System.out.println("error  while reading from xlsx");
				e.printStackTrace();
			}

			ftPage = new newFreeTrailPage(driver);

		}

		
		@Test(enabled = false)
		public void A_SignUpToXDC() throws IOException{			
			logger = report.startTest("Sign Up to XDC");
			ftPage.freeTrailPage(data[1][1], data[2][1], data[3][1], data[4][1], "United States");
		}

}
