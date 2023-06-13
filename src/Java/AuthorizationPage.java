import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class AuthorizationPage {
    private static final String pageUrl = "http://citilink.ru";

    public static String getPageUrl() {
        return pageUrl;
    }
    public static Locator getLoginMenuButton(Page page) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти"));
    }
    public static Locator getEmailOrPhoneField(Page page) {
        return page.getByLabel("Email или телефон");
    }
    public static Locator getPasswordField(Page page){
        return page.getByLabel("Пароль");
    }
    public static Locator getEnterButton(Page page) {
        return page.locator("form").filter(new Locator.FilterOptions().setHasText("Email или телефонПарольЗабыли пароль?Войти"))
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Войти"));
    }
}
