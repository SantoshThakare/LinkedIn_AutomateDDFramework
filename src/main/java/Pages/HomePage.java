package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends LoginPage {

	@FindBy(xpath = "//span[@title='Home']")
	WebElement homebtn;

	@FindBy(xpath = "//span[normalize-space()='Photo']")
	WebElement photobtn;

	@FindBy(xpath = "//button[@class='ml2 artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")
	WebElement DonePhotobtn;

	@FindBy(xpath = "//span[normalize-space()='Post']")
	WebElement Postbtn;

	@FindBy(xpath = "//div[@aria-label='Text editor for creating content']//p")
	WebElement textcommentbox;
	
	@FindBy(xpath = "//img[@class='feed-identity-module__member-photo EntityPhoto-circle-5 lazy-image ember-view']")
	WebElement IdentifyProfilebtn;
	
	@FindBy(xpath = "//img[@class='ember-view profile-photo-edit__preview']")
	WebElement IdentProfilebtn;
	
	@FindBy(xpath = "//button[@class='display-block display-flex flex-column fl ml6 artdeco-button artdeco-button--inverse artdeco-button--4 artdeco-button--tertiary ember-view']//li-icon[@type='edit']")
	WebElement EditProfileBtn;
	
	@FindBy(xpath = "//button[@class='display-block display-flex flex-column fl ml6 artdeco-button artdeco-button--inverse artdeco-button--4 artdeco-button--tertiary ember-view']//li-icon[@type='camera']")
	WebElement AddPhotoBtn;

	@FindBy(xpath = "//label[normalize-space()='Upload photo']")
	WebElement UploadPhotoBtn;
	
	@FindBy(xpath = "//button[@class='profile-photo-cropper__apply-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")
	WebElement SavePhotoBtn;
	
	@FindBy(xpath = "(//*[name()='svg'][@class='mercado-match'])[40]")
	WebElement MinimizeMsgBtn;
	
	@FindBy(xpath = "(//span[@class='reactions-react-button feed-shared-social-action-bar__action-button'])[1]")
	WebElement LikeBtn;
	
	@FindBy(xpath = "//div[@aria-label='Text editor for creating content']//p")
	WebElement CommentBoxBtn;
	
	@FindBy(xpath = "(//button[@aria-label='Comment'])[1]")
	WebElement CommentBtn;
	
	@FindBy(xpath = "(//button[@class='comments-comment-box__submit-button mt3 artdeco-button artdeco-button--1 artdeco-button--primary ember-view'])[1]")
	WebElement CommentPostBtn;
	/**
	 * To Upload profile image of user in facebook
	 */
	public void UploadUserProfileImage() {
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			homebtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(IdentifyProfilebtn));
			IdentifyProfilebtn.click();

			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(IdentProfilebtn));
			IdentProfilebtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(AddPhotoBtn));
			AddPhotoBtn.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(UploadPhotoBtn));
			UploadPhotoBtn.click();
			Runtime.getRuntime().exec(".\\src\\main\\resources\\repository\\ProfilePhoto.exe");
			Thread.sleep(2000);					
			wait.until(ExpectedConditions.visibilityOfAllElements(SavePhotoBtn));
			SavePhotoBtn.click();
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * To Upload  image of user in facebook
	 */
	public void UploadUserImage() {
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			homebtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(photobtn));
			photobtn.click();
			Runtime.getRuntime().exec(".\\src\\main\\resources\\repository\\auto_photos.exe");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(DonePhotobtn));
			DonePhotobtn.click();
			textcommentbox.click();
			wait.until(ExpectedConditions.elementToBeClickable(textcommentbox));
			textcommentbox.sendKeys("Hii....... Guys");
			wait.until(ExpectedConditions.visibilityOfAllElements(Postbtn));
			Postbtn.click();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To post comment in LinkedIn
	 */
	public void userCommentPost() throws InterruptedException {
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			homebtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(CommentBtn));
			CommentBtn.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", CommentBoxBtn);
//				for (int i = 1; i < 6; i++) {
//					js.executeScript("window.scrollBy(0, 250)");
//					Thread.sleep(2000);
//				}
//				for (int i = 1; i < 5; i++) {
//					js.executeScript("window.scrollBy(0, 0)");
//					Thread.sleep(2000);
//				}

			wait.until(ExpectedConditions.elementToBeClickable(CommentBoxBtn));
			CommentBoxBtn.sendKeys("IIॐ जय श्री राम नमःII");

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(CommentPostBtn));
			CommentPostBtn.click();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To post Randomly Comment in LinkedIn
	 */
	public void userRandomCommentPost() throws InterruptedException, AWTException {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);

		wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
		homebtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(CommentBtn));
		CommentBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", CommentBoxBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(CommentBoxBtn));
		CommentBoxBtn.sendKeys(randomString);

		wait.until(ExpectedConditions.visibilityOfAllElements(CommentPostBtn));
		CommentPostBtn.click();
	}

	
	/**
	 * To Like post in LinkedIn
	 * 
	 * @throws InterruptedException
	 *
	 */

	public void userLikePost() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", LikeBtn);
//		
//		String likee = LikeBtn.getAttribute("aria-pressed");
//		switch (likee) {
//		case "true":
//			System.out.println("Already click Like Button");
//			break;
//
//		default:
//			wait.until(ExpectedConditions.visibilityOfAllElements(LikeBtn));
//			Thread.sleep(3000);
//			LikeBtn.click();
//			break;

		wait.until(ExpectedConditions.visibilityOfAllElements(LikeBtn));
		wait.until(ExpectedConditions.elementToBeClickable(LikeBtn));

//		Actions actions = new Actions(driver);
//		actions.moveToElement(LikeBtn).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", LikeBtn);
		if (LikeBtn.isEnabled()) {

			System.out.println("Already click on like button ");
		} else {
			wait.until(ExpectedConditions.visibilityOfAllElements(LikeBtn));
			LikeBtn.click();
		}

		}
	}




