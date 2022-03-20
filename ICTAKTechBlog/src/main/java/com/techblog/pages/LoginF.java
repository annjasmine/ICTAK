package com.techblog.pages;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class LoginF {
			 WebDriver driver;
			 
			 //objects
			 @FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
			    private WebElement dropdown;
			    @FindBy(xpath="//a[@href=\"/login\"]")
			    private WebElement selectLogin;
			    
			    @FindBy(id="user")
			    private WebElement username;
			    @FindBy(id="pwd")
			    private WebElement password;    
			    @FindBy(id="logbut")
			    private WebElement login;
			    
			    
			    
			    @FindBy(xpath="//*[text()='logout']")
			    private WebElement logout;
			    

			 
			 public LoginF(WebDriver driver){
			        this.driver = driver;
			        //This initElements method will create all WebElements
			        PageFactory.initElements(driver, this);
			    }
			 
			 //methods to access the objects
			    
			   //Valid Login Credentials-Admin
			    public void AdminLogin(String strUserName,String strPassword){
			    	
			   	username.sendKeys(strUserName);   
			   	password.sendKeys(strPassword);
			   	login.click();
			    }
			//Click on drop down menu
			    public void clickDropDown(){ 
			    	dropdown.click();
			   	} 
			    
			  //Select Login
			    public void SelectLogin(){ 
			    	selectLogin.click();
			   	} 
			    
			    
			  //Set user name in text box
			    public void setUserName(String strUserName){
			    	username.sendKeys(strUserName);     
			    }

			     /*public void clearUserName() {
			    	 username.clear();
			     }*/
			   
			    
			  //Set password in password textbox
			     public void setPassword(String strPassword){
			       password.sendKeys(strPassword);
			    }
			    
			     /*public void clearPassword() {
			    	password.clear();
			    }*/
			    
			       
			  //Click on login button 
			     public void clickLogin(){ 
			    	      login.click();   
			    	      
			     }
			     
			     //Click logout
			     public void clickLogout(){ 
					 logout.click(); 
				}

			 }


			
			
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

