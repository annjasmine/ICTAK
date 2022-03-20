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

public class TCNewPost extends TestBase {

	NewPost objNewPost;
	MyPosts objMyPosts;
	Home objHome;
	Login objLogin;
	
	@Test(priority=0)
	public void  verifyNewPostHeader() throws InterruptedException, IOException {
		
	//objHome = new Home(driver);
//	Thread.sleep(3000);
//	objHome.clickLogin();
			
//	objLogin = new Login(driver); 
   //Login to application
//	String username = ExcelUtility.getCellData(0, 0);
//    String password = ExcelUtility.getCellData(0, 1);
//	objMyPosts=objLogin.LoginCredentials(username,password);
//	Thread.sleep(3000);
	
	//Navigate to New post page
	objNewPost = new NewPost(driver);
	//objNewPost =objMyPosts.clickNewPost();
    String expectedPgHeader =AutomationConstants.NEWPOST_HEADER ;
    String actualPgHeader   = objNewPost.getNewpostHeader();
    Thread.sleep(2000);
    Assert.assertEquals(expectedPgHeader,actualPgHeader);
   
   } 
	 
	
	 @Test(priority=1)
	 public void  verifyAddNewPostValidTest() throws IOException, InterruptedException {
	
     String title = ExcelUtility.getCellData(1, 1);
     String imageUrl = ExcelUtility.getCellData(2, 1);
     String post = ExcelUtility.getCellData(3, 1);
     
     objNewPost.setTitle(title);
     
     String expectedAuthor = AutomationConstants.AUTHOR;
     String actualAuthor    = objNewPost.getAuthorName();
     Assert.assertEquals(actualAuthor, expectedAuthor);
     
     objNewPost.setImageUrl(imageUrl); 
     
     String selectedCategory= objNewPost.addCatSpace();
     Assert.assertEquals(selectedCategory,"SPACE");
     
     objNewPost.setPost(post);
     objNewPost.clickSend();
     Thread.sleep(2000);
     objNewPost.verifyAlertMsg();
	 }
   
	 
	 @Test(priority=2)
	 public void  verifyNewPostNullTest() throws InterruptedException {
		 
	 objNewPost =objMyPosts.clickNewPost();
	 Thread.sleep(1000);
	 
	    if (objNewPost.sendButtonEnabled()) {
		  
		System.out.println("Send button Enabled");
		objNewPost.clickSend();
		objNewPost.verifyAlertMsg();	
		Thread.sleep(2000);
		
	    }else {
		   
		 System.out.println("Send button Disabled|Post Not Added");
	    }
	 }
	 
	 
	 @Test(priority=3)
	 public void  verifyTitleofNewPostwithEmptyStrings() throws IOException, InterruptedException {
	
	// objNewPost = new NewPost(driver);
     String imageUrl = ExcelUtility.getCellData(2, 1);
     String post = ExcelUtility.getCellData(3, 1);
     
     String expectedAuthor = AutomationConstants.AUTHOR;
     String actualAuthor    = objNewPost.getAuthorName();
     Thread.sleep(3000);
     Assert.assertEquals(actualAuthor, expectedAuthor);
     
     objNewPost.setImageUrl(imageUrl); 
     
     Thread.sleep(2000);
     String selectedCategory= objNewPost.addCatSpace();
     Assert.assertEquals(selectedCategory,"SPACE");
     
     objNewPost.setPost(post);
     Thread.sleep(3000);
     if (objNewPost.sendButtonEnabled()) {
		  
 		System.out.println("Send button Enabled");
 		objNewPost.clickSend();
 		objNewPost.verifyAlertMsg();	
 		Thread.sleep(2000);
 		
 	    }else {
 		   
 		 System.out.println("Send button Disabled|Post Not Added");
 	    }
 	 }
		 
	 
	 @Test(priority=4)
	 public void verifyImageUrlofNewPostwithEmptyStrings() throws IOException, InterruptedException {
	 objNewPost = new NewPost(driver);	
     String title = ExcelUtility.getCellData(1, 1);
	 String post = ExcelUtility.getCellData(3, 1);
	
	 objNewPost.clearTitle();
	 objNewPost.setTitle(title);
	 
	 String expectedAuthor = AutomationConstants.AUTHOR;
     String actualAuthor    = objNewPost.getAuthorName();
     Assert.assertEquals(actualAuthor, expectedAuthor);
     
     objNewPost.clearImageUrl();
     
     String selectedCategory= objNewPost.addCatSpace();
     Assert.assertEquals(selectedCategory,"SPACE");
     
     objNewPost.clearPost();
     objNewPost.setPost(post);
     
     Thread.sleep(2000);
     if (objNewPost.sendButtonEnabled()) {
		  
 		System.out.println("Send button Enabled");
 		objNewPost.clickSend();
 		Thread.sleep(3000);
 		objNewPost.verifyAlertMsg();	
 	    }else {
 		   
 		 System.out.println("Send button Disabled|Post Not Added");
 	    }
     Thread.sleep(3000);
 	 }
	 
	 
	 @Test(priority=5)
	 public void  verifyPostContentofNewPostwithEmptyStrings() throws IOException, InterruptedException {
	
		 objNewPost = new NewPost(driver);
	 String title = ExcelUtility.getCellData(1, 1);
	 String imageUrl = ExcelUtility.getCellData(2, 1);
     
     objNewPost.clearTitle();
	 objNewPost.setTitle(title);
	 
	 String expectedAuthor = AutomationConstants.AUTHOR;
     String actualAuthor    = objNewPost.getAuthorName();
     Assert.assertEquals(actualAuthor, expectedAuthor);
     
     objNewPost.clearImageUrl();
     objNewPost.setImageUrl(imageUrl);
	 
     String selectedCategory= objNewPost.addCatSpace();
     Assert.assertEquals(selectedCategory,"SPACE");
     
     objNewPost.clearPost();
     
     Thread.sleep(2000);
     if (objNewPost.sendButtonEnabled()) {
		  
 		System.out.println("Send button Enabled");
 		objNewPost.clickSend();
 		Thread.sleep(3000);
 		objNewPost.verifyAlertMsg();	
 		
 	     }else {
 		   
 		 System.out.println("Send button Disabled|Post Not Added");
 	    }
     Thread.sleep(3000);
 	 }
	 
	 
	 @Test(priority=6)
	 public void  verifyAddingPostInRobot() throws InterruptedException, IOException {
		 
	 objNewPost =objMyPosts.clickNewPost();
	 Thread.sleep(3000);	 
		 
	 String title = ExcelUtility.getCellData(1, 1);
	 String imageUrl = ExcelUtility.getCellData(2, 1);
	 String post = ExcelUtility.getCellData(3, 1);
	  
	 objNewPost.clearTitle();
	 objNewPost.setTitle(title);
	     
	 String expectedAuthor = AutomationConstants.AUTHOR;
	 String actualAuthor    = objNewPost.getAuthorName();
	 Assert.assertEquals(actualAuthor, expectedAuthor);
	     
	 objNewPost.clearImageUrl();
	 objNewPost.setImageUrl(imageUrl); 
	 
	 String selectedCategory= objNewPost.addCatRobot();
	 Assert.assertEquals(selectedCategory,"ROBOTICS");
	 
	 objNewPost.clearPost();
	 objNewPost.setPost(post);
	 
	 objNewPost.clickSend();
	 Thread.sleep(2000);
	 objNewPost.verifyAlertMsg();
	 
	 System.out.println("Post added for Robotics");
	 Thread.sleep(3000);
	}
		
		 
	 @Test(priority=7)
	 public void  verifyAddingPostInElect() throws InterruptedException, IOException {
		 
	 objNewPost =objMyPosts.clickNewPost();
	 Thread.sleep(3000);
	
	 String title = ExcelUtility.getCellData(1, 1);
	 String imageUrl = ExcelUtility.getCellData(2, 1);
	 String post = ExcelUtility.getCellData(3, 1);
	     
	 objNewPost.setTitle(title);
	     
	 String expectedAuthor = AutomationConstants.AUTHOR;
	 String actualAuthor    = objNewPost.getAuthorName();
	 Assert.assertEquals(actualAuthor, expectedAuthor);
	     
	 objNewPost.setImageUrl(imageUrl); 
	     
	 String selectedCategory= objNewPost.addCatElect();
	 Assert.assertEquals(selectedCategory,"ELECTRONICS");
	     
	 objNewPost.setPost(post);
	 objNewPost.clickSend();
	 Thread.sleep(2000);
	 objNewPost.verifyAlertMsg();
	 System.out.println("Post added for Electronics");
	 Thread.sleep(2000);
	}
	 	
}
		
