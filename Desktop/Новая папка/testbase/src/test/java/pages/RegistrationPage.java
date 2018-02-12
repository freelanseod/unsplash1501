package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    public SelenideElement
            firstNameField = $("#user_first_name"),
            lastNameField =$("#user_last_name"),
            emailField = $ ("#user_email"),
            usernameField = $("#user_username"),
            passwordField = $("#user_password"),
            joinButton = $(byValue("Join")),
            joinUsingFacebook = $x("//a[@href='/users/auth/facebook']"),
            homeButton = $(byTitle("Home — Unsplash"));


    public RegistrationPage() {
        open("/join");
    }

    public void fillUserName(String firstName, String lastName) {
        firstNameField.val(firstName);
        lastNameField.val(lastName);
    }

    public void fillUserDate(String email, String username) {
        emailField.val(email);
        usernameField.val(username);
    }

    public void fillUserPassword(String password) {
        passwordField.val(password);
    }

    public void clickOnJoinButton(){
        joinButton.click();
    }
}
