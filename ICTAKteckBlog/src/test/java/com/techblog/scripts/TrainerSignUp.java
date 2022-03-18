package com.techblog.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.SignUp;
import com.techblog.utilities.ExcelUtility;

	public class TrainerSignUp extends TestBase{
	SignUp objSignUp;
	
		@Test(priority=1)
		public void verifyInvalidTrainerEmail() throws IOException, InterruptedException {
		//Create Signup Page object
		
			objSignUp = new SignUp(driver);
			objSignUp.clickDropDown();
			objSignUp.SelectSignUp();
			
			String trainername = ExcelUtility.getCellData(12, 3);
			String traineremail = ExcelUtility.getCellData(13, 3);
			String trainerpassword = ExcelUtility.getCellData(14, 3);
			objSignUp.setYourName(trainername);
			objSignUp.SelectTrainer();
			objSignUp.clickDropDownQual();
			objSignUp.SelectQual();
			objSignUp.setTrainerEmail(traineremail);
			objSignUp.setTrainerPassword(trainerpassword);
			objSignUp.clickSubmitTrainer();

			if (objSignUp.clickSubmitTrainer1()){
				System.out.println("SUBMIT Enabled");
				}else {
				System.out.println("InvalidTrainerEmail-SUBMIT Not enabled");
				}
				}
		@Test(priority=2)
		public void verifyInvalidPasswordTrainerSignup() throws IOException, InterruptedException {
	
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();
			
			String trainername = ExcelUtility.getCellData(20, 4);
			String traineremail = ExcelUtility.getCellData(21,4);
			String trainerpassword = ExcelUtility.getCellData(22, 4);
			objSignUp.setYourName(trainername);
			objSignUp.SelectTrainer();
			objSignUp.clickDropDownQual();
			objSignUp.SelectQual();
			objSignUp.setTrainerEmail(traineremail);
			objSignUp.setTrainerPassword(trainerpassword);
			objSignUp.clickSubmitTrainer();

			Thread.sleep(2000);
			if (objSignUp.clickSubmitTrainer1()){
				System.out.println("SUBMIT Enabled");
				}else {
				System.out.println("InvalidTrainerPW- SUBMIT Not enabled");
				}
			}
		@Test(priority=3)
		public void verifyValidTrainerSignup() throws IOException, InterruptedException {
		
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();

			String trainername = ExcelUtility.getCellData(24, 4);
			String traineremail = ExcelUtility.getCellData(25,4);
			String trainerpassword = ExcelUtility.getCellData(26, 4);
			
			objSignUp.setYourName(trainername);
			objSignUp.SelectTrainer();
			objSignUp.clickDropDownQual();
			objSignUp.SelectQual();
			objSignUp.setTrainerEmail(traineremail);
			objSignUp.setTrainerPassword(trainerpassword);
			objSignUp.clickSubmitTrainer();

			Thread.sleep(2000);
			String alertmessg4=driver.switchTo().alert().getText();
			System.out.println(alertmessg4);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			String expectedURL =AutomationConstants.URL3;
			String actualURL =driver.getCurrentUrl();
			//Assert.assertEquals(expectedURL,actualURL);
			}
		@Test(priority=4)
		public void verifySignin() throws IOException, InterruptedException {
	
			objSignUp = new SignUp(driver);
			driver.navigate().refresh();
			objSignUp.clickLoginButton();
			
			String expectedURL =AutomationConstants.URL3;
			String actualURL =driver.getCurrentUrl();
			System.out.println(actualURL);
			Assert.assertEquals(expectedURL,actualURL);
			}
	}

