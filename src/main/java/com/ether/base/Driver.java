package com.ether.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Driver {
	public static AndroidDriver<AndroidElement> driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	
	//@Test
	public static void setUp() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		if(driver==null){
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				config.load(fis);
				//log.debug("Config file is loaded!!");
				System.out.println("Config file is loaded!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Setting the cap now");
			
			cap.setCapability("deviceName", config.getProperty("deviceName"));
			cap.setCapability("udid", config.getProperty("udid"));
			cap.setCapability("platformName", config.getProperty("platformName"));
			cap.setCapability("platformVersion", config.getProperty("platformVersion"));
			cap.setCapability("appPackage", config.getProperty("appPackage"));
			cap.setCapability("appActivity", config.getProperty("appActivity"));
			
			System.out.println("Capabilities are set");
			URL url = new URL(config.getProperty("appiumServer"));
			driver = new AndroidDriver<AndroidElement>(url , cap);
			driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			//wait = new WebDriverWait(driver,5);
		}
	}
	public static void tearDown(){
		if(driver!=null){
			driver.quit();
		}
		//log.debug("Test Execution completed");
	}
}
