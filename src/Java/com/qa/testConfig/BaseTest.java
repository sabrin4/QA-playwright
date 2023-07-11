package com.qa.testConfig;

import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightFactory;
import com.qa.pageModel.CitilinkPage;
import org.testng.annotations.*;

import static com.qa.reporter.QaseReporter.addTestRunResult;

public class BaseTest {
    public Page page;
    public PlaywrightFactory playwrightFactory;
    public CitilinkPage citilinkPage;

    @BeforeClass
    @Parameters({"baseUrl","browserType"})
    public void setUp(String url, String browserType) {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.getPage(url, browserType);
        citilinkPage = new CitilinkPage(page);
    }

    @AfterMethod
    public void returnBaseUrl() {
        page.navigate(System.getenv("homePage"));
    }

    public void resultReport(String projectCode, int caseId) {
        addTestRunResult(projectCode, caseId);
    }

    @AfterClass
    public void tearDown(){
        playwrightFactory.playwright.close();
    }
}
