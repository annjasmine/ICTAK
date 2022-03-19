package com.techblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    WebDriver driver;
    
    @FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
    private WebElement dropdown;
    @FindBy(xpath="//a[@href=\"/signup\"]")
    private WebElement signup;
   
    @FindBy(xpath="//*[@id=\"sign\"]/small[1]")
    private WebElement errorname;
    @FindBy(id="first")
    private WebElement yourname;
    @FindBy(xpath="//*[@id=\"sign\"]/select")
    private WebElement drpdnoption;    
    @FindBy(xpath="//option[@value='0: user']")
    private WebElement user;
    
    @FindBy(id="em")
    private WebElement youremail;
    @FindBy(id="pw")
    private WebElement yourpassword;
    @FindBy(id="but")
    private WebElement submituser;
    
    @FindBy(xpath="//*[@id=\"sign\"]/small[2]/b")
    private WebElement errorMessage1;
    @FindBy(xpath="//*[@id=\"sign\"]/small[4]")
    private WebElement errorMessage2;
    
    //Trainer
    @FindBy(id="first")
    private WebElement trainername;
    @FindBy(xpath="//option[@value='1: trainer']")
    private WebElement trainer; 
    @FindBy(xpath="//*[@id=\"sign\"]/select[2]")
    private WebElement dropdnqual;    
    @FindBy(xpath="//option[@value=\"2: P.H.D\"]")
    private WebElement phd;
    
    @FindBy(xpath="//*[@id=\"sign\"]/small[3]/b")
    private WebElement errorMessage3;
    @FindBy(xpath="//*[@id=\"sign\"]/small[4]")
    private WebElement errorMessage4;
    @FindBy(id="em")
    private WebElement traineremail;
    @FindBy(id="pw")
    private WebElement trainerpassword;
    @FindBy(id="but")
    private WebElement submittrainer;
   
    @FindBy(xpath="//*[@id=\"sign\"]/p/a")
    private WebElement loginredirect;
    
    public SignUp(WebDriver driver){
    this.driver = driver;
 
    PageFactory.initElements(driver, this);
  }
    public void clickDropDown(){ 
    	dropdown.click();
   	} 
    public void SelectSignUp(){ 
    	signup.click();
    }
    public String getErrorName() {
        return errorname.getText();
        }
    public void setYourName(String strYourName){
        yourname.sendKeys(strYourName);  
    }
    //public void clickDropDownOption(){ 
    	//drpdnoption.click();
//}
    public void SelectUser(){ 
    	user.click();
    }
    public void setYourEmail(String strYourEmail){
        youremail.sendKeys(strYourEmail); 
    }
    public void setYourPassword(String strYourPassword){
        yourpassword.sendKeys(strYourPassword); 
    }
    public void clickSubmitUser(){
        submituser.click();
    }
    public String getErrorMessage1() {
   	 return errorMessage1.getText();
    }
    public String getErrorMessage2() {
     return errorMessage2.getText();
    }
    //Trainer
    public void setTrainerName(String strTrainerName){
        trainername.sendKeys(strTrainerName);  
    }
    public void SelectTrainer(){ 
        	trainer.click();
    }
    public void clickDropDownQual(){ 
    	dropdnqual.click();
    }
    public void SelectQual(){ 
    	phd.click();
    }
    public void setTrainerEmail(String strTrainerEmail){
    	traineremail.sendKeys(strTrainerEmail); 
    }
    public void setTrainerPassword(String strTrainerPassword){
       trainerpassword.sendKeys(strTrainerPassword); 
    }
    public void clickSubmitTrainer(){
        submittrainer.click();
    }
        public String getErrorMessage3() {
          	 return errorMessage3.getText();
        }
        public String getErrorMessage4() {
        return errorMessage4.getText();
        }
        
        public void clickLoginButton(){
        	loginredirect.click();
}
}

