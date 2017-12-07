package com.spectrum.automation.keywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class Test {
	
	public WebDriver driver;
	public Framework framework;
	
	@BeforeTest
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mcarr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
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
		framework.y();
	}
}
