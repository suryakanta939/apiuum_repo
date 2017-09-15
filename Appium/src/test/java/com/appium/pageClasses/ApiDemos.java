package com.appium.pageClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemos {

	static AndroidDriver<AndroidElement> driver;
	static AndroidElement element;
	 public ApiDemos(AndroidDriver<AndroidElement> driver){
		 this.driver=driver;
	 }
	 
	 public static AndroidElement animation(){
		 element=driver.findElementByXPath("//android.widget.TextView[@text='Animation']");
		 return element;
	 }
	 
	 public static AndroidElement views(){
		 element=driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		 return element;
	 }
	 public static AndroidElement text(){
		 element=driver.findElementByXPath("//android.widget.TextView[@content-desc='Text']");
		 return element;
	 }
}
