package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Facebook group - Russian QA in Silicon Valley")
@Feature("Front page")
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
	}

	@Test
	@Story("User opens group page")
	@Description("Verify the group's title")
	void openFacebookGroupWebsite()
	{
		System.out.println("Hi, Russian QA in Silicon Valley!");
		driver.get("https://www.facebook.com/groups/365258477409510");
		String title = driver.getTitle();
		assertTrue(title.contains("Russian Speaking QA Engineers in Silicon Valley"));
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
