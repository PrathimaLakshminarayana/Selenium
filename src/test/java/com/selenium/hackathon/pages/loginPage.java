package com.selenium.hackathon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.hackathon.Utils.generalUtils;

public class loginPage extends generalUtils {

	WebDriver driver;
	By email = By.id("email");
	By password = By.id("password");
	By login = By.id("submitButton");
	By forgotPwd = By.linkText("Forgot your password?");
    By username = By.id("UserName");
    By sendLink = By.id("submitButton");
    
	public loginPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement email() {
		return driver.findElement(email);
		
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement login() {	
		return driver.findElement(login);
	}
	public WebElement fortgotPassword(){
		return driver.findElement(forgotPwd);
				//clickObject(driver.findElement(forgotPwd),"Forgot your password link");
	}

	public WebElement userName(){
		return driver.findElement(username);
		//enterText(driver.findElement(username), uName, "UserName");
		
	}
	
	public WebElement clickSend(){
		return driver.findElement(sendLink);
		//clickObject(driver.findElement(sendLink), "Send Link for forgot password");
	}
}
