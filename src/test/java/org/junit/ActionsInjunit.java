package org.junit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ActionsInjunit {
	
	private static WebDriver driver;
	@Test
	public void keyDown() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");

        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .perform();

        WebElement textField = driver.findElement(By.id("textInput"));
        Assert.assertEquals("A", textField.getAttribute("value"));
    }
}
