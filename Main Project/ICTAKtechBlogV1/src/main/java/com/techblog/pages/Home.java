package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
    WebDriver driver;
    
    @FindBy(xpath="//img[@src='../../assets/images/user.png']")
    private WebElement dropDown;
    
    @FindBy(xpath="//a[@href='/login']")
    private WebElement selectLogin;
    
    
    public Home(WebDriver driver){
     this.driver = driver;
    PageFactory.initElements(driver, this);
   }
       
    
    //Validate HomePage Title
     public String validateHomePageTitle() {
    	 
     return driver.getTitle();
    }
    
        
    //Navigate to Login Page  
     public Login clickLogin() {  
    	 
     dropDown.click();
     selectLogin.click();
	 return new Login(driver);
    } 
       

}
