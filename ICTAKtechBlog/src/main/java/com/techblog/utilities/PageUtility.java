package com.techblog.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	 public WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, int Time) {
	        WebDriverWait wait = new WebDriverWait(driver, Time);
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
	        return element;
	    }
	 public WebElement waitForElementTobeClickable(WebDriver driver, WebElement elementToBeClickable, int Time) {
	        WebDriverWait wait = new WebDriverWait(driver, Time);
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
	        return element;
	    }
	 public void hitenter(WebDriver driver, WebElement element) {
	        //Retrieve WebElemnt  to perform mouse hover
	    	Actions actions = new Actions(driver);
	    	actions.sendKeys(element,Keys.ENTER);
	    	actions.build().perform();
	    }
	 public void doubleClick(WebDriver driver, WebElement element) {
	        //Retrieve WebElemnt  to perform mouse hover
	    	Actions actions = new Actions(driver);
	    	actions.doubleClick(element);
	    	actions.build().perform();
	    }
	 public void contextClick(WebDriver driver, WebElement element) {
	        //Retrieve WebElemnt  to perform mouse hover
	    	Actions actions = new Actions(driver);
	    	actions.contextClick(element);
	    	actions.build().perform();
	    }
}

