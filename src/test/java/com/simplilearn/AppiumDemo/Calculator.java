package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {

	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}
	
	@Test(priority=0)
	public void verifyAdditionProcess() {
		//press digit 9
		driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();
		//Press + symbol
		driver.findElementByAccessibilityId("plus").click();
		//press digit 6
		driver.findElement(By.id("com.miui.calculator:id/digit_6")).click();
		//Press = symbol
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();
		String expectedResult = "15";
		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
					
	}
	
	@Test(priority=1)
	public void verifyMultiplicationProcess() {
		//press 5
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
		//press *
		driver.findElement(By.id("com.miui.calculator:id/op_mul")).click();
		//press 4
		driver.findElement(By.id("com.miui.calculator:id/digit_4")).click();
		//press =
		driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
		
		String expectedResult = "20";
		String actualResult = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority=2)
	public void clearBtnIsPresent() {
		boolean clearBtnDisplayed = driver.findElement(By.id("com.miui.calculator:id/btn_del_s")).isDisplayed();
		Assert.assertTrue(clearBtnDisplayed);
	}
	
	@AfterTest
	
	public void closingApplication()
	{
	driver.quit();
	}
}
