import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class LandingPage {

    public SelenideElement
            loginMainButton = $(byLinkText("Login"));

    public LoginPage clickOnLoginButton() {
        loginMainButton.click();
        return new LoginPage();
    }
}


