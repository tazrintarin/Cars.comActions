package SearchCars;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPage {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();      
	//	handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.cars.com");
		driver.manage().window().maximize();

		driver.findElement(By.name("zip")).sendKeys("60008");

		By usedcar = By.name("stockType");
		By AllMakes = By.name("makeId");
		By Model = By.name("modelId");
		By Price = By.name("priceMax");
		By Miles = By.name("radius");
		By Search = By.xpath("//input[@class='NZE2g']");

		doSelectDropDownVisibleText(usedcar, "Used Cars");
		doSelectDropDownVisibleText(AllMakes, "Honda");
		doSelectDropDownVisibleText(Model, "Pilot");
		doSelectDropDownVisibleText(Price, "$50,000");
		doSelectDropDownVisibleText(Miles, "100 Miles from");

		driver.findElement(By.name("zip")).sendKeys("60008");
		driver.findElement(By.xpath("//input[@class='NZE2g']")).click();;
		//doActionsClick(Search);

	}

	public static void doSelectDropDownVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsClick(By locator) {

		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
		// action.moveToElement(getElement(locator)).click().build().perform();
	}

}
