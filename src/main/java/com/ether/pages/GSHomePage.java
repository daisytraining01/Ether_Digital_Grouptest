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
	//homePage
	public static final By countryDropdown = By.id("android:id/text1");
	public static final By country = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
	public static final By name = By.id("com.androidsample.generalstore:id/nameField");
	public static final By gender = By.id("com.androidsample.generalstore:id/radioMale");
	public static final By search = By.id("com.androidsample.generalstore:id/btnLetsShop");
	/*
	//productMenu
	public static final By priceList = By.id("com.androidsample.generalstore:id/productPrice");
	public static final By productList = By.id("com.androidsample.generalstore:id/productName");
	public static final By cartList = By.id("com.androidsample.generalstore:id/productAddCart");
	public static final By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
	public static final By cartCount = By.id("com.androidsample.generalstore:id/counterText");*/
	
	//productMenu
		public static final By priceList = By.id("productPrice");
		public static final By productList = By.id("productName");
		public static final By cartList = By.id("productAddCart");
		public static final By cartButton = By.id("appbar_btn_cart");
		public static final By cartCount = By.id("counterText");
	
	
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
