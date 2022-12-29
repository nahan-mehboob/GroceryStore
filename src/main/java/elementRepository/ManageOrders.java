package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class ManageOrders {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Manage Orders')]")
	WebElement manageOrders;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[2]")
	WebElement firstDeleteBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn_ListOrders;

	@FindBy(xpath = "//input[@id='od']")
	WebElement orderIdInputBox;

	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[7]/button[1]")
	WebElement searchBtn_SearchListOrders;

	@FindBy(xpath = "//table[contains(@class,'table-bordered table')]//td[1]")
	WebElement tableResult;

	@FindBy(xpath = "//select[@id='pt']")
	WebElement paymentMode_Dropdown;

	@FindBy(xpath = "//select[@id='st']")
	WebElement statusDropdown;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement orderId_Result;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]")
	WebElement cod_Result;

	public String verifyDeletionOfProductOrder() throws InterruptedException {
		gu.clickOnElement(manageOrders);
		gu.clickOnElement(firstDeleteBtn);
		gu.acceptingAlerts(driver);
		gu.clickOnElement(searchBtn_ListOrders);
		gu.sendText(orderIdInputBox, "674");
		gu.mediumDelay(4000);
		gu.cilckOnElementByJavaScript(driver, searchBtn_SearchListOrders);
		gu.scrollToTheElement(tableResult, driver);
		return gu.getElementText(tableResult);
	}

	public void basicClick() {
		gu.clickOnElement(manageOrders);
		gu.clickOnElement(searchBtn_ListOrders);
	}

	public Boolean verifyPaymentModeIsBank() {
		basicClick();
		gu.clickOnElement(paymentMode_Dropdown);
		gu.selectFuncbyindex(paymentMode_Dropdown, 2);
		gu.cilckOnElementByJavaScript(driver, searchBtn_SearchListOrders);
		List<WebElement> paymentMode_List = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]"));
		int size = paymentMode_List.size();
		Boolean result = true;
		for (int i=0; i<size; i++) {
			String paymentModeText = paymentMode_List.get(i).getText();

			if(!paymentModeText.equals("Bank")) {
				return false;
			}
		}
		return result;
	}

	public int verifySizeOfStatusDropdown() {
		basicClick();
		gu.clickOnElement(statusDropdown);
		Select select = new Select(statusDropdown);
		List<WebElement>l = select.getOptions();
		return l.size();
	}

	public String verifyOrderId() {
		basicClick();
		gu.sendText(orderIdInputBox, "361");
		gu.cilckOnElementByJavaScript(driver, searchBtn_SearchListOrders);
		return gu.getElementText(orderId_Result);
	}

	public String verifyPaymentMethod() throws InterruptedException {
		basicClick();
		gu.clearInputField(orderIdInputBox);
		gu.sendText(orderIdInputBox, "361");
		gu.cilckOnElementByJavaScript(driver, searchBtn_SearchListOrders);
		gu.mediumDelay(2000);
		gu.moveToTheElement(driver, cod_Result);
		return gu.getElementText(cod_Result);
	}




}

