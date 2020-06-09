package com.ether.actions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ether.listener.TestListener;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class UserActions {

	public void pass(String Text) {
		TestListener.test.get().pass(Text);
	}
	
	public void fail(String Text) {
		TestListener.test.get().fail(Text);
	}
	
	public void skip(String Text) {
		TestListener.test.get().skip(Text);
	}
	
	public void info(String Text) {
		TestListener.test.get().info(Text);
	}
	public void pass(String Text,AndroidDriver<MobileElement> driver) throws IOException {
		System.out.println(driver !=null);
		
		TestListener.test.get().pass(Text,MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	}
	
	public void fail(String Text,AndroidDriver<MobileElement> driver) throws IOException {
		System.out.println(driver !=null);
		
		TestListener.test.get().fail(Text,MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	}
	
	public void skip(String Text,AndroidDriver<MobileElement> driver) throws IOException {
		System.out.println(driver !=null);
		
		TestListener.test.get().skip(Text,MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	}
	
	public void info(String Text,AndroidDriver<MobileElement> driver) throws IOException {
		System.out.println(driver !=null);
		
		TestListener.test.get().info(Text,MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	}
}
