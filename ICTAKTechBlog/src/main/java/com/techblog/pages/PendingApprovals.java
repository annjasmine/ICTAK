<<<<<<< HEAD
package com.techblog.pages;

	

	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class PendingApprovals {
		
		
		WebDriver driver;
		
		@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[2]/li[1]/div/div/div/button[1]")
	    private WebElement approveBtn;
		
		@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[2]/li[1]/div/div/div/button[2]")
	    private WebElement rejectBtn;
		
		@FindBy(xpath="//textarea[@name='p_post']")
	    private WebElement comment;
		
		@FindBy(xpath="//button[@type='submit']")
	    private WebElement sendBtn;
		
		@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[1]/h2")
	    private WebElement pendingApprHeader;
		
		

	    public PendingApprovals(WebDriver driver){
	     this.driver = driver;
	    PageFactory.initElements(driver, this);
	   }
	    
	    
	   //AllPosts page header
	    public String getPendingApprPgHeader() {
	    return pendingApprHeader.getText();
	    }
	    
	    
	    public void verifyApproveBtn() {
	    approveBtn.sendKeys(Keys.RETURN);
	   }
	    
	    
	    public AllPosts verifyCommentsToUser(String comments) {
	    comment.sendKeys(comments);
	    sendBtn.click();
	    return new AllPosts(driver);
	   }
	    
	    
	    public void verifyRejectBtn() {
	    rejectBtn.sendKeys(Keys.RETURN);
	   }
	}


	
	
	
	
	
	
	
	

=======
package com.techblog.pages;

	

	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class PendingApprovals {
		
		
		WebDriver driver;
		
		@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[2]/li[1]/div/div/div/button[1]")
	    private WebElement approveBtn;
		
		@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[2]/li[1]/div/div/div/button[2]")
	    private WebElement rejectBtn;
		
		@FindBy(xpath="//textarea[@name='p_post']")
	    private WebElement comment;
		
		@FindBy(xpath="//button[@type='submit']")
	    private WebElement sendBtn;
		
		@FindBy(xpath="/html/body/app-root/app-pendingapproval/div[1]/h2")
	    private WebElement pendingApprHeader;
		
		

	    public PendingApprovals(WebDriver driver){
	     this.driver = driver;
	    PageFactory.initElements(driver, this);
	   }
	    
	    
	   //AllPosts page header
	    public String getPendingApprPgHeader() {
	    return pendingApprHeader.getText();
	    }
	    
	    
	    public void verifyApproveBtn() {
	    approveBtn.sendKeys(Keys.RETURN);
	   }
	    
	    
	    public AllPosts verifyCommentsToUser(String comments) {
	    comment.sendKeys(comments);
	    sendBtn.click();
	    return new AllPosts(driver);
	   }
	    
	    
	    public void verifyRejectBtn() {
	    rejectBtn.sendKeys(Keys.RETURN);
	   }
	}


	
	
	
	
	
	
	
	

>>>>>>> ec2d49963ebd06203cfa3a68ad0b980969050210
