package org.junit;

import java.time.Duration;
import java.util.Date;

import org.junit.experimental.theories.DataPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitEx {
	private static WebDriver driver;

	@DataPoint(value = "data-set")
	public static Object[][] datasets() {
		Object[][] datas = { { "valid", "sri", "12345" }, { "invalid", "dhanu", "54321" } };
		return datas;
	}

	@Before
	public void before() {
		Date d = new Date();
		System.out.println(d);
	}

	@Test()
	public void test(String type, String username, String password) {
		System.out.println(type + " " + username + " " + password);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys("asdgfg");
		driver.findElement(By.name("password")).sendKeys("sri");
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		if (type.contains("valid")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Instagram']")));
		} else {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//p[text()='Sorry, your password was incorrect. Please double-check your password.']")));
		}

		String veriUrl = "https://www.facebook.com/";
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(veriUrl, currentUrl);

	}

	@After
	public void after() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	public static void afterclass() {
		String title = driver.getTitle();
		System.out.println(title);
	}

}
