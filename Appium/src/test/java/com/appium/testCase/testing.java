package com.appium.testCase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.commonClasses.AndroidKeyboardFunctions;
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
	  File f=new File("ApiDemos-debug.apk");
		File fs=new File(f,"");
		DesiredCapabilities cap=new DesiredCapabilities();
		  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		  cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ViewFunctions vs=new ViewFunctions(driver);
		vs.checkDargandDrop();
		AndroidKeyboardFunctions.clickOnBack(driver);
//		vs.checkAnimation();
//		
//		for(int i=0;i<2;i++){
//			AndroidKeyboardFunctions.clickOnBack(driver);
//			Thread.sleep(500);
//		}
		
		vs.selectingDate();
  }
}
