package com.techblog.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.Home;


public class TCHome extends TestBase{
	
	 Home objHome;
	
	 @Test(priority=0)
	 public void  verifyHomePageTitle(){
			
	//Create Home Page object
	 objHome = new Home(driver); 
		    
    //Loading Home page
	 String expectedTitle = AutomationConstants.TITLE;
	 String actualTitle = objHome.validateHomePageTitle();
	 Assert.assertEquals(expectedTitle,actualTitle);
	}
	
	 @Test(priority=1)
	 public void verifyClickLogin() throws InterruptedException {
	 objHome.clickLogin();
	 Thread.sleep(2000);
	 String loginPageExpectedUrl = AutomationConstants.LOGINPAGE_URL;
	 String loginPageActualUrl = driver.getCurrentUrl();
	 Assert.assertEquals(loginPageExpectedUrl,loginPageActualUrl);
	}
	  
}
	  
	  
	  
	  
	  
	  
	
