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

	@Test(priority = 1, description = "validating whether product title is updated")
	public void validatingTheProductTitleIsUpdated() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		me = new ManageExpense(driver);
		String actualPrdName = me.verifyingTheProductTitleIsUpdated();
		SoftAssert softAssert = new SoftAssert();
		String expectedPrdName = Constant.EXPECTED_PRD_TITLE_NAME;
		softAssert.assertEquals(actualPrdName, expectedPrdName,Constant.TITLE_UPDATE_STATUS);
		softAssert.assertAll();
	}
}
