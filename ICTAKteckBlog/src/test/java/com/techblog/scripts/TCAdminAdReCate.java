package com.techblog.scripts;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstants;
import com.techblog.pages.AdminAdReCate;
import com.techblog.pages.Login;
import com.techblog.utilities.ExcelUtility;

	public class TCAdminAdReCate extends TestBase{
	AdminAdReCate objAdminAdReCate;
	
		@Test(priority=1)
		public void verifyAdminLogin() throws IOException, InterruptedException {
		//Create Login Page object
		
			objAdminAdReCate = new  AdminAdReCate(driver);
			
			objAdminAdReCate.clickDropDown();
			objAdminAdReCate.SelectLogin();
			
			//login to application
			String loginname = ExcelUtility.getCellData(34, 4);
		    String loginpass = ExcelUtility.getCellData(35, 4);
		    objAdminAdReCate.setLoginName(loginname);
		    objAdminAdReCate.strLoginPass(loginpass);
		    objAdminAdReCate.clickSubmLogin();
		    
		    Thread.sleep(2000);
			String expectedURL =AutomationConstants.URL7;
			String actualURL =driver.getCurrentUrl();
			System.out.println(actualURL);
			Assert.assertEquals(expectedURL,actualURL);
			Thread.sleep(2000);
			}
		@Test(priority=2)
		public void verifyActions() throws IOException, InterruptedException {
			//Create Login Page object
			objAdminAdReCate = new  AdminAdReCate(driver);
		
			objAdminAdReCate.clickActions();
			objAdminAdReCate.clickAddCat();
			
			Thread.sleep(2000);
			String expectedURL =AutomationConstants.URL8;
			String actualURL =driver.getCurrentUrl();
			System.out.println(actualURL);
			Assert.assertEquals(expectedURL,actualURL);
			}
		@Test(priority=3)
		public void verifyAddCatNull() throws IOException, InterruptedException {
			//Create Login Page object
			objAdminAdReCate = new  AdminAdReCate(driver);
		
			objAdminAdReCate.clickAdd();
			if (objAdminAdReCate.clickAdd()){
			System.out.println("ADD Enabled");
			}else {
			System.out.println("ADD 'Null'");
			}
			}
		@Test(priority=4)
		public void verifyAddCatSmallLet() throws IOException, InterruptedException {
			//Create Login Page object
			objAdminAdReCate = new  AdminAdReCate(driver);
	
			String newcat = ExcelUtility.getCellData(37, 4);
			objAdminAdReCate.setNewCat(newcat);
			objAdminAdReCate.clickAdd();
			if (objAdminAdReCate.clickAdd()){
			System.out.println("ADD Enabled");
			}else {
			System.out.println("ADD 'Not enabled'");
			}
			}
		@Test(priority=5)
		public void verifyAddCatCAPS() throws IOException, InterruptedException {
			//Create Login Page object
			objAdminAdReCate = new  AdminAdReCate(driver);
			driver.navigate().refresh();
			
			String newcat = ExcelUtility.getCellData(38, 4);
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
			//Create Login Page object
			objAdminAdReCate = new  AdminAdReCate(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			objAdminAdReCate.clickRemove();
		
			Thread.sleep(2000);
			String alertMessage= driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			driver.switchTo().alert().accept();
			}
		@Test(priority=7)
		public void verifyAdminLogout() throws IOException, InterruptedException {
			//Create Login Page object
			objAdminAdReCate = new  AdminAdReCate(driver);
			objAdminAdReCate.clickLogout();

			Thread.sleep(2000);
			String expectedTitle=AutomationConstants.HOMEPAGETITLE;
			String actualTitle =driver.getTitle();
			System.out.println("Title of the page Loaded is "+actualTitle);
			Assert.assertEquals(expectedTitle,actualTitle);
			}
}
