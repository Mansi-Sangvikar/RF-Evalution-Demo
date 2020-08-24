package pages.AddingItemToCart;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AddingItemToCart.Locators;

public class AddingItemsToCart extends Locators{

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,10);
	
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mansi Sangvikar\\eclipse-workspace\\demo\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	public void naviagteTocategories() {
		
		CategoriesButton.click();
		wait.until(ExpectedConditions.visibilityOf(WomenFashion));
		WomenFashion.click();
		wait.until(ExpectedConditions.visibilityOf(EthnicWearCategory));
		EthnicWearCategory.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void sortByDropdown() throws AWTException {
		
		Robot robot = new Robot();
		robot.mouseWheel(40);
		wait.until(ExpectedConditions.visibilityOf(sareeSubcategory));
		sareeSubcategory.click();
		wait.until(ExpectedConditions.visibilityOf(sortByDropdown));
		sortByDropdown.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Select sel = new Select(dropDownSelection);
		sel.selectByVisibleText("Price: High to Low");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void addingItemToCart() {
		
		for(int i=0;i<2;i++) {

			ItemPriceList.get(i).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Set<String> AllWindowHandles = driver.getWindowHandles(); 
			String Window1 = (String) AllWindowHandles.toArray()[0];  //parent
			String Window2 = (String) AllWindowHandles.toArray()[1];   //Child	
			//String Window3 = (String) AllWindowHandles.toArray()[2];
			driver.switchTo().window(Window1);
			driver.switchTo().window(Window2);
			
			wait.until(ExpectedConditions.visibilityOf(addingItemToCart));
			addingItemToCart.click(); 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.close();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().window(Window1);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

	}

}
