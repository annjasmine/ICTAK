package com.techblog.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class NewPost {

	WebDriver driver;
	
	
	@FindBy(xpath="//h2[@class='my-5 text-white']")
	private WebElement addNewpostHeader;

	@FindBy(xpath="//input[@name='P_title']")
    private WebElement title;
	
	@FindBy(xpath="//input[@name='P_author']")
    private WebElement author;
	
	@FindBy(xpath="//input[@name='P_image']")
    private WebElement imageUrl;
	
	@FindBy(xpath="//select[@name='p_cat']")
    private WebElement category;
    
    @FindBy(xpath="//textarea[@name='p_post']")
    private WebElement post;
    
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sendForApproval;
	

	
	public NewPost(WebDriver driver){
	 this.driver = driver;
	PageFactory.initElements(driver, this);
   }

	
   //Verify Add Newpost title
    public String getNewpostHeader() {
    	
    return addNewpostHeader.getText();
   }
    
    
   //Add Title for post
    public void setTitle(String strTitle){
    	
    title.sendKeys(strTitle); 
   }
    
    
    //Clear Title
    public void clearTitle() {
    	
    title.clear();
   }
    
    
    public String getAuthorName() { 
    	
    return author.getAttribute("value");
   }
    
    
   //Add image url for post
    public void setImageUrl(String url){
    	
    	 imageUrl.sendKeys(url); 
    }
    
    
   //Clear Image url
    public void clearImageUrl() {
    	
    	imageUrl.clear();
   }
    
    
   //Select category 
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
   
   
    //Add Post Contents 
     public void setPost(String strPost) {
    	
     post.sendKeys(strPost); 
    }
    
     
    //Clear Post Contents
     public void clearPost() {
    	
     post.clear();
    }
    
     
    public void clickSend(){
     	
     sendForApproval.sendKeys(Keys.RETURN);
    }
    
     
    //Verify Alert messages 
     public void verifyAlertMsg() throws InterruptedException {
    	
     String alertMsg = driver.switchTo().alert().getText();
     System.out.println(alertMsg);
     Thread.sleep(2000);
     driver.switchTo().alert().accept();
    }
    
     
    //Title containing empty strings
     public void emptyTitle() {
		
	 title.sendKeys("");
    }
   
     
   //Image url containing empty strings 
    public void emptyImageUrl() {
		
	imageUrl.sendKeys("");
   }
   
    
   //Post contents containing empty strings 
    public void emptyPostContent() {
		
	post.sendKeys("");
   }
   
   
    public boolean sendButtonEnabled() {
	   
    return sendForApproval.isEnabled();
    }
   
    
   //Scroll Element into view
    public void scrollToView(){
    	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  title);
   }

} 







    
    