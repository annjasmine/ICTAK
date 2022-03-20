package com.techblog.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.Home;
import com.techblog.pages.Login;
import com.techblog.pages.MyPosts;
import com.techblog.utilities.ExcelUtility;

public class TCLogin extends TestBase {
	
   Login objLogin;
   Home objHome;
   MyPosts objMyPosts;
   
  
    @Test(priority=0)
	public void  verifyValidLogin() throws IOException, InterruptedException{
	objHome = new Home(driver);
	objHome.clickLogin();
	
    objLogin = new Login(driver); 
	   
   //Login to application
	String username = ExcelUtility.getCellData(0, 0);
	String password = ExcelUtility.getCellData(0, 1);
	objMyPosts=objLogin.LoginCredentials(username,password);
	Thread.sleep(3000);
	String myPostsPgExpectedUrl = AutomationConstants.MYPOSTSURL;
	String myPostsPgActualUrl = driver.getCurrentUrl();
	Assert.assertEquals(myPostsPgExpectedUrl,myPostsPgActualUrl);
	
   }
 
    
     @Test(priority=1)
	 public void  verifyLogoutLink() throws InterruptedException {
		 
	 objMyPosts.clickLogout();
	 Thread.sleep(1000);
	 String logoutExpectedUrl =AutomationConstants.LOGOUT_URL;
	 String logoutActualUrl =driver.getCurrentUrl();
	 Thread.sleep(3000);
	 Assert.assertEquals(logoutExpectedUrl,logoutActualUrl);
	 
   }
      
}
