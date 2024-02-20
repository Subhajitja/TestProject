package com.facebook.pages;

import com.facebook.genericPage.CommonMethods;

public class LoginPage extends CommonMethods {

	public LoginPage() throws Exception {
		super();
	}

	// Click Email or Phone
	public void clickEmailOrPhone() {
		click("EmailorPhone");
	}
	// Get Text
		public void getFacebookText() {
			getWebElementText("FacebookText");
		}

	// Enter Email
	public void enterEmail() {
		enterData("EmailorPhone", "testData1");
	}

	// Click Password
	public void clickPassword() {
		click("Password");
	}

	// Enter Password
	public void enterPassword() {
		enterData("Password", "testData2");

	}

	// Click Login Button
	public void clickLoginButton() {
		click("LoginButton");
	}
}
