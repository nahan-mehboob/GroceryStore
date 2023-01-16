package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileHandling;
import utilities.GeneralUtilities;

public class ManageProduct {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	FileHandling fh = new FileHandling();

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//p[text()='Manage Product'])[1]")
	WebElement manageProduct;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//input[@value='Veg']")
	WebElement veg_RadioBtn;

	@FindBy(xpath = "(//input[@name='stock'])[1]")
	WebElement stockYes_RadioBtn;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveBtn;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//div[@id='imagePreview']")
	WebElement imagePreview;

	public void basicClick() {
		gu.clickOnElement(manageProduct);
		gu.clickOnElement(newBtn);
	}

	public Boolean verifyVegIsSelectedByDefault() {
		basicClick();
		return gu.elementIsSelected(veg_RadioBtn);
	}

	public Boolean verifyStockIsYesByDefault() {
		basicClick();
		gu.scrollToTheElement(stockYes_RadioBtn, driver);
		return gu.elementIsSelected(stockYes_RadioBtn);
	}

	public String verifyStylePropertyOfSaveButton() {
		basicClick();
		gu.scrollToTheElement(saveBtn, driver);
		String color = gu.stylePropertyValidation(saveBtn, "color");
		return color;
	}

	public Boolean verifyUploadedFileIsPreviewDisplayed() throws AWTException, InterruptedException {
		basicClick();
		gu.mediumDelay(4000);
		gu.scrollToTheElement(chooseFile, driver);
		gu.mediumDelay(4000);
		fh.fileUpload("C:\\Users\\admin\\eclipse-workspace\\GroceryStore\\src\\main\\resources\\Images\\Rice.png", chooseFile,driver);
		gu.mediumDelay(3000);
		Boolean status = gu.elementIsDisplayed(imagePreview);
		return status;
	}
}
