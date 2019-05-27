package com.selenium.hackathon.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.hackathon.Utils.generalUtils;

public class newFreeTrailPage extends generalUtils{	
	
	WebDriver driver;
	
	public newFreeTrailPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText ="Try Xero for free")
	WebElement tryFree;
	
	@FindBy(name ="FirstName")
	WebElement firstName;
	
	@FindBy(name ="LastName")
	WebElement lastName;
	
	@FindBy(name ="EmailAddress")
	WebElement emailAddress;
	
	@FindBy(name ="PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(name ="LocationCode")
	WebElement country ;
	
	@FindBy(xpath ="//input[@name='TermsAccepted']")
	WebElement termsCheck;
	
	@FindBy(tagName ="submit")
	WebElement getStartedButton;
	
	@FindBy(linkText ="terms of use")
	WebElement termsOfUse;
	
	@FindBy(linkText ="privacy notice")
	WebElement privacyNotice;
	
	@FindBy(linkText ="accountant or bookkeeper")
	WebElement accountantOrBookkeeper;
	
	@FindBy(id ="signup-form-error-message-1")
	WebElement missingFirstName;
	
	@FindBy(id ="ignup-form-error-message-2")
	WebElement missingLastName ;
	
	@FindBy(id ="signup-form-error-message-3")
	WebElement missingemailAddress;
	
	@FindBy(id ="signup-form-error-message-4")
	WebElement missingPhone;
	
	@FindBy(linkText ="offer details")
	WebElement offerDetials;

	public void freeTrailPage(String fname, String Pwd,String Email, String pNo, String ctry) {
		tryFree.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(Pwd);
		emailAddress.sendKeys(Email);
		phoneNumber.sendKeys(pNo);
		country.click();
		selectDropDown(country, ctry);
		termsCheck.click();
		getStartedButton.click();	
		
	}
	

}
