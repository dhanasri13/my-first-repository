package org.baseclass;



import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public static void getappurl(String url) {
		driver.get(url);
	}
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}
	public static void minimizewindow() {
		driver.manage().window().minimize();
	}
	public static void elementsendkeys(WebElement element,String data) {
		element.sendKeys(data);
	}
	public static void elementsendkeysjs(WebElement element,String data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','" + data +"')", element);
	}
	
	public static String getdatafromcell(String data,WebElement element) {
		return null;
	}
	public static void elementclick(WebElement element) {
		element.click();
	}
	public String getwindowtitle() {
		String title = driver.getTitle();
		return title;
	}
	public WebElement findelementbyid(String attributevlue,WebElement element) {
		 element = driver.findElement(By.id(attributevlue));
		 return element;
	}
	public WebElement findelementbyname(String attributevlue,WebElement element) {
		 element = driver.findElement(By.name(attributevlue));
		 return element;
	}
	public WebElement findelementbyclassname(String attributevlue,WebElement element) {
		 element = driver.findElement(By.className(attributevlue));
		 return element;
	}
	public WebElement findelementbyxpath(String attributevlue,WebElement element) {
		 element = driver.findElement(By.xpath(attributevlue));
		 return element;
	}
	public WebElement findelementbycssselector(String attributevlue,WebElement element) {
		 element = driver.findElement(By.cssSelector(attributevlue));
		 return element;
	}
	public WebElement findelementbylinkText(String attributevlue,WebElement element) {
		 element = driver.findElement(By.linkText(attributevlue));
		 return element;
	}
	public WebElement findelementbypartiallinktext(String attributevlue,WebElement element) {
		 element = driver.findElement(By.partialLinkText(attributevlue));
		 return element;
	}
	public WebElement findelementbytagname(String attributevlue,WebElement element) {
		 element = driver.findElement(By.tagName(attributevlue));
		 return element;
	}
	public void closewindow() {
		driver.close();
	}
	public void quitwindow() {
		driver.quit();
	}
	public String elementgettext(WebElement element) {
		String text = element.getText();
		return text;
	}
	public String elementgetattributevalue(WebElement element, String attributname) {
		 String attribute = element.getAttribute(attributname);
		 return attribute;
	}
	public void selectoptionbytext(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void selectoptionbyattribute(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void selectoptionbyindex(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public String getoptions(WebElement element) {
		Select s=new Select(element);
		List<WebElement> options =s.getOptions();
		WebElement webElement= options.get(4);
		String text = webElement.getText();
		return text;
	}
	public String getallselectedoptions(WebElement element) {
		Select s=new Select(element);
		List<WebElement> options=s.getAllSelectedOptions();
		String text = options.get(1).getText();
		return text;
	}
	public String getfirstselectedoption(WebElement element) {
		Select s=new Select(element);
		WebElement option = s.getFirstSelectedOption();
		String text = option.getText();
		return text;
	}
	public void ismultiple(WebElement element) {
		Select s=new Select(element);
		s.isMultiple();
	}
	public void deselectoptionbytext(WebElement element, String text) {
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
	public void deselectoptionbyattribute(WebElement element, String value) {
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	public void deselectoptionbyindex(WebElement element, int index) {
		Select s=new Select(element);
		s.deselectByIndex(index);
	}
	public void deselectall(WebElement element) {
		Select s= new Select(element);
		s.deselectAll();
	}
	public String elementgettext(WebElement element, String value) {
		String text = element.getAttribute(value);
		return text;
	}
	public void elementclickbuttonbyjs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void clickokalert() {
		driver.switchTo().alert().accept();
	}
	public void clickcancelalert() {
		driver.switchTo().alert().dismiss();
	}
	public void acceptandokalert(String data) {
		driver.switchTo().alert().sendKeys(data);
		driver.switchTo().alert().accept();
	}
	public void switchtoframebyindex(int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoframebyid(String id) {
		driver.switchTo().frame(id);
	}
	public void switchtomainpagefromframe() {
		driver.switchTo().defaultContent();
	}
	public String getparentwindowid() {
		String id = driver.getWindowHandle();
		return id;
	}
	public Set<String> getallwindowsid() {
		Set<String> id = driver.getWindowHandles();
		return id;
	}
	public void switchtowindowbyid(String id) {
		driver.switchTo().window(id);
	}
	public void switchtowindowbytitle(String title) {
		driver.switchTo().window(title);
	}
	public void switchtowindowbyurl(String url) {
		driver.switchTo().window(url);
	}
	public void navigateback() {
		driver.navigate().back();
	}
	public void navigateforward() {
		driver.navigate().forward();
	}
	public void navigaterefresh() {
		driver.navigate().refresh();
	}
	public void navigatetourl(String url) {
		driver.navigate().to(url);
	}
	public void movetoelement(WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void draganddrop(WebElement element1, WebElement element2) {
		Actions a=new Actions(driver);
		a.dragAndDrop(element1,element2).perform();
	}
	public void rightclick(WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	public void doubleclick(WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	public String getpagesource() {
		String text = driver.getPageSource();
		return text;
	}
	public String tagname(WebElement element) {
		String text = element.getTagName();
		return text;
	}
	public String getcssvalue(WebElement element, String value) {
		String text = element.getCssValue(value);
		return text;
	}
	public Dimension getsize(WebElement element) {
		Dimension size = element.getSize();
		return size;
	}
	public void getconnection(String url) throws SQLException {
		DriverManager.getConnection(url);
	}
	public void clear(WebElement element) {
		element.clear();
	}
	public boolean isenabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public boolean isdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public void submit(WebElement element) {
		element.submit();
	}
	public void takescreenshot(WebElement element, String path) throws IOException {
		
		TakesScreenshot scrn = (TakesScreenshot) driver;
		File f = scrn.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(f, d);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
