package PlaywrightFactory;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AuthorizationPageLocators {
    public static Locator getLoginMenuButton(Page page) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти"));
    }
    public static Locator getEmailOrPhoneField(Page page) {
        return page.getByLabel("Email или телефон");
    }

    public static Locator getPasswordField(Page page){
        return page.getByLabel("Пароль");
    }

    public static Locator getLoginConfirmButton(Page page) {
        return page.locator("form").filter(new Locator.FilterOptions().setHasText("Email или телефонПарольЗабыли пароль?Войти"))
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Войти"));
    }

    public static Locator getUserProfileButton(Page page) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(System.getenv("UserName")));
    }
}