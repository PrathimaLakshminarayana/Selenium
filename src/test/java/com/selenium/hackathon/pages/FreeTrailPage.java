package com.selenium.hackathon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.hackathon.Utils.generalUtils;

public class FreeTrailPage extends generalUtils {
	By tryFree = By.linkText("Try Xero for free");
	By firstName = By.name("FirstName");
	By lastName = By.name("LastName");
	By emailAddress = By.name("EmailAddress");
	By phoneNumber = By.name("PhoneNumber");
	By country = By.name("LocationCode");
	By termsCheck = By.xpath("//input[@name='TermsAccepted']");
	By captcha = By.className("recaptcha-checkbox-border");
	By getStartedButton = By.tagName("submit");
	By termsOfUse = By.linkText("terms of use");
	By privacyNotice = By.linkText("privacy notice");
	By accountantOrBookkeeper = By.linkText("accountant or bookkeeper");
	By missingFirstName= By.id("signup-form-error-message-1");
	By missingPhone= By.id("signup-form-error-message-4");
	By missingLastName = By.id("signup-form-error-message-2");
	By missingemailAddress = By.id("signup-form-error-message-3");
	By offerDetials = By.linkText("offer details");
	
	public WebElement offerDetials(){
		return driver.findElement(offerDetials);
	}
	public WebElement missingFirstName(){
		return driver.findElement(missingFirstName);
	}
	
	public WebElement captcha(){
		return driver.findElement(captcha);
	}
	public WebElement accountantOrBookkeeper(){
		return driver.findElement(accountantOrBookkeeper);
	}
	
	public WebElement phoneNumber(){
		return driver.findElement(phoneNumber);
	}
	
	public WebElement emailAddress(){
		return driver.findElement(emailAddress);
	}
	public WebElement lastName(){
		return driver.findElement(lastName);
	}
	
	public WebElement firstName(){
		return driver.findElement(firstName);
	}
	
	
	
	public WebElement tryFree(){
		return driver.findElement(tryFree);
	}
		
	public WebElement privacyNotice(){
		return driver.findElement(privacyNotice);
	}
	public WebElement termsOfUse(){
		return driver.findElement(termsOfUse);
	}
	public WebElement getStartedButton(){
		return driver.findElement(getStartedButton);
	}
	public WebElement termsCheck(){
		return driver.findElement(termsCheck);
	}
	public WebElement country(){
		return driver.findElement(country);
	}

	public WebElement missingemailAddress() {
		return driver.findElement(missingemailAddress);
	}

	public WebElement missingLastName() {
		return driver.findElement(missingLastName);
	}

	public WebElement missingPhone() {
		return driver.findElement(missingPhone);
	}
	
}
