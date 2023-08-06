package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.PushNotificationsPage;
import com.sevenmart.utilities.ExcelUtility;



public class PushNotificationsTest extends Base {
	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test
	public void verifyPushNotificationLinkHit() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		loginpage.login();
		pushnotificationpage.hitOnPushNotificationLink();
		Assert.assertTrue(pushnotificationpage.hitConfirmPushnotificationPage(),"Push Notification Page is not opened");
	}
	@Test
	public void verify_EnterStringOnTitleAndDescription() {
		pushnotificationpage = new PushNotificationsPage(driver);
		pushnotificationpage.EnterStringOnTitleAndDescription();
		excelutility.setExcelFile("PushNotificationData","Sheet1");
		String titleMessage=excelutility.getCellData(0, 0);
		String descriptionMessage=excelutility.getCellData(0, 1);
		pushnotificationpage.passValuesOnTitleAndDescription(titleMessage, descriptionMessage);
		pushnotificationpage.clickSubmit();
		Assert.assertTrue(pushnotificationpage.successAlert(), "Sending push message is not succesfull");
		}
	public void verify_ResetButtonIsWorking() {
		pushnotificationpage = new PushNotificationsPage(driver);
		pushnotificationpage.EnterStringOnTitleAndDescription();
		excelutility.setExcelFile("PushNotificationData","Sheet1");
		String titleMessage=excelutility.getCellData(0, 0);
		String descriptionMessage=excelutility.getCellData(0, 1);
		pushnotificationpage.passValuesOnTitleAndDescription(titleMessage, descriptionMessage);
		pushnotificationpage.clickReset();
		Assert.assertTrue(false);
	}
	

}
