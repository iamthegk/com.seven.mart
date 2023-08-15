package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class AdminUserDataProvider {
	ExcelUtility excelutility=new ExcelUtility();
	
	@DataProvider(name = "NewAdminCreationFromAdminPageUsingExcel")
	public Object[][] NewAdminCreationFromAdminPageUsingExcel() {
		excelutility.setExcelFile("AdminUsers", "AdminCreation");
		Object data[][] = excelutility.getMultiDimensionalData(4, 2);
		return data;
	}
	@DataProvider(name = "NewStaffCreationFromAdminPageUsingExcel")
	public Object[][] NewStaffCreationFromAdminPageUsingExcel() {
		excelutility.setExcelFile("AdminUsers", "StaffCreation");
		Object data[][] = excelutility.getMultiDimensionalData(4, 2);
		return data;
	}
	@DataProvider(name = "NewPartnerCreationFromAdminPageUsingExcel")
	public Object[][] NewPartnerCreationFromAdminPageUsingExcel() {
		excelutility.setExcelFile("AdminUsers", "PartnerCreation");
		Object data[][] = excelutility.getMultiDimensionalData(4, 2);
		return data;
	}
	@DataProvider(name = "NewDeliveryBoyCreationFromAdminPageUsingExcel")
	public Object[][] NewDeliveryBoyCreationFromAdminPageUsingExcel() {
		excelutility.setExcelFile("AdminUsers", "DeliveryBoyCreation");
		Object data[][] = excelutility.getMultiDimensionalData(4, 2);
		return data;
	}
	
	
	

}








