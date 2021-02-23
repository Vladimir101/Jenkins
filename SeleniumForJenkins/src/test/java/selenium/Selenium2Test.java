package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Selenium2Test
{
	private WebDriver driver;

	@BeforeAll
	static void oneTimeSetUp()
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	void openFacebookGroupWebsite()
	{
		System.out.println("Hi, Russian QA in Silicon Valley!");
		driver.get("https://www.facebook.com/groups/365258477409510");
		String title = driver.getTitle();
		assertEquals("Russian QA in Silicon Valley", title);
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
