package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomeTestCases extends BaseClass{

	LoginPage lp;
	HomePage hp;

	@Test(priority=1, description="Validating the background color of home page")
	public void homeBgColorValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		hp = new HomePage(driver);
		String actualBgColor = hp.stylePropertyVerificationOfHome();
		String expectedBgColor = Constant.EXPECTED_BG_COLOR;
		Assert.assertEquals(actualBgColor, expectedBgColor, Constant.STYLE_ERROR);
	}

	@Test(priority=2, description="Validating the text of manage expense")
	public void manageExpenseTextValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		hp = new HomePage(driver);
		String expectedText_ME = hp.manageExpenseTextVerification();
		String actualText_ME = Constant.MANAGE_EXPENSE_TEXT;
		Assert.assertEquals(actualText_ME, expectedText_ME, Constant.WRONG_TEXT_ERROR);
	}

	@Test(priority=3, description="Validating the text of manage users", groups = {"Smoke test"})
	public void manageUsersTextValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		hp = new HomePage(driver);
		String expectedText_MU = hp.manageUsersTextVerification();
		String actualText_MU = Constant.MANAGE_USERS_TEXT;
		Assert.assertEquals(actualText_MU, expectedText_MU, Constant.WRONG_TEXT_ERROR);
	}


}
