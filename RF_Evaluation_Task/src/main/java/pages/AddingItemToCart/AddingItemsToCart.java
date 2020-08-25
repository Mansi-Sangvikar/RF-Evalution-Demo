package pages.AddingItemToCart;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AddingItemsToCart {
	
	WebDriver driver;
	
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mansi Sangvikar\\eclipse-Demo\\RF_Evaluation_Task\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	public void naviagteTocategories() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);	
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		WebElement categoryButton = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
		wait.until(ExpectedConditions.visibilityOf(categoryButton));
		categoryButton.isDisplayed();
		categoryButton.click();
		Thread.sleep(3000);
		
		WebElement WomenFashion = driver.findElement(By.xpath("(//a[@class='hmenu-item']/div)[10]"));
		WomenFashion.isDisplayed();
		Thread.sleep(3000);
		WomenFashion.click();
		
		WebElement EthnicWearCategory = driver.findElement(By.xpath("(//a[contains(text(),'Ethnic Wear')])"));
		EthnicWearCategory.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(EthnicWearCategory));
		EthnicWearCategory.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void sortByDropdown() throws AWTException {
		WebDriverWait wait = new WebDriverWait(driver,10);
		Robot robot = new Robot();
		robot.mouseWheel(40);
		
		WebElement sareeSubcategory = driver.findElement(By.xpath("(//a[@class='sl-sobe-carousel-sub-card-image'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(sareeSubcategory));
		sareeSubcategory.isDisplayed();
		sareeSubcategory.click();
		
		WebElement sortByDropdown = driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']"));
		wait.until(ExpectedConditions.visibilityOf(sortByDropdown));
		sortByDropdown.isDisplayed();
		sortByDropdown.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement dropDownSelection = driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
		Select sel = new Select(dropDownSelection);
		sel.selectByVisibleText("Price: High to Low");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement sortText = driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']/span[2]"));
		Assert.assertEquals(sortText.getText(), "Price: High to Low");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	int sum=0;
	
	public void addingItemToCart() throws InterruptedException {
		List<WebElement> ItemPriceList =  driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));
		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=0;i<2;i++) {

			ItemPriceList.get(i).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			int priceAddition = Integer.parseInt(ItemPriceList.get(i).getText().replaceAll(",", ""));
			//for(int j=0;j<2;j++) {
				
				 sum  = sum + priceAddition;
			//}
			
			System.out.println("Sum of Items added to cart: "+sum);

			
			Set<String> AllWindowHandles = driver.getWindowHandles(); 
			String Window1 = (String) AllWindowHandles.toArray()[0];  //parent
			String Window2 = (String) AllWindowHandles.toArray()[1];   //Child	
			driver.switchTo().window(Window1);
			driver.switchTo().window(Window2);
			
			/*WebElement ItemPrice = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']"));
			wait.until(ExpectedConditions.visibilityOf(ItemPrice));
			String price = ItemPrice.getText().replaceAll(",", "");*/
			
						
			WebElement addingItemToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
			wait.until(ExpectedConditions.visibilityOf(addingItemToCart));
			addingItemToCart.click(); 
			Thread.sleep(3000);
			driver.close();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().window(Window1);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}
	
	public void validatingCartItems() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.navigate().refresh();
		WebElement cart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
		wait.until(ExpectedConditions.visibilityOf(cart));
		cart.click();
		
		WebElement addedItemsCount = driver.findElement(By.xpath("//span[@id='sc-subtotal-label-buybox']"));
		wait.until(ExpectedConditions.visibilityOf(addedItemsCount));
		
		Assert.assertEquals(addedItemsCount.getText(), "Subtotal (2 items):");
		
		WebElement exp = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
		Assert.assertEquals(sum, exp.getText().replaceAll(",", "").replaceAll(".00", "").trim());
		
		if(addedItemsCount.getText().contains("Subtotal (2 items):")) {
			System.out.println("Items got added to the cart successfully");
		}else {
			System.out.println("Items are not added to the cart");
		}
		
	}

}
