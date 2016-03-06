package com.technosoft.selenium.MavenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage extends AbstractTest {

	public void enterTextIntoEditField(WebDriver driver,
			String enterLocatorValue, String enterDataIntoTextField) {
		driver.findElement(By.id(enterLocatorValue)).sendKeys(
				enterDataIntoTextField);

	}

	public void clickOnButton(WebDriver driver, String enterLocatorValue) {
		driver.findElement(By.id(enterLocatorValue)).click();

	}

}
