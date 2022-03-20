package com.techblog.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.pages.HomeF;
import com.techblog.pages.NewPostF;
import com.techblog.utilities.ExcelUtilityF;

public class TCAdminNewPostF extends TestBase{
	NewPostF objNewPostF;
	HomeF  objHomeF;
	
	
	@Test(priority=1)
    public void verifyNewPost() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
    //Create NewPost and homepage  objects
		objNewPostF = new NewPostF(driver);
		objHomeF = new HomeF(driver);
		
	//Calling functions	
		objHomeF.clickHome();
		objNewPostF.clickAction();
		objNewPostF.clickNewPost();
		
	    String title = ExcelUtilityF.getCellData(1,5);
	    String author = ExcelUtilityF.getCellData(2,5);
	    String imageurl = ExcelUtilityF.getCellData(3,5);
	    String post = ExcelUtilityF.getCellData(4,5);
	    
	    objNewPostF.setTitle(title);
	    objNewPostF.setAuthor(author);   
	    objNewPostF.setImageUrl(imageurl);
	    
	    
	     String selectedCategory= objNewPostF.addCatRobot();
	     Assert.assertEquals(selectedCategory,"ROBOTICS");
	    objNewPostF.setPostContent(post);
		objNewPostF.clickSubmit();
	Thread.sleep(2000);
	String alertMessage= driver.switchTo().alert().getText();
	System.out.println(alertMessage);
	driver.switchTo().alert().accept();
	objHomeF.scrollToView1();
	}

		
	}	


