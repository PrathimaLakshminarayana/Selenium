package com.selenium.hackathon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.hackathon.Utils.generalUtils;

public class homePage extends generalUtils {
	
	 By dashBoard= By.linkText("Dashboard");
	 By business = By.xpath("//button[contains(text(),'Business')]");
	 By accounts= By.xpath("//button[contains(text(),'Accounting')]");
	 By reports= By.linkText("Reports");
	 By contacts= By.xpath("//button[contains(text(),'Contacts')]");
	 By allContacts = By.linkText("All contacts");
	 By companyName = By.className("xrh-appbutton--body");
	  By settings= By.linkText("Settings");
	  By plus= By.xpath(" //li[1]//button[1]//div[1]");
	  By invoice = By.linkText("Invoice");
	  By files= By.linkText("Files");
	  By filePageTitle = By.id("page_title");
	  By notification= By.id("");
	  By search= By.id("");
	  By help= By.id("");
	  By bankAccounts = By.linkText("Bank accounts");
	  
	  By userInitials = By.xpath("//button[contains(text(),'Prathima Lakshminarayana')]");
	  By logout = By.id("logout");
	 // By logout = By.cssSelector("xrh-verticalmenuitem--icon xrh-iconwrapper");
	/*  reports
	  Advanced
	  AdvancedTransaction*/
	  
	  public WebElement logout(){
		  return driver.findElement(logout);
	  }
	  
	  public WebElement userInitials(){
		  return driver.findElement(userInitials);
	  }
	  
	  public WebElement filePageTitle(){
		  return driver.findElement(filePageTitle);
	  }
	  public WebElement files(){
		  return driver.findElement(files);
	  }
	  public WebElement invoice(){
		  return driver.findElement(invoice);
	  }
	  public WebElement plus(){
		  return driver.findElement(plus);
	  }
	  public WebElement settings(){
		  return driver.findElement(settings);
	  }
	  
	  public WebElement companyName(){
		  return driver.findElement(companyName);
	  }
	   
	  public WebElement allContacts(){
		  return driver.findElement(allContacts);
	  }
	  
	  
	  public WebElement contacts(){
		  return driver.findElement(contacts);
	  }
	  
	  
	  public WebElement reports(){
		  return driver.findElement(reports);
	  }
	  
	  public WebElement bankAccounts(){
		  return driver.findElement(bankAccounts);
	  }
	  
	  
	  public WebElement accounts(){
		  return driver.findElement(accounts);
	  }
	  
	  public WebElement dashBoard(){
		  return driver.findElement(dashBoard);
	  }
}
