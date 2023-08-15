package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.AdminUserDataProvider;
import com.sevenmart.pages.AdminUsersPage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;

public class AdminUsersTest extends Base{
	AdminUsersPage adminUsersPage;
	LoginPage loginpage;
	ExcelUtility excelutility;
	PageUility pageutility;
	@Test(priority=1)
	public void verify_HitOnAdminUsersPage() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		String actual=adminUsersPage.adminUsersPageVerification();
		String expected="Admin Users";
		System.out.println(GeneralUtility.getRandomName());
		Assert.assertEquals(actual,expected,"hiting not working");
		
	}
	@Test(dataProvider = "NewAdminCreationFromAdminPageUsingExcel", dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewAdminCreation(String usernameFromExcel,String passwordFromExcel) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(usernameFromExcel);
		adminUsersPage.enterPassWord(passwordFromExcel);
		adminUsersPage.selectUserType("Admin");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=usernameFromExcel;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"New admin creation failed");
	}
	@Test(dataProvider = "NewStaffCreationFromAdminPageUsingExcel", dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewStaffCreation(String staffUsernameFromExcel,String staffPasswordFromExcel) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		String username=staffUsernameFromExcel;
		String password=staffPasswordFromExcel;
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Staff");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"New Staff creation failed");
	}
	@Test(dataProvider = "NewPartnerCreationFromAdminPageUsingExcel", dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewPartnerCreation(String partnerUsernameFromExcel,String partnerPasswordFromExcel) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		String username=partnerUsernameFromExcel;
		String password=partnerPasswordFromExcel;
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Partner");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"New partner creation failed");
	}
	
	@Test(dataProvider = "NewDeliveryBoyCreationFromAdminPageUsingExcel", dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewDeliveryBoyCreation(String deliveryBoyUsernameFromExcel,String deliveryBoyPasswordFromExcel) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		String username=deliveryBoyUsernameFromExcel;
		String password=deliveryBoyPasswordFromExcel;
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Delivery Boy");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"New Delivery Boy Creation Failed");
		
	
	}
	@Test
	public void verify_DeleteAnUser() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.deleteUser("reymondd23deliver");
		pageutility=new PageUility(driver);
		pageutility.acceptAlert();
		Assert.assertTrue(adminUsersPage.alertDeleteMessage(),"User not deleted");
		
		
	}
	
}


