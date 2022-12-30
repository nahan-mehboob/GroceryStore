package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass{

	LoginPage lp;
	ManageProduct mp;

	@Test(priority =1, description = "Validating whether veg is selected by default", enabled = false)
	public void validateVegIsSelectedByDefault() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		Boolean actualStatus = mp.verifyVegIsSelectedByDefault();
		Assert.assertTrue(actualStatus, Constant.RADIO_BTN_ERROR);
	}

	@Test(priority =2, description = "Validating whether yes button is selected by default for stock",enabled = false)
	public void validateStockIsYesByDefault() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		Boolean actualStatus = mp.verifyStockIsYesByDefault();
		Assert.assertTrue(actualStatus, Constant.RADIO_BTN_ERROR);
	}

	@Test(priority =3, description = "Validating the font color of save button", enabled = false)
	public void validateStylePropertyOfSaveButton() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		String actualColor = mp.verifyStylePropertyOfSaveButton();
		String expectedColor = Constant.EXPECTED_SAVEBTN_COLOR;
		Assert.assertEquals(actualColor, expectedColor, Constant.STYLE_ERROR);
	}

	@Test(priority =4, description = "Validating whether the uploaded file is previewed", retryAnalyzer = retryTest.RetryAnalyzer.class)
	public void validateUploadedFileIsPreviewDisplayed() throws AWTException, InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		Boolean actualStatus = mp.verifyUploadedFileIsPreviewDisplayed();
		Assert.assertTrue(actualStatus, Constant.IMAGE_DISPLAY_ERROR);
	}
}
