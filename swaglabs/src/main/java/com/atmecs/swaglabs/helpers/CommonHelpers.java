package com.atmecs.swaglabs.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.atmecs.swaglabs.filepath.FilePath;

public class CommonHelpers {
	public static String pageTittle;
	public static String currentUrl;

	public static void SendkeysAction(WebDriver driver, String elementPath, String value) {
		driver.findElement(By.xpath(elementPath)).sendKeys(value);
	}

	public static void clickAction(WebDriver driver, String elementPath) {
		driver.findElement(By.xpath(elementPath)).click();
	}

	public static void getTittle(WebDriver driver, String elementPath, String Value) {
		pageTittle = driver.getTitle();
		return;
	}

	public static void getUrl(WebDriver driver, String elementPath, String Value) {
		currentUrl = driver.getCurrentUrl();

	}

	public static void dropDown(WebDriver driver, String elementPath, String value, String option) {
		try {
			WebElement webElement = driver.findElement(By.xpath(elementPath));
			Select sc = new Select(webElement);
			if (option.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void handleAlerts(WebDriver driver, String action) {
		Alert alert = driver.switchTo().alert();
		if (action.equalsIgnoreCase("accept")) {

			alert.accept();
		} else if (action.equalsIgnoreCase("dismiss")) {
			System.out.println(alert.getText());
			alert.dismiss();
		}
	}

	public static void alertSendText(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys(text);
		alert.accept();

	}
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(FilePath.page_load_timeout, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, FilePath.page_load_timeout);
		WebElement element;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.click();
	}

	
	

}
