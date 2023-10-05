package org.learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.*;


public class PlaywrightDemo {

    Playwright playwright;
    Browser browser;

    BrowserContext context;

    Page page;

    @BeforeClass
    void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterClass
    void closeBrowser(){
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    void closeContext(){
        context.close();
    }

    @Test
    void navigateToPlaywrightDocsAndVerifyPageTitle(){
        try {
            page.navigate("https://playwright.dev/java/docs/intro");
            Assert.assertTrue(page.title().contains("Playwright"));
        } catch (Exception e) {
            page.close();
        }

    }

    @Test
    void navigateToPlaywrightDocsAndVerifyPlaywrightLogoExists(){
        page.navigate("https://playwright.dev/java/docs/intro");
        Assert.assertTrue(page.locator("//img[@alt='Playwright logo']").isVisible());
    }
}
