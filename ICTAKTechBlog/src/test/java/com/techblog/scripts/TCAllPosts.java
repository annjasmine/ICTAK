package com.techblog.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstantsF;
import com.techblog.pages.AllPosts;
import com.techblog.pages.HomeF;
import com.techblog.pages.LoginF;
import com.techblog.pages.NewPostF;
import com.techblog.pages.PendingApprovals;
import com.techblog.utilities.ExcelUtilityF;

public class TCAllPosts extends TestBase {

	
	AllPosts objAllPosts;
	PendingApprovals objPendApp;
	NewPostF objNewPost;
	LoginF objLogin;
	HomeF objHome;
	
	
	/* @Test(priority=0)
	 public void  verifyValidAdminLogin() throws InterruptedException, IOException{
		  
	objHome = new HomeF(driver);
	 //objHome.AdminLogin();
		
	 objLogin = new LoginF(driver); */
	 	   
	/*//Login to application
	 String username = ExcelUtility.getCellData(0, 2);
	 String password = ExcelUtility.getCellData(0, 3);
	 objAllPosts=objLogin.AdminLogin(username,password);
	 Thread.sleep(3000);
	 String allPostsPgExpectedUrl = AutomationConstants.ALLPOSTSURL;
	 String allPostsPgActualUrl = driver.getCurrentUrl();
	 Assert.assertEquals(allPostsPgExpectedUrl,allPostsPgActualUrl);
	 Thread.sleep(2000);
	}*/
	
	 
	 @Test(priority=1)
	 public void verifyAllPostsHeader() {
		 objAllPosts = new AllPosts(driver);
	 String expectedAllPostsPgHeader =AutomationConstantsF.ALLPOSTSPG_HEADER;
     String actualAllPostsPgHeader = objAllPosts. getAllPostsPgHeader();
	 Assert.assertEquals(expectedAllPostsPgHeader,actualAllPostsPgHeader);
	}
	 
	  
	 @Test(priority=2)
	 public void verifyActionsLink() {
	 objAllPosts = new AllPosts(driver);	
     objAllPosts.clickActions();
	}
	
	
	 @Test(priority=3)
	 public void verifyPendapproval() throws InterruptedException {
		 objAllPosts= new AllPosts(driver);
	 objAllPosts.clickPendingApproval();
     Thread.sleep(2000);
	 
	 String expectedPendingAppUrl =AutomationConstantsF.PENDING_APPROVALSURL;
	 String actualPendingAppUrl =driver.getCurrentUrl();
     Assert.assertEquals(expectedPendingAppUrl,actualPendingAppUrl);
     
     
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


