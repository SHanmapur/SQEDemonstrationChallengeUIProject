package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

public class OrderPage {

	WebDriver driver;

	@FindBy(id = "pizza1Pizza")
	public WebElement ddPizaType;

	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
	public WebElement ddPizzaToppingsOption1;

	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
	public WebElement ddPizzaToppingsOption2;

	@FindBy(id = "pizza1Qty")
	public WebElement tbPizzaQty;

	@FindBy(id = "pizza1Cost")
	public WebElement tbPizzaCost;

	@FindBy(id = "ccpayment")
	public WebElement radioCreditCard;

	@FindBy(id = "cashpayment")
	public WebElement radioCash;

	@FindBy(id = "email")
	public WebElement tbEmail;

	@FindBy(id = "name")
	public WebElement tbName;

	@FindBy(id = "phone")
	public WebElement tbPhone;

	@FindBy(id = "placeOrder")
	public WebElement buttonPplaceOrder;

	@FindBy(id = "reset")
	public WebElement buttonRreset;

	@FindBy(id = "dialog")
	public WebElement dialogBox;

	@FindBy(xpath = "//div[@id='dialog']/p")
	public WebElement dialogBoxText;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectPizaType(String type) {
		new Select(ddPizaType).selectByValue(type);
	}

	public void selectPizaToppingsOption1(String type) {
		new Select(ddPizzaToppingsOption1).selectByValue(type);
	}

	public void selectPizaToppingsOption2(String type) {
		new Select(ddPizzaToppingsOption2).selectByValue(type);
	}

	public void chosePizzaQuantity(String qty) {
		// TODO Auto-generated method stub
		tbPizzaQty.sendKeys(qty);
		tbPizzaQty.sendKeys(Keys.TAB);
	}

	public void enterAddress(String name, String ph, String email) {
		tbName.sendKeys(name);
		tbEmail.sendKeys(email);
		tbPhone.sendKeys(ph);

	}

	public void choosePaymentMethod(String type) {
		// TODO Auto-generated method stub
		if (type.contains("cc"))
			radioCreditCard.click();
		else
			radioCash.click();

	}

	public void verifyThatOderPlaced(String pizatype) {
		// TODO Auto-generated method stub
		boolean isDialogDisplayed = dialogBox.isDisplayed();
		String text = dialogBoxText.getText();
		String actualText = "Thank you for your order!";

		Assert.assertTrue(isDialogDisplayed, "Dialog Not Dispaled");
		Assert.assertTrue(text.contains(actualText), "Failed to place an order ");
		Assert.assertTrue(text.contains(pizatype), "Failed to place an order with correct piza type");
	}

	public void verifyThatOderisNotPlaced(String pizatype) {
		// TODO Auto-generated method stub
		boolean isDialogDisplayed = dialogBox.isDisplayed();
		String text = dialogBoxText.getText();
		String actualText = "Thank you for your order!";

		Assert.assertTrue(isDialogDisplayed, "Dialog Not Dispaled");
		Assert.assertTrue(!text.contains(actualText), "Successfully  placed an order ");

	}

	public void placeOrder() {
		buttonPplaceOrder.click();
		// TODO Auto-generated method stubF

	}

}
