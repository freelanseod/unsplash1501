package pages;

import com.codeborne.selenide.SelenideElement;
import pages.LandingPage;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public SelenideElement
            emailField = $("#user_email"),
            passwordField = $("#user_password"),
            loginButton = $(byValue("Login")),
            homeButton = $(byTitle("Home — Unsplash")),
            errorMessage = $(byText("Invalid email or password.")),
            backHomeButton=$("#back-home");

    public LoginPage() {
        open("/login");
    }

    public void fillUserInfoField(String email, String password) {
        emailField.val(email);
        passwordField.val(password);
    }

    public LandingPage agreeToLoginButton() {
        loginButton.click();
        return new LandingPage();
    }

}
