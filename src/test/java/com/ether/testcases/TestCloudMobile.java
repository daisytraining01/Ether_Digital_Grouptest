package com.ether.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ether.base.Base;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestCloudMobile {

	//private String accessKey = "eyJ4cC51Ijo4NjA5MDU5LCJ4cC5wIjo4NjA5MDU4LCJ4cC5tIjoiTVRVNU1UWTNPVGt4TWpreE5RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE5MDcwMzk5NzAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.FTMWAE-tMgmxNKN1X-P2W8G0IArkVR7cXz19Neqm_qM";
	AndroidDriver driver = Base.driver;
	DesiredCapabilities dc = new DesiredCapabilities();
	public List<String> recents = new ArrayList<String>();
	public int count = 0;
	public int elecount = 0;
	/*
	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("accessKey", accessKey);
		dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		dc.setCapability("udid", "ZX1C22GBLV");
		// for cloud

		dc.setCapability(MobileCapabilityType.APP, "cloud:com.wheelsize/.presentation.container.AppContainer");
		dc.setCapability("instrumentApp", true);
		dc.setCapability(MobileCapabilityType.FULL_RESET, true);
		dc.setCapability("dontGoHomeOnQuit", true);
		dc.setCapability("appBuildVersion", "12");
		dc.setCapability("appReleaseVersion", "1.2.0");

		URL remoteUrl = new URL("https://cloud.seetest.io/wd/hub");
		driver = new AndroidDriver(remoteUrl, dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
*/
	@Test(priority = 1)
	public void sampleTest() throws InterruptedException {
		System.out.println("test is starting");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("_____PREFERENCE CHECK_____");
		driver.findElement(By.id("ibSettings")).click();
		
		//MobileElement el1 = (MobileElement) driver.findElementByXPath("//*[@id='ibSettings']");
		//el1.click();
		Thread.sleep(7000);
		MobileElement el2 = (MobileElement) driver.findElementByXPath("//*[@text='Preferable car markets']");
		el2.click();
		Thread.sleep(7000);
		// (new TouchAction(driver)).press(PointOption.point(604,
		// 459)).moveTo(PointOption.point(604, 357)).release().perform();
		String market = driver.findElementByXPath("(//*[@id='tvMarket'])[1]").getText();
		System.out.println("\nThe Market preference has been set to : " + market);
		MobileElement el3 = (MobileElement) driver.findElementByXPath(
				"//*[@class='h.b.p.m' and (./preceding-sibling::* | ./following-sibling::*)[@text='Settings']]");
		el3.click();
		Thread.sleep(7000);
		MobileElement el4 = (MobileElement) driver.findElementByXPath(
				"//*[@class='h.b.p.m' and (./preceding-sibling::* | ./following-sibling::*)[@text='Settings']]");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByXPath("//*[@text='By flotation tire']");
		el5.click();

		Thread.sleep(7000);
		MobileElement el6 = (MobileElement) driver.findElementByXPath("//*[@id='tireDiameterClick']");

		el6.click();
		Thread.sleep(7000);
		MobileElement el5Dia = (MobileElement) driver.findElementByXPath("//*[@text='29']");
		Thread.sleep(7000);
		el5Dia.click();
		Thread.sleep(7000);
		MobileElement el6Wid = (MobileElement) driver.findElementByXPath("//*[@text='7.5']");
		el6Wid.click();
		Thread.sleep(7000);
		MobileElement el7Rim = (MobileElement) driver.findElementByXPath("//*[@text='16']");
		el7Rim.click();
		Thread.sleep(7000);

		MobileElement el9 = (MobileElement) driver.findElementByXPath("(//*[@id='tvMake'])[1]");
		el9.click();
		System.out.println("The Element being viewed is " + el9.getText());
		Thread.sleep(7000);
		MobileElement el10 = (MobileElement) driver.findElementByXPath("//*[contains(@text,'Defender')]");
		el10.click();
		Thread.sleep(7000);
		MobileElement el11 = (MobileElement) driver.findElementByXPath("(//*[@id='tvTrim'])[1]");

		if (el11.getText().contains(market.substring(0, 4)))
			System.out.println("The preference has been validated - " + market.substring(0, 4));
		else
			AssertJUnit.assertTrue("The preference was not set", false);

		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementByXPath("//*[@text='1994']");
		el12.click();
		Thread.sleep(7000);
		MobileElement el13 = (MobileElement) driver.findElementByXPath("//*[@id='tvTitle']");
		recents.add(count++, el13.getText());
		Thread.sleep(7000);
		MobileElement el14 = (MobileElement) driver.findElementByXPath("//*[@id='ivHome']");
		el14.click();
		Thread.sleep(7000);

	}

	@Test(priority = 2)
	public void Scenario2() {
        System.out.println("\n_____SEARCH HISTORY VALIDATION_____");
        MobileElement el1 = (MobileElement) driver
                .findElementByXPath("//*[@id='icon' and ./parent::*[@id='tab_main']]");
        el1.click();

 

        MobileElement el2 = (MobileElement) driver.findElementByXPath("//*[@text='Land Rover Defender 1994']");
        System.out.println("1-" + recents.get(0) + "-\n2-" + el2.getText() + "-");
        if (recents.get(0).contains(el2.getText().substring(0, (el2.getText().length()) - 5)))
            System.out.println("All the search history is available in the recents section");
        else
            AssertJUnit.assertTrue("The element searched is not in recents list", false);

 

    }
/*
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
*/
}