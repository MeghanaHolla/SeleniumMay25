package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void implementImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void navigateToApp(String url) {
		driver.get(url);
	}
	
	public void enterTextBox(String locValue, String value) {
		driver.findElement(By.id(locValue)).sendKeys(value);
	}
	
	public void clickButton(String loc, String locValue) {
		if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
		else if(loc.equals("xpath")){
			driver.findElement(By.xpath(locValue)).click();
		}
	}
	public String getMessage(String loc,String locValue) {
		String getConfMsg = null;
		if(loc.equals("cssSelector")) {
			 getConfMsg = driver.findElement(By.cssSelector(locValue)).getText();
		}
		else if(loc.equals("id")) {
			 getConfMsg = driver.findElement(By.id(locValue)).getText();
		}
		return getConfMsg;
	}
	
	public void closeApplication() {
		driver.close();
	}
	
	public void clickLink(String locValue) {
		driver.findElement(By.linkText(locValue)).click();
	}
}
