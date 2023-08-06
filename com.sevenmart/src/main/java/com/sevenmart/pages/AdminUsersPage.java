package com.sevenmart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;
import com.sevenmart.utilities.WaitUtility;
import java.util.ArrayList;

public class AdminUsersPage {
	PageUility pageutility;
	WaitUtility waitutility;
	LoginPage loginpage;
	GeneralUtility generalutility;
	WebDriver driver;
	int pos = 0;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class=' nav-link']")
	private WebElement adminUsersButton;
	@CacheLookup
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@CacheLookup
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement createNewButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control' and @id='user_type']")
	private WebElement selectUserType;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	private WebElement adminUsersConfirmationLabel;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible' and contains(.,'User Created Successfully')]")
	WebElement success;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement newlyCreatedUser;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> userNames;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteSuccessfullAlert;

	public void hitOnAdminUsersPage() {
		adminUsersButton.click();
	}

	public String adminUsersPageVerification() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(adminUsersConfirmationLabel);
	}

	public void clickOnCreateButton() {
		createNewButton.click();
	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPassWord(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void selectUserType(String userType) {
		pageutility = new PageUility(driver);
		if (userType.equals("Staff")) {
			pageutility.selectByVisibleText(selectUserType, "Staff");
		} else if (userType.equals("Admin")) {
			pageutility.selectByVisibleText(selectUserType, "Admin");
		} else if (userType.equals("Partner")) {
			pageutility.selectByVisibleText(selectUserType, "Partner");
		} else if (userType.equals("Delivery Boy")) {
			pageutility.selectByVisibleText(selectUserType, "Delivery Boy");
		}

	}

	public String getSuccesMessage() {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUility(driver);
		return generalutility.getTextOfElement(success);
	}

	public String userNameCreated() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(newlyCreatedUser);
	}

	public void deleteUser(String personName) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		PageUility pageutility = new PageUility(driver);

		List<String> names = new ArrayList<String>();

		names = generalUtility.getTextOfElements(userNames);
		for (pos = 0; pos < names.size(); pos++) {
			if (personName.equals(names.get(pos))) {
				pos++;
				break;
			}
			System.out.println(pos);
		}

		WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[" + pos + "]/td[5]/a[3]"));
		pageutility.scrollAndClick(deleteButton);

	}
	public boolean alertDeleteMessage() {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(deleteSuccessfullAlert);
	}

}
