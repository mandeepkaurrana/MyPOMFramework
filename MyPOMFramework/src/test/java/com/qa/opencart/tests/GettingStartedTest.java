
package com.qa.opencart.tests;

import com.microsoft.playwright.*;
import com.qa.opencart.factory.Login;
import java.lang.Thread;

import org.testng.annotations.*;

public class GettingStartedTest {
	Page page;
	Browser browser;

	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		page = browser.newPage();
		page.navigate("http://automationexercise.com");
		Thread.sleep(5000);
	
	}

	@Test
	public void TC1() {
		Login loginobj = new Login(page);
        loginobj.getStarted();
		loginobj.clickSubmit();
		loginobj.clickDropdown();
		loginobj.clickSetting();

	}
	
	
@AfterMethod
	public void TearDown() {
		page.close();
	}

}
