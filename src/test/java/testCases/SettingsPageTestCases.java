package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.SettingsPage;

public class SettingsPageTestCases extends BaseClass{

	LoginPage lp;
	SettingsPage sp;

	@Test(priority = 1, description = "Validating whether logout button logs out of the page")
	public void validateLogout(){
		lp = new LoginPage(driver);
		lp.presteps();
		sp = new SettingsPage(driver);
		String actualUrl = sp.verifyLogout();
		String expectedUrl = Constant.LOGIN_PAGE_URL;
		Assert.assertEquals(actualUrl, expectedUrl, Constant.URL_ERROR);
	}
}
