package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

import Base.base;

public class utility extends base {


	/**
	 * To Initialize the WebDriver
	 */
	public static void intilization(String browser) {
		try {

			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get(prop.getProperty("baseURL"));

			} else if (browser.equals("opera")) {
				driver = new OperaDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get(prop.getProperty("baseURL"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object[][] getloginData() {

		try {

			excelfile = new FileInputStream(FILE_PATH);
			xWorkBook = new XSSFWorkbook(excelfile);
			xSheet = xWorkBook.getSheet("LoginData");
			int lastrow = xSheet.getLastRowNum();

			data = new Object[lastrow][2];
			int k = 0;
			for (int i = 1; i <= lastrow; i++) {
				String username = xSheet.getRow(i).getCell(k).getStringCellValue();
				String password = xSheet.getRow(i).getCell(k + 1).getStringCellValue();
				System.out.println("Row" + i + "Username" + username);
				System.out.println("Row" + i + "Password" + password);
				System.out.println();

				data[i][0] = username;
				data[i][1] = password;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}
//Method To Use  read data from XLSX file

	public static List<List<String>> excelreader() throws IOException {

		List<List<String>> values = new LinkedList<List<String>>();
		File file = new File(FILE_PATH);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Data");

		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			int cellCount = sheet.getRow(i).getLastCellNum();
			List<String> val = new LinkedList<String>();
			for (int j = 0; j < cellCount; j++) {
				val.add(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			values.add(val);
		}
		return values;
	}

//	Method  To use  Take  Screenshot

	public static void takeScreenshots() {
		try {

			Date dates = new Date();
			String date0 = dates.toString();
			System.out.println("Date is:" + date0);
			String date1 = date0.replaceAll(":", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;

			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(".//Screenshot/" + date1 + "FailurePage.png");

			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To verify Assertion Homepagetitle
	 */
	public static String verifyHomePage() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}

	/**
	 * To verify Assertion PostProfileImagePage
	 * 
	 * @throws InterruptedException
	 */
	public static String verifyProfileImagePostPage() throws InterruptedException {

		WebElement pt = driver.findElement(By.xpath("(//a[@aria-label='1 m'])[1]"));
		int x = pt.getLocation().getX();
		int y = pt.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");

		String PostTime = pt.getText();

		System.out.println(PostTime);
		return PostTime;
	}

	/**
	 * To verify Assertion PostImagePage
	 */
	public static String verifyImagePostPage() {

		WebElement pt = driver.findElement(By.xpath("(//a[@aria-label='1 m'])[1]"));
		int x = pt.getLocation().getX();
		int y = pt.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");

		String PostTime = pt.getText();

		System.out.println(PostTime);
		return PostTime;
	}

	/**
	 * To verify Assertion Post Video in Facebook
	 */
	public static String verifyVideoPage() {
		WebElement pt = driver.findElement(By.xpath("(//a[@aria-label='1 m'])[1]"));
		int x = pt.getLocation().getX();
		int y = pt.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");

		String PostTime = pt.getText();

		System.out.println(PostTime);
		return PostTime;
	}

	/**
	 * To verify Assertion Random Comment page in Facebook
	 */
	public static String verifyRandomCommentPage() {
		WebElement pt = driver.findElement(By.xpath("//span[normalize-space()='1 m']"));
		int x = pt.getLocation().getX();
		int y = pt.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");

		String PostTime = pt.getText();

		System.out.println(PostTime);
		return PostTime;
	}
	/**
	 * To verify Assertion Comment Post in Facebook
	 */
	public static String verifyCommentPage() {
		WebElement pt = driver.findElement(By.xpath("(//span[normalize-space()='1 m'])[1]"));
		int x = pt.getLocation().getX();
		int y = pt.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");

		String PostTime = pt.getText();

		System.out.println(PostTime);
		return PostTime;
	}
	
	// Method To Run Terminate method after running each Testcases

	public static void closedriver() {

		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
