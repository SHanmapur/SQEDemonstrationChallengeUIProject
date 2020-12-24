package com.sample.test.demo;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private Configuration config;
	protected WebDriver driver;
	protected String url;

	@BeforeClass(alwaysRun = true)
	public void init() throws Throwable {
		config = new Configuration();
		url = config.getUrl();
		initializelDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		navigateToSite();
	}

	private void navigateToSite() {
		driver.get(url);
	}

	 @AfterClass(alwaysRun = true)
	public void tearDown() {
		try {
			driver.quit();

		} catch (Exception e) {
		}
	}

	private void initializelDriver__() {
		WebDriverManager.firefoxdriver().arch64().setup();
		driver = new FirefoxDriver();
	}

	private void initializelDriver() {
		if (config.getBrowser().equalsIgnoreCase("chrome")) {
			if (config.getPlatform().equalsIgnoreCase("mac")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
			} else {
				System.setProperty("webdriver.chrome.driver",
						"src/test/resources/chromedriver/windows/chromedriver.exe");
			}
			driver = new ChromeDriver();
		} else {
			fail("Unsupported bfrowser " + config.getBrowser());
		}

	}

}
