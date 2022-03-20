package com.techblog.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstantsF;
import com.techblog.pages.AllPosts;
import com.techblog.pages.HomeF;
import com.techblog.pages.LoginF;
import com.techblog.pages.NewPostF;
import com.techblog.pages.PendingApprovals;
import com.techblog.utilities.ExcelUtilityF;

public class TCPendingApp extends TestBase {

   
	PendingApprovals objPendApp;
	NewPostF objNewPost;
	AllPosts objAllPosts;
	LoginF objLogin;
	HomeF objHome;
	
	
	@Test(priority=0)
	 public void  verifyPendingAppHeader() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
	 objHome = new HomeF(driver);
	// objHome.clickLogin();
			
	 /*objLogin = new Login(driver); 
	 String username = ExcelUtility.getCellData(0, 2);
	 String password = ExcelUtility.getCellData(0, 3);
	 objAllPosts=objLogin.AdminLogin(username,password);
	 Thread.sleep(3000);*/
		 
	 objAllPosts = new AllPosts(driver);
	 objAllPosts.clickActions();
	 objAllPosts.clickPendingApproval();
	 Thread.sleep(2000);
		 
	 objPendApp = new PendingApprovals(driver); 
	 String expectedPendingAppPgHeader =AutomationConstantsF.PENDINGAPPPG_HEADER;
                String actualPendingAppPgHeader = objPendApp.getPendingApprPgHeader();
	 Assert.assertEquals(expectedPendingAppPgHeader,actualPendingAppPgHeader);
	}
	 
	 
	 @Test(priority=1)
	 public void  verifyPostApproval() throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 objPendApp = new PendingApprovals(driver); 	  
	 objPendApp.verifyApproveBtn();
	 Thread.sleep(1000);
	 
	 objNewPost= new NewPostF(driver);
	 objNewPost.verifyAlertMsg();
	 Thread.sleep(2000);
	 
	 String expectedCommentPgUrl =AutomationConstantsF.COMMENTPAGE_URL;
	 String actualCommentPgUrl =driver.getCurrentUrl();
               Assert.assertEquals(expectedCommentPgUrl,actualCommentPgUrl);
     
             String comment = ExcelUtilityF.getCellData(8,2);
	 objPendApp.verifyCommentsToUser(comment);
	 Thread.sleep(2000);
		 
	 objNewPost.verifyAlertMsg();
	 Thread.sleep(1000);
		 
	 String expectedAllPostsUrl =AutomationConstantsF.ALLPOSTSURL;
	 String actualAllPostsUrl =driver.getCurrentUrl();
	 Assert.assertEquals(expectedAllPostsUrl,actualAllPostsUrl);
	 Thread.sleep(2000);
	}
	
	 
	 @Test(priority=2)
	 public void  verifyPostRejection() throws IOException, InterruptedException{
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		objAllPosts= new AllPosts(driver); 
	 objAllPosts.clickActions();
	 objAllPosts.clickPendingApproval();
	 Thread.sleep(2000);
		 
	 objPendApp.verifyRejectBtn();
	 Thread.sleep(2000);
		 
	 objNewPost.verifyAlertMsg();
	 Thread.sleep(1000);
		 
	 String expectedCommentPgUrl =AutomationConstantsF.COMMENTPAGE_URL;
	 String actualCommentPgUrl =driver.getCurrentUrl();
	 Assert.assertEquals(expectedCommentPgUrl,actualCommentPgUrl);
	     
	 String comment = ExcelUtilityF.getCellData(9,2);
	 objPendApp.verifyCommentsToUser(comment);
	 Thread.sleep(3000);
			 
	 objNewPost.verifyAlertMsg();
	 Thread.sleep(1000);
			 
	 String expectedAllPostsUrl =AutomationConstantsF.ALLPOSTSURL;
	 String actualAllPostsUrl =driver.getCurrentUrl();
	 Assert.assertEquals(expectedAllPostsUrl,actualAllPostsUrl);	 
	 
	}
	 
}

