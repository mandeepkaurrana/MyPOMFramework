package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	Page page;
//	
//	private String productLink = "//a[text()=' Products']";
//	private String addProduct1 = "(//p[text()='Blue Top']/following-sibling::a)[1]";
//	private String addProduct2 = "(//p[text()='Men Tshirt']/following-sibling::a)[2]";
//	private String continueShoppingBtn = "//button[text()='Continue Shopping']";
//	private String viewCart = "//u[text()='View Cart']";
//	private String cartBtn = "//a[text()=' Cart']";
//	
	// =================================
	private String search = "//input[@name='search']";
	private String searchButton = "//button[@class='btn btn-default btn-lg']";
	private String searchPageHeading = "//div[@id='content']/h1";
	private String loginLink = "a:text('Login')";
	private String accountLink = "//a[@title='My Account']";
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("The Title of HomePage is : "+title);
		return title;
	}
	
	public String getHomePageURL(){
		String url =  page.url();
		System.out.println("The URL of HomePage is : "+url);
		return url;
	}
	
	public String doSearch(String productName){
		page.fill(search,productName);
		page.click(searchButton);
		String header =  page.textContent(searchPageHeading);
		System.out.println("Search page heading : "+header);
		return header;
	}
	
	public LoginPage navigateToLoginPage(){
		page.click(accountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

//	public String getProductLink() {
//		return productLink;
//	}
//
//	public void setProductLink(String productLink) {
//		this.productLink = productLink;
//		System.out.println("The product link is : "+productLink);
//	}
//
//	public String getAddProduct1() {
//		return addProduct1;
//	}
//
//	public void setAddProduct1(String addProduct1) {
//		this.addProduct1 = addProduct1;
//		System.out.println("The added product is : "+addProduct1);
//	}
//
//	public String getAddProduct2() {
//		return addProduct2;
//	}
//
//	public void setAddProduct2(String addProduct2) {
//		this.addProduct2 = addProduct2;
//		System.out.println("The 2nd product added is : "+addProduct2);
//	}
//
//	public String getContinueShoppingBtn() {
//		return continueShoppingBtn;
//	}
//
//	public void setContinueShoppingBtn(String continueShoppingBtn) {
//		this.continueShoppingBtn = continueShoppingBtn;
//		System.out.println("The shopping is continued : "+continueShoppingBtn);
//	}
//
//	public String getCartBtn() {
//		return cartBtn;
//	}
//
//	public void setCartBtn(String cartBtn) {
//		this.cartBtn = cartBtn;
//		System.out.println("Reset the cart button : "+cartBtn);
//	}
//
//	public String getViewCart() {
//		return viewCart;
//	}
//
//	public void setViewCart(String viewCart) {
//		this.viewCart = viewCart;
//		System.out.println("Let's view the cart : "+viewCart);
//	}
	
	
}
