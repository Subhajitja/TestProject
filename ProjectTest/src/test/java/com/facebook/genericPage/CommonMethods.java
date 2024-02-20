package com.facebook.genericPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods extends MasterPage {

	public CommonMethods() throws Exception {
		super();

	}

	// Get Text of WebElement
	public void getWebElementText(String xpathkey) {
		String getTextOfWebElement = driver.findElement(By.xpath(or.getProperty(xpathkey))).getText();
		System.out.println(getTextOfWebElement);

	}

	// Click Method
	public void click(String xpathkey) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).click();

	}

	// Enter Data
	public void enterData(String xpathkey, String testData) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(td.getProperty(testData));

	}

	// Clear Data
	public void clearData(String xpathkey) {
		driver.findElement(By.xpath(or.getProperty(xpathkey))).clear();

	}

	// Mouse Hover
	public void moveToElement(String xpathkey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathkey)))).build().perform();

	}

	// Click list of WebElement
	public void clickListElement(String xpathkey, String testData) {
		List<WebElement> listOfElements = driver.findElements(By.xpath(or.getProperty(xpathkey)));
		for (int i = 0; i < listOfElements.size(); i++) {
			if (listOfElements.get(i).getText().equalsIgnoreCase(td.getProperty(testData))) {
				;
				listOfElements.get(i).clear();
			}
		}
	}

	// Select dropdown value
	public void selectDropDownValue(String xpathkey, String testData1, String testData2) {
		WebElement ele = driver.findElement(By.xpath(or.getProperty(xpathkey)));
		Select webElem = new Select(ele);
		webElem.selectByVisibleText(td.getProperty(testData1));
		webElem.selectByValue(td.getProperty(testData2));

	}

	// Reading Excel
	public void readExcelData(String xpathkey, int rowNo, int columnNo) throws Exception {
		File src = new File(".\\src/test/java\\com.facebook.data\\Excel_Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		System.out.println(sh.getSheetName());
		String abc = sh.getRow(rowNo).getCell(columnNo).getStringCellValue();
		driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(abc);

	}
}
