package pages.AddingItemToCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Locators {
	
	WebDriver driver = new ChromeDriver();
	
	List<WebElement> ItemPriceList =  driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));
	WebElement CategoriesButton = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
	WebElement WomenFashion = driver.findElement(By.xpath("(//a[@class='hmenu-item']/div)[10]"));
	WebElement EthnicWearCategory = driver.findElement(By.xpath("(//a[contains(text(),'Ethnic Wear')])"));
	WebElement sareeSubcategory = driver.findElement(By.xpath("(//a[@class='sl-sobe-carousel-sub-card-image'])[1]"));
	WebElement sortByDropdown = driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']"));
	WebElement dropDownSelection = driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
	WebElement addingItemToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
}
