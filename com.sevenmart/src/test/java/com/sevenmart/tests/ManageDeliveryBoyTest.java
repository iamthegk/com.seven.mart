package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.DeliveryBoyCreationDataProvider;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.ManageDeliveryBoyPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;

public class ManageDeliveryBoyTest extends Base {
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	PageUility pageutility;
	ExcelUtility excelutility;

	@Test(groups = "smoke")
	public void verify_HitOnManageDeliveryBoyPage() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.HitOnManageDeliveryBoyPage();
		String actual = managedeliveryboypage.validatingDeliveryBoyPage();
		String expected = "List Delivery Boy";
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "deliveryBoyProfileCreation", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_CreateNewDeliveryBoy(String name, String mail, String phone, String address, String username,
			String password) {

		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.CreateNewDeliveryBoys(name, mail, phone, address, username, password);
		System.out.println(managedeliveryboypage.getSuccesAlertText());
		Assert.assertTrue(managedeliveryboypage.succesAlertMessage(), "New Delivery Boy Creation Failed");

	}

	@Test(dataProvider = "deliveryBoyProfileDetailsExcel", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_AlreadyExistingUserNameAlertTest(String name, String mail, String phone, String address,
			String username, String password) {
		ExcelUtility excelutility = new ExcelUtility();
		excelutility.setExcelFile("DeliveryBoyData", "AlreadyExistingUserDetails");
		String expectedUserName = excelutility.getCellData(0, 4);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.HitOnManageDeliveryBoyPage();
		String actual = managedeliveryboypage.searchingByUserName(expectedUserName);
		Assert.assertEquals(actual, expectedUserName, "Username not exist");

	}


	@Test(dataProvider = "deliveryBoyProfileDetailsExcel", dataProviderClass = DeliveryBoyCreationDataProvider.class, groups = "regression")
	public void verify_SearchingExistingDeliveryBoy(String name, String mail, String phone, String address,
			String username, String password) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		ExcelUtility excelutility = new ExcelUtility();
		excelutility.setExcelFile("DeliveryBoyData", "AlreadyExistingUserDetails");
		String existingname=excelutility.getCellData(0, 0);
		String existingemail=excelutility.getCellData(0, 1);
		String phoneNumber=excelutility.getCellData(0, 2);
		String expectedUserName=excelutility.getCellData(0, 4);
		managedeliveryboypage.SearchingExistingDeliveryBoy(existingname, existingemail,phoneNumber);
		String actualUserName=managedeliveryboypage.getUserNameOfExistingDeliveryBoyFromSearchTable();
		Assert.assertEquals(actualUserName, expectedUserName,"Searched user not found");
		
	}

	@Test(dataProvider = "NonExistingDeliveryBoyNameAndEmail", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_ResultNotFoundForNonExistingDeliveryBoy(String existingName, String existingEmail) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.ResultNotFoundForNonExistingDeliveryBoy(existingName, existingEmail);
		Assert.assertTrue(managedeliveryboypage.noResultFound());
	}

}
