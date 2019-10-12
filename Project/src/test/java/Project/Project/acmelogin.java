package Project.Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class acmelogin {
	public static ChromeDriver driver;
	@Test
	public static void acme()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prabhakara\\Documents\\Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement username = driver.findElementById("email");
		username.sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementByXPath("//*[@id=\'buttonLogin\']").click();
		WebElement vendormenu = driver.findElementByXPath("//*[@id='dashmenu']/div[5]/button");
		
Actions actions = new Actions(driver);
actions.moveToElement(vendormenu).perform();
driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementByXPath("//*[@id=\'vendorName\']").sendKeys("Blue Lagoon");
		driver.findElementByXPath("//*[@id='buttonSearch']").click();
		String countryname = driver.findElementByXPath("//*[contains(text(),'Blue')]/following-sibling::td[4]").getText();
		System.out.println(countryname);
driver.findElementByLinkText("Log Out").click();
		
}
}