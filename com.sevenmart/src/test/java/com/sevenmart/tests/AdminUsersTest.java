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
	@Test()
	public void verifyNewAdminCreation() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		excelutility=new ExcelUtility();
		excelutility.setExcelFile("AdminUsers", "UsersInfo");
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		String username=excelutility.getCellData(0, 0);
		String password=excelutility.getCellData(0, 1);
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Admin");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"Newly Created Admin User Not Found, Created admin user name not found in the table");
	}
	@Test()
	public void verifyNewStaffCreation() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		excelutility=new ExcelUtility();
		excelutility.setExcelFile("AdminUsers", "UsersInfo");
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		String username=excelutility.getCellData(1, 0);
		String password=excelutility.getCellData(1, 1);
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Staff");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"Newly Created Staff User Not Found, Created admin user name not found in the table");
	}
	@Test()
	public void verifyNewPartnerCreation() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		excelutility=new ExcelUtility();
		excelutility.setExcelFile("AdminUsers", "UsersInfo");
		String username=excelutility.getCellData(2, 0);
		String password=excelutility.getCellData(2, 1);
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Partner");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"Newly Created Partner User Not Found, Created admin user name not found in the table");
	}
	@Test()
	public void verifyNewDeliveryBoyCreation() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		excelutility=new ExcelUtility();
		excelutility.setExcelFile("AdminUsers", "UsersInfo");
		String username=excelutility.getCellData(3, 0);
		String password=excelutility.getCellData(3, 1);
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectUserType("Delivery Boy");
		adminUsersPage.clickOnSaveButton();
		String expectedUserName=username;
		String actualUsetName=adminUsersPage.userNameCreated();
		Assert.assertEquals(actualUsetName, expectedUserName,"Newly Created Delivery Boy User Not Found, Created admin user name not found in the table");
		
	
	}
	@Test
	public void verify_DeleteAnUser() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.deleteUser("Appukuttan1_Admin");
		pageutility=new PageUility(driver);
		pageutility.acceptAlert();
		Assert.assertTrue(adminUsersPage.alertDeleteMessage(),"User not deleted");
		
		
	}

}
