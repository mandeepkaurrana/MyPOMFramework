package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void successfulLogin() {
		loginPage = homePage.navigateToLoginPage();
		String actualLoginPageT = loginPage.getLoginPageTitle();
		System.out.println("Actual Login Page Title : "+actualLoginPageT);
		Assert.assertEquals(actualLoginPageT,AppConstants.LOGIN_PAGE_TITLE);
		
	}

	@Test(priority=2)
	public void forgotPwdTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
	}
	
	@Test(priority=3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));		
	}

}
