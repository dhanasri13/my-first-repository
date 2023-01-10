package com.launch;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends BaseClass{

	public static void main(String[] args) {
		BrowserLaunch b=new BrowserLaunch();
		getdriver();
		getappurl("https://www.facebook.com/");
		maximizewindow();
		WebElement user = driver.findElement(By.id("email"));
		elementsendkeysjs(user,"asd");
//		elementsendkeys(user,"asd");
		

	}

}
 