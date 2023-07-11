package com.qa.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    public Playwright playwright = Playwright.create();
    public Page page;
    public Browser browser;
    public BrowserContext context;

    public Page getPage(String baseUrl, String browserType) {
        switch (browserType) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }
        context = browser.newContext();
        page = context.newPage();
        page.navigate(baseUrl);
        return page;
    }
}
