package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class browserContextsUsage {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();

		// BrowserContext opens the session in Incognito mode. 
		// It won't share cookies/cache with other browser contexts.
		
		BrowserType chromium = pw.chromium();
		// Create a Chromium browser instance
		Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// Create two isolated browser contexts
		BrowserContext userContext = browser.newContext();
			
		// Create pages and interact with contexts independently
		Page userPage = userContext.newPage();
		userPage.navigate("http://automationexercise.com");
		System.out.println(userPage.title());
		
		String ActualTitle = userPage.title();
		System.out.println(ActualTitle);
		assertThat(userPage.getByText(" Products")).isVisible();	
		System.out.println("Assertion Passed");
		pw.close();
		browser.close();
		userContext.close();
	}

}