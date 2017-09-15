package com.appium.commonClasses;

import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidGesture {

	public static void dragAndDrop(AndroidDriver<AndroidElement> driver,AndroidElement src,AndroidElement dst){
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction(Duration.ofSeconds(3)).moveTo(dst).release().perform();
	}
	public static void swipeToleft(AndroidDriver<AndroidElement> driver,AndroidElement src,AndroidElement dst){
		TouchAction ta=new TouchAction(driver);
		int srcDateXcod=src.getLocation().x;
		System.out.println(srcDateXcod);
		int srcDateYcod=src.getLocation().y;
		System.out.println(srcDateYcod);
		
		int dstDateXcord=dst.getLocation().x;
		System.out.println(dstDateXcord);
		int dstDateYcord=dst.getLocation().y;
		System.out.println(dstDateYcord);
	
		ta.longPress(src, srcDateXcod, srcDateYcod).moveTo(dst, dstDateXcord, dstDateYcord).release().perform();
		
	}
	public static void swipe(AndroidDriver<AndroidElement> driver,AndroidElement src,AndroidElement dst){
		TouchAction ta=new TouchAction(driver);
		ta.press(src).moveTo(dst).release().perform();
	}
	
	public static void longPressOnElement(AndroidDriver<AndroidElement> driver,AndroidElement element){
		TouchAction ta=new TouchAction(driver);
		ta.longPress(element).waitAction(Duration.ofSeconds(500)).perform();
	}
	
	/*
	 * This function is to scroll to particular element
	 * he re is the real 
	 * driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Animation\"));");
	 * */
	public static void scrollToElemntBytext(AndroidDriver<AndroidElement> driver,String text){
		String s1="new UiScrollable(new UiSelector()).scrollIntoView(text(\"";
		String s2="\"));";
		driver.findElementByAndroidUIAutomator(s1+text+s2);
	}

	public static void scrollToElemntByid(AndroidDriver<AndroidElement> driver,String id){
		String s1="new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"";
		String s2="\"));";
		driver.findElementByAndroidUIAutomator(s1+id+s2);
	}
	
}
