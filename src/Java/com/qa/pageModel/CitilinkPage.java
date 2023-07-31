package com.qa.pageModel;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CitilinkPage {
    public final Locator enterMenuButton;
    public final Locator emailOrPhoneField;
    public final Locator passwordField;
    public final Locator loginConfirmButton;
    public final Locator userProfileButton;
    public final Locator userLogoutButton;
    public final Locator enterMenuCloseButton;

    public CitilinkPage(Page page) {
        enterMenuButton =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти"));
        emailOrPhoneField = page.getByText("Email или телефон");
        passwordField = page.getByLabel("Пароль");
        loginConfirmButton = page.locator("form").filter(new Locator.FilterOptions().setHasText("Email или телефонПарольЗабыли пароль?Войти"))
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Войти"));
        userProfileButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(System.getenv("UserName")));
        userLogoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Выйти"));
        enterMenuCloseButton = page.locator(".e1nu7pom0");
    }
}
