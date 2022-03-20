
package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPosts {

	
WebDriver driver;
	
@FindBy(xpath="/html/body/app-root/app-admin/app-header/nav/div/div/ul/li[7]/a/p")
    private WebElement actions;
	
    @FindBy(xpath="//a[@href='/approval']")
    private WebElement pendingApproval;
	
@FindBy(xpath="//a[@href='/category']")
    private WebElement addRemCat;
	
@FindBy(xpath="//a[@href='/newpost']")
    private WebElement newPost;
	
@FindBy(xpath="//div[@class='px-5 py-2']/child::h2")
    private WebElement allPostHeader;
	
	  
public AllPosts(WebDriver driver){
     this.driver = driver;
PageFactory.initElements(driver, this);
   }

	
//AllPosts page header
    public String getAllPostsPgHeader() {
    return allPostHeader.getText();
    }
	
   //click Actions dropdown
	public void clickActions(){
	actions.click();
	}
	
	
   //Navigate to Pending approvals page
	public PendingApprovals clickPendingApproval() {
	pendingApproval.click();
	return new PendingApprovals(driver);
   }
}