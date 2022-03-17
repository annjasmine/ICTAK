package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAdReCate {
		 WebDriver driver;
		    @FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
		    private WebElement dropdown;
		    @FindBy(xpath="//a[@href=\"/login\"]")
		    private WebElement loginopt; 
		   
		    @FindBy(id="user")
		    private WebElement loginname;
		    
		    @FindBy(id="logbut")
		    private WebElement login;
		    
		    
		 public AdminAdReCate(WebDriver driver){
		        this.driver = driver;
		        //This initElements method will create all WebElements
		        PageFactory.initElements(driver, this);
		    }
		 public void clickDropDown(){ 
		    	dropdown.click();
		   	} 
		    public void SelectLogin(){ 
		    	loginopt.click();
		    }
		    public void setLoginName(String strLoginName) {
		    loginname.sendKeys(strLoginName);  
		    }
		   
	    	 public void clickSubmLogin (){
	    	 login.click();
		 	}
	    	

