import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomeTask3 {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://citilink.ru");
            assertThat(page).
                    hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
            Locator userButton = page.locator("text=Войти").nth(0);
            userButton.click();
        }
    }
}
