package com.techblog.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstantsF;
import com.techblog.pages.AdminAdReCate;
import com.techblog.pages.HomeF;
import com.techblog.utilities.ExcelUtilityF;

import com.techblog.scripts.TestBase;

public class TCAdminAdReCate extends TestBase{
		AdminAdReCate objAdminAdReCate;
		HomeF objHomeF;
		
		/*	@Test(priority=1)
			public void verifyAdminLogin() throws IOException, InterruptedException {
			//Create Login Page object
				
				
			
				objAdminAdReCate = new  AdminAdReCate(driver);
				
				/*objAdminAdReCate.clickDropDown();
				objAdminAdReCate.SelectLogin();
				
				//login to application
				String loginname = ExcelUtilityF.getCellData(1,2);
			    String loginpass = ExcelUtilityF.getCellData(1,3);
			    objAdminAdReCate.setLoginName(loginname);
			    objAdminAdReCate.strLoginPass(loginpass);
			    objAdminAdReCate.clickSubmLogin();
			    
			    Thread.sleep(2000);
				String expectedURL =AutomationConstantsF.URLADMIN;
				String actualURL =driver.getCurrentUrl();
				System.out.println(actualURL);
				Assert.assertEquals(expectedURL,actualURL);
				Thread.sleep(2000);
				}*/
			@Test(priority=1)
			public void verifyActions() throws IOException, InterruptedException {
				driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				//Create Addcat Page object
				objAdminAdReCate = new  AdminAdReCate(driver);
			
				objAdminAdReCate.clickActions();
				objAdminAdReCate.clickAddCat();
				
				Thread.sleep(2000);
				String expectedURL =AutomationConstantsF.URL8;
				String actualURL =driver.getCurrentUrl();
				System.out.println(actualURL);
				Assert.assertEquals(expectedURL,actualURL);
				}
			@Test(priority=2)
			public void verifyAddCatNull() throws IOException, InterruptedException {
				driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);	
				//Create Login Page object
				driver.navigate().refresh();
				objAdminAdReCate = new  AdminAdReCate(driver);
		Thread.sleep(2000);	
				objAdminAdReCate.clickAdd();
				if (objAdminAdReCate.clickAdd()){
				System.out.println("ADD Enabled");
				}else {
				System.out.println("ADD 'Null'");
				}
				}
			@Test(priority=3)
			public void verifyAddCatSmallLet() throws IOException, InterruptedException {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				objAdminAdReCate = new  AdminAdReCate(driver);
		
				String newcat = ExcelUtilityF.getCellData(1,2);
				objAdminAdReCate.setNewCat(newcat);
				objAdminAdReCate.clickAdd();
				
				if (objAdminAdReCate.clickAdd()){
				System.out.println("ADD Enabled");
				}else {
				System.out.println("ADD 'Not enabled'");
				}
				}
			@Test(priority=4)
			public void verifyAddCatCAPS() throws IOException, InterruptedException {
				//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				objAdminAdReCate = new  AdminAdReCate(driver);
				driver.navigate().refresh();
				
				String newcat = ExcelUtilityF.getCellData(2,2);
				objAdminAdReCate.setNewCat(newcat);
				objAdminAdReCate.clickAdd();
				if (objAdminAdReCate.clickAdd()){
				System.out.println("ADD Enabled");
				}else {
				System.out.println("ADD 'Not enabled'");
				}
				objAdminAdReCate.clickAdd1();
				
				Thread.sleep(2000);
				String alertMessage= driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				driver.switchTo().alert().accept();
				}
			@Test(priority=6, enabled=false)
			public void verifyRemoveCat() throws IOException, InterruptedException {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				objHomeF= new HomeF(driver);
				objAdminAdReCate = new  AdminAdReCate(driver);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				objAdminAdReCate.clickRemove();
			
				Thread.sleep(2000);
				String alertMessage= driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				driver.switchTo().alert().accept();
				objHomeF.scrollToView1();
				}
			/*@Test(priority=7)
			public void verifyAdminLogout() throws IOException, InterruptedException {
				//Create Login Page object
				objAdminAdReCate = new  AdminAdReCate(driver);
				//objAdminAdReCate.clickLogout();

				Thread.sleep(2000);
				String expectedTitle=AutomationConstantsF.HOMEPAGETITLE;
				String actualTitle =driver.getTitle();
				System.out.println("Title of the page Loaded is "+actualTitle);
				Assert.assertEquals(expectedTitle,actualTitle);
				}*/
	


}
