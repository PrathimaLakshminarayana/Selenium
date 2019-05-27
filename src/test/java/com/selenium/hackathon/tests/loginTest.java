package com.selenium.hackathon.tests;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.selenium.hackathon.Utils.generalUtils;
import com.selenium.hackathon.pages.loginPage;
import com.selenium.hackathon.pages.newLoginPage;

public class loginTest extends generalUtils {
	String data[][] = null;
	SoftAssert sa = new SoftAssert();

	loginPage loginPO;

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

		loginPO = new loginPage(driver);

	}

	// forgotPassword
	@Test(priority =3)
	public void forgotPassword() throws IOException {

		logger = report.startTest("forgotPassword");

		clickObject(loginPO.fortgotPassword(), "forgot login link");
		Assert.assertEquals(driver.getCurrentUrl().toString(), "https://login.xero.com/ForgottenPassword");
		enterText(loginPO.userName(), data[5][1], "user name");
		clickObject(loginPO.clickSend(), "send button");

		Assert.assertEquals(driver.getCurrentUrl().toString(), "https://login.xero.com/ForgottenPassword/SendLink");
		report.endTest(logger);

	}

	// Incorrect Email
	
	 @Test(priority =1)
	public void incorrectEmail() throws IOException {

		driver.get(data[0][1]);
		logger = report.startTest("incorrectEmail");

		enterText(loginPO.email(), data[4][1], "Email");
		enterText(loginPO.password(), data[4][2], "Password");
		clickObject(loginPO.login(), "LOgin");
		Assert.assertNotEquals(driver.getCurrentUrl().toString(), "https://go.xero.com/");
		report.endTest(logger);

	}

	@Test(priority =2)
	public void incorrectPassword() throws IOException {

		
		logger = report.startTest("incorrectPassword");

		enterText(loginPO.email(), data[3][1], "Email");
		enterText(loginPO.password(), data[3][2], "Password");
		clickObject(loginPO.login(), "LOgin");
		Assert.assertNotEquals(driver.getCurrentUrl().toString(), "https://go.xero.com/Dashboard/");
		report.endTest(logger);

	}

	@Test(priority =4)
	public void loginpageTest() throws IOException {

		driver.get(data[0][1]);
		logger = report.startTest("loginPage");

		enterText(loginPO.email(), data[2][1], "Email");
		enterText(loginPO.password(), data[2][2], "Password");
		clickObject(loginPO.login(), "LOgin");
		sa.assertEquals(driver.getCurrentUrl().toString(), "https://go.xero.com/Dashboard/");
		driver.quit();
		report.endTest(logger);
		closeReport();

	}

}
