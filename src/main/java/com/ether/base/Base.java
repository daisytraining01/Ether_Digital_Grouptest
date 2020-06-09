package com.ether.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ether.utilities.ExcelReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	public static AndroidDriver driver;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\formData.xlsx");
	private static String accessKey = "eyJ4cC51Ijo4NTM3NzI4LCJ4cC5wIjo4NTM3NzI3LCJ4cC5tIjoiTVRVNU1USTNNRGs0TWpFM053IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE5MDY2MzE5ODYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.eQxEx-5SwwTdUvENnvkEedFDoFegNuvlQR91Gnp8bOk";
	//private static String accessKey ="eyJ4cC51Ijo4NjA5MDEyLCJ4cC5wIjo4NjA5MDExLCJ4cC5tIjoiTVRVNU1UWTNPRGMyTURJME13IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE5MDcwMzg4MjAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.KRqGJxtkuwFbcDL09BROX988gbjLdMvnYTOGYl7I4mU";
	public static String url = "http://127.0.0.1:4723/wd/hub";

	@BeforeSuite
	@Parameters({ "deviceType", "appName", "realDevice", "emulator", "cloudDevice", "cloudAppName", "appBuildVersion",
			"appReleaseVersion" })
	public static void setUp(@Optional("emulator") String deviceType, String appName, String realDevice,
			String emulator, String cloudDevice, String cloudAppName, String appReleaseVersion, String appBuildVersion)
			throws MalformedURLException {
		System.out.println(deviceType);
		System.out.println(appName);
		File appDir = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\apps");
		File app = new File(appDir, appName);
		DesiredCapabilities cap = new DesiredCapabilities();
		if (deviceType.equals("realDevice")) {
			cap.setCapability(MobileCapabilityType.UDID, realDevice);
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			// cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		} else if (deviceType.equals("cloudDevice")) {
			cap.setCapability("accessKey", accessKey);
			cap.setCapability(MobileCapabilityType.UDID, cloudDevice);
			//cap.setCapability(MobileCapabilityType.UDID, "c8fc88d6");
			// cap.setCapability(MobileCapabilityType.UDID, "ce07171724231323047e");
			cap.setCapability(MobileCapabilityType.APP, cloudAppName);
			cap.setCapability("instrumentApp", true);
			cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			cap.setCapability("dontGoHomeOnQuit", true);
			cap.setCapability("appBuildVersion", "1");
			cap.setCapability("appReleaseVersion", "1.0");
			cap.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			url = "https://cloud.seetest.io/wd/hub";
		} else {
			cap.setCapability(MobileCapabilityType.UDID, emulator);
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		}

		driver = new AndroidDriver(new URL(url), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite
	public static void tearDown() throws IOException {
		if (driver != null) {
			driver.quit();
		}
		File htmlFile = new File("Test-Automaton-Report.html");
		Desktop.getDesktop().browse(htmlFile.toURI());
		// log.debug("Test Execution completed");
	}

	public static void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}
}
