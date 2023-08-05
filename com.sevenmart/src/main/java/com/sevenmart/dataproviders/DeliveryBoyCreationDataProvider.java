package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class DeliveryBoyCreationDataProvider {
	ExcelUtility excelutility=new ExcelUtility();
	@DataProvider(name = "deliveryBoyProfileCreation")
	public Object[][] deliveryBoyProfileCreations() {
		excelutility.setExcelFile("DeliveryBoyData", "CreatingNewDelivery");
		Object data[][] = excelutility.getMultiDimensionalData(2, 6);
		return data;
	}
	@DataProvider(name="ExistingDeliveryBoyDataProvider")
	public Object[][] ExistingDeliveryBoyDataProvider()
	{
		return new Object [][] {{"gopidas22","gdas22dopi@gmail.com","821121","gokulas22daam ndd","d22akfg","125225535"}};
	}
	@DataProvider(name="ExistingDeliveryBoyNameAndEmail")
	public Object[][] ExistingDeliveryBoyNameAndEmail()
	{
		return new Object [][] {{"gopidas22","gdas22dopi@gmail.com"}};
	}
	@DataProvider(name="NonExistingDeliveryBoyNameAndEmail")
	public Object[][] NonExistingDeliveryBoyNameAndEmail()
	{
		return new Object [][] {{"hello","hello@gmail.com"}};
	}
	@DataProvider(name = "deliveryBoyProfileDetailsExcel")
	public Object[][] deliveryBoyProfileDetails() {
		excelutility.setExcelFile("DeliveryBoyData", "AlreadyExistingUserDetails");
		Object data[][] = excelutility.getMultiDimensionalData(1, 6);
		return data;
	}

}
