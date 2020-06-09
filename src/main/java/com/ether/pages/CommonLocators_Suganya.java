package com.ether.pages;


import org.openqa.selenium.support.PageFactory;

import com.ether.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class CommonLocators_Suganya {

	/*
	 * @AndroidFindBy (id="android:id/button1") public MobileElement okButton;
	 */
	
	//==============================Age Selection==========================//
	
	@AndroidFindBy(xpath = "//*[@text='2-9 yrs']") public MobileElement ageCheck; // common
	@AndroidFindBy(xpath = "//*[@text='YES']") public MobileElement yesButton; //common
	@AndroidFindBy(xpath = "//*[@text='Yes']") public MobileElement cyesButton; //cloud
	
	//==============================Language Selection=========================//
	
	@AndroidFindBy(id="btnBack") public MobileElement clangClick; //cloud
	@AndroidFindBy(id="com.GamesForKids.Mathgames.MultiplicationTables:id/btnBack") public MobileElement langClick; //common
	
	//================================ADD Selection=================================//
	
	@AndroidFindBy(id="com.GamesForKids.Mathgames.MultiplicationTables:id/text_view_id") public MobileElement addClick; //common
	@AndroidFindBy(xpath = "//*[@id='add']") public MobileElement caddClick; // cloud
	
	//=================================multi Selection=================================//
	@AndroidFindBy(id="com.GamesForKids.Mathgames.MultiplicationTables:id/text_view_id2") public MobileElement multiClick; //common
	@AndroidFindBy(xpath = "//*[@id='mul']") public MobileElement cmultiClick; // cloud

	

	//==============================Quiz PAge========================================//
	
	@AndroidFindBy(xpath = "//*[@text='Quiz']") public MobileElement quizClick; //common
	
	
	//common
	@AndroidFindBy(id="com.GamesForKids.Mathgames.MultiplicationTables:id/n1") public MobileElement ques1; //common
	@AndroidFindBy(id="com.GamesForKids.Mathgames.MultiplicationTables:id/n2") public MobileElement ques2; //common
	@AndroidFindBy(id="com.GamesForKids.Mathgames.MultiplicationTables:id/ans") public MobileElement ans; //common
	
	//cloud
	
	@AndroidFindBy(id="n1") public MobileElement cques1; //cloud
	@AndroidFindBy(id="n2") public MobileElement cques2; //cloud
	@AndroidFindBy(id="ans") public MobileElement cans; //common
		
	
	//===============================Exit from Quiz===================================//
	
	@AndroidFindBy(id = "exit") public MobileElement exitClick;
	

	
	
	
		public CommonLocators_Suganya()
		{
			PageFactory.initElements(new AppiumFieldDecorator(Base.driver), this);
		}
}

