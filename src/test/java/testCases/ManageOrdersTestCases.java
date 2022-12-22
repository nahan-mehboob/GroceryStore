package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrders;

public class ManageOrdersTestCases extends BaseClass {

	LoginPage lp;
	ManageOrders mo; 

	@Test(priority = 4, description = "Validating whether the delete action is successfully performed")
	public void validateDeletionOfProductOrder() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		String actualStatus = mo.verifyDeletionOfProductOrder();
		String expectedStatus = Constant.EXPECTED_TABLE_RESULT;
		Assert.assertEquals(actualStatus, expectedStatus,Constant.DELETION_ERROR);
	}

	@Test(priority = 2, description = "Validating whether the payment mode is bank itself while selecting bank from dropdown")
	public void validatePaymentModeIsBank() {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		Boolean actualText = mo.verifyPaymentModeIsBank();
		Assert.assertTrue(actualText,Constant.PAYMENT_MODE_ERROR);
	}

	@Test(priority = 1, description = "Validating size of the status dropdown")
	public void validateSizeOfStatusDropdown() {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		int actualStatus = mo.verifySizeOfStatusDropdown();
		Assert.assertTrue(actualStatus==Constant.STATUS_DROPDOWN_SIZE,Constant.LIST_SIZE_ERROR);
	}

	@Test(priority = 3, description = "Validating the text of given order id and its payment mode")
	public void validateOrderIdAndPaymentMode() {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		String actualOrderId = mo.verifyOrderId();
		String expectedOrderId = Constant.EXPECTED_ORDER_ID;
		String actualMethod = mo.verifyPaymentMethod();
		String expectedMethod = Constant.EXPECTED_PAYMENT_MODE;
		SoftAssert softAssert  = new SoftAssert();
		softAssert.assertEquals(actualOrderId, expectedOrderId,Constant.WRONG_TEXT_ERROR);
		softAssert.assertEquals(actualMethod, expectedMethod, Constant.WRONG_TEXT_ERROR);
		softAssert.assertAll();
	}


}
