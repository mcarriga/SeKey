package framework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;

public class Test {
	
	private  WebDriver driver;
	public ILogging logger;
	public IWait waits = new Waits(driver, logger);
	public IGet gets = new Gets(driver, logger);
	public IAssert asserts = new Asserts(driver, logger, waits);;
	public IAction actions = new Actions(driver, logger, waits);
	public Framework framework = new Framework(driver, new KeywordLogger());
	
	@BeforeTest
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTest() {
		framework
		.withLogEvent(framework.logger.cleanupSection("Quiting Driver"));
		driver.quit();
	}
	
	@org.testng.annotations.Test
	public void SimpleTest() throws Exception {
		b();
	}
	
	@org.testng.annotations.Test
	public void b() throws InterruptedException {
		By by = By.xpath("//form[@action]");
		framework
		.withAction(actions.navigateTo("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_radio"))
		.withAction(actions.switchToFrame("iframeResult"))
		.withAction(actions.selectRadioOptionByValue(by, "male"))
		.withAssert(asserts.assertElementSelected(By.xpath("//input[@value='male']")));
		Thread.sleep(5000);
	}
	
	@org.testng.annotations.Test
	public void y() {
		framework
		.withLogEvent(logger.arrangeSection("Navigating to Google"))
		.withAction(actions.navigateTo("https://www.google.com/"))
		.withLogEvent(logger.actSection("Searching for Selenium"))
		.withAction(actions.click(By.xpath("//*[@name='q']")))
		.withAction(actions.sendKeys(By.xpath("//*[@name='q']"), "selenium"))
		.withWait(waits.untilElementExists(By.xpath("//li[@role='presentation']"), 5));
		
		String inputText = framework.withGet(gets.GetElementText(By.xpath("//li[@role='presentation']")));
		framework
		.withLogEvent(logger.assertSection("Asserting results in popup search"))
		.withAssert(asserts.assertText(By.xpath("//li[@role='presentation']"), "selenium", 15));
		
		System.out.println("inputText: "+inputText);
	}
}
