package com.techblog.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.EditPost;
import com.techblog.pages.Home;
import com.techblog.pages.Login;
import com.techblog.pages.MyPosts;
import com.techblog.pages.NewPost;
import com.techblog.utilities.ExcelUtility;

public class TCEditPost extends TestBase {

	EditPost objEditPost;
	MyPosts objMyPosts;
	NewPost objNewPost;
	Home objHome;
	Login objLogin;
	
	@Test(priority=0)
	public void  verifyEditPost() throws IOException, InterruptedException{
		
	objHome = new Home(driver);
	objHome.clickLogin();
			
	objLogin = new Login(driver); 

   //Login to application
	String username = ExcelUtility.getCellData(0, 0);
	String password = ExcelUtility.getCellData(0, 1);
	objMyPosts=objLogin.LoginCredentials(username,password);
	Thread.sleep(3000);
	  
	objMyPosts	 = new MyPosts(driver); 
    objMyPosts.clickEditButton();		
	Thread.sleep(1000);
		 
	 objNewPost	 = new NewPost(driver); 
	 objNewPost.scrollToView();
	 Thread.sleep(2000);
	  
	 String title = ExcelUtility.getCellData(4, 1);
	 String post = ExcelUtility.getCellData(5, 1);
	 objNewPost.clearTitle();
	 objNewPost.setTitle(title);
	 Thread.sleep(1000);
	     
	 String expectedAuthor = AutomationConstants.AUTHOR;
	 String actualAuthor    = objNewPost.getAuthorName();
	 Thread.sleep(3000);
	 Assert.assertEquals(actualAuthor, expectedAuthor);
	 
	   
	 objNewPost.clearPost();
	 objNewPost.setPost(post);
	 Thread.sleep(1000);
	 
	 objEditPost= new EditPost(driver); 
	 objEditPost.clickSubmitBtn();
	 Thread.sleep(2000);
	 objNewPost.verifyAlertMsg();

   }
	
}	
	
	
	
	
	
	
	
	