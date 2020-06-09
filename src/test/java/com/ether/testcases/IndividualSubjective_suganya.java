package com.ether.testcases;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ether.base.Base;
import com.ether.pages.CommonLocators_Suganya;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IndividualSubjective_suganya {
	static AndroidDriver driver = Base.driver;
	//public static AndroidDriver driver;
	//File app = new File("APK/Math Games Learn Add Subtract Multiply Divide_v8.4_apkpure.com.apk");
   // private String accessKey = "eyJ4cC51Ijo4NTM3NzI4LCJ4cC5wIjo4NTM3NzI3LCJ4cC5tIjoiTVRVNU1USTNNRGs0TWpFM053IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE5MDY2MzE5ODYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.eQxEx-5SwwTdUvENnvkEedFDoFegNuvlQR91Gnp8bOk";
	//private String accessKey = "eyJ4cC51Ijo0NTU2OTksInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yT0RFNU1EVTFOQSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3MjgxOTEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.12UHA51l_lyYn3qF65unNXg4oVcfUEIFgYZepzMQQAM";
    public static String whatToRun = "Emul"; // Emul or Cloud
/*    
@BeforeMethod
public void setUpAPK() throws Throwable {
	if(whatToRun=="Emul") {
		
		
		  DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); //
		  desiredCapabilities.setCapability("app", app.getAbsolutePath());
		  
		  desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
		  desiredCapabilities.setCapability("platformName", "Android");
		  desiredCapabilities.setCapability("platformVersion", "10"); //
		 // desiredCapabilities.setCapability("udid", "emulator-5554"); // //
		  // RZ8MA25QBQK // 
		  desiredCapabilities.setCapability("udid", "ec1f4bbd");
		  //desiredCapabilities.setCapability("udid", "RZ8MA25QBQK");
		  
		  desiredCapabilities.setCapability("app", app.getAbsolutePath()); //
		  
		  URL remoteUrl = new URL("http://localhost:4723/wd/hub"); 
		  driver = new AndroidDriver(remoteUrl, desiredCapabilities);		 	
	}
	else
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		  dc.setCapability("accessKey", accessKey); 
		  dc.setCapability("deviceQuery","@os='android' and @category='PHONE'"); 
		  dc.setCapability("udid", "c8fc88d6");
		  //for cloud
		  
		  dc.setCapability(MobileCapabilityType.APP,"cloud:com.GamesForKids.Mathgames.MultiplicationTables/.SplashScreenActivity"); 
		  dc.setCapability("instrumentApp", true);
		  dc.setCapability(MobileCapabilityType.FULL_RESET, true);
		  dc.setCapability("dontGoHomeOnQuit", true);
		  dc.setCapability("appBuildVersion", "84");
		  dc.setCapability("appReleaseVersion", "8.4");
		  
		  URL remoteUrl = new URL("https://cloud.seetest.io/wd/hub"); 
		  driver = new AndroidDriver(remoteUrl, dc);
		 

	}	  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}*/
public static void erlaunchPage(String am) throws Throwable {
	// TODO Auto-generated method stub
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	CommonLocators_Suganya cl=new CommonLocators_Suganya();
	cl.ageCheck.click();
	cl.yesButton.click();
	cl.langClick.click();
	if(am == "add") cl.addClick.click();
	else cl.multiClick.click();
	
	
}
public static void claunchPage(String am) throws Throwable {
	// TODO Auto-generated method stub
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	CommonLocators_Suganya cl=new CommonLocators_Suganya();
	cl.ageCheck.click();
	cl.cyesButton.click();
	cl.clangClick.click();
	if(am == "add") cl.caddClick.click();
	else cl.cmultiClick.click();
}


@Test(priority = 0)
public void AddQuiz() throws Throwable {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	CommonLocators_Suganya cl=new CommonLocators_Suganya();
    if(whatToRun=="Emul") erlaunchPage("add");
    else claunchPage("add");
    
    cl.quizClick.click();
	System.out.println("Quiz selected");	
	for(int i=1;i<=10;i++) {
	playQuizAdd();
	}
	cl.exitClick.click();
	
	
}
public static void playQuizAdd() {
	// TODO Auto-generated method stub
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	CommonLocators_Suganya cl=new CommonLocators_Suganya();
	if(whatToRun=="Emul") {
		String value1=cl.ques1.getText();
		if(value1.equals("?")) 
		{
			String value11=cl.ques2.getText();
			value1=value11;
		}
		String value2=cl.ans.getText();
		int a= Integer.parseInt(value1);
		int b = Integer.parseInt(value2);
		int c=b-a;
		System.out.println(c);
		String value3= Integer.toString(c);
		for(int i = 1;i<=4;i++) {
			MobileElement el5 = (MobileElement) driver.findElementById("com.GamesForKids.Mathgames.MultiplicationTables:id/opt"+i);
			//System.out.println(el5.getText());
			if(el5.getText().equals(value3)) {
				el5.click();
				break;
			}
		}

	
	}
	else
	{
		String value1=cl.cques1.getText();
		if(value1.equals("?")) 
		{
			String value11=cl.cques2.getText();
			value1=value11;
		}
		String value2=cl.cans.getText();
		int a= Integer.parseInt(value1);
		int b = Integer.parseInt(value2);
		int c=b-a;
		System.out.println(c);
		String value3= Integer.toString(c);
		for(int i = 1;i<=4;i++) {
			MobileElement el5 = (MobileElement) driver.findElementById("opt"+i);
			//System.out.println(el5.getText());
			if(el5.getText().equals(value3)) {
				el5.click();
				break;
			}
		}

	}
}
/*
@AfterMethod
public void tearDown() {
    System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
    driver.quit();
}*/

@Test(priority = -1)
public void multiQuiz() throws Throwable {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    CommonLocators_Suganya cl=new CommonLocators_Suganya();
    if(whatToRun=="Emul") erlaunchPage("multi");
    else claunchPage("multi");
    
    cl.quizClick.click();
	System.out.println("Quiz selected");	
	for(int i=1;i<=10;i++) {
	playQuizMulti();
	}
	cl.exitClick.click();

}
public static void playQuizMulti() {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	CommonLocators_Suganya cl=new CommonLocators_Suganya();
	if(whatToRun=="Emul") {
		String value1=cl.ques1.getText();
		if(value1.equals("?")) 
		{
			String value11=cl.ques2.getText();
			value1=value11;
		}
		String value2=cl.ans.getText();
		int a= Integer.parseInt(value1);
		int b = Integer.parseInt(value2);
		int c=b/a;
		System.out.println(c);
		String value3= Integer.toString(c);
		for(int i = 1;i<=4;i++) {
			MobileElement el5 = (MobileElement) driver.findElementById("com.GamesForKids.Mathgames.MultiplicationTables:id/opt"+i);
			//System.out.println(el5.getText());
			if(el5.getText().equals(value3)) {
				el5.click();
				break;
			}
		}

	
	}
	else
	{
		String value1=cl.cques1.getText();
		if(value1.equals("?")) 
		{
			String value11=cl.cques2.getText();
			value1=value11;
		}
		String value2=cl.cans.getText();
		int a= Integer.parseInt(value1);
		int b = Integer.parseInt(value2);
		int c=b/a;
		System.out.println(c);
		String value3= Integer.toString(c);
		for(int i = 1;i<=4;i++) {
			MobileElement el5 = (MobileElement) driver.findElementById("opt"+i);
			//System.out.println(el5.getText());
			if(el5.getText().equals(value3)) {
				el5.click();
				break;
			}
		}

	}

}

}
