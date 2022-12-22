package elementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpense {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/p[1]")
	WebElement manageExpense;

	@FindBy(xpath = "//p[contains(text(),'Expense Category')]")
	WebElement expenseCategory;

	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement firstProductTitle;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]")
	WebElement titleEditBtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement inputTitleBox;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateBtn;

	public String verifyingTheProductTitleIsUpdated() throws InterruptedException {
		gu.clickOnElement(manageExpense);
		//gu.selectFromDropDownByAction(driver, manageExpense, expenseCategory);
		gu.mediumDelay(4000);
		gu.keyDownAction(driver, Keys.TAB);
		gu.keyUpAction(driver, Keys.TAB);
		gu.keyDownAction(driver, Keys.ENTER);
		gu.keyUpAction(driver, Keys.ENTER);
		gu.clickOnElement(titleEditBtn);
		gu.clearInputField(inputTitleBox);
		gu.sendText(inputTitleBox, "SpicesOrg9937");
		gu.clickOnElement(updateBtn);
		return gu.getElementText(firstProductTitle);
	}



}
