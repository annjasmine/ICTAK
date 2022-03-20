package com.techblog.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPosts {
	
	WebDriver driver;
	
    @FindBy(xpath="//div[@class='px-5 py-2']/child::h2")
    private WebElement landingPageHeader;
    
    @FindBy(xpath="//img[@src='../../assets/images/logg2.jpg']")
    private WebElement logo;
    
    @FindBy(xpath="//ul[@class='navbar-nav me-auto mb-2 mb-lg-0']/child::li")
    private WebElement home;
    
    @FindBy(xpath="//a[@href='/mypost']")
    private WebElement myPostsLink;
    
    @FindBy(xpath="//a[@href='/usernewpost']")
    private WebElement newPost;
    
    @FindBy(xpath="//a[@href='/adminmesag']")
    private WebElement adminMessages;
    
    @FindBy(xpath="//li[@class='nav-item']/child::a[@href='#']")
    private WebElement logout;
    
    @FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[1]/div/div/div/button[1]")
    private WebElement editBtn;
    
    @FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[1]/div/div/div/button[2]")
    private WebElement deleteBtn;
    
    @FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[2]/div/div/div/small")
    private WebElement readMoreLink;
    
    @FindBy(xpath="//h1[@class='card-title']")
    private WebElement postTitle;
    
    @FindBy(xpath="//img[@class='card-img-top']")
    private WebElement postImage;
    
    @FindBy(xpath="//div[@class='card-body']")
    private WebElement postContent;
  
    
    public MyPosts(WebDriver driver){
     this.driver = driver;
    PageFactory.initElements(driver, this);
   }
        
    
   //MyPosts page header
    public String getMypostHeader() {
    	
    return landingPageHeader.getText();
   }
    
     
   //Click Logo
    public Home clickTBLogo() throws InterruptedException {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  logo);
    Thread.sleep(500);
    logo.click();
	return new Home(driver);
   }
    
    //Navigate to NewPost page
     public NewPost clickNewPost() {
     newPost.click();
     return new NewPost(driver);
    }
     
     
    //Click Edit Button
     public EditPost clickEditButton() throws InterruptedException {
    	
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  editBtn);
     Thread.sleep(500);
     editBtn.sendKeys(Keys.RETURN);
     return new EditPost(driver);
    }
     
     
    //Click Delete Button
     public void clickDeleteButton() throws InterruptedException {
    	
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  deleteBtn);
     Thread.sleep(500);
     deleteBtn.sendKeys(Keys.RETURN);
    }
      
     
    //Click Readmore Link
     public void clickReadmoreLink() throws InterruptedException {
    	
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  readMoreLink);
     Thread.sleep(500);
     readMoreLink.click();
    }
    
     
    //View Post Title
     public void viewPostTitle() throws InterruptedException {
    	
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  postTitle);
     Thread.sleep(500);
     postTitle.isDisplayed();
    }
    
    //View Post Image
     public void viewPostImage() throws InterruptedException {
    	
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  postImage);
     Thread.sleep(500);
     postImage.isDisplayed();
    }
    
     
    //View Post Content
     public void viewPostContent() throws InterruptedException {
    	
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  postContent);
     Thread.sleep(500);
     postContent.isDisplayed();
    }	
    
   
    //Click admin messages
     public AdminMsgs clickAdminMsgs() throws InterruptedException {
       
     adminMessages.click();
	 return new AdminMsgs(driver);
    }
    
     
    //Click My Posts Link
     public MyPosts clickMyPostLink(){ 
    	 
     myPostsLink.sendKeys(Keys.RETURN);
	 return new MyPosts(driver);
    }
    	

    //Click Logout 
     public void clickLogout() throws InterruptedException{
        
     logout.click();
     Thread.sleep(1000);
   	}
    
}


