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
	driver.navigate().refresh();
	objSignUp.clickDropDown();
	objSignUp.SelectSignUp();
	//login to application
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

		Thread.sleep(2000);
		String expectedErrorMessage =AutomationConstants.ERROR_MESSAGE3;
		String actualErrorMessage =objSignUp.getErrorMessage3();
		System.out.println("InvalidTrainerEmailError is "+actualErrorMessage);
		Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
		}
	
	@Test(priority=2)
	public void verifyInvalidPasswordTrainerSignup() throws IOException, InterruptedException {
	//Create Signup Page object
	
	objSignUp = new SignUp(driver);
	driver.navigate().refresh();
	objSignUp.clickDropDown();
	objSignUp.SelectSignUp();
	//login to application
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

	//String expectedErrorMessage2 =AutomationConstants.ERROR_MESSAGE4;
	//String actualErrorMessage2 =objSignUp.getErrorMessage4();
	//System.out.println("InvalidTrainerPasswordError is "+actualErrorMessage2);
	//Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
	}
	@Test(priority=3)
	public void verifyValidTrainerSignup() throws IOException, InterruptedException {
	//Create Signup Page object
	
	objSignUp = new SignUp(driver);
	driver.navigate().refresh();
	objSignUp.clickDropDown();
	objSignUp.SelectSignUp();
	//login to application
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
	//Create Signup Page object
	
	objSignUp = new SignUp(driver);
	driver.navigate().refresh();
	objSignUp.clickLoginButton();
	
	String expectedURL =AutomationConstants.URL3;
	String actualURL =driver.getCurrentUrl();
	System.out.println(actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}
	}

