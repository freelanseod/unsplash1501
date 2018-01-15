import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends LandingPage{

    public SelenideElement
            emailField = $x("//*[@id='user_email']"),
            passwordField = $x("//*[@id='user_password']"),
            loginButton = $(byValue("Login")),
            homeButton = $(byTitle("Home — Unsplash")),
            errorMessage = $(byText("Invalid email or password.")),
            backHomeButton=$("#back-home");


    public void fillUserInfoField(String email, String password) {
        emailField.val(email);
        passwordField.val(password);
    }

    public void agreeToLoginButton() {
        loginButton.click();
    }

    public void checkThatUserInSystem() {
        homeButton.shouldBe(visible);
    }

    public void checkThatUserNotLogin(){
        //то есть что пользователь не залогинен
        backHomeButton.shouldBe(hidden);
        // отображается ошибка с верным текстом
        errorMessage.shouldBe(visible);
    }

}
