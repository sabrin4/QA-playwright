package com.qa;

import com.qa.testConfig.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AuthTest extends BaseTest {
    @Test
    void validEmailAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("Email"));
        citilinkPage.passwordField.fill(System.getenv("Password"));
        citilinkPage.loginConfirmButton.click();
        assertThat(citilinkPage.userProfileButton).hasText(System.getenv("UserName"));
        resultReport("SP", 7);
        citilinkPage.userProfileButton.click();
        citilinkPage.userLogoutButton.click();
    }

    @Test
    void ValidPhoneAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("PhoneNumber"));
        citilinkPage.passwordField.fill(System.getenv("Password"));
        citilinkPage.loginConfirmButton.click();
        assertThat(page).hasURL("https://www.citilink.ru/?_action=login&_success_login=1");
        resultReport("SP", 8);
        citilinkPage.userProfileButton.click();
        citilinkPage.userLogoutButton.click();
    }

    @Test
    void invalidEmailAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("invalidEmail"));
        citilinkPage.passwordField.fill(System.getenv("Password"));
        assertThat(page.getByText("Введите правильный телефон или email")).hasText("Введите правильный телефон или email");
        resultReport("SP", 25);
    }

    @Test
    void invalidPhoneAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("invalidPhone"));
        citilinkPage.passwordField.fill(System.getenv("Password"));
        assertThat(page.getByText("Введите правильный телефон или email")).hasText("Введите правильный телефон или email");
        resultReport("SP", 27);
    }

    @Test
    void invalidPasswordValidEmailAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("Email"));
        citilinkPage.passwordField.fill(System.getenv("invalidPassword"));
        assertThat(citilinkPage.loginConfirmButton).hasAttribute("data-meta-disabled", "true");
        resultReport("SP", 29);
    }

    @Test
    void invalidPasswordValidPhoneAuth() {
        assertThat(page).hasTitle("Ситилинк - интернет-магазин техники, электроники, товаров для дома и ремонта");
        citilinkPage.enterMenuButton.click();
        citilinkPage.emailOrPhoneField.fill(System.getenv("PhoneNumber"));
        citilinkPage.passwordField.fill("1");
        citilinkPage.passwordField.fill(System.getenv("invalidPassword"));
        assertThat(page.getByText("Обязательное поле")).hasText("Обязательное поле");
        resultReport("SP", 28);
    }
}
