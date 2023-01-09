package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotifications;

public class PushNotificationsTestCases extends BaseClass{

	LoginPage lp;
	PushNotifications pn;

	@Test(priority=1, description="Validating the title of push notifications page", groups = {"Smoke test"})
	public void validateTitleOfThePage() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualTitle  = pn.verifyTitleOfPage();
		String expectedTitle = Constant.EXPECTED_TITLE_PUSH_NOTIFICATIONS;
		Assert.assertEquals(actualTitle, expectedTitle,Constant.TITLE_ERROR);
	}

	@Test(priority=3, description="Validating the color of send button")
	public void validateColorOfSendButton() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualColor  = pn.verifyStylePropertyOfSendButton();
		String expectedColor = Constant.EXPECTED_SENDBTN_CLR;
		Assert.assertEquals(actualColor, expectedColor,Constant.STYLE_ERROR);
	}

	@Test(priority=2, description="Validating the color of mandatory field")
	public void validateColorOfMandatoryField() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualFieldColor  = pn.verifyStylePropertyOfMandatoryField();
		String expectedFieldColor = Constant.EXPECTED_MANDATORY_FIELD_CLR;
		Assert.assertEquals(actualFieldColor, expectedFieldColor,Constant.STYLE_ERROR);
	}

	@Test(priority=4, description="Validating the text of alert message")
	public void validateAlertMessage() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualMsg  = pn.verifyAlertMessage();
		String expectedMsg = Constant.EXPECTED_ALERT_MSG;
		Assert.assertEquals(actualMsg, expectedMsg,Constant.ALERT_MSG_ERROR);
	}

	@Test(priority=5, description="Validating the background color of alert message")
	public void validateAlertMsgBgColor() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualBgColor  = pn.verifyBgColorOfAlertMsg();
		String expectedBgColor = Constant.EXPECTED_ALERT_BGCLR;
		Assert.assertEquals(actualBgColor, expectedBgColor,Constant.STYLE_ERROR);
	}


}
