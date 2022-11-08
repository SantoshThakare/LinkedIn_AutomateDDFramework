package Test;

import static org.testng.Assert.assertEquals;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.base;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.utility;


public class HomePageTest extends base {

	public HomePageTest() {
		super();
	}

	/**
	 * To Run Initialize method before running each Testcases
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
	 * To upload profile picture in LinkedIn
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1)
	public void UploadProfileImage() {
		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();
		homep = new HomePage();
		homep.UploadUserProfileImage();

		String homePageTitle = util.verifyHomePage();
		assertEquals(homePageTitle, "Santosh Thakare | LinkedIn");
	}
	/**
	 * To upload  picture in LinkedIn
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 2)
	public void UploadImage() {
		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();
		homep = new HomePage();
		homep.UploadUserImage();

		String homePageTitle = util.verifyHomePage();
		assertEquals(homePageTitle, "Feed | LinkedIn");
	}
	/**
	 * To post Comment in LinkedIn
	 *
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 3)
	public void CommentPost() throws Exception {

		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();
		homep = new HomePage();
		homep.userCommentPost();
		String homePageTitle = util.verifyHomePage();
		assertEquals(homePageTitle, "Feed | LinkedIn");

	}
	/**
	 * To post Randomly Comment in LinkedIn
	 *
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 4)
	public void RandomCommentPost() throws Exception {

		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();
		homep = new HomePage();
		homep.userRandomCommentPost();
		String homePageTitle = util.verifyHomePage();
		assertEquals(homePageTitle, "Feed | LinkedIn");
	}
	
	/**
	 * To like post in LinkedIn
	 * @throws Exception
	 *
	 */

	@SuppressWarnings("static-access")
	@Test(priority = 5)
	public void likePost() throws InterruptedException {
		loginp = new LoginPage();
		loginp.LoginUserUsingXlsx();
		homep = new HomePage();
		homep.userLikePost();
		String homePageTitle = util.verifyHomePage();
		AssertJUnit.assertEquals(homePageTitle, "Feed | LinkedIn");

	}

	
	/**
	 * To Run Terminate method after running each Testcases
	 */

	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		try {

			Thread.sleep(4000);
			utility.closedriver();

		} catch (Exception e) {

		}
	}
}
