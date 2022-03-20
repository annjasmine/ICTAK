package com.techblog.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.Home;
import com.techblog.pages.Login;
import com.techblog.pages.MyPosts;
import com.techblog.pages.NewPost;
import com.techblog.utilities.ExcelUtility;

public class TCMyPosts extends TestBase {
	
	MyPosts objMyPosts;
	NewPost objNewPost;
	Login objLogin;
	Home objHome;
	
	
	@Test(enabled =false)
	public void  verifyMyPostHeader() throws InterruptedException, IOException {
		
	objHome = new Home(driver);
	objHome.clickLogin();
			
	objLogin = new Login(driver); 
   //Login to application
	String username = ExcelUtility.getCellData(0, 0);
	String password = ExcelUtility.getCellData(0, 1);
	objMyPosts=objLogin.LoginCredentials(username,password);
	Thread.sleep(3000);
	
	objMyPosts.getMypostHeader();
	String expectedMyPostsPgHeader =AutomationConstants.MYPOSTSPAGE_HEADER;
    String actualMyPostsPgHeader   = objMyPosts.getMypostHeader();
    Thread.sleep(2000);
    Assert.assertEquals(expectedMyPostsPgHeader,actualMyPostsPgHeader);
    
   }
	
	
	@Test(priority=1)
	public void  verifyEditButton() throws InterruptedException, IOException{
		
		objHome = new Home(driver);
		objHome.clickLogin();
				
		objLogin = new Login(driver); 
	   //Login to application
		String username = ExcelUtility.getCellData(0, 0);
		String password = ExcelUtility.getCellData(0, 1);
		objMyPosts=objLogin.LoginCredentials(username,password);
		Thread.sleep(3000);
		
		objMyPosts.getMypostHeader();
		String expectedMyPostsPgHeader =AutomationConstants.MYPOSTSPAGE_HEADER;
	    String actualMyPostsPgHeader   = objMyPosts.getMypostHeader();
	    Thread.sleep(2000);
	    Assert.assertEquals(expectedMyPostsPgHeader,actualMyPostsPgHeader);
		
		
		
	//objMyPosts	 = new MyPosts(driver); 
	objMyPosts.clickEditButton();		
	Thread.sleep(2000);
	String expectedPageUrl =AutomationConstants.EDITPOST_URL;
    String actualPageUrl =driver.getCurrentUrl();
    Thread.sleep(3000);
    Assert.assertEquals(expectedPageUrl,actualPageUrl);
    
   //Back to My Posts page
    objNewPost	 = new NewPost(driver); 
	objNewPost.scrollToView();
	objMyPosts.clickMyPostLink();
	Thread.sleep(2000);
	
	 String myPostsPgExpectedUrl = AutomationConstants.MYPOSTSURL;
	 String myPostsPgActualUrl = driver.getCurrentUrl();
	 Thread.sleep(3000);
	 Assert.assertEquals(myPostsPgExpectedUrl,myPostsPgActualUrl);
	
   }

	
	 
	 
	 @Test(enabled=false)
	 public void  verifyDelete() throws InterruptedException{
	
	 objMyPosts.clickDeleteButton();		
	 Thread.sleep(1000);
	 objNewPost.verifyAlertMsg(); 
	}
	 
	 
	 @Test(priority=2)
	 public void  verifyReadmoreLink() throws InterruptedException {
		 
	 objMyPosts.clickReadmoreLink(); 
	 Thread.sleep(1000);
	 String expectedUrl =AutomationConstants.VIEWPOST_URL;
	 String actualUrl =driver.getCurrentUrl();
	 Thread.sleep(3000);
	 Assert.assertEquals(expectedUrl,actualUrl);
	 
		 
	 objMyPosts.viewPostTitle();
	 Thread.sleep(3000);
	 Assert.assertTrue(true, "Title Present");
	 
		 
	 objMyPosts.viewPostImage();
	 Thread.sleep(3000);
	 Assert.assertTrue(true, "Image Present");
	 
		 
	 objMyPosts.viewPostContent();
	 Thread.sleep(3000);
	 Assert.assertTrue(true, "Post content Present");
	 
	}	 	 
	 
	 
     @Test(priority=3)
	 public void  verifyTBLogo() throws InterruptedException {
		 
     objMyPosts.clickTBLogo(); 	
     Thread.sleep(2000);
	 String homePageExpectedUrl = AutomationConstants.HOMEPAGE_URL;
	 String homePageActualUrl = driver.getCurrentUrl();
	 Thread.sleep(3000);
	 Assert.assertEquals(homePageExpectedUrl,homePageActualUrl); 
	 
	}
	 
  
     
     @Test(priority=5)
	 public void  verifyNewPostLink() throws InterruptedException{
		 
	 objMyPosts.clickNewPost();
	 Thread.sleep(2000);
	 
	 String newPostPgExpectedUrl = AutomationConstants.NEWPOSTSURL;
	 String newPostPgActualUrl = driver.getCurrentUrl();
	 Thread.sleep(3000);
	 Assert.assertEquals(newPostPgExpectedUrl,newPostPgActualUrl);
	 
	}
     
     
     @Test(priority=6)
	 public void  verifyAdminMsgsLink() throws InterruptedException{
		 
	 objMyPosts.clickAdminMsgs();
	 Thread.sleep(2000);
	 
	 String expectedAdminMsgsUrl =AutomationConstants.ADMINMSGS_URL;
	 String actualAdminMsgsUrl =driver.getCurrentUrl();
	 Thread.sleep(3000);
     Assert.assertEquals(expectedAdminMsgsUrl,actualAdminMsgsUrl);
     objNewPost = new NewPost(driver);
 	 objNewPost =objMyPosts.clickNewPost();
	    
	 }
     
}

	 
	 

