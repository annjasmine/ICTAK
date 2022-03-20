package com.techblog.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeF {
	
	WebDriver driver;
	 
	 //objects
	 @FindBy (xpath="//*[@id=\"nav\"]")
	 private WebElement home;
//Edit post elements	 
	 
	 @FindBy(xpath="/html/body/app-root/app-home/div/div[4]/div/li[1]/div/div/div/button[1]")
	 private WebElement edit;
	 
	 @FindBy(xpath="//input[@name=\"P_title\"]")
	 private WebElement title;
	@FindBy(xpath="//input[@name='P_author']")
	    private WebElement author;
		
		@FindBy(xpath="//input[@name='P_image']")
	    private WebElement imageUrl;
    
	    @FindBy(xpath="//textarea[@name='p_post']")
	    private WebElement post;
	    @FindBy(xpath="//button[@type='submit']")
		private WebElement submit;
	 	 
//Delete post elements
	    @FindBy(xpath="/html/body/app-root/app-home/div/div[4]/div/li[1]/div/div/div/button[2]")
	    private WebElement deleteBtn;
	 	 
	 public HomeF(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	 
	 
	 //methods to access the objects

	//Click on 'Home'
	    public void clickHome(){ 
	    	home.click();
	    }
	    
	 //Click on 'Edit'   	
	    	 public void clickEdit(){ 
	 	    	edit.sendKeys(Keys.RETURN);
	   	}
	    	
	   //Clear Title
  
	  			  public void clearTitle(){
				    	title.clear();  
	  			  }
	   //Set title in text box
	    	 
			    public void setTitle(String strTitle) throws InterruptedException{
			    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  title);
			    	    Thread.sleep(500);
		    	title.sendKeys(strTitle);     
		    }
	//Clear author
	  			  public void clearAuthor(){
				    	author.clear();  
	  			  }	    
			 			    
			    
	//Set author name	    
	    	 public void setAuthor(String strAuthor){
			    	author.sendKeys(strAuthor);     
			    }
	//Clear image url
 			  public void clearimageURL(){
			    	imageUrl.clear();  
			  }

	
	    	 //Set image url
	    	 
	  			    public void setimageURL(String strimageURL){
			    	imageUrl.sendKeys(strimageURL);     
			    }
	//Clear Post
		  			  public void clearPost(){
					    	post.clear();  
		  			  }

//Set post content
		  			public void setPostContent(String strPostContent){
				    	post.sendKeys(strPostContent);     
				    }
			  
//Click submit
		  			 public void clickSubmit(){ 
		  		    	submit.sendKeys(Keys.RETURN);
		  		    }

		  			 //Verify Alert messages 
		  		     public void verifyAlertMsg() throws InterruptedException {
		  		  
//Verify Alert message		  		    	 
		  		     String alertMsg = driver.switchTo().alert().getText();
		  		     System.out.println(alertMsg);
		  		     Thread.sleep(2000);
		  		     driver.switchTo().alert().accept();
		  		    }	  			 
		  			 
//Click	delete
		  		   public void clickDelete() throws InterruptedException{ 
		  			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  deleteBtn);
		  		    Thread.sleep(500);
		  		    	deleteBtn.sendKeys(Keys.RETURN);
		  		    }
//Verify invalid cases for edit
		  		//Title containing empty strings
		  	     public void emptyTitle() throws InterruptedException {
		  	    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  title);
		  	       Thread.sleep(500);
		  		 title.sendKeys(Keys.DELETE);
		  	    }
		  	   public void clearTitle1() {
		  			
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
		  	   
		  	   
		  	    public boolean submitButtonEnabled() {
		  		   
		  	    return submit.isEnabled();
		  	    }
		  	   
	//Go back1
		  	    public void GoBack1() {
		  	    	driver.navigate().back();
		  	    }
		  		     
//Scroll Element into view
		  	    
		  		    public void scrollToView(){
		  		    	
		  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  title);
		  		   }	  			 

		  		    public void scrollToView1(){
		  		    	
		  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  home);
		  		   }	 	  			
}
