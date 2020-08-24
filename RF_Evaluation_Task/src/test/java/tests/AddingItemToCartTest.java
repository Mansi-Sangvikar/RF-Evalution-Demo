package tests;

import java.awt.AWTException;

import pages.AddingItemToCart.AddingItemsToCart;

public class AddingItemToCartTest {

	public static void main(String[] args) throws AWTException {

		AddingItemsToCart obj = new AddingItemsToCart();

		obj.naviagteTocategories();
		obj.sortByDropdown();
		obj.addingItemToCart();
	}

}
