package com.appium.testCase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.commonClasses.AndroidKeyboardFunctions;
import com.appium.commonClasses.InvokeAppium;
import com.appium.commonClasses.StartingAppiumServer;
import com.appium.pageClasses.ViewFunctions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class testing {
	AndroidDriver<AndroidElement> driver;
	String nodepath="C:/Program Files/nodejs/node.exe";
	String apppath="C:/Users/User/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
	int port=4723;
	@Test
	public void f() throws InterruptedException, IOException 
	{
		if(StartingAppiumServer.checkIfServerIsRunnning(port)){

			System.out.println("Appium Server already running on Port - " + port);
			StartingAppiumServer.stopServer();
			Thread.sleep(10000);
			StartingAppiumServer.startServeronConsol(nodepath, apppath);



		}else{
			StartingAppiumServer.startServeronConsol(nodepath, apppath);
			//		  StartingAppiumServer.startServerOnCommandPrompt("startappium.bat");
			//		  Thread.sleep(8000);
		}
		//	  if(StartingAppiumServer.stopServer()==false){
		//		  StartingAppiumServer.stopServer();
		//	  }else{
		//		  StartingAppiumServer.startServeronConsol(nodepath, apppath);
		//	  }

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
