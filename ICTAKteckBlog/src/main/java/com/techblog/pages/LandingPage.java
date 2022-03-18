package com.techblog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
		 WebDriver driver;
		 
		 //Feedback   
		    @FindBy(id="fname")
		    private WebElement firstname;
		    @FindBy(id="lname")
		    private WebElement lastname; 
		    @FindBy(id="country") 
		    private WebElement countryDropdown;
		    @FindBy(id="subject")
		    private WebElement subject; 
		    @FindBy(xpath="//input[@value='Submit']")
		    private WebElement submit;
	
		    //contact us
		    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[2]")
		    private WebElement contactus;
		    @FindBy(id="name")
		    private WebElement tname;
		    @FindBy(id="email")
		    private WebElement email;
		    @FindBy(name="message")
		    private WebElement message;
		    @FindBy(id="submit")
		    private WebElement submitmessage;
		    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[1]")
		    private WebElement github;
		    //About us
		    @FindBy (xpath="//*[text()='About us']")
		    private WebElement aboutus;
		    @FindBy (xpath="/html/body/app-root/app-footer/footer/div[3]/p[2]")
		    private WebElement terms;
		    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[1]")
		    private WebElement fb;
		    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[2]")
		    private WebElement insta;
		    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[3]")
		    private WebElement linkin;
		    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[4]")
		    private WebElement twit;
		    
		    //Latest articles
		    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[1]")
		    private WebElement homepage;
		    @FindBy(xpath="*[text()='Metal clouds and liquid gems spotted in the atmosphere of hot Jupiter WASP-121 b']")
		    private WebElement jupiter;
		    
		    //Explore Categories
		    @FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[7]")
		    private WebElement drpcatagories;
		    @FindBy(xpath="//*[text()='SPACE']")
		    private WebElement space;
		    
		    public LandingPage(WebDriver driver){
		    this.driver = driver;
		        
		    PageFactory.initElements(driver, this);
		    }
		    //enter data in Feedback
		     public void setFirstName(String strFirstName){
		        firstname.sendKeys(strFirstName);  
		    }
		     public void setLastName(String strLastName){
		            lastname.sendKeys(strLastName);
		    }   
		     public void setSubject(String strSubject){
		            subject.sendKeys(strSubject);
		    } 
		     public void clickSubmit(){
		            submit.click();
		     }
		     
		     //Enter data in Contact us
		     public void clickContactUs(){
			            contactus.click();
		     }
			 public void setName(String strName){
					        tname.sendKeys(strName);             
			 }
			 public void setEmail(String strEmail){
			        email.sendKeys(strEmail);  
			 }
			 public void setMessage(String strMessage){
			        message.sendKeys(strMessage);  
			 }
			 public void clickSubmit1(){
			            submitmessage.click();
		     }
			 public boolean clickGithub(){
		            return github.isEnabled();
			 }
			//Navigate About us page
		     public void clickAboutUs(){
			            aboutus.click();
		    }      
		     public boolean clickHandle(){
		            return fb.isEnabled();
		            //return linkin.isEnabled();
		            //return twit.isEnabled();
		            //return insta.isEnabled();
		     }
		     public boolean clickTerms() {
		    	 return terms.isEnabled();
		    }
		   //Explore Latest Articles section
		     public void clickHomePage(){  
		            homepage.click();
		    }
		     public void clickJupiter(){  
		           jupiter.click();
		     }
		   //Explore categories
		     public void clickDrpCatagories(){  
		    	 drpcatagories.click();
		     }
		     public void clickSpace(){  
		    	 space.click();
		     }
}