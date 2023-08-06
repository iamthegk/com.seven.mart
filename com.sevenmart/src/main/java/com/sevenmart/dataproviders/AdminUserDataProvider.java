package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class AdminUserDataProvider {
	ExcelUtility excelutility=new ExcelUtility();
	@DataProvider(name="NewAdminUserDataProvider")
	public Object[][] NewAdminUserDataProvider()
	{
		return new Object [][] {{"gkadmin","1223"}};
	}
	@DataProvider(name="NewStaffUserDataProvider")
	public Object[][] StaffUserDataProvide()
	{
		return new Object [][] {{"gkstaff","1223"}};
	}
	@DataProvider(name="NewPartnerUserDataProvider")
	public Object[][] PartnerUserDataProvider()
	{
		return new Object [][] {{"gkpardastner","125423"}};
	}
	@DataProvider(name="NewDeliveryUserDataProvider")
	public Object[][] DeliveryUserDataProvider()
	{
		return new Object [][] {{"fffasdasdsdfscssdf","1sagsdsddasd223"}};
	}

	@DataProvider(name = "NewAdminCreationFromAdminPage")
	public Object[][] deliveryBoyProfileDetails() {
		excelutility.setExcelFile("AdminUsers", "UsersInfo");
		Object data[][] = excelutility.getMultiDimensionalData(4, 2);
		return data;
	}

}








