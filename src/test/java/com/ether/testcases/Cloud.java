package com.ether.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ether.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Cloud {
	
	AndroidDriver driver = Base.driver;
	
	private String accessKey = "eyJ4cC51Ijo4NjEwMzMzLCJ4cC5wIjo4NjEwMzMyLCJ4cC5tIjoiTVRVNU1UWTRPVFEwT1RJM09BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE5MDcwNTQ1NzAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.xjjk8RZ9fdo1WDdyTdOmVpPn1x7Kwq9lDVwr_p_ZCpY";
    
    DesiredCapabilities dc = new DesiredCapabilities();
   

 
/*
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
        dc.setCapability("udid", "d22bfadd");
        // for cloud

        dc.setCapability(MobileCapabilityType.APP, "cloud:com.wordwebsoftware.android.wordweb/.activity.WordWebActivity");
        dc.setCapability("instrumentApp", true);
        dc.setCapability(MobileCapabilityType.FULL_RESET, true);
         dc.setCapability("dontGoHomeOnQuit", true);
        dc.setCapability("appBuildVersion", "35");
        dc.setCapability("appReleaseVersion", "4.0");

 

        URL remoteUrl = new URL("https://cloud.seetest.io/wd/hub");
        driver = new AndroidDriver(remoteUrl, dc);

 

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 

    }
*/
	 

	  @Test(priority=-1)
	  public void sampleTest()  {
		  MobileElement el1 = (MobileElement) driver.findElementsByXPath("//*[@text='OK']");
		    el1.click();
		    MobileElement el2 = (MobileElement) driver.findElementsByXPath("//*[@id='search_close_btn']");
		    el2.click();
		    MobileElement el3 = (MobileElement) driver.findElementsByXPath("//*[@id='search_src_text']");
		    el3.click();
		    MobileElement el4 = (MobileElement) driver.findElementsByXPath("//*[@class='android.widget.FrameLayout' and ./*[@id='windowContentFrame']]");
		    el4.sendKeys("best");
		    MobileElement el5 = (MobileElement) driver.findElementByXPath("//*[@id='listlayout' and ./*[@text='best']]");
		    el5.click();
	  }
	  
	  @Test(priority=0)  
	  public void sampleTest1() throws InterruptedException 
	{
		  MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
		    el6.click();
		    MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Clear query");
		    el7.click();
		    MobileElement el8 = (MobileElement) driver.findElementByXPath("//*[@class='android.widget.FrameLayout' and ./*[@id='windowContentFrame']]");
		    el8.click();
		    MobileElement el9 = (MobileElement) driver.findElementByXPath("//*[@id='search_src_text']");
		    el9.sendKeys("web server");
		    MobileElement el10 = (MobileElement) driver.findElementByXPath("//*[@id='item_name']");
		    el10.click();
		    MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("Add Bookmark");    //findElementByXPath("//*[@id='add_to_bookmark_menu']")
		    el11.click();
		    MobileElement el12 = (MobileElement) driver.findElementByAccessibilityId("Bookmarks & Recent");  //findElementByXPath("//*[@id='menu_bookmarks']")
		    el12.click();
		    Thread.sleep(2000);
	}
}

/*
	  @AfterTest
	  public void tearDown() {
	    driver.quit();
	  }
	}
*/



