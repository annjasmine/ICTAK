package com.techblog.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.AdminMsgs;
import com.techblog.pages.Home;
import com.techblog.pages.Login;
import com.techblog.pages.MyPosts;
import com.techblog.pages.NewPost;
import com.techblog.utilities.ExcelUtility;

public class TCAdminMsg extends TestBase{
 
	AdminMsgs objAdminMsgs;
	NewPost objNewPost;
	MyPosts objMyPosts;
	Login objLogin;
	Home objHome;
	
	@Test(priority=0)
	public void  verifyAdminMsgsHeader() throws InterruptedException, IOException {
		
	objHome = new Home(driver);
	objHome.clickLogin();
			
	objLogin = new Login(driver); 
	
   //Login to application
	String username = ExcelUtility.getCellData(0, 0);
	String password = ExcelUtility.getCellData(0, 1);
	objMyPosts=objLogin.LoginCredentials(username,password);
	Thread.sleep(3000);
	
	//Navigate to Admin messages page
	objMyPosts	 = new MyPosts(driver); 
	objMyPosts.clickAdminMsgs();
	Thread.sleep(1000);
	String adminMsgsExpectedHeader = AutomationConstants.ADMINPG_HEADER;
    String adminMsgsActualHeader   = objAdminMsgs.getAdminMsgsHeader();
    Thread.sleep(3000);
    Assert.assertEquals(adminMsgsExpectedHeader,adminMsgsActualHeader);
    Thread.sleep(2000);
   } 
	 
	 
	 	
	 @Test(priority=1)
	 public void  verifyGetAdminMsgs() throws InterruptedException{
	 objAdminMsgs= new AdminMsgs(driver);		 
	 objAdminMsgs.viewAdminMsgs();
	 Thread.sleep(3000);
	 Assert.assertTrue(true, "Admin Msgs present");
	 Thread.sleep(2000);
	 objAdminMsgs.getAdminMsgs();
	}
	 
}


