package pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.LogStatus;
import com.technosoft.selenium.MavenTest.BasePage;



public class LandingScreen extends BasePage {

	private WebDriver driver = null;
	private String username = "email";
	private String password = "pass";
	private String loginButton = "loginbutton";


	public LandingScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String enterDataIntoTextField) {
		enterTextIntoEditField(driver, username, enterDataIntoTextField);
	}

	public void enterPassword(String enterDataIntoTextField) {
		enterTextIntoEditField(driver, password, enterDataIntoTextField);
	}
	public void verifyTitle(String title) {
		
		Assert.assertTrue(driver.getTitle().contains(title), "Title is not correct.");
		System.out.println("Application title is correct.");
		
	}

	public void clickOnLoginButton() {
		clickOnButton(driver,loginButton);
	}
}
