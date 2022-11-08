package Pages;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.base;
import Utility.utility;


public class LoginPage extends base {


	@FindBy(id = "username")
	WebElement emailId;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@aria-label='Sign in']")
	WebElement loginBtn;

	@FindBy(xpath = "//span[@title='Home']")
	WebElement homebtn;


	/**
	 *To Initialize the WebElements generated from FindBy Annotation
	 */
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}
	WebDriverWait wait = new WebDriverWait(driver,90);


	/**
	 *To verify Home Page Title with Config data
	 */
	public void LoginUser() {
		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			password.sendKeys(prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			loginBtn.click();
//			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To verify Home Page Title with Xlsx file
	 */
	public void LoginUserUsingXlsx() {
		try {
			List<List<String>> values= new LinkedList<List<String>>();
			values.addAll(utility.excelreader());
			emailId.sendKeys(values.get(0).get(0));
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			password.sendKeys(values.get(0).get(1));
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			loginBtn.click();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}