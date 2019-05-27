package com.selenium.hackathon.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.hackathon.Utils.generalUtils;
import com.selenium.hackathon.pages.loginPage;
import com.selenium.hackathon.pages.newLoginPage;

public class newLoginTest extends generalUtils {
	newLoginPage loginPage;
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

		loginPage = new newLoginPage(driver);

	}

	@Test(priority =3)
	public void forgotPassword() {
		logger = report.startTest("forgot Password");
		driver.get(data[0][1]);
		loginPage.forgotPassword(data[5][1]);
		System.out.println(driver.getCurrentUrl().toString());
		Assert.assertEquals(driver.getCurrentUrl().toString(), "https://login.xero.com/");
		report.endTest(logger);
	}
	

	@Test(priority =1)
	public void incorrectEmail() {
		logger = report.startTest("incorrectEmail");
		driver.get(data[0][1]);
		loginPage.incorrectEmail(data[4][1], data[4][2]);
		System.out.println(driver.getCurrentUrl().toString());
		Assert.assertEquals(driver.getCurrentUrl().toString(), "https://login.xero.com/");
		report.endTest(logger);

	}

	@Test(priority =2)
	public void incorrectPassword() {

		logger = report.startTest("incorrectEmail");
		driver.get(data[0][1]);
		loginPage.incorrectPassword(data[3][1]);
		System.out.println(driver.getCurrentUrl().toString());
		Assert.assertEquals(driver.getCurrentUrl().toString(), "https://login.xero.com/");
		report.endTest(logger);

		generalUtils.closeReport();

	}

	@Test(priority =4)
	public void loginTest() {

		logger = report.startTest("incorrectEmail");
		driver.get(data[0][1]);
		loginPage.validLogin(data[2][1], data[2][2]);
		System.out.println(driver.getCurrentUrl().toString());
		Assert.assertEquals(driver.getCurrentUrl().toString(), "https://go.xero.com/Dashboard/");
		report.endTest(logger);
		closeReport();
		

	}

}
