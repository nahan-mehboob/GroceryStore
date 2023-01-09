package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocation;

public class ManageLocationTestCases extends BaseClass{

	LoginPage lp;
	ManageLocation ml;

	@Test(priority = 1, description = "Validate the count for the status active",groups = {"Sanity test"})
	public void validateCountOfActiveStatus() {
		lp = new LoginPage(driver);
		lp.presteps();
		ml = new ManageLocation(driver);
		Boolean actualCount = ml.verifyCountOfActiveStatus();
		Assert.assertTrue(actualCount, Constant.WRONG_TEXT_ERROR);
	}

	@Test(priority = 2, description = "Validate the value selected from the  state dropdown")
	public void validateStateNameFromDropdown() {
		lp = new LoginPage(driver);
		lp.presteps();
		ml = new ManageLocation(driver);
		String actualText = ml.verifyStateNameFromDropdown();
		String expectedText = Constant.EXPECTED_STATE_NAME;
		Assert.assertEquals(actualText,expectedText,Constant.WRONG_TEXT_ERROR);
	}


}
