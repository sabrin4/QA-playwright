import com.microsoft.playwright.*;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//code gen:
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://citilink.ru"

public class HomeTask3 {
    public static void main(String[] args) throws InterruptedException {
        validDataAuthTest();
    }

    public static void validDataAuthTest() throws InterruptedException {
        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate(AuthorizationPage.getPageUrl());
            assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");

            AuthorizationPage.getLoginMenuButton(page).click();
            AuthorizationPage.getEmailOrPhoneField(page).fill(System.getenv("PhoneNumber"));
            AuthorizationPage.getPasswordField(page).fill(System.getenv("Password") + "1");
//          Thread.sleep(3000);
            AuthorizationPage.getEnterButton(page).click();

            page.navigate(AuthorizationPage.getPageUrl() + "/profile/club");
            //assertThat(page.locator("span").filter(new Locator.FilterOptions().setHasText(System.getenv("UserName"))));
            Thread.sleep(5000);
        }
    }
}
