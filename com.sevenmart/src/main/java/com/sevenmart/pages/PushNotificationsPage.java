package com.sevenmart.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sevenmart.utilities.GeneralUtility;

public class PushNotificationsPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	LoginPage loginpage;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	private WebElement PushNotificationLink;
	@FindBy(xpath = "//input[@id='description']")
	private WebElement description;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement title;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	private WebElement pushNotificationPageConfirm;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//a[@type='button']")
	private WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hitOnPushNotificationLink() {

		PushNotificationLink.click();

	}

	public void passValuesOnTitleAndDescription(String titleText, String descriptionText) {
		title.sendKeys(titleText);
		description.sendKeys(descriptionText);
		
	}

	public boolean hitConfirmPushnotificationPage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(pushNotificationPageConfirm);
	}

	public void clickSubmit() {
		submitButton.click();
	}

	public void clickReset() {
		resetButton.click();
	}

	public boolean successAlert() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(successAlert);
	}

	public void EnterStringOnTitleAndDescription() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		hitOnPushNotificationLink();

	}

}
