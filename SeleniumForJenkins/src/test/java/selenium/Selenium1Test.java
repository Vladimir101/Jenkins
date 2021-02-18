package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Selenium1Test
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
	}

	@Test
	void openSchoolWebsite()
	{
		System.out.println("Hi, Selenium!");
		driver.get("https://www.selenium.dev/");
		String title = driver.getTitle();
		assertEquals("SeleniumHQ Browser Automation", title);
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
