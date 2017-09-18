package com.appium.testCase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.commonClasses.AndroidKeyboardFunctions;
import com.appium.commonClasses.InvokeAppium;
import com.appium.pageClasses.ViewFunctions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class testing {
	AndroidDriver<AndroidElement> driver;
  @Test
  public void f() throws MalformedURLException, InterruptedException 
  {
	 driver=InvokeAppium.runAppium("ApiDemos-debug.apk", "Android device");
	//  driver=InvokeAppium.runAppium("bookmyshow.apk", "SuryaEmulator");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		String text = "your text";
//				AndroidElement el = driver.findElement(MobileBy
//				                    .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
//				                            + "new UiSelector().text(\""+text+"\"));"));
		ViewFunctions vs=new ViewFunctions(driver);
		vs.checkDargandDrop();
		AndroidKeyboardFunctions.clickOnBack(driver,1);
		vs.checkAnimation();
		
	
			AndroidKeyboardFunctions.clickOnBack(driver,2);
	
		vs.selectingDate();
		
	
			AndroidKeyboardFunctions.clickOnBack(driver,3);

		vs.spinnerFunction();
		AndroidKeyboardFunctions.clickOnBack(driver,2);
		vs.performexpandableFunction();
		
		
 }
}
