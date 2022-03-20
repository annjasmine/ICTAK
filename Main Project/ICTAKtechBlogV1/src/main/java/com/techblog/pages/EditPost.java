package com.techblog.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPost {
	
	WebDriver driver;
	
	@FindBy(xpath="//h2[@class='my-5 text-white']")
    private WebElement editPostHeader;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitBtn;
	
    
    public EditPost(WebDriver driver){
     this.driver = driver;
    PageFactory.initElements(driver, this);
   }

     
   //Verify Edit post Header
    public String getEditpostHeader() {
    	
    return editPostHeader.getText();
   }
    
    
      
    //Click Submit Button
     public Home clickSubmitBtn() {
    	 
     submitBtn.sendKeys(Keys.RETURN);
     return new Home(driver);
    }
	

}
