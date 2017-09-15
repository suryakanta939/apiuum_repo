package com.appium.pageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.appium.commonClasses.AndroidGesture;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ViewFunctions{
	
	static AndroidDriver<AndroidElement> driver;
	static AndroidElement element;
	static List<AndroidElement> elements;
	String dateXpath1="//android.view.View[@content-desc='";
	String dateXpath2="']";
	ApiDemos apidemo;
	public ViewFunctions(AndroidDriver<AndroidElement> driver){  
		apidemo=new ApiDemos(driver);
	//	super(driver);
		this.driver=driver;
	}
	/*
	 * Bello the elements are view elements
	 * 
	 * */

	public static AndroidElement animation(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Animation']");
		return element;
	}

	public static AndroidElement datewidgets(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
		return element;
	}

	/*
	 * 
	 *  elements related to drag and drop
	 *  */ 
	public static AndroidElement dragandDrop(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']");
		return element;
	}

	public static AndroidElement dragElement(){
    	element=driver.findElementById("io.appium.android.apis:id/drag_dot_3");
    	return element;
    }
	
    public static AndroidElement dropElement(){
    	element=driver.findElementById("io.appium.android.apis:id/drag_dot_2");
    	return element;
    }
    
    
	/*----------------------------------------------------------------------*/
    
	public static AndroidElement expandableList(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		return element;
	}

	public static AndroidElement spinner(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Spinner']");
		return element;
	}

	public static AndroidElement tab(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Tabs']");
		return element;
	}

	public void clickonViews(){
		apidemo.views().click();
	}
	/*
	 * this function is to perform the drag and drop
	 * 
	 * */
	
	public void checkDargandDrop(){

		clickonViews();            
		dragandDrop().click();
		AndroidGesture.dragAndDrop(driver, dragElement(), dragElement());
		

	}
	/*
	 * 
	 * below elements are for animation
	 * 
	 * */
	public static List<AndroidElement> animationelements(){
		 elements=driver.findElementsById("android:id/text1");
		 return elements;
	}
	 public static void  chooseElements(String name){
		 for(int i=0;i<animationelements().size();i++){
			 String text=animationelements().get(i).getText();
			 if(text.equals(name)){
				 animationelements().get(i).click();
			 }
		 }
	 }
	 
	 public static void chooseAlltransition() throws InterruptedException{
		 for(int i=0;i<animationelements().size();i++){
			
				 animationelements().get(i).click();
				 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				 driver.findElementById("io.appium.android.apis:id/picture").click();
				 Thread.sleep(1000);
			 }
		 }
	 
	public void checkAnimation() throws InterruptedException{
		animation().click();
		chooseElements("3D Transition");
	    chooseAlltransition();
	}
	/*-----------------------------------------------------------------------------*/
	
	/*
	 * below functions are to perform the date widget function
	 * */
	
	
	
	public static AndroidElement dialog(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='1. Dialog']");
		return element;
	}
	
	public static AndroidElement changeDate(){
		element=driver.findElementByXPath("//android.widget.Button[@text='change the date']");
		return element;
	}
	
	public static AndroidElement nextButton(){
		element=driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Next month']");
		return element;
	}
	
	public AndroidElement dateMonthYear(String dateIn){
		element=driver.findElementByXPath(dateXpath1+dateIn+dateXpath2);
		return element;
		
	}
//	public AndroidElement dateMonthYear(){
//		element=driver.findElementByXPath("//android.view.View[@content-desc='12 December 2017']");
//		return element;
//		
//	}
//	
	/*this function is to choose the advnace date*/
	
	public void chooseDateFromCalender(String urdateMonthYear) throws InterruptedException{
		for(int i=0;i<6;i++){
		
			try{
					
					if(i==5){
						System.out.println("it seems you have not enterd valid date or the date format you"
								+ "have entered is not correct .Please enter the date as ex.30 December 2017");
						break;
					}else{
						
						dateMonthYear(urdateMonthYear).click();
						String date=dateMonthYear(urdateMonthYear).getText();
						System.out.println(date);
						
						break;
					}
					
				
			}catch(Throwable t){
				nextButton().click();
			}
		}
	
	}
	
	public void selectingDate() throws InterruptedException{
		datewidgets().click();
		dialog().click();
		changeDate().click();
		chooseDateFromCalender("32 December 2017");
	}
	
}
