package com.facebook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.facebook.genericPage.MasterPage;
import com.facebook.pages.LoginPage;

public class LoginTest {

	@Test
	public void loginTest() throws Exception {

		LoginPage lp = new LoginPage();

		lp.clickEmailOrPhone();
		lp.enterEmail();
		lp.clickPassword();
		lp.enterPassword();
		lp.getFacebookText();
		lp.clickLoginButton();
		Thread.sleep(3000);
		lp.readExcelData("EmailorPhone", 3, 1);
		Thread.sleep(3000);

	}

	@AfterClass
	public static void closeLoginPage() {
		MasterPage.driver.close();
	}

}
