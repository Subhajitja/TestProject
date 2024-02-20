package com.facebook.genericPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MasterPage {

	public static WebDriver driver;
	public Properties prop;
	public Properties or;
	public Properties td;

	// Constructor
	public MasterPage() throws Exception {

		// Configuration Properties File Implementation

		FileInputStream ip = new FileInputStream(
				".\\src/test/java\\com\\facebook\\repository\\configuration.properties");
		prop = new Properties();
		prop.load(ip);

		// Locators Properties File Implementation

		FileInputStream fs = new FileInputStream(".\\src/test/java\\com\\facebook\\repository\\locators.properties");
		or = new Properties();
		or.load(fs);

		// TestData Properties File Implementation

		FileInputStream ts = new FileInputStream(".\\src/test/java\\com\\facebook\\repository\\testdata.properties");
		td = new Properties();
		td.load(ts);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src/test/java\\com.facebook.drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src/test/java\\com.facebook.drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.out.println("Open IE Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

	}
}