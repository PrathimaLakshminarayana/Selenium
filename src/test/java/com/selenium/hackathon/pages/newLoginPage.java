package com.selenium.hackathon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newLoginPage {
	WebDriver driver;
	
	public newLoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id ="email")
	WebElement email;
	
	@FindBy(id ="password")
	WebElement password;
	
	@FindBy(id ="submitButton")
	WebElement login;
	
	@FindBy(id ="UserName")
	WebElement username;
	
	@FindBy(id ="submitButton")
	WebElement sendLink;
	
	@FindBy(linkText ="Forgot your password?")
	WebElement forgotPwd;

	public void forgotPassword(String emailId) {
		email.clear();
		email.sendKeys(emailId);
		login.click();
		
	}

	public void incorrectEmail(String emailId, String pwd) {
		email.sendKeys(emailId);
		password.sendKeys(pwd);		
		login.click();
	}

	public void incorrectPassword(String emailId) {
		email.sendKeys(emailId);
		
		login.click();
	}

	public void validLogin(String emailId, String pwd) {
		email.clear();
		email.sendKeys(emailId);
		password.sendKeys(pwd);		
		login.click();
	}
	
    
	
	
}
