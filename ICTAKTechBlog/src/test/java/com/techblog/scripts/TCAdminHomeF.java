package com.techblog.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstantsF;
import com.techblog.pages.HomeF;
import com.techblog.pages.LoginF;
import com.techblog.utilities.ExcelUtilityF;

import com.techblog.scripts.TestBase;


public class TCAdminHomeF extends TestBase{
		HomeF objHomeF;
		LoginF objLoginF; // added for login
@Test(priority=1)
	    public void verifyHome() throws IOException, Exception {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    //Create Home Page object
	    objHomeF = new HomeF(driver);
	    objLoginF = new LoginF(driver);
	    
	    objLoginF.clickLogin();
	    
	    //Navigating to home page
	 	    objHomeF.clickHome();
	 	   String expectedURL =AutomationConstantsF.URLHOME;
		    String actualURL =driver.getCurrentUrl();
		   AssertJUnit.assertEquals(expectedURL,actualURL);
	 		    Thread.sleep(2000);
}
@Test(priority=2)
public void verifyDelete() throws IOException, InterruptedException {
	 //Create Home Page object
	    objHomeF = new HomeF(driver);
	    objHomeF.clickHome();
		   objHomeF.clickDelete();
		    Thread.sleep(1000);
		    String expectedURLD =AutomationConstantsF.URLDELETE;
		    String actualURL =driver.getCurrentUrl();
		    Assert.assertEquals(expectedURLD,actualURL);

		    Thread.sleep(2000);
	 
}	 
	    
 @Test(priority=3)  
 public void verifyEdit() throws IOException, InterruptedException {
	    //Create Home Page object
	    objHomeF = new HomeF(driver);
	    objLoginF = new LoginF(driver);
	    //Edit post
	 //Clicking on edit
	  //  objLoginF.clickLogin(); // login before start
	    
	    objHomeF.scrollToView1();
	    objHomeF.clickHome();
	   objHomeF.clickEdit();
	   objHomeF.scrollToView();
	    Thread.sleep(2000);
	    String expectedURL1 =AutomationConstantsF.URLEDIT;
	    String actualURL1 =driver.getCurrentUrl();
	   AssertJUnit.assertEquals(expectedURL1,actualURL1);
	   
	   Thread.sleep(2000);
	
	   
	   String title = ExcelUtilityF.getCellData(1, 5);
	   String Author = ExcelUtilityF.getCellData(2,5);
	     String imageUrl = ExcelUtilityF.getCellData(3,5);
	     String post = ExcelUtilityF.getCellData(4,5);
	     
	     objHomeF.clearTitle();
	     objHomeF.setTitle(title);
	     objHomeF.clearAuthor();
	     objHomeF.setAuthor(Author); 
	     objHomeF.clearimageURL();
	     objHomeF.setimageURL(imageUrl); 
	     objHomeF.clearPost();
	     objHomeF.setPostContent(post);
	     objHomeF.clickSubmit();
	     Thread.sleep(2000);
	    
	     String alertMessage= driver.switchTo().alert().getText();
	 	System.out.println(alertMessage);
	 	driver.switchTo().alert().accept();
	 	objHomeF.scrollToView1();
	 	objLoginF.clickLogout(); // logout 

		 }
	   
	 
}
	 
	 
	 
/* @Test(priority=4)
 public void  verifyEditPostNullTest() throws InterruptedException {
	 objHomeF = new HomeF(driver);
	 objHomeF.clickHome();
     objHomeF.clickEdit();
     Thread.sleep(1000);
 
    if (objHomeF.submitButtonEnabled()) {
	  
	System.out.println("Send button Enabled");
	objHomeF.clickSubmit();
	objHomeF.verifyAlertMsg();	
	Thread.sleep(2000);
	
    }else {
	   
	 System.out.println("Send button Disabled|Post Not Edited");
    }
    
   
 }	 */
	 
/* @Test(priority=5)
 public void  verifySubmitwithTitleEmptyStrings() throws IOException, InterruptedException {

 objHomeF = new HomeF(driver);
 //objHomeF.scrollToView();
 
 objHomeF.clickHome();
 objHomeF.clickEdit();
 objHomeF.scrollToView();
 objHomeF.clearTitle1();

  String Author = ExcelUtilityF.getCellData(2,5);
 String imageUrl = ExcelUtilityF.getCellData(3,5);
 String post = ExcelUtilityF.getCellData(4,5);
 

 

 objHomeF.clearAuthor(); 
 objHomeF.setAuthor(Author); 
 objHomeF.clearimageURL();
 objHomeF.setimageURL(imageUrl); 
 objHomeF.clearPost();
 objHomeF.setPostContent(post);
  if (objHomeF.submitButtonEnabled()) {
	  
	System.out.println("Send button Enabled");
	objHomeF.clickSubmit();
	objHomeF.verifyAlertMsg();	
	Thread.sleep(2000);
	
    }else {
	   
	 System.out.println("Send button Disabled|Post Not Added");
    }
 
 Thread.sleep(2000);
 
 } */
	 
	 
	 
	 
 	 
 
 
 
 
 
 
 
 
 
 
 
 
	    

		
