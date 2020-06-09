package com.ether.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.ether.base.Driver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage{
	 @AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
	    public AndroidElement username;
	 
	 @AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
	    public AndroidElement password;
	 
	 @AndroidFindBy(id = "android:id/button1")
	    public AndroidElement popup;
	 
	 @AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
	    public AndroidElement signin;
	 
	 public LoginPage() {
			PageFactory.initElements(new AppiumFieldDecorator(Driver.driver , Duration.ofSeconds(15)) , this);
		}
}



