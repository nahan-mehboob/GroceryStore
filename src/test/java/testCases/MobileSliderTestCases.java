package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobileSlider;

public class MobileSliderTestCases extends BaseClass {

	LoginPage lp;
	MobileSlider ms;

	@Test(priority=1, description="Validating the title of mobile slider page")
	public void validateTitleOfThePage() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobileSlider(driver);
		String actualTitle = ms.verifyTitleOfPage();
		String expectedTitle = Constant.EXPECTED_TITLE_MOBILE_SLIDER;
		Assert.assertEquals(actualTitle, expectedTitle, Constant.TITLE_ERROR);
	}

	@Test(priority=2, description="Validating whether the first image is displayed")
	public void validateImageDisplay() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobileSlider(driver);
		Boolean actualResult = ms.verifyImageIsDisplayed();
		Assert.assertTrue(actualResult, Constant.IMAGE_DISPLAY_ERROR);
	}

	@Test(priority=3, description="Validating the status of first image")
	public void validateStatusOfFirstImage() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobileSlider(driver);
		String actualImageStatus = ms.verifyStatusOfFirstImage();
		String expectedImageStatus = Constant.EXPECTED_IMAGE_STATUS;
		Assert.assertEquals(actualImageStatus, expectedImageStatus, Constant.IMAGE_STATUS_ERROR);
	}



}
