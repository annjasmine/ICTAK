package com.techblog.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.techblog.constants.AutomationConstantsF;
import com.techblog.pages.AdminElements;
import com.techblog.pages.HomeF;

public class TCAdminElements extends TestBase{
		AdminElements objAdminElements;
		
@Test(priority=1)
	    public void verifyAllpostsTab() throws IOException, Exception {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	    objAdminElements = new AdminElements(driver);
	    //Navigating allposts page
	 	    objAdminElements.clickAllPosts();
	 	   String expectedURL =AutomationConstantsF.ALLPOSTSURL;
		    String actualURL =driver.getCurrentUrl();
		   AssertJUnit.assertEquals(expectedURL,actualURL);
	 		    Thread.sleep(2000);
}
	
@Test(priority=2)
public void verifyMypostsTab() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

objAdminElements = new AdminElements(driver);
//Navigating mypost page
	    objAdminElements.Myposts();
	   String expectedURL =AutomationConstantsF.MYPOSTURL;
    String actualURL =driver.getCurrentUrl();
   AssertJUnit.assertEquals(expectedURL,actualURL);
		    Thread.sleep(2000);
}
	
	
	

}
