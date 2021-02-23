package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

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
		String name = System.getProperty("OS");
		System.out.println("OS name is " + name);
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void openFacebookGroupWebsite()
	{
		System.out.println("Hi, Russian QA in Silicon Valley!");
		driver.get("https://www.facebook.com/groups/365258477409510");
		String title = driver.getTitle();
		assertTrue(title.contains("Russian QA in Silicon Valley"));
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
