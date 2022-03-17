package com.techblog.scripts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {
		public static WebDriver driver;
	    public static Properties prop = null;
	    String driverPath = "D:\\Jasmine\\ICTAK\\chromedriver\\chromedriver.exe";
	public static void TestBase() {
	        try {
	        	//Below line creates an object of Properties called 'prop'
	            prop = new Properties();
	          //Below line creates an object of FileInputStream called 'ip'. 
	          //Give the path of the properties file which you have created
	            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
	                    + "/config.properties");
	            //Below line of code will load the property file
	            prop.load(ip);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
				@Parameters("browser") 
				@BeforeTest
				public void onSetup(String browserName) {
	    	        TestBase(); 
	    	        // for loading the configurations
	    	       // String browserName = prop.getProperty("browser");

	    	        if (browserName.equals("chrome")) {
	    	        	System.setProperty("webdriver.chrome.driver", driverPath);
	    	            driver = new ChromeDriver();
	    	        }
	    else if (browserName.equals("firefox")) {
	    	        	//geckodriver
	    	        	System.setProperty("webdriver.gecko.driver", driverPath);
	    	            driver = new FirefoxDriver();
	    	        }
	    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	        driver.get(prop.getProperty("url"));
	    	        driver.manage().window().maximize();
	    		    }
	            @AfterMethod
			    public void tearDown(ITestResult iTestResult) throws IOException {
			        if (iTestResult.FAILURE == iTestResult.getStatus()) {
			            takeScreenshot(iTestResult.getName());
			        }
			    }
		 public String takeScreenshot(String name) throws IOException {
			    	
			    	/*Step 1) Convert web driver object to TakesScreenshot
			          Step 2) Call getScreenshotAs method to create image file
			          Step 3) Copy file to Desired Location*/
			    	
			       String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
		 //Take the screenshot
			        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			        
			        String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
			                + ".png";
			       
			        File finalDestination = new File(destination);
			     
			        //FileHandler.copy(source, finalDestination);
			        FileUtils.copyFile(source, finalDestination);
			        return destination;   
	            	 }
		/* @AfterTest
		    public void quitBrowser() throws IOException {
		        driver.quit();
		 }
		 */
	        }
