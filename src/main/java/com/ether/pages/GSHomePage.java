package com.ether.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.ether.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GSHomePage {
	
	public static final By countryDropdown = By.id("android:id/text1");
	public static final By country = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
	public static final By name = By.id("com.androidsample.generalstore:id/nameField");
	public static final By gender = By.id("com.androidsample.generalstore:id/radioMale");
	public static final By search = By.id("com.androidsample.generalstore:id/btnLetsShop");
	
	
	/*
	@AndroidFindBy (id = "android:id/text1")
    public AndroidElement countryDropdown;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
    public AndroidElement country;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement name;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public AndroidElement gender;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement search;
	
	public GSHomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(Base.driver , Duration.ofSeconds(15)) , this);
	}*/
}
