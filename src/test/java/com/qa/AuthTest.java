package com.qa;

import com.qa.parameters.AuthParams;
import com.qa.testConfig.BaseTest;
import io.qase.api.annotation.CaseId;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AuthTest extends BaseTest {
    @Test
    @CaseId(7)
    void validEmailAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("Email"));
        citilinkPage.passwordField.fill(System.getenv("Password"));
        citilinkPage.loginConfirmButton.click();
        assertThat(citilinkPage.userProfileButton).hasText(System.getenv("UserName"));
        citilinkPage.userProfileButton.click();
        citilinkPage.userLogoutButton.click();
    }

    @Test
    @CaseId(8)
    void validPhoneAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("PhoneNumber"));
        citilinkPage.passwordField.fill(System.getenv("Password"));
        citilinkPage.loginConfirmButton.click();
        assertThat(page).hasURL("https://www.citilink.ru/?_action=login&_success_login=1");
        //resultReport("SP", 8);
        citilinkPage.userProfileButton.click();
        citilinkPage.userLogoutButton.click();
    }

    @Test(dataProvider = "invalidEmailAuthParams", dataProviderClass = AuthParams.class)
    @CaseId(25)
    void invalidEmailAuth(String email, String password) {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(email);
        citilinkPage.passwordField.fill(password);
        if(citilinkPage.loginConfirmButton.getAttribute("data-meta-disabled").equals("false")) {
            citilinkPage.loginConfirmButton.click();
            assertThat(page).hasURL("https://www.citilink.ru/login/?_from=https%3A%2F%2Fwww.citilink.ru%2F&error=10");
            page.navigate(System.getenv("baseUrl"));
        }
        else {
            assertThat(citilinkPage.loginConfirmButton).hasAttribute("data-meta-disabled", "true");
            citilinkPage.enterMenuCloseButton.click();
        }
    }

    @Test(dataProvider = "invalidPhoneAuthParams", dataProviderClass = AuthParams.class)
    @CaseId(27)
    void invalidPhoneAuth(String phone, String password) {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(phone);
        citilinkPage.passwordField.fill(password);
        if(citilinkPage.loginConfirmButton.getAttribute("data-meta-disabled").equals("false")) {
            citilinkPage.loginConfirmButton.click();
            assertThat(page).hasURL("https://www.citilink.ru/login/?_from=https%3A%2F%2Fwww.citilink.ru%2F&error=10");
            page.navigate(System.getenv("baseUrl"));
        }
        else {
            assertThat(citilinkPage.loginConfirmButton).hasAttribute("data-meta-disabled", "true");
            citilinkPage.enterMenuCloseButton.click();
        }
    }

    @Test(dataProvider = "invalidPasswordValidEmailAuthParams", dataProviderClass = AuthParams.class)
    @CaseId(29)
    void invalidPasswordValidEmailAuth(String email, String password) {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(email);
        citilinkPage.passwordField.fill(password);
        if(citilinkPage.loginConfirmButton.getAttribute("data-meta-disabled").equals("false")) {
            citilinkPage.loginConfirmButton.click();
            assertThat(page).hasURL("https://www.citilink.ru/login/?_from=https%3A%2F%2Fwww.citilink.ru%2F&error=10");
            page.navigate(System.getenv("baseUrl"));
        }
        else {
            assertThat(citilinkPage.loginConfirmButton).hasAttribute("data-meta-disabled", "true");
            citilinkPage.enterMenuCloseButton.click();
        }
    }

    @Test(dataProvider = "invalidPasswordValidPhoneAuthParams", dataProviderClass = AuthParams.class)
    @CaseId(28)
    void invalidPasswordValidPhoneAuth(String phone, String password) {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(phone);
        citilinkPage.passwordField.fill(password);
        citilinkPage.passwordField.fill(System.getenv("invalidPassword"));
        if(citilinkPage.loginConfirmButton.getAttribute("data-meta-disabled").equals("false")) {
            citilinkPage.loginConfirmButton.click();
            assertThat(page).hasURL("https://www.citilink.ru/login/?_from=https%3A%2F%2Fwww.citilink.ru%2F&error=10");
            page.navigate(System.getenv("baseUrl"));
        }
        else {
            assertThat(citilinkPage.loginConfirmButton).hasAttribute("data-meta-disabled", "true");
            citilinkPage.enterMenuCloseButton.click();
        }
    }
}
