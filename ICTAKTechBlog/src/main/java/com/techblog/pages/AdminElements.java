<<<<<<< HEAD
package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminElements {
	
	WebDriver driver;
	 
	 //objects
	 @FindBy (xpath="/html/body/app-root/app-admin/app-header/nav/div/div/ul/li[2]/a")
	 private WebElement allposts;
	 
	 @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/h5")
	 private WebElement links;
	 
	 @FindBy (xpath="/html/body/app-root/app-footer/footer/div[1]/a[1]")
	 private WebElement homelow;
	 
	 @FindBy(xpath="/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[3]/a")
	 private WebElement myposts;
	 
	 public AdminElements(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }

	
	 public void clickAllPosts(){ 
	    	allposts.click();
	 }
	    	
	 public void Myposts(){ 
	    	myposts.click();
	   	} 
	      	
	  
	    
	
	

}
=======
package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminElements {
	
	WebDriver driver;
	 
	 //objects
	 @FindBy (xpath="/html/body/app-root/app-admin/app-header/nav/div/div/ul/li[2]/a")
	 private WebElement allposts;
	 
	 @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/h5")
	 private WebElement links;
	 
	 @FindBy (xpath="/html/body/app-root/app-footer/footer/div[1]/a[1]")
	 private WebElement homelow;
	 
	 @FindBy(xpath="/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[3]/a")
	 private WebElement myposts;
	 
	 public AdminElements(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }

	
	 public void clickAllPosts(){ 
	    	allposts.click();
	 }
	    	
	 public void Myposts(){ 
	    	myposts.click();
	   	} 
	      	
	  
	    
	
	

}
>>>>>>> ec2d49963ebd06203cfa3a68ad0b980969050210
