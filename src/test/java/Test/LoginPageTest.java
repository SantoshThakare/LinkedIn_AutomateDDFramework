package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.base;
import Pages.LoginPage;
import Utility.utility;


public class LoginPageTest extends base {

	public LoginPageTest() {

		super();
	}



	/**
	 *  To Run Initialize method before running each Testcases and To Open
	 * browser
	 */
	@BeforeMethod
	public void triggerDriver() {
		try {
			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 *  To Test LinkIn Login Page is working or not using config file
	 */

	@SuppressWarnings("static-access")
	@Test(priority = 1)
	public void validLoginPagewithConfigDataTest() {


		loginp = new LoginPage();
		loginp.LoginUser();
		

	}
	/**
	 *	To Test LinkIn Login Page is working or not using XLSX file
	 */


	 @SuppressWarnings("static-access")
	@Test(priority = 2)
	public void validLoginPageWithXlsxDataTest() {
		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();

		

	}

	/**
	 * To Run Terminate method after running each Testcases
	 */

	@AfterMethod
	public void terminateDriver() {
		try {

			utility.closedriver();

		} catch (Exception e) {

		}
	}
}
