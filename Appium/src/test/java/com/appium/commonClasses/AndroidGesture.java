package com.appium.commonClasses;

import java.time.Duration;
import java.util.List;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
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
		int srcDateXcod=src.getLocation().getX();
		System.out.println(srcDateXcod);
		int srcDateYcod=src.getLocation().getY();
		System.out.println(srcDateYcod);
		
		int dstDateXcord=dst.getLocation().getX();
		System.out.println(dstDateXcord);
		int dstDateYcord=dst.getLocation().getY();
		System.out.println(dstDateYcord);
	
		//ta.longPress(src, srcDateXcod, srcDateYcod).moveTo(dst, dstDateXcord, dstDateYcord).release().perform();
		ta.press(src).waitAction(Duration.ofNanos(1000)).moveTo(0, dstDateYcord).release().perform();
	}
	public static void swipe(AndroidDriver<AndroidElement> driver,AndroidElement src,AndroidElement dst){
		TouchAction ta=new TouchAction(driver);
		ta.press(src).moveTo(dst).release().perform();
	}
	
	public static void longPressOnElement(AndroidDriver<AndroidElement> driver,AndroidElement element){
		TouchAction ta=new TouchAction(driver);
		ta.longPress(element).waitAction(Duration.ofSeconds(500)).release().perform();
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
	/*
	 * 
	 * This function is to do tap operation
	 * on the element by scrolling to top or bottom
	 *  
	 *  */
	public static Boolean tapCellByTitle(AndroidDriver<AndroidElement> driver,String title) {
        System.out.println("  tapCellByTitle(): " + title);
        List<AndroidElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setMaxSearchSwipes(5).scrollIntoView("
                        + "new UiSelector().text(\"" + title + "\"))"));
        if (elementList.isEmpty())
            return false;
        else {
           try {
        	   //TouchAction act=new TouchAction((MobileDriver)driver);
             new TouchAction((MobileDriver) driver).press(elementList.get(0)).waitAction(Duration.ofMillis(70)).release().perform();
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
        return true;
        
       
    }
	
	/*
	 * This function is to only scroll to the element
	 * on vertical way both top and bottom
	 * 
	 * */
	public static void scrollToDesiredElementInVertcalWay(AndroidDriver<AndroidElement> driver,String title){
		
	        System.out.println("  tapCellByTitle(): " + title);
	        List<AndroidElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setMaxSearchSwipes(5).scrollIntoView("
	                        + "new UiSelector().text(\"" + title + "\"))"));
	        
	}
	/*
	 * This function is to only scroll to the element
	 * on horizontal way both left and right
	 * 
	 * */
	public static void scrollToHorizantalWay(AndroidDriver<AndroidElement> driver,String title){
		List<AndroidElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setAsHorizontalList().setMaxSearchSwipes(5).scrollIntoView("
                        + "new UiSelector().text(\"" + title + "\"))"));
		
	}
}
