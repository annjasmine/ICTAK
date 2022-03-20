package com.techblog.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewPostF {
	
	
	 WebDriver driver;
	 
	 //objects
	 @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/a/p")
	    private WebElement actiondropdown;
	 @FindBy (xpath="//*[@id=\"nav\"]")
	 private WebElement home;
	    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/ul/li[3]/a")
	    private WebElement newpost;
	    
	    @FindBy(xpath="//input[@name=\"P_title\"]")
	    private WebElement title;
	    @FindBy(xpath="//input[@name=\"P_author\"]")
	    private WebElement author;    
	    @FindBy(xpath="//input[@name=\"P_image\"]")
	    private WebElement imageurl;
	    @FindBy(xpath="/html/body/app-root/app-newpost/form/div[4]/select")
	   	    private WebElement category; 
	    @FindBy(xpath="//textarea[@name=\"p_post\"]")
	    private WebElement post;
	    @FindBy(xpath="//button[@type=\"submit\"]")
	    private WebElement submit;

	    
	    public NewPostF(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	   //Click on Home 
	    
	    public void clickHome(){ 
	    	home.click();
	    }
	    
	    
	  //Click on drop down menu
	    public void clickAction(){ 
	    	actiondropdown.click();
	   	} 
	    
	  //Click on new post
	    public void clickNewPost(){ 
	    	newpost.click();
	   	} 
	    
	  //Set Title in text box
	    public void setTitle(String strTitle){
	    	title.sendKeys(strTitle);     
	    }
	    
	  //Set Title in text box
	    public void setAuthor(String strAuthor){
	    	author.sendKeys(strAuthor);     
	    }    
	  //Set Title in text box
	    public void setImageUrl(String strImageUrl){
	    	imageurl.sendKeys(strImageUrl);     
	    }
	    
	 //Select Category   
	    public String addCatElect(){
	    	
	        Select category_item= new Select(category);
	    	category_item.selectByVisibleText("ELECTRONICS");
	        return category_item.getFirstSelectedOption().getText();
	       }
	        
	         public String addCatRobot(){
	        	
	         Select category_item= new Select(category);
	      	 category_item.selectByVisibleText("ROBOTICS");
	         return category_item.getFirstSelectedOption().getText();
	        }
	        
	         public String addCatSpace(){
	        	
	         Select category_item= new Select(category);
	      	 category_item.selectByVisibleText("SPACE");
	         return category_item.getFirstSelectedOption().getText();
	        }
	          
	    
	  //Set Post Content
	    public void setPostContent(String strPostContent){
	    	post.sendKeys(strPostContent);     
	    }   
	    
	  //Click submit
	   
	    public void clickSubmit(){ 
	    	submit.sendKeys(Keys.RETURN);
	   	}

		
	  //Verify Alert messages 
	     public void verifyAlertMsg() throws InterruptedException {
	    	
	     String alertMsg = driver.switchTo().alert().getText();
	     System.out.println(alertMsg);
	     Thread.sleep(2000);
	     driver.switchTo().alert().accept();
	    }
	     
	     //Scroll Element into view
	      public void scrollToView(){
	      	
	  	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  title);
	     }

	    
	    
}











