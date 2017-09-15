package com.appium.commonClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class AndroidKeyboardFunctions {
	
	public static void clickOnBack(AndroidDriver<AndroidElement> driver){
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
}
