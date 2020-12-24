package com.sample.test.demo.tests;

import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

import pages.OrderPage;

public class DemoTest extends TestBase {

	@Test(description = "This Test case is POSITVE scenario - which takes all inputs and places an order then verifys success message")
	public void placeAnOrderTest() {
		OrderPage op = new OrderPage(driver);
		op.selectPizaType(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());
		op.selectPizaToppingsOption1(PizzaToppings.OLIVES.getDisplayName());
		op.selectPizaToppingsOption2(PizzaToppings.MUSHROOMS.getDisplayName());
		op.chosePizzaQuantity("2");
		op.enterAddress("Swetha", "9987664455", "testSwetha@gmail.com");
		op.choosePaymentMethod("cc");
		op.placeOrder();
		op.verifyThatOderPlaced(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());
	}

	@Test(description = "This Test case is Negative scenario - which takes all inputs except payment and places an order then verifys that oder should not be placed ")
	public void placeAnOrderWithOutPaymentTest() {
		OrderPage op = new OrderPage(driver);
		op.selectPizaType(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());
		op.selectPizaToppingsOption1(PizzaToppings.OLIVES.getDisplayName());
		op.selectPizaToppingsOption2(PizzaToppings.MUSHROOMS.getDisplayName());
		op.chosePizzaQuantity("2");
		op.enterAddress("Swetha", "9987664455", "testSwetha@gmail.com");
		op.placeOrder();
		op.verifyThatOderPlaced(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName());
	}

}
