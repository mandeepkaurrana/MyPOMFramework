package com.qa.opencart.factory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ElementState;
import com.qa.opencart.tests.*;
import java.lang.Thread;

public class Login {
private Page page;
private Locator get;
private Locator username;
private Locator setting;
private Locator dropdown;



public Login(Page page) {
    this.page = page;
    this.get = page.locator("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    this.username = page.locator("text= Signup / Login");
    this.setting = page.locator("//div[@class=\"login-form\"]/h2").getByText("Login to your account");
    this.dropdown = page.locator("[data-qa=\"login-email\"]");
}



public void gotoPage() {
    page.navigate("https://automationexercise.com/");
}

public void getStarted() {
    assertThat(get).hasAttribute("alt" , "Website for automation practice"); 
    //assertThat(page.locator("div[class='example'] p")).hasText("Congratulations! You must have the proper credentials.");
}

public void clickSubmit() {
    username.click();
}

public void clickDropdown() {
	assertThat(setting).hasText("Login to your account");
}

public void clickSetting() {
    dropdown.fill("test555@yopmail.com");
}
}
