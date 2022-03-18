package com.techblog.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstants;
import com.techblog.pages.Login;
import com.techblog.pages.SignUp;
import com.techblog.utilities.ExcelUtility;

	public class TCLogin extends TestBase{
	Login objLogin;
			@Test(priority=1)
			public void verifyNullLogin() throws IOException, InterruptedException {
				objLogin = new Login(driver);
			
				objLogin.clickDropDown();
				objLogin.SelectLogin();
			    objLogin.clickSubmLogin();
			    
			    Thread.sleep(2000);
			    if (objLogin.clickSubmitLogin1()){
					System.out.println("SUBMIT Enabled");
					}else {
					System.out.println("NullUserSignup- SUBMIT Not enabled");
					}

				}
			@Test(priority=2)
			public void verifyInvalidPasswLogin() throws IOException, InterruptedException {
			//Create Login Page object
			
				objLogin = new Login(driver);
				driver.navigate().refresh();
				
				//login to application
				String loginname = ExcelUtility.getCellData(28, 4);
			    String loginpass = ExcelUtility.getCellData(29, 4);
			  
			    objLogin.setLoginName(loginname);
			    objLogin.strLoginPass(loginpass);
			    objLogin.clickSubmLogin();
			  
			    Thread.sleep(2000);
				String alertmessg=driver.switchTo().alert().getText();
				System.out.println("InvalidLoginPWD pops "+alertmessg);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				}
			@Test(priority=3)
			public void verifyInvalidEmailLogin() throws IOException, InterruptedException {
				objLogin = new Login(driver);
				driver.navigate().refresh();
			
				String loginname = ExcelUtility.getCellData(31, 4);
			    String loginpass = ExcelUtility.getCellData(32, 4);
			  
			    objLogin.setLoginName(loginname);
			    objLogin.strLoginPass(loginpass);
			    objLogin.clickSubmLogin();
			  
			    Thread.sleep(2000);
				String alertmessg=driver.switchTo().alert().getText();
				System.out.println("InvalidLoginEMAIL pops "+alertmessg);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				}
			@Test(priority=4)
			public void verifySignUpLink() throws IOException, InterruptedException {
				objLogin = new Login(driver);
					
				driver.navigate().refresh();
				objLogin.clickSignUpButton();
				
				String expectedURL =AutomationConstants.URL4;
				String actualURL =driver.getCurrentUrl();
				System.out.println(actualURL);
				Assert.assertEquals(expectedURL,actualURL);
				}
			}
