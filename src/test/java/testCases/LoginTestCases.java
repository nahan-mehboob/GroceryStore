package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;

public class LoginTestCases extends BaseClass{

	LoginPage lp;
	List<String> loginList;

	@Test(priority=1, description="Validating the profile name of logged user")
	public void loggedInProfileNameValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		String expectedProfileName = Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName = lp.profileNameVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}

	@Test(priority = 2, description="Login using data provider", dataProvider = "data")
	public void loggedInProfileNameValidationUsingDataProvider(String username, String password) {
		lp = new LoginPage(driver);
		//lp.presteps();
		lp.getUserName(username);
		lp.getPassword(password);
		lp.clickSignin();
		String expectedProfileName = Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName = lp.profileNameVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}

	@Test(priority=3, description="Validating color property of profile name")
	public void profileNameStyleValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		String actualProfileColor = lp.stylePropertyVerification();
		String expectedProfileClr = Constant.EXPECTED_PROFILE_CLR;
		Assert.assertEquals(actualProfileColor, expectedProfileClr,Constant.STYLE_ERROR);
	}

	@Test(priority = 4, description = "Validating whether remember checkbox is unchecked")
	public void validationOfRememberMeCheckbox() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassword("admin");
		Boolean actualStatus = lp.rememberMeCheckboxVerficiation();
		Boolean expectedStatus = false;
		Assert.assertEquals(actualStatus, expectedStatus,Constant.CHECKBOX_ERROR);
	}

	@Test(priority=5, description="Login using excel read")
	public void excelRead() {
		lp = new LoginPage(driver);
		loginList = lp.getLoginDetails();
		lp.excelSteps(loginList.get(0), loginList.get(1));
		String expectedProfileName = Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName = lp.profileNameVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}

	@DataProvider(name = "data")
	public Object [][] getuserData(){
		return new Object[][] {
			{"admin", "admin"},
			{"admin5", "admin"},
			{"admin", "admin4"},
			{"admin1", "admin2"},
		};
	}

}




