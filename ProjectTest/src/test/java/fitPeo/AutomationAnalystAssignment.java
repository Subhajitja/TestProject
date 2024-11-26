package fitPeo;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationAnalystAssignment {

	public static void main(String[] args) throws Exception {

		// Setting the property of chrome browser and passing chrome driver path
		System.setProperty("webdriver.chrome.driver", "D:\\New_Chrome_driver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open the web browser
		driver.get("https://www.fitpeo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Navigate to FitPeo Homepage.
		driver.findElement(By.xpath("//div[text()='Home']")).click();

		Thread.sleep(5000);
		// Navigate to the Revenue Calculator Page:
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		Thread.sleep(5000);
		// We use JavascriptExecutor Interface in our driver for scrolling
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// Scroll Down using javaScript vertical
		jse.executeScript("window.scrollBy(0, 350)");

		// Define the WebElement for slider
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

		// Adjust the slider position at 820 position
		jse.executeScript("window.scrollBy(0, 200)");

		while (true) {
			if (slider.getAttribute("value").toString().equals("820"))
				break;
			else {
				slider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
		System.out.println("Adjust the Slider Value to 820.");

		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//input[@type='number']"));

		// Remove the data from Input field by Action class
		Actions act = new Actions(driver);
		act.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();

		// put the data in Input Text field
		element.sendKeys("560");
		System.out.println("Update the slider value 560.");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 200)");

		// Verify slider value
		WebElement slider1 = driver.findElement(By.xpath("//input[@type='range']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=560;", slider1);

		String sliderValue = slider1.getAttribute("value");
		if ("560".equals(sliderValue)) {
			System.out.println("Slider value Verified it's  correctly set to 560.");
		} else {
			System.out.println("Slider value  560 is not set correctly.");
		}

		// Scroll Down using javaScript vertical
		jse.executeScript("window.scrollBy(0, 300)");

		// Find all checkboxes on the page
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		// Select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474 on
		// their index
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);

			// Select the first,second,third and eight checkboxes
			if (i == 0 || i == 1 || i == 2 || i == 7) {
				checkbox.click();
			}
		}
		System.out.println("Selected CPT Codes : CPT-99091,CPT-99453,CPT-99454 and CPT-99474.");

		// Update the value 820 in the text field to get Total Recurring Reimbursement for all Patients Per Month: $110700
		jse.executeScript("window.scrollBy(0, -350)");
		act.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		element.sendKeys("820");
		System.out.println(
				"Update the value 820 in the text field to get Total Recurring Reimbursement for all Patients Per Month: $110700.");

		jse.executeScript("window.scrollBy(0, 300)");

		// Validating "Total Recurring Reimbursement for all Patients Per Month:"
		// Locate the WebElement for "Total Recurring Reimbursement for all Patients Per Month:".
		WebElement reimbursementElement = driver
				.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));

		String reimbursementText = reimbursementElement.getText();

		String expectedReimbursement = "$110700";
		if (reimbursementText.equals(expectedReimbursement)) {
			System.out.println("Verified the Total Recurring Reimbursement for all Patients Per Month : $110700.");
		} else {
			System.out
					.println("Verified the Total Recurring Reimbursement for all Patients Per Month :$110700. Expected: "
							+ expectedReimbursement + ", Actual: " + reimbursementText);
		}
		driver.quit();

	}

}
