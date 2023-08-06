package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.HomePage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.dataproviders.*;

public class LoginTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	ExcelUtility excelutility=new ExcelUtility();
	
	@Test(priority=1)
	public void verify_AdminUserlogin() {
		loginpage=new LoginPage(driver);
		loginpage.AdminUserlogin();
		homepage =new HomePage(driver);
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName="Admin";
		Assert.assertEquals(actualProfileName,expectedProfileName,"Admin Login Failed");
	}
	@Test
	public void verify_LoginUsingWrongCredentials() {
		loginpage =new LoginPage(driver);
		excelutility.setExcelFile("LoginData","InvalidLoginCredentials");
		String invalidUserName=excelutility.getCellData(0, 0);
		String invalidPassword=excelutility.getCellData(0, 1);
		loginpage.login(invalidUserName,invalidPassword);
		String actualerror=loginpage.getErrorMessage();
		String expectedErrorMessage="Alert!";
		Assert.assertEquals(actualerror,expectedErrorMessage,"Wrong Credentials Accepted");
		
		
	}
	@Test
	public void verify_RememberMeCheckBoxIsNotSelectedByDefaultInLoginPage() {
		loginpage =new LoginPage(driver);
		loginpage.accessLoginPageWithoutLogin();
		Assert.assertFalse(loginpage.rememberMeCheckBox(),"Remember me check box is checked by default");
	}
	

}