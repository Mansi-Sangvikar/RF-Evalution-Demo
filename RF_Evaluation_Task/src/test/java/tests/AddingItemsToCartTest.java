package tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.AddingItemToCart.AddingItemsToCart;

public class AddingItemsToCartTest {
  @Test
  public void f() throws AWTException, InterruptedException {
	  
	  AddingItemsToCart obj = new AddingItemsToCart();
	  	obj.beforeMethod();
		obj.naviagteTocategories();
		obj.sortByDropdown();
		obj.addingItemToCart();
		obj.validatingCartItems();
  }
}
