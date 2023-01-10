package org.testNg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgEx {
	private static WebDriver driver;

	@DataProvider(name = "datas")
	public static Object[][] datasets() {
		Object[][] datas = { { "valid", "vj_sri16", "lavsri1102" }, { "invalid", "sri", "4321" } };
		return datas;
	}

	@Test(dataProvider = "datas")
	public void sampletest(String type, String username, String password) throws InterruptedException {
		try {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.instagram.com/");
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			Thread.sleep(8000);
			WebElement sign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Log in']")));

			sign.click();

			if (type.equals("valid")) {

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Not Now']")));
			} else {

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//p[text()='Sorry, your password was incorrect. Please double-check your password.']")));
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("no clickable element");

		}

	}
}
