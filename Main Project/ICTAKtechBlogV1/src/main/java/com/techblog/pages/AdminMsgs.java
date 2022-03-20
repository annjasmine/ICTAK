package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminMsgs {

	WebDriver driver;
	
	@FindBy(xpath="/html/body/app-root/app-adminmessage/div/h2")
    private WebElement adminMsgsHeader;
	
	@FindBy(xpath="/html/body/app-root/app-adminmessage/div/ul[1]/li")
    private WebElement adminMsg;
	
	
	public AdminMsgs(WebDriver driver){
	 this.driver = driver;
	PageFactory.initElements(driver, this);
   }

	
	//Verify Admin messages page header
     public String getAdminMsgsHeader() {
    	
     return adminMsgsHeader.getText();
    }
	 
     
	//View Admin messages
	 public void viewAdminMsgs() {
	    	
	 adminMsg.isDisplayed();
	}
		
	 
	 public void getAdminMsgs() {
		
	 String Msgs= adminMsg.getText();
	 System.out.println(Msgs);
	}
	 
}
