<<<<<<< HEAD
package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAdReCate {
	
	
	
	WebDriver driver;
	   
	/*@FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
    private WebElement dropdown;
 
    @FindBy(xpath="//a[@href=\"/login\"]")
    private WebElement loginopt; 
   
    @FindBy(id="user")
    private WebElement loginname;
 
    @FindBy(id="pwd")
    private WebElement loginpass;  
    
    @FindBy(id="logbut")
    private WebElement login;*/

    @FindBy(xpath="//*[text()=' Actions']")
    private WebElement actions;
     
    @FindBy(xpath="//*[text()='Add/Remove category']")
    private WebElement addcat;
    
    @FindBy(name="category")
    private WebElement newcat;
    
    @FindBy(xpath="//*[text()='Add']")
    private WebElement add;
    
    @FindBy(xpath="/html/body/app-root/app-category/div/div[2]/li[18]/button")
    private WebElement remove;
    
    /*@FindBy(xpath="//*[text()='logout']")
    private WebElement logout;*/
    
    
 public AdminAdReCate(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
 
 	/*public void clickDropDown(){ 
    	dropdown.click();
   	} 
    public void SelectLogin(){ 
    	loginopt.click();
    }
    public void setLoginName(String strLoginName) {
    loginname.sendKeys(strLoginName);  
    }
    public void strLoginPass(String strLoginPass){
    	loginpass.sendKeys(strLoginPass);
	}
	public void clickSubmLogin (){
		login.click()
		};*/
 	
	public void clickActions(){ 
		actions.click();
	}
	public void clickAddCat(){ 
		addcat.click();
	}
	public void setNewCat(String strNewCat) {
		newcat.sendKeys(strNewCat);  
	}
	public boolean clickAdd(){ 
		return add.isEnabled();
	}
	public void clickAdd1(){ 
		 add.click();
	}
	public void clickRemove(){ 
		 remove.click();
	}
	/*public void clickLogout(){ 
		 logout.click(); 
	}*/
	}


=======
package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAdReCate {
	
	
	
	WebDriver driver;
	   
	/*@FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
    private WebElement dropdown;
 
    @FindBy(xpath="//a[@href=\"/login\"]")
    private WebElement loginopt; 
   
    @FindBy(id="user")
    private WebElement loginname;
 
    @FindBy(id="pwd")
    private WebElement loginpass;  
    
    @FindBy(id="logbut")
    private WebElement login;*/

    @FindBy(xpath="//*[text()=' Actions']")
    private WebElement actions;
     
    @FindBy(xpath="//*[text()='Add/Remove category']")
    private WebElement addcat;
    
    @FindBy(name="category")
    private WebElement newcat;
    
    @FindBy(xpath="//*[text()='Add']")
    private WebElement add;
    
    @FindBy(xpath="/html/body/app-root/app-category/div/div[2]/li[18]/button")
    private WebElement remove;
    
    /*@FindBy(xpath="//*[text()='logout']")
    private WebElement logout;*/
    
    
 public AdminAdReCate(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
 
 	/*public void clickDropDown(){ 
    	dropdown.click();
   	} 
    public void SelectLogin(){ 
    	loginopt.click();
    }
    public void setLoginName(String strLoginName) {
    loginname.sendKeys(strLoginName);  
    }
    public void strLoginPass(String strLoginPass){
    	loginpass.sendKeys(strLoginPass);
	}
	public void clickSubmLogin (){
		login.click()
		};*/
 	
	public void clickActions(){ 
		actions.click();
	}
	public void clickAddCat(){ 
		addcat.click();
	}
	public void setNewCat(String strNewCat) {
		newcat.sendKeys(strNewCat);  
	}
	public boolean clickAdd(){ 
		return add.isEnabled();
	}
	public void clickAdd1(){ 
		 add.click();
	}
	public void clickRemove(){ 
		 remove.click();
	}
	/*public void clickLogout(){ 
		 logout.click(); 
	}*/
	}


>>>>>>> ec2d49963ebd06203cfa3a68ad0b980969050210
