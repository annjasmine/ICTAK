package com.techblog.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstantsF;
import com.techblog.pages.LoginF;
import com.techblog.utilities.ExcelUtilityF;

import com.techblog.scripts.TestBase;

public class TCAdminLoginClassF extends TestBase{
	LoginF objLoginF;


	//@BeforeClass
	@Test(priority=1)
    public void verifyValidLogin() throws IOException, Exception {
    //Create Login Page object
    objLoginF = new LoginF(driver);
    //login to application
    
    objLoginF.clickDropDown();
    objLoginF.SelectLogin();
    String username = ExcelUtilityF.getCellData(1,0);
   //String password = ExcelUtilityF.getCellData(2,0);
    objLoginF.setUserName(username);
  // objLoginF.setPassword(password);
    /*WebElement username=driver.findElement(By.id("user"));
    username.sendKeys("admin");*/
    WebElement password=driver.findElement(By.id("pwd"));
    password.sendKeys("1234");
    objLoginF.clickLogin();
    
    Thread.sleep(2000);
    
        String expectedURL =AutomationConstantsF.URLADMIN;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);

    Thread.sleep(2000);
    }

	
}
