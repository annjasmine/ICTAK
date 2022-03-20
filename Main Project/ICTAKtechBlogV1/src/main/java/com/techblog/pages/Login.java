package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	
    @FindBy(id="user")
    private WebElement username;
    
    @FindBy(id="pwd")
    private WebElement password;  
    
    @FindBy(id="logbut")
    private WebElement login;
    
    
    public Login(WebDriver driver){
     this.driver = driver;
    PageFactory.initElements(driver, this);
   }
    
   //Valid Login Credentials-User
    public MyPosts LoginCredentials(String strUserName,String strPassword){
    	
    username.sendKeys(strUserName);   
    password.sendKeys(strPassword);
    login.click();
    return new MyPosts(driver);
   }
  
          
    public void clearUserName() {
   	 username.clear();
    }
    
    public void clearPassword() {
    	password.clear();
    }
    
 }

 