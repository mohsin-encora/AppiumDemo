package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZoomOutDemo {

	
AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	    public void launchApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}
	
	@Test
	
	public void zoomOut() throws InterruptedException {
		Thread.sleep(5000);
		
		//Swipe from right to left
		TouchAction<?> ta1 = new TouchAction<>(driver);
		ta1.press(PointOption.point(865,618)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
			.moveTo(PointOption.point(642,602)).release();
		
		
		//Swipe from left to right
				TouchAction<?> ta2 = new TouchAction<>(driver);
				ta2.press(PointOption.point(116,586)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(295,594)).release();
				
			MultiTouchAction mta = new MultiTouchAction(driver);
			mta.add(ta1).add(ta2).perform();
		
	}
}
