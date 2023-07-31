package com.qa.parameters;

import org.testng.annotations.DataProvider;

public class AuthParams {

    @DataProvider(name = "invalidEmailAuthParams")
    public Object [][] getInvalidEmailAuth() {
        String password = System.getenv("Password");
        return new Object[][]
                {
                        {"testemailgmail.com", password},
                        {"@testemailgmail.com", password},
                        {"testemail@gmail", password},
                        {"@testemail@gmail.com", password},
                        {"testemail@gmail.ru", password},
                        {"wrongemailQAtest@gmail.com", password},
                        {"", password}
                };
    }

    @DataProvider(name = "invalidPhoneAuthParams")
    public Object [][] getInvalidPhoneAuth() {
        String password = System.getenv("Password");
        return new Object[][]
                {
                        {"+7917555555", password},
                        {"+791755555555", password},
                        {"", password},
                        {"+7917555555%", password},
                        {"+7917555555R", password},
                        {"+79174444444", password} //кнопка активна
                };
    }

    @DataProvider(name = "invalidPasswordValidEmailAuthParams")
    public Object [][] getInvalidPasswordValidEmailAuthParams() {
        String email = System.getenv("Email");
        return new Object[][]
                {
                        {email, "passw"},
                        {email, "password123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"},
                        {email, ""},
                        {email, "wrongPassword"},
                };
    }

    @DataProvider(name = "invalidPasswordValidPhoneAuthParams")
    public Object [][] getInvalidPasswordValidPhoneAuth() {
        String phone = System.getenv("Email");
        return new Object[][]
                {
                        {phone, "passw"},
                        {phone, "password123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"},
                        {phone, ""},
                        {phone, "wrongPassword"},
                };
    }
}
