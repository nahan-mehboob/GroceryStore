package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;

public class ManageDeliveryBoyTestCases extends BaseClass {

	LoginPage lp;
	ManageDeliveryBoy mdb;

	@Test(priority = 1, description = "Tool kit validation", groups = {"SmokeTest"})
	public void validateToolKit() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mdb = new ManageDeliveryBoy(driver);
		String actualToolKit = mdb.verifyToolKit();
		String expectedToolKit = Constant.EXPECTED_SHOW_DETAILS;
		Assert.assertEquals(actualToolKit, expectedToolKit, Constant.TOOL_KIT_ERROR);
	}

	@Test(priority = 3, description = "Validating the color property of search button")
	public void validateSearchButtonColor() {
		lp = new LoginPage(driver);
		lp.presteps();
		mdb = new ManageDeliveryBoy(driver);
		String actualColor = mdb.stylePropertyVerification();
		String expectedColor = Constant.EXPECTED_SEARCHBTN_COLOR;
		Assert.assertEquals(actualColor, expectedColor, Constant.STYLE_ERROR);
	}

	@Test(priority=2, description="Validating whether the search button is enabled")
	public void validateSearchButtonClickability() {
		lp = new LoginPage(driver);
		lp.presteps();
		mdb = new ManageDeliveryBoy(driver);
		Boolean actualResult = mdb.verifySearchButtonClickability();
		Assert.assertTrue(actualResult, Constant.CLICK_ERROR);
	}

}
