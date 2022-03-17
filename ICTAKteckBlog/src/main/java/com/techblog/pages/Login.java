package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
		 WebDriver driver;
		    @FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
		    private WebElement dropdown;
		    @FindBy(xpath="//a[@href=\"/login\"]")
		    private WebElement loginopt; 
		   
		    @FindBy(id="user")
		    private WebElement loginname;
		    
		    @FindBy(id="pwd")
		    private WebElement loginpass;  
		    
		    @FindBy(id="logbut")
		    private WebElement login;
		   
		    @FindBy(xpath="//*[@id=\"log\"]/small[1]")
		    private WebElement errorlogin1;
		    
		    @FindBy(xpath="//*[@id=\"log\"]/small[2]")
		    private WebElement errorlogin2;
		  
		    @FindBy(xpath="//*[@id=\"log\"]/p/a")
		    private WebElement signupredirect;
		 public Login(WebDriver driver){
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
		    public void strLoginPass(String strLoginPass){
	    	 loginpass.sendKeys(strLoginPass);
		    }
	    	 public void clickSubmLogin (){
	    	 login.click();
		 	}
	    	 public String getErrorLogin1() {
	          	 return errorlogin1.getText();
	        }
	        public String getErrorLogin2() {
	        return errorlogin2.getText();
	        }
	        public void clickSignUpButton(){
	        	signupredirect.click();
	        }
}

