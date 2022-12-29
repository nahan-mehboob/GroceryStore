package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;

public class ManageExpenseTestCases extends BaseClass{

	LoginPage lp;
	ManageExpense me;

	@Test(priority = 1, description = "Validating whether product title already exists")
	public void validatingTheProductTitleAlreadyExists() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		me = new ManageExpense(driver);
		String actualAlert = me.verifyTheProductTitleAlreadyExists();
		SoftAssert softAssert = new SoftAssert();
		String expectedAlert = Constant.EXPECTED_NEW_TITLE_ALERT;
		softAssert.assertNotEquals(actualAlert, expectedAlert,Constant.ALERT_MSG_ERROR);
		softAssert.assertAll();
	}

	

}
