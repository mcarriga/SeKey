package framework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
public class Test {
	
	public WebDriver driver;
	public Framework framework;
	
	@BeforeTest
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/Downloads/chromedriver");
		ChromeOptions ops = new ChromeOptions();
		driver.
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		framework = new Framework(driver, new KeywordLogger());
	}
	
	@AfterTest
	public void afterTest() {
		framework
		.withLogEvent(framework.logger.cleanupSection("Quiting Driver"));
		driver.quit();
	}
	
	@org.testng.annotations.Test
	public void SimpleTest() throws Exception {
		framework.x();
	}
}
