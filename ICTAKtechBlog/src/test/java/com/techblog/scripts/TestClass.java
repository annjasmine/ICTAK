package com.techblog.scripts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.techblog.constants.AutomationConstants;
import com.techblog.pages.LandingPage;
import com.techblog.pages.SignUp;
import com.techblog.utilities.ExcelUtility;
import com.techblog.utilities.PageUtility;

public class TestClass extends TestBase{
LandingPage objLandingPage;
@Test(priority=1)
public void verifyLandingPage() throws IOException, InterruptedException {
	
//Create Landing Page object
objLandingPage = new LandingPage(driver);

String expectedTitle=AutomationConstants.HOMEPAGETITLE;
String actualTitle =driver.getTitle();
System.out.println("Title of the page Loaded is "+actualTitle);
Assert.assertEquals(expectedTitle,actualTitle);
}

@Test(priority=2)
public void varifyingFeedback() throws IOException, InterruptedException {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
String firstname = ExcelUtility.getCellData(0,3);
String lastname = ExcelUtility.getCellData(1,3);
String subject = ExcelUtility.getCellData(2,3);
objLandingPage.setFirstName(firstname);
objLandingPage.setLastName(lastname);
objLandingPage.setSubject(subject);
objLandingPage.clickSubmit();

String alertmessg=driver.switchTo().alert().getText();
System.out.println(alertmessg);
Thread.sleep(2000);
driver.switchTo().alert().accept();
Thread.sleep(2000);
}
@Test(priority=3)
public void varifyingContactUs() throws IOException, InterruptedException {

objLandingPage.clickContactUs();
String expectedURL =AutomationConstants.URL2;
String actualURL =driver.getCurrentUrl();
System.out.println(actualURL);
Assert.assertEquals(expectedURL,actualURL);

String tname = ExcelUtility.getCellData(0,4);
String email= ExcelUtility.getCellData(1,4);
String message = ExcelUtility.getCellData(2,4);
objLandingPage.setName(tname);
objLandingPage.setEmail(email);
objLandingPage.setMessage(message);
objLandingPage.clickSubmit1();

String alertmessg2=driver.switchTo().alert().getText();
System.out.println(alertmessg2);
Thread.sleep(2000);
driver.switchTo().alert().accept();
Thread.sleep(2000);
}
@Test(priority=4)
public void varifyingLatestArticles() throws IOException, InterruptedException {

objLandingPage.clickHomePage();
WebElement  jupiter=driver.findElement(By.xpath("//*[text()='Metal clouds and liquid gems spotted in the atmosphere of hot Jupiter WASP-121 b']")); 
JavascriptExecutor ex=(JavascriptExecutor)driver;
Thread.sleep(2000);
ex.executeScript("arguments[0].click()", jupiter);
Thread.sleep(2000);

String expectedURL3 =AutomationConstants.URL5;
String actualURL3 =driver.getCurrentUrl();
System.out.println(actualURL3);
Assert.assertEquals(expectedURL3,actualURL3);
Thread.sleep(3000);

}
@Test(priority=6)
public void varifyingAboutUs() throws IOException, InterruptedException {

objLandingPage.clickAboutUs();
String expectedURL2 =AutomationConstants.URL1;
String actualURL2 =driver.getCurrentUrl();
System.out.println(actualURL2);
Assert.assertEquals(expectedURL2,actualURL2);
Thread.sleep(3000);

objLandingPage.clickTerms();

if (objLandingPage.clickTerms()) {
		System.out.println("Terms Enabled, but unable to click");
}else {
		System.out.println("Terms 'Null'");
}
Thread.sleep(2000);

objLandingPage.clickHandle();

if (objLandingPage.clickTerms()) {
		System.out.println("Social media handles are unable to click");
}else {
		System.out.println("Terms 'Null'");
}
Thread.sleep(2000);
}
@Test(priority=5)
public void varifyingCategories() throws IOException, InterruptedException {
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
objLandingPage.clickDrpCatagories();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
objLandingPage.clickSpace();

String expectedURL4 =AutomationConstants.URL6;
String actualURL4 =driver.getCurrentUrl();
System.out.println(actualURL4);
Assert.assertEquals(expectedURL4,actualURL4);
driver.navigate().back();
/*
WebElement space= driver.findElement(By.xpath("/html/body/app-root/app-group/div[2]/li[15]/div/div/div/small"));
JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click()", space); 

String expectedURL5 =AutomationConstants.URL5;
String actualURL5 =driver.getCurrentUrl();
System.out.println(actualURL5);
Assert.assertEquals(expectedURL5,actualURL5);
Thread.sleep(2000);

*/
}
}


