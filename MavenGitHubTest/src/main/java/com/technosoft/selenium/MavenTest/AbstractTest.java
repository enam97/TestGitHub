package com.technosoft.selenium.MavenTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;



public class AbstractTest {
	
	
	public WebDriver driver = null;
	public File firefoxPath = null;
	private String url = "http://facebook.com";

	public void getDriver() {
		
		System.out.println("Executing on Chrome Browser");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Java source files\\chromedriver.exe");
		driver = new ChromeDriver();
		
/*		FirefoxBinary ffBinary = new FirefoxBinary("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		FirefoxProfile ffProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, ffProfile);*/
		
/*		firefoxPath = new File ("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(firefoxPath);  //"C:/Program Files (x86)/Mozilla Firefox/firefox.exe"
		FirefoxProfile ffProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, ffProfile);*/
		
//		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
	}
	
	public void getUrl() {
		driver.get(url);
	}
	
	public void cleanUP() {
//		driver.quit();
	}

}
