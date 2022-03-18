package com.techblog.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.SignUp;
import com.techblog.utilities.ExcelUtility;

	public class UserSignup extends TestBase{
	SignUp objSignUp;
	
		@Test(priority=1)
		public void verifyNullUserSignup() throws IOException, InterruptedException {
		
			objSignUp = new SignUp(driver);
			objSignUp.clickDropDown();
			objSignUp.SelectSignUp();
			Thread.sleep(2000);
	
			objSignUp.clickSubmitUser();
			
			if (objSignUp.clickSubmitUser1()){
				System.out.println("SUBMIT Enabled");
				}else {
				System.out.println("NullUserSignup- SUBMIT Not enabled");
				}
				}
		@Test(priority=2)
		public void verifyInvalidUserName() throws IOException, InterruptedException {
			
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();
			Thread.sleep(2000);

			String yourname = ExcelUtility.getCellData(8, 3);
			String youremail = ExcelUtility.getCellData(9, 3);
			String yourpassword = ExcelUtility.getCellData(10, 3);
			objSignUp.setYourName(yourname);
			objSignUp.SelectUser();
			objSignUp.setYourEmail(youremail);
			objSignUp.setYourPassword(yourpassword);
			objSignUp.clickSubmitUser();
			Thread.sleep(2000);
			
			String alertmessg=driver.switchTo().alert().getText();
			System.out.println(alertmessg);
			driver.switchTo().alert().accept();
			}
		@Test(priority=3)
		public void verifyInvalidUserEmail() throws IOException, InterruptedException {
			
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();

			String yourname = ExcelUtility.getCellData(12, 3);
			String youremail = ExcelUtility.getCellData(13, 3);
			String yourpassword = ExcelUtility.getCellData(14, 3);
			objSignUp.setYourName(yourname);
			objSignUp.SelectUser();
			objSignUp.setYourEmail(youremail);
			objSignUp.setYourPassword(yourpassword);
			objSignUp.clickSubmitUser();
		
			Thread.sleep(2000);
			String expectedErrorMessage =AutomationConstants.ERROR_MESSAGE1;
			String actualErrorMessage =objSignUp.getErrorMessage1();
			System.out.println("InvalidUserEmail Error= "+actualErrorMessage);
			Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
			}
		@Test(priority=4)
		public void verifyInvalidPassword() throws IOException, InterruptedException {
	
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();
			
			String yourname = ExcelUtility.getCellData(16, 3);
			String youremail = ExcelUtility.getCellData(17, 3);
			String yourpassword = ExcelUtility.getCellData(18, 3);
			objSignUp.setYourName(yourname);
			objSignUp.SelectUser();
			objSignUp.setYourEmail(youremail);
			objSignUp.setYourPassword(yourpassword);
			objSignUp.clickSubmitUser();

			Thread.sleep(2000);
			String pwerror1=objSignUp.getErrorMessage2();
			System.out.println("Short PW Error= "+pwerror1);
			}
		@Test(priority=5)
		public void verifyInValidPassword2() throws IOException, InterruptedException {
	
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();

			//login to application
			String yourname = ExcelUtility.getCellData(20, 3);
			String youremail = ExcelUtility.getCellData(21, 3);
			String yourpassword = ExcelUtility.getCellData(22, 3);
			objSignUp.setYourName(yourname);
			objSignUp.SelectUser();
			objSignUp.setYourEmail(youremail);
			objSignUp.setYourPassword(yourpassword);
			objSignUp.clickSubmitUser();

			Thread.sleep(2000);
			String pwerror2=objSignUp.getErrorMessage2();
			System.out.println("Special Chr in PW Error= "+pwerror2);
			}
		@Test(priority=6)
		public void verifyValidUserSignup() throws IOException, InterruptedException {
	
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();

			String yourname = ExcelUtility.getCellData(24, 3);
			String youremail = ExcelUtility.getCellData(25, 3);
			String yourpassword = ExcelUtility.getCellData(26, 3);
			objSignUp.setYourName(yourname);
			objSignUp.SelectUser();
			objSignUp.setYourEmail(youremail);
			objSignUp.setYourPassword(yourpassword);
			objSignUp.clickSubmitUser();
		
			Thread.sleep(2000);
			String alertmessg3=driver.switchTo().alert().getText();
			System.out.println(alertmessg3);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			String expectedURL =AutomationConstants.URL3;
			String actualURL =driver.getCurrentUrl();
			//Assert.assertEquals(expectedURL,actualURL);
			}
}
