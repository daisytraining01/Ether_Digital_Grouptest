package com.ether.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
		
		//Select select = new Select(driver.findElement(By.className("android.widget.DropDownListView")));
		//select.selectByIndex(3);
		driver.findElement(By.id("nameField")).sendKeys("naser");
		driver.findElement(By.id("radioMale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnLetsShop")).click();
		/*
		driver.findElement(GSHomePage.countryDropdown).click();
		System.out.println(driver.findElement(GSHomePage.country).getText());
		driver.findElement(GSHomePage.country).click();
		Thread.sleep(2000);
		driver.findElement(GSHomePage.name).sendKeys("naser");
		Thread.sleep(2000);
		driver.findElement(GSHomePage.gender).click();
		Thread.sleep(2000);
		driver.findElement(GSHomePage.search).click();*/
		Thread.sleep(2000);
		//driver.resetApp();
		
	}
	@Test(dataProvider = "getData", dataProviderClass = TestData.class , dependsOnMethods = "homePage")
	public void productPriceTest(String product , String price) {
		int priceIndex;
		AndroidDriver<WebElement> driver = Base.driver;
		//List<WebElement> priceList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		//List<WebElement> productList = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		
		List<WebElement> priceList = driver.findElements(By.id("productPrice"));
		List<WebElement> productList = driver.findElements(By.id("productName"));
		//productList.get(0)
		System.out.println(productList.get(0).getText());
		System.out.println(product);
		for(int i=0; i<productList.size(); i++) {
			if(productList.get(i).getText().matches(product) && priceList.get(i).getText().equals(price)) {
				System.out.println("product exists");
				actions.info("product exists");
				actions.pass("The price is ");
			}
		}
		
	}
	
	@Test(dependsOnMethods = "productPriceTest")
	public void addProductToCartTest() throws InterruptedException, IOException {
		AndroidDriver<WebElement> driver = Base.driver;
		//List<WebElement> cartLinks = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
		//List<WebElement> productList = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		actions.info("Products List", Base.driver);
		List<WebElement> cartLinks = driver.findElements(GSHomePage.cartList);
		List<WebElement> productList = driver.findElements(GSHomePage.productList);
		//String productName = productList.get(0).getText();
		for(WebElement cart : cartLinks) {
			//String productName = cart.getText();
			cart.click();
			actions.info("product is added to the cart");
			Thread.sleep(1000);
		}
		//String cartCount = driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText();
		String cartCount = driver.findElement(GSHomePage.cartCount).getText();
		System.out.println(cartCount);
		System.out.println(cartLinks.size());
		if(Integer.parseInt(cartCount) == cartLinks.size()) {
			actions.pass("Items are succesfully added to the cart");
			actions.pass("Screenshot", Base.driver);
			
		}
		System.out.println("number of items added to the cart are "+ cartCount);
		System.out.println("sixe of the cartList is "+ cartLinks.size());
		//cartLinks.get(0).click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(GSHomePage.cartButton).click();
		Thread.sleep(3000);
		
	}
}
