import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//code gen:
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://citilink.ru"

public class HomeTask3 {
    static String testUrl = "http://citilink.ru";

    public static void main(String[] args) throws InterruptedException {
        validDataAuthTest();
    }

    public static void validDataAuthTest() throws InterruptedException {
        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate(testUrl);
            assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти")).click();
            page.getByLabel("Email или телефон").fill("+79171606041");
            page.getByLabel("Пароль").fill("123456");
            Thread.sleep(5000);
            page.getByText("Войти").click(); // ???
        }
    }
}
