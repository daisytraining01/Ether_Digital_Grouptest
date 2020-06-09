package com.ether.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ether.actions.UserActions;
import com.ether.base.Base;
import com.ether.pages.GSHomePage;
import com.ether.utilities.TestData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@Listeners(com.ether.listener.TestListener.class)
public class GeneralStoreTest {
	UserActions actions = new UserActions();
	//GSHomePage home = new GSHomePage();
	@Test//(dataProvider = "getData", dataProviderClass = TestData.class)
	public void homePage() throws InterruptedException {
		AndroidDriver driver = Base.driver;
		/*
		home.countryDropdown.click();
		home.country.click();
		home.name.sendKeys("sami");
		Thread.sleep(3000);
		home.gender.click();
		Thread.sleep(3000);
		home.search.click();
		*/
		driver.findElement(GSHomePage.countryDropdown).click();
		System.out.println(driver.findElement(GSHomePage.country).getText());
		driver.findElement(GSHomePage.country).click();
		Thread.sleep(2000);
		driver.findElement(GSHomePage.name).sendKeys("naser");
		Thread.sleep(2000);
		driver.findElement(GSHomePage.gender).click();
		Thread.sleep(2000);
		driver.findElement(GSHomePage.search).click();
		Thread.sleep(2000);
		
		List<WebElement> productList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		//productList.get(0)
		System.out.println(productList.get(0).getText());
		//Base.scrollToText("Converse All Star");
		Thread.sleep(2000);
		//driver.resetApp();
		/*
		MobileElement el1 = (MobileElement) driver.findElementById("android:id/text1");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/nameField");
		el3.sendKeys(name);
		Thread.sleep(3000);
		MobileElement el4 = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/radioMale");
		el4.click();
		Thread.sleep(3000);
		MobileElement el5 = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		el5.click();
		
		MobileElement el6 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.ImageView");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/productPrice");
		el10.click();
		MobileElement el11 = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/btnProceed");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]");
		el12.click();
		*/
	}
	@Test(dataProvider = "getData", dataProviderClass = TestData.class , dependsOnMethods = "homePage")
	public void productPriceTest(String product , String price) {
		int priceIndex;
		AndroidDriver<WebElement> driver = Base.driver;
		List<WebElement> priceList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		List<WebElement> productList = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		//productList.get(0)
		System.out.println(productList.get(0).getText());
		System.out.println(product);
		if(productList.contains(product.trim())) {
			priceIndex = productList.indexOf(product);
			if(priceList.get(priceIndex).getText().equals(price)) {
				System.out.println("price matched");
			}else
				System.out.println("actual price is "+ priceList.get(priceIndex).getText());
		}
		else
			System.out.println("given product does not exists");
			actions.info("This product doesn't exists");
		
		//System.out.println(productList.get(0).getText());
		
	}
}
