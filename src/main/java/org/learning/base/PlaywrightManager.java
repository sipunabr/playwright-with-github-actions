package org.learning.base;

import com.microsoft.playwright.*;

public class PlaywrightManager {

    private static ThreadLocal<Playwright> playwright = ThreadLocal.withInitial(Playwright::create);
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void setUp() {
        Browser browserInstance = playwright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext contextInstance = browserInstance.newContext();
        Page pageInstance = contextInstance.newPage();

        browser.set(browserInstance);
        browserContext.set(contextInstance);
        page.set(pageInstance);
    }

    public static Page getPage() {
        return page.get();
    }

    public static BrowserContext getContext() {
        return browserContext.get();
    }

    public static Browser getBrowser() {
        return browser.get();
    }

    public static void tearDown() {
        getPage().close();
        getContext().close();
        getBrowser().close();

        page.remove();
        browserContext.remove();
        browser.remove();
        playwright.remove();
    }
}