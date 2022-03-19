package com.techblog.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstants;
import com.techblog.pages.AdminAdReCate;
import com.techblog.pages.Login;
import com.techblog.utilities.ExcelUtility;

public class TCAdminAdReCate extends TestBase{
	Login objLogin;
	@Test(priority=1)
	public void verifyAdminLogin() throws IOException, InterruptedException {
		//Create Login Page object
		
		objLogin = new Login(driver);
		
		objLogin.clickDropDown();
		objLogin.SelectLogin();
		
		//login to application
		String loginname = ExcelUtility.getCellData(34, 4);
	    //String loginpass = ExcelUtility.getCellData(35, 4);
		WebElement pass=driver.findElement(By.id("pwd"));
	    objLogin.setLoginName(loginname);
	   // objLogin.strLoginPass(loginpass);
	    pass.sendKeys("1234");
	    objLogin.clickSubmLogin();
	    
	    Thread.sleep(2000);
		String expectedURL =AutomationConstants.URL7;
		String actualURL =driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertEquals(expectedURL,actualURL);
		}
	
	 AdminAdReCate objAdminAdReCate;
	@Test(priority=1)
	public void verifyActions() throws IOException, InterruptedException {
		//Create Login Page object
		
		objAdminAdReCate = new  AdminAdReCate(driver);
		
		
	}
}
