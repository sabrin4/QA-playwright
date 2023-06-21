package PlaywrightFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightUtils {
    private final static Playwright playwright = Playwright.create();
    private final static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    private final static Page page = browser.newPage();

    public static void openBaseUrl() {
        page.navigate("https://www.citilink.ru");
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
    }

    public static void pressLoginMenuButton(){
        AuthorizationPageLocators.getLoginMenuButton(page).click();
    }

    public static void fillLoginForm(){
        AuthorizationPageLocators.getEmailOrPhoneField(page).fill(System.getenv("PhoneNumber"));
        AuthorizationPageLocators.getPasswordField(page).fill(System.getenv("Password"));
    }

    public static void pressLoginConfirmButton(){
        AuthorizationPageLocators.getLoginConfirmButton(page).click();
    }

    public static void pressUserProfileButton(){
        AuthorizationPageLocators.getUserProfileButton(page).click();
    }

    public static void tearDown() {
        playwright.close();
    }
}